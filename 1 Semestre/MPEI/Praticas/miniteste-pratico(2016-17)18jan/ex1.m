clc;clear all;close all;
%Estado 1 - pacote sem erros, Estado 2 - pacote com 1 erro, Estado 3 -
%pacote com 2 ou + erros
%% Ex 1 - alinea A
T = [0.9 0.5 0.5
    0.01 0.1 0.1
    0.09 0.4 0.4]
v = [0;0;1]
%% Ex 1 - alinea B
aux = T^3*v
Respostas_Sem_Erro = aux(1)
Respostas_1Erro = aux(2)
Respostas_2Erros = aux(3)
%% Ex 1 - alinea C
N = 100;
for i = 2:N
    aux = T^(i-1)*v
    aux1 = T^i*v
    if(aux1-aux>0.001)
        break;
    end    
end


current_T = T;
next_T = T*T;
A = abs(current_T - next_T);
while max(A(:)) > 1e-3
    current_T = next_T; 
    next_T = next_T * T;
    A = abs(current_T - next_T);
end
fprintf("1 c)\n")
disp(current_T*v)
