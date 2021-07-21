clc;clear all; close all;
% 1 estado = sol, 2 estado = nuvens, 3 estado = chuva
%% Ex 5 - alinea A
T = [0.7 0.2 0.1
    0.2 0.3 0.5
    0.3 0.3 0.4]
%% Ex 5 - alinea B
X0 = [1;0;0];
aux = T^2*X0;
ResultadoB = aux(3)
%% Ex 5 - alinea C
for i=1:20
    auxg = T^(i);
    graficoSol(i) = auxg(1);
    graficoNuvens(i) = auxg(2);
    graficoChuva(i) = auxg(3);
end
subplot(2,2,1)
stem(graficoSol), title('Sol')
%plot(graficoSol), title('Sol') - ve-se melhor assim
subplot(2,2,2)
stem(graficoNuvens),title('Nuvens')
subplot(2,2,3)
stem(graficoChuva),title('Chuva')
%% Ex 5 - alinea D
i=1;
while(true)
    auxg = T^(i);
    graficoSol(i) = auxg(1);
    graficoNuvens(i) = auxg(2);
    graficoChuva(i) = auxg(3);
    if(i>1)
        if(max(abs(graficoSol(i)-graficoSol(i-1))<10^-4)) % max, e para determinar o maximo de alguma coisa
            break;
        end
        if(max(abs(graficoNuvens(i)-graficoNuvens(i-1))<10^-4))
            break;
        end
        if(max(abs(graficoChuva(i)-graficoChuva(i-1))<10^-4))
            break;
        end
    end
    i = i + 1;    
end
figure % é para aparecer os dois graficos
subplot(2,2,1)
stem(graficoSol), title('Sol')
subplot(2,2,2)
stem(graficoNuvens),title('Nuvens')
subplot(2,2,3)
stem(graficoChuva),title('Chuva')