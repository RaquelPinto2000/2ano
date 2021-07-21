

public class Fractions{
  private int numerador; // numero de cima
  private int denominador; // numero de baixo

  // Construtores
  public Fractions(int n, int d){
    numerador = n;
    denominador=d;
  }
  public Fractions(int n){
    numerador = n;
    denominador=n;
  }

  public int numerador (){
    return numerador;
  }
  public int denominador(){
    return denominador;
  }
  public Fractions sum(Fractions a){
    int num = numerador*a.denominador() + denominador*a.numerador();
    int deno= denominador*a.denominador();
    return new Fractions(num,deno);
  }

  public Fractions sub(Fractions a){
    int num = numerador*a.denominador() - denominador*a.numerador();
    int deno= denominador*a.denominador();
    return new Fractions(num,deno);
  }

  public Fractions mult(Fractions a){
    int num = numerador*a.numerador();
    int deno=denominador*a.denominador();
    return new Fractions(num,deno);
  }

  public Fractions div(Fractions a){
    int num = numerador*a.denominador();
    int deno=denominador*a.numerador();
    return new Fractions(num,deno);
  }

  public Fractions expr(int exp){ // expoente
      int num = 0;
      int deno = 0;
    if(exp>=0){
      num = (int) Math.pow(numerador,exp);
      deno=(int) Math.pow(denominador,exp);
    }else{
      exp=(-exp);
      num = (int) Math.pow(denominador,exp);
      deno= (int) Math.pow(numerador,exp);
    }

    return new Fractions(num,deno);
  }

  public Fractions reduce(){
    int mdc = MDC(numerador,denominador);
    int num =0;
    int deno = 0;
    if(mdc>1){
      num =  numerador/mdc;
      deno= denominador/mdc;
    }else{
      num =  numerador;
      deno= denominador;
    }
    return new Fractions(num,deno);
  }
  public int MDC(int a, int b){
      if(b==0) return a;
      else return MDC(a, a%b);
  }
}
