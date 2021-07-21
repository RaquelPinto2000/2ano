clc;clear all; close all;
%% Ex 2 - alinea A
T = [0.84 0.1 0 0.5
     0.1 0.7 0 0.1
     0.05 0.1 0.8 0.1
     0.01 0.1 0.2 0.3];
X0 = [1;2;10;5]
aux = T^7*X0;
Angola = aux(1)
Brasil = aux(2)
Chile = aux(3)
Dinamarca = aux(4)

%% Ex 2 - alinea B
i=1;
while(true)
   atual = T^i*X0;
   anterior = T^(i-1)*X0
   if(atual(1)>anterior(1))
       Max_Angola = atual(1);
   end
   if(atual(2)>anterior(2))
       Max_Brasil = atual(2);
   end
   if(atual(3)>anterior(3))
       Max_Chile = atual(3);
   end
   if(atual(4)>anterior(4))
       Max_Dinamarca = atual(4);
   end
   if( isequal(atual,anterior)==1)
       break;
   end
   i = i+1;
end
if (Max_Angola < X0(1))
    Max_Angola = X0(1);
end

if(Max_Brasil < X0(2))
    Max_Brasil = X0(2);
end
if(Max_Chile < X0(3))
    Max_Chile = X0(3);
end
if(Max_Dinamarca < X0(4))
    Max_Dinamarca = X0(4);
end
Max_Angola
Max_Brasil
Max_Chile
Max_Dinamarca
%% Ex 2 - alinea C
i=0;
while(true)
    aux = T^i*X0;
    if(aux(4)<2)
        break;
    end
   i=i+1;
end
dia = 1
mes = i % ao fim de i iteracoes
