clc;clear all; close all;
%Estado 1 = A, Estado 2 = B, Estado 3 = C, Estado 4 = D, Estado 5 = E, Estado 6 = F
%% Ex 1 - alinea A
H=[0 0 1/2 0 1/2 1/5
   1/4 1/3 1/2 1/2 1/2 1/5
   1/4 0 0 0 0 1/5
   1/4 1/3 0 0 0 1/5
   1/4 0 0 1/2 0 1/5
   0 1/3 0 0 0 0];

X0 = [1/6;1/6;1/6;1/6;1/6;1/6];

ResultadoB = H^3*X0

%% Ex 1 - alinea B
N = 50
grafico = zeros(length(H),N);
for i = 1:N
    aux = H^i*X0;
   grafico(:,i) = aux;
end
plot(1:N,grafico),grid on %grid on - tem uma grelha

%% Ex 1 - alinea C
pags = H^15*X0;
ResultadoC = max(pags)
for i = 1: length(pags)
    if(ResultadoC == pags(i))
        Pagina = i
        break;
    end
end