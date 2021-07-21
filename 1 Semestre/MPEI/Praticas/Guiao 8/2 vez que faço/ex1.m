clc ; clear all; close all;
% Estado 1 = presente Estado 2 = falta
%% Ex 1 - alinea A
estados=[1 2];
T = [0.7 0.8
    0.3 0.2];
X0 = [1; 0];
x2 = T^2*X0;
resultadoA = x2(1)

%% Ex 2 - alinea B
X0 = [0;1];
X2 = T^2 * X0;
resultadoB = X2(1)

%% Ex 2 - alinea C
X0= [1;0];
x30 = T^29*X0;
resultadoC = x30(1)

%% Ex 3 - alinea D
X0= [0.85; 0.15]
for i=1:30
    Xi = T^i * X0;
    resultadosD(i) = Xi(2); % é resultadosD(i) pq assim e um vetor, se fosse so resultadosD era = so a ultima conta que contava
end 
stem(resultadosD)