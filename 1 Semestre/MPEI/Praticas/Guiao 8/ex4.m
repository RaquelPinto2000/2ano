% Raquel Resende Milheiro Pinto NMEC = 92948
clc;clear all; close all;
%% Ex 4 - (1 estado = A, 2 estado = B, 3 estado = C, 4 estado = D)
p = 0.4;
q = 0.6;
%alinea A
T = [p^2 0 0 q^2
    (1-p)^2 0 0 q*(1-q)
     p*(1-p) 0 0 q*(1-q)
     p*(1-p) 1 1 (1-q)^2];
X0= [1;0;0;0]; 

aux = T^10 * X0;
resultadoB = aux(2) % resultado da alinea B
estadoA = aux(1)
estadoC = aux(3)
estadoD=aux(4)