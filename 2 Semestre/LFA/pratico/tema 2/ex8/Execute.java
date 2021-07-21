import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Execute extends CalculatorBaseVisitor<Fractions> {
    HashMap<String, Fractions> map = new HashMap<String, Fractions>();

   @Override public Fractions visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fractions visitStat(CalculatorParser.StatContext ctx) {
     try{ visit(ctx.expr()); }
     catch(NullPointerException e) {
        try{ visit(ctx.print());}
        catch(NullPointerException e0) {
           try{ visit(ctx.assignment()); }
           catch(NullPointerException e1){ }
        }
     }
     return null;
   }

   @Override public Fractions visitAssignment(CalculatorParser.AssignmentContext ctx) {
      map.put(ctx.ID().getText(), visit(ctx.expr()));
      return null;
   }

   @Override public Fractions visitPrint(CalculatorParser.PrintContext ctx) {
       Fractions result = visit(ctx.expr());
       if(result!=null)
          System.out.println(result);
       return null;
   }

   @Override public Fractions visitReduce(CalculatorParser.ReduceContext ctx) {
      return visit(ctx.expr()).reduce();
   }
/*
   @Override public Fractions visitRead(CalculatorParser.ReadContext ctx)  {
      Scanner sc  = new Scanner(System.in);
      System.out.print(ctx.ID().getText()+": ");
      String s = sc.next();
      try{
          Scanner lerfich = new Scanner(new File(s));
          while(lerfich.hasNextLine()){
            String fraction = lerfich.nextLine();
            try{
               String aux[] = fraction.split("/");
               return new Fractions(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
            }
            catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
               System.err.println("ERROR: invalid sintax (insert <number></><number>)");
               return null;
            }
          }
          lerfich.close();
      }catch (FileNotFoundException e) {
        System.err.println("File not found");
        System.exit(1);
      }
      sc.close();
      return null;
   }

   */

   @Override public Fractions visitRead(CalculatorParser.ReadContext ctx)  {
      Scanner sc  = new Scanner(System.in);
      System.out.print(ctx.ID().getText()+": ");
      String s = sc.next();


      String fraction = sc.nextLine();
      try{
         String aux[] = fraction.split("/");
         return new Fractions(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
      }
      catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
         System.err.println("ERROR: invalid sintax (insert <number></><number>)");
         return null;
      }
   }

   @Override public Fractions visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
       Fractions op1 = visit(ctx.expr(0));
       Fractions op2 = visit(ctx.expr(1));
       switch(ctx.op().getText()){
        case("+"):
         return op1.sum(op2);
        case("-"):
         return op1.sub(op2);
      }

       return null;
   }

   @Override public Fractions visitExprRead(CalculatorParser.ExprReadContext ctx) {
      return visit(ctx.read());
   }

   @Override public Fractions visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fractions visitExprNegativeNumber(CalculatorParser.ExprNegativeNumberContext ctx) {
      return new Fractions(-Integer.parseInt(ctx.Integer().getText()));
   }

   @Override public Fractions visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return new Fractions(Integer.parseInt(ctx.Integer().getText()));

   }

   @Override public Fractions visitExprReduce(CalculatorParser.ExprReduceContext ctx) {
      return visit(ctx.reduce());
   }

   @Override public Fractions visitExprId(CalculatorParser.ExprIdContext ctx) {

       if(!map.containsKey(ctx.ID().getText())){
          System.err.println("variavel " + ctx.ID().getText() + "nao existe");
          return null;
      }
        Fractions result = map.get(ctx.ID().getText());
        return result;
   }

   @Override public Fractions visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
       Fractions op1 = visit(ctx.expr(0));
       Fractions op2 = visit(ctx.expr(1));
       switch(ctx.op().getText()){
          case "*":
             return op1.mult(op1);
          case ":":
             return op2.div(op1);
       }
       return null;
   }

   @Override public Fractions visitExprFraction(CalculatorParser.ExprFractionContext ctx) {
     return new Fractions(Integer.parseInt(ctx.expr(0).getText()), Integer.parseInt(ctx.expr(1).getText()));

   }

   @Override public Fractions visitOp(CalculatorParser.OpContext ctx) {
      return visitChildren(ctx);
   }
}
