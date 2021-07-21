clc; clear all; close all;
%Estado 1 = a, Estado 2 = b, Estado 3 = c, Estado 4 = d, Estado 5 = ?, Estado
%6 = .
%% Ex 3 - alinea A
T = [0.7 0.2 0 0 0 0
     0.2 0 0.3 0 0 0
     0 0.6 0.3 0 0 0 
     0.1 0.2 0.3 0.1 0 0
     0 0 0 0.4 1 0
     0 0 0.1 0.5 0 1]
 
%% Ex 3 - alinea B
X0 = [1;0;0;0;0;0];
aux = T^9*X0;
Resposta_10_C = aux(3)
aux = T^14*X0;
Resposta_15_D = aux(4)

%% Ex 3 - alinea C
Q = T(1:4,1:4);
auxF = eye(size(Q))-Q;
F = inv(auxF);
t = sum(F);
Resposta_C = t(3)