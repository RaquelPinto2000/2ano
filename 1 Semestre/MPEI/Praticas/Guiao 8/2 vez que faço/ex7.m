clc;clear all;close all;
% estado 1 = Ana , estado 2 = Bernardo, estado 3 = Catarina
%% Ex 7 - alinea A 
T = [0.8 0.1 0.05
     0.2 0.6 0.2
     0 0.3 1-0.25];
X0=[100;200;30]; %estado inicial do dia 1 de janeiro ao 12h

aux = T^3*X0; 
ResultadoA_Ana = aux(1)
ResultadoA_Bernardo = aux(2)
ResultadoA_Catarina = aux(3)

%% Ex 7 - alinea B
% o ano de 2016 teve 366 dias
aux = T^365*X0;
ResultadoB_Ana= aux(1)
ResultadoB_Bernardo = aux(2)
ResultadoB_Catarina = aux(3)
%% Ex 7 - alinea C
dias=1;
while(true)
    aux = T^dias*X0;
    if(aux(3)>130)
        break;
    end
    dias = dias +1
end
RespostaC = dias % dia 9 de janeiro