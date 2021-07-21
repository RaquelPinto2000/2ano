% Raquel Resende Milheiro Pinto NMEC = 92948
clc; clear all; close all;
% estado 1 = Ana, estado 2 = Bernardo, estado 3 = Catarina
%% Ex 7 - alinea A 
T =[0.8 0.1 0.05
    0.2 0.6 0.20
    0 0.3 0.75]
X0 = [100;200;30];
aux = T^4*X0; % no dia 4 de janeiro
resultadoA_ANA = aux(1)
resultadoA_Bernardo = aux(2)
resultadoA_Catarina = aux(3)

%% EX 7 - alinea B
aux = T^365*X0;  % 2015 = 365 dias
resultadoA_ANA = aux(1)
resultadoA_Bernardo = aux(2)
resultadoA_Catarina = aux(3)

%% Ex 7 - alinea C
nDias = 1;
while true
    aux = T^nDias*X0;
    if(aux(3)>130) % Catarina ter mais de 130 euros
        respostaC = nDias % numero de dias que passaram 
        break;
    end 
    nDias = nDias +1;
end