% Raquel Resende Milheiro Pinto NMEC = 92948
clc;clear all;close all;
% 1 estado = sol, 2 estado = nuvens, 3 estado = chuva
%% Ex 5 - alinea A 

T = [0.7 0.2 0.1
    0.2 0.3 0.5
    0.3 0.3 0.4];

%% Ex 5 - alinea B
X0 = [1;0;0];
aux = T^2*X0;
resultadoB = aux(3)

%% Ex 5 - alinea C
for i = 1:20
    grafico = T^(i)*X0;
    resultadosSol(i) = grafico(1);
    resultadosNuvens(i) = grafico(2);
    resultadosChuva(i) = grafico(3);
end
  subplot(2,2,1)
  stem(resultadosSol),title('Sol')
  subplot(2,2,2)
  stem(resultadosNuvens),title('Nuvens')
  subplot(2,2,3)
  stem(resultadosChuva),title('Chuva')
  
 %% Ex 5 - alinea D
 X0 = T
 i =1;
while (true)
    grafico = T^(i)*X0;
    resultadosSol(i) = grafico(1);
    resultadosNuvens(i) = grafico(2);
    resultadosChuva(i) = grafico(3);
    if (i>1)
        if max(abs(resultadosSol(i)-resultadosSol(i-1)))<10^(-4)
            break;
        end
        if max(abs(resultadosNuvens(i)-resultadosNuvens(i-1)))<10^(-4)
            break;
        end
         if max(abs(resultadosChuva(i)-resultadosChuva(i-1)))<10^(-4)
            break;
         end
    end
    i=i+1;
end
figure
subplot(2,2,1)
stem(resultadosSol),title('Sol')
subplot(2,2,2)
stem(resultadosNuvens),title('Nuvens')
subplot(2,2,3)
stem(resultadosChuva),title('Chuva')
  