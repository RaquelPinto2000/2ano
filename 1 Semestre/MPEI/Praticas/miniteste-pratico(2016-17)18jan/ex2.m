clc; close all; clear all;
%% Ex 2 - alinea A
H = [0 1/2 1/3 1/4 0
     1/2 0 0 1/4 1/2
     1/2 1/2 1/3 1/4 0
     0 0 0 0 1/2
     0 0 1/3 1/4 0];

r0 = (zeros(5,5));
for i = 1:length(r0)
    for j = 1:length(r0)
        r0(i,j)=1/5;
    end
end
%ou  N=5
% One_over_N = ones(N, N)/N
B = 0.8;

A = B*H + (1-B)*r0

%% Ex 2 - alinea B
r0 = [1/5; 1/5; 1/5; 1/5; 1/5]; % ou N=5 rank = ones(N,1)/N % = rank_0
aux = A^10*r0;
Resposta_C = aux(1)
Resposta_D = aux(2)
Resposta_E = aux(3)
Resposta_F = aux(4)
Resposta_G = aux(5)