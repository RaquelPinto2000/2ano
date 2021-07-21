% Raquel Resende Milheiro Pinto NMEC = 92948
clc;clear all;close all;
%(1 estado = 1, 2 estado= 2, 3 estado = 3, 4 estado=4)-> Nao consegui
%fazer a alinea i deste ex
%% Ex 6 - alinea A
%matriz de transicao (alinea A)
H = [ 0.8 0 0.3 0 
     0.2 0.9 0.2 0
     0 0.1 0.4 0 
     0 0 0.1 1]; 
%% Ex 6 - alinea B
X0 = [1;0;0;0];
aux = H^1000*X0;
resultadoB = aux(2)
%como os estados sao absorventes, estavamos a espera de um valor proximo de
%0 o que aconteceu.

%% Ex 6 - alinea C
for k=1:4
    X0=zeros(4,1);
    X0(k) = 1;
    for i = [1 2 10 100]
        i % o numero de passos
        aux = H^i*X0;
        EstadoA=aux(1)
        EstadoB=aux(2)
        EstadoC=aux(3)
        EstadoD=aux(4)
    end
end 
%% Ex 6 - alinea D
Q = H(1:3,1:3)
%% Ex 6 - alinea E
aux= eye(size(Q))-Q;
F=inv(aux)
%% Ex 6 - alinea F
%comecar na pagina 1
aux =F(3,1:3);
resultado_comecarpagina1 = aux(1)
resultado_comecarpagina2 = aux(2)
resultado_comecarpagina3 = aux(3)
%% Ex 6 - alinea G
pagina1 =sum(F(1:3,1))
pagina2=sum(F(1:3,2))
pagina3=sum(F(1:3,3))
%% Ex 6 - alinea H
H = [ 0.8 0 0.3+(0.1-0.01) 0 
     0.2 0.9 0.2 0
     0 0.1 0.4 0 
     0 0 0.01 1]
Q = H(1:3,1:3)
aux= eye(size(Q))-Q;
F=inv(aux) 