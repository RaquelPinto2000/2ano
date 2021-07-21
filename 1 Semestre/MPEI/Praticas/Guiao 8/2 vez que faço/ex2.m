clc; clear all; close all;
% Estado 1 = grupo A Estado 2 = grupo B Estado 3 = grupo C
%% Ex 2 - alinea A 
T = [1/3 1/4 0
    1/3 0.55 1/2 
    1/3 1/5 1/2]

verificar = sum(T)

%% Ex 2 - alinea B
Matriz1 = [1 1 1
           1 -2 -2 
           0 1 -1];
Matriz2 = [90;0;0];
X0alunos = inv(Matriz1) * Matriz2 % vetor com o numero de alunos de cada grupo
%X0alunos = Matriz1\Matriz2 (resolve um sistema de equacoes)
X0=0;
for i=1:length(X0alunos)
    X0 = [X0;X0alunos(i)/90]; %matriz coluna - concatenar valores(tens de ter [X0;...] se nao nao concatena
end
X0 = X0(2:end) % tira o 0 inicial do X0

%% Ex 2 - alinea C
%aux = ceil(T^30*X0alunos) %arredonda para cima
aux = floor (T^30*X0alunos)  % arredonda para baixo
ResultadoCgrupoA = aux(1)
ResultadoCgrupoB = aux(2)
ResultadoCgrupoC = aux(3)

%% Ex 2 - alinea D
X0alunos=[90/3; 90/3 ;90/3]
aux = fix (T^30 * X0alunos)
ResultadoCgrupoA = aux(1)
ResultadoCgrupoB = aux(2)
ResultadoCgrupoC = aux(3)