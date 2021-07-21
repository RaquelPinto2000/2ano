% Raquel Resende Milheiro Pinto NMEC = 92948
clc;clear all; close all
% estado 1 = Presente, estado 2 = Faltar 
%% Ex 1 - alinea A (resutado para a 2 iteracao)
estados = [0.7 0.8;
           0.3 0.2];

Xo = [1;0];

aux = estados^2 * Xo;
resultadoA = aux(1)

%% Ex 1 - alinea B (resultados para a 2 iteracao)
Xo = [0;1];
aux = estados^2 * Xo;
resultadoB = aux(2)

%% Ex 1 - alinea C (resultados para a 15 iteracoes)
Xo = [1;0];
aux = estados^15 * Xo;
resultadoC = aux(1)

%% Ex 1 - alinea D (resultados para a iteracao 30)
Xo = [0.85 ; 0.15];
aux = estados^30*Xo;
resultadosD = aux(2) % ao fim de 30 iteracoes (30 aulas)
for i = 1:30
    grafico = estados^(i)*Xo;
    resultados(i) = grafico(2);
end
  stem(resultados)