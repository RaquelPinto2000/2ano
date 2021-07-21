public class Fractions{
    private int dem=0;
    private int num =0;

    public Fractions(int num,int dem){
        this.num=num;
        this.dem=dem;
    }
    public Fractions(int num){
        this.num=num;
        this.dem=1;
    }

    public int getDem(){
        return dem;
    }
    public int getNum(){
        return num;
    }

    // adicionar uma fracao a outra
    public Fractions add(Fractions f){
        int n = (num*f.dem) + (f.num*dem);
        int d = dem*f.dem;
        return new Fractions(n,d);
    }
    //subtrair uma fração
    public Fractions sub(Fractions f){
        int n = (num*f.dem) - (f.num*dem);
        int d = dem*f.dem;
        return new Fractions(n,d);
    }

    // multiplicar
    public Fractions mult(Fractions f){
        int n = num*f.num;
        int d = dem*f.dem;
        return new Fractions(n,d);
    }
    // dividir
    public Fractions div(Fractions f){
        int n = num*f.dem;
        int d = dem * f.num;
        return new Fractions(n,d);
    }
    //elevado
    public Fractions pow(int p){
        int n=0;
        int d =0;
        if(p>0){
            n = (int) (Math.pow(num,p));
            d = (int) (Math.pow(dem,p));
        }else if( p<0){
            n = (int) (Math.pow(dem,p));
            d = (int) (Math.pow(num,p)); 
        }else{// = 0
            n = 1;
            d = 1;
        }
        return new Fractions(n,d);
    }

    //reduzir
    public Fractions reduce(){
        int mdc = MDC(num,dem);
        int n =0;
        int d = 0;
        if(mdc>1){
          n =  num/mdc;
          d = dem/mdc;
        }else{
          n =  num;
          d = dem;
        }
        return new Fractions(n,d);
    }

    public int MDC(int a, int b){
        if(b==0) return a;
        else return MDC(a, a%b);
    }

    @Override
    public String toString(){
        return num+(dem == 1 ? "" : "/"+dem);
    }
}
