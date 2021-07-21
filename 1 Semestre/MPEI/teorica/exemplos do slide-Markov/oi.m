clc, clear all, close all
n = 10000;
x = linspace(-2,2,n);
y = linspace(-2,2,n);
f = (x.^2+y.^2-1).^3-x.^2.*y.^3;
plot(x,f,'r')