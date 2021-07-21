clc;clear all; close all;
% estado 1 = A, estado 2 = B, estado 3 = C, estado 4 = D  
%% Ex 4 - alinea A
p=0.4;
q=0.4;
T = [p^2 0 0 q^2
    (1-p)^2 0 0 q*(1-q)
    p*(1-p) 0 0 q*(1-q)
    p*(1-p) 1 1 (1-q)^2]

%% Ex 4 - alinea B
X0 = [1;0;0;0];
aux = T^10 * X0;
ResultadoB = aux(2)