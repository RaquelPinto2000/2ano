clc;clear all; close all;
% Estado 1 = Iraque, Estado 2 = França, Estado 3 = Suiça, Estado 4 =
% Brasil, Estado 5 = Israel, Estado 6 = EUA
%% Ex 2 - alinea A 
T = [0.7 0.1 0 0 0 0
     0.2 0 0.3 0 0 0
     0 0.6 0.1 0 0 0
     0.1 0.3 0.4 0.1 0 0
     0 0 0 0.5 1 0
     0 0 0.2 0.4 0 1]
v = [0; 1/2; 1/2; 0; 0; 0] % estado inicial
%% Ex 2 - alinea B
Q = [0.7 0.1 0 0
     0.2 0 0.3 0
     0 0.6 0.1 0
     0.1 0.3 0.4 0.1];
Q = T(1:4,1:4);
aux = eye(size(Q))-Q;
F = inv(aux);
t = sum(F)
RespostaB = t(1)
%% Ex 2 - alinea C
X0 = [1;0;0;0;0;0];
aux = T^5*X0;
RespostaC_parteA = aux(end)
X0 = [0;0;0;1;0;0];
aux = T^50*X0;
RespostaC_parteB = aux(5)