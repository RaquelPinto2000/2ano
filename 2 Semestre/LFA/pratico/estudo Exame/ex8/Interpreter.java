import java.util.*;

public class Interpreter extends CalculatorBaseVisitor<Object> {
   private HashMap<String,Fractions> map = new HashMap<>();
   

   @Override public Object visitPrint(CalculatorParser.PrintContext ctx) {
      Fractions res = (Fractions) visit(ctx.expr());
      if(res!=null){
         System.out.println(res.toString());
      }
      return res;
   }

   @Override public Object visitAssigment(CalculatorParser.AssigmentContext ctx) {
      if(map.containsKey(ctx.ID().getText())){
         return null;
      }else{
         Fractions res = (Fractions) visit(ctx.expr());
         map.put(ctx.ID().getText(),res);
         return res;
         
      }
   }

   @Override public Object visitExprFrac(CalculatorParser.ExprFracContext ctx) {
      String n = ctx.Number(0).getText();
      String d = ctx.Number(1).getText();
      Fractions res = null;
      if(n!=null && d!= null){
         res = new Fractions(Integer.parseInt(n),Integer.parseInt(d));
      }
      return res;
   }

   @Override public Object visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Fractions f1 = (Fractions) visit(ctx.expr(0));
      Fractions f2 = (Fractions) visit(ctx.expr(1));
      Fractions res = null;
      String op = ctx.op.getText();
      switch(op){
         case "+":
            res = f1.add(f2);
            break;
         case "-": 
            res = f1.sub(f2);
            break;
         default:
            System.err.println("ERRO: should be add or sub operation");
      }
      return res;
   }


   @Override public Object visitExprPow(CalculatorParser.ExprPowContext ctx) {
      Fractions f1 = (Fractions) visit(ctx.expr(0));
      int potencia = (int) visit (ctx.expr(1));
      return f1.pow(potencia);
   }
   
   @Override public Object visitExprRead(CalculatorParser.ExprReadContext ctx) {
      String chave = ctx.ler.getText();
      Fractions res = null;
     
         if(map.containsKey(chave)){
            res = map.get(chave);
         }
      
     
      return res;
   }

   @Override public Object visitExprMulDiv(CalculatorParser.ExprMulDivContext ctx) {
      Fractions f1 = (Fractions) visit(ctx.expr(0));
      Fractions f2 = (Fractions) visit(ctx.expr(1));
      Fractions res = null;
      String op = ctx.op.getText();
      switch(op){
         case "*":
            res = f1.add(f2);
            break;
         case ":": 
            res = f1.sub(f2);
            break;
         default:
            System.err.println("ERRO: should be mult or div operation");
      }
      return res;
   }

   @Override public Object visitExprParent(CalculatorParser.ExprParentContext ctx) {
      Fractions res = (Fractions) visit(ctx.expr());
      return res;
   }

   @Override public Object visitExprNumber(CalculatorParser.ExprNumberContext ctx) {
      return new Fractions (Integer.parseInt(ctx.Number().getText()));
      //OU
      /*Fractions res = null;
      String num = ctx.Number().getText();
      if(num!=null){
         res = new Fractions (Integer.parseInt(num));
      }
      return res;*/
   }

   @Override public Object visitExprReduce(CalculatorParser.ExprReduceContext ctx) {
      Fractions res = null;
      Fractions f1 = (Fractions) visit(ctx.expr());
      res = f1.reduce();
      return res;
   }

   @Override public Object visitExprID(CalculatorParser.ExprIDContext ctx) {
      if(map.containsKey(ctx.ID().getText())){
         return map.get(ctx.ID().getText());
      }else{
         System.err.println("ERRO: A variavel " + ctx.ID().getText() + "nao existe");
         return null;
      }
   }

   @Override public Object visitExprPosNeg(CalculatorParser.ExprPosNegContext ctx) {
      String signal = ctx.signal.getText();
      Fractions res = null;
      switch(signal){
         case "+":
            res = (Fractions) visit(ctx.expr());
            break;
         case "-":
            Fractions aux = (Fractions) visit(ctx.expr());
            if(aux.getDem()!=0 && aux.getNum()!=0){
               res = new Fractions(aux.getNum(),aux.getDem());
            }else{
               res = new Fractions(aux.getNum());
            }
            break;
      }
      return res;
   }
}
