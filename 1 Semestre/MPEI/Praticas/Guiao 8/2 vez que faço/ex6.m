clc;clear all; close all;
% 1 estado = 1, 2 estado = 2, 3 estado = 3, 4 estado = 4
%% Ex 6 - alinea A
H = [0.8 0 0.3 0
    0.2 0.9 0.2 0
    0 0.1 0.4 0
    0 0 0.1 1]
%% Ex 6 - alinea B
X0=[1;0;0;0];
aux = H^1000*X0;
ResultadoB = aux(2)%como um dos estados é absorvente (estado 4), 
%estavamos a espera de um valor proximo de 0, o que aconteceu.
% o vetor fica todo 0 exceto no sitiu do estado absorvente(4) = 1

%% Ex 6 - alinea C
for j = 1:4
X0=[zeros(4,1)];
X0(j)=1;
    for i=[1 2 10 100]
        npassos = i
        aux= H^i * X0;
        Estado1 = aux(1)
        Estado2 = aux(2)
        Estado3 = aux(3)
        Estado4 = aux(4)
    end
end
%% Ex 6 - alinea D
Q=H(1:3,1:3)
%Q=[0.8 0 0.3
%   0.2 0.9 0.2
%   0 0.1 0.1]
%% Ex 6 - alinea E
aux = eye(size(Q))- Q;
F = inv(aux)
%% Ex 6 - alinea F
aux = sum(F);
resultado_comecarpagina1 = aux(1)
resultado_comecarpagina2 = aux(2)
resultado_comecarpagina3 = aux(3)
% ele depois chega ao 4 e fica sempre la (estado absorvente) - por isso so
% interesa o numero de visitas aos estados todos ate a absorcao
%% Ex 6 - alinea G = F

Tpagina1 = sum(F(1:3,1))
Tpagina2 = sum(F(1:3,2))
Tpagina3 = sum(F(1:3,3))
%% Ex 6 - alinea H
%Para isso tens que mudar(aumentar) no caminho do 3 para o 1 e diminuir no
%caminho do 3 para o 4. Demorara a ir mais para o 4 quando a probabilidade
%de ir para la for menor, a mais baixa possivel e de 0.01 pq se fosse de 0
%nao ia para la
Hnova = [ 0.8 0 0.3+(0.1-0.01) 0 
     0.2 0.9 0.2 0
     0 0.1 0.4 0 
     0 0 0.01 1]
Qnova=Hnova(1:3,1:3)
aux = eye(size(Qnova))-Qnova;
Fnova=inv(aux)
Tpagina1 = sum(Fnova(1,1:3))
Tpagina2 = sum(Fnova(2,1:3))
Tpagina3 = sum(Fnova(3,1:3))
 %% Ex 6 - alinea I  (slides)
T=sum(F)
Ntry = 1000;
to=4;
for from=1:3
    R = zeros(1,Ntry);
    for n = 1:Ntry
        state = crawl(H,from,to);
        R(n)=length(state);
    end
    m = mean(R);
    fprintf(1, 'De%d para %d (absorvente):\n\tSIMUL(%d iters) = %.2f Teorico (usado F) = %.2f\n',from,to,Ntry,m,t(from));
end

function state = crawl(H,first,last)
    state = [first];
    while(1)
        state (end+1) = nextState(H,state(end));
        if(state(end) == last) break;
        end
    end
end

function state = nextState(H, currentState)
probVector = H(:,currentState);
N = length(probVector);
state  = discrete_rnd(N,probVector);
state = state(1);
end