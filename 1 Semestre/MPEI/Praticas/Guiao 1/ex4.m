function [probSimulacao] = ex4(p,l,c,e)

%simulacao
lancamentos = rand(l,e) >p;
sucessos = sum(lancamentos) >=c;
probSimulacao = sum(sucessos)/e;
end

