% Raquel Resende Milheiro Pinto NMEC = 92948
clc; clear all; close all;
% estado 1 = Grupo A, estado 2 = Grupo B, estado 3 = Grupo C
%% Ex 2 - alinea A 
transicao = [1/3 1/4 0
             1/3 0.55 1/2
             1/3 1/5 1/2]
% é uma matriz estocastica pq a soma dos elementos das colunas da 1 e tem elementos entre 0 e 1
Mestocastica = sum (transicao) 

%% Ex 2 - alinea B  (Grupo A- 1 linha    Grupo B - 2 linha  Grupo C - 3 linha)
A = [ 1 -2 -2
     0 1 -1
     1 1 1];
B = [0;0;90];

X0alunos = inv(A)*B % vetor com o numero de alunos de cada grupo
X0=0;
for i=1:length(X0alunos)
    X0 = [X0; X0alunos(i)/90];  %matriz coluna - concatenar valores
end 
X0 = X0(2:end) % vetor do estado inicial - probabilidades

%% Ex 2 - alinea C (Grupo A- 1 linha    Grupo B - 2 linha  Grupo C - 3 linha)
T= transicao;
resultadoC = round(T^30 * X0alunos) 

%% Ex 2 - alinea D
X0 = [90/3;90/3;90/3];
resultadoD = round(T^30*X0)