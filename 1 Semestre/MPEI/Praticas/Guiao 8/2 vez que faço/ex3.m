clc; clear all; close all;
%% Ex 3
T = rand(20,20); % matriz 20 por 20 - elementos de cada posicao (como no ex 2 com os alunos)
X0=0;
for i = 1:length(T)
    %T(:,i) % da-nos as colunas todas
     T(:,i) =  T(:,i)/sum( T(:,i));  % a matriz com as probabilidades dos elementos
     X0=[X0;T(i)]; % partimos do principio que o estado inicial e a primeira coluna da matriz T, ou seja, existe coisas distribuidas por todos os estados (como ex 2 B)
end 
X0 = X0 (2:end); % para tirar o 0 do inicio do vetor (vai da posicao 2 ate ao final do array)
%zeros(19,1) % 19 zeros numa coluna (19 linhas e uma coluna de zeros)
%X0 = [1; zeros(19,1)]; % Se fizeres assim partes do principio que o estado
%inicial é o primeiro estado, e esta todas as coisas nele

% 20 transicoes
aux = T^20*X0;
Resultado20 = aux(20)
% 40 transicoes
aux = T^40*X0;
Resultado40 = aux(20)
% 100 transicoes
aux = T^100*X0;
Resultado100 = aux(20)