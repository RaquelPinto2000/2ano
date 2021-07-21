% Raquel Resende Milheiro Pinto NMEC = 92948
clc;clear all;close all;
%% Ex 3
t = rand(20); % matriz transicao
X0=0;
for i=1:length(t)
    t(:,i)= t(:,i)./sum(t(:,i))  % obter a probabilidade cada elemento/pela soma de cada coluna
    X0=[X0;t(i)]
end
X0 = X0(2:end)
%para 20 iteracoes
aux = t^20*X0;
resultado_20= aux(length(aux))
%para 40 iteracoes
aux = t^40*X0;
resultado_40= aux(length(aux))
%para 100 iteracoes
aux = t^100*X0;
resultado_100= aux(length(aux))
