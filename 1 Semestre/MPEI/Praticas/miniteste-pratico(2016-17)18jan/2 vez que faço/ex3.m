T = [0.7 0.2 0 0 0 0
     0.2 0 0.3 0 0 0
     0 0.6 0.3 0 0 0
     0.1 0.2 0.3 0.1 0 0
     0 0 0 0.4 1 0
     0 0 0.1 0.5 0 1]
 
r0 = [1;0;0;0;0;0];
aux = T^9*r0;
RespostaC = aux(3)
aux1 = T^14*r0;
RespostaD = aux(4)

Q = T(1:4,1:4)
F = inv(eye(size(Q))-Q)
aux = sum(F)
Resposta = aux(3)