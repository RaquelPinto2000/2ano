T = [0.9 0.5 0.5
     0.09 0.4 0.4
     0.01 0.1 0.1]
V = [0;0;1]

aux = T^3*V;
Resposta_Sem = aux(1)
Resposta_Cum = aux(2)
Resposta_C2=aux(3)


i=1;

while (true)
   aux = T^i*V;
   auxant=T^(i-1)*V;
   if (aux - auxant)<0.001 
        aux = auxant
       break
   end
   
   i = i+1;
end
% se o aux- auxant for < que 0.001, significa que e o anterior que
% queremos, pq esse de agora ja nao conta, pois primeiro fiz as contas e so
% depois e que testei

Resultado_PerdaPacote = aux(3)

Resultado_PerdaPacote_SemCorretor = aux(2) + aux(3)