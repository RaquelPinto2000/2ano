import java.util.*;
public class Execute extends CalculatorBaseVisitor<Integer> {
	HashMap <String,Integer> map = new HashMap <String,Integer> ();
   
   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      try{System.out.println("Resultado: " + visit(ctx.expr()) + "\n"); }
      catch(NullPointerException e) { 
         try{ visit(ctx.assignment());}
         catch(NullPointerException e1){ System.err.println("ERROR: insert an expression\n"); } 
      }
      
      
      return visitChildren(ctx);
   }

   @Override public Integer visitAssignment(CalculatorParser.AssignmentContext ctx) {
	   String s = ctx.ID().getText();
	   int value;
	   try{
		   value = visit(ctx.expr());
	   }catch(NullPointerException e){
		   return null;
	   }
	   map.put(s,value);
	   System.out.println(s+" = "+map.get(s)+"\n");
       return null;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
        Integer op1 = visit(ctx.expr(0));
	    Integer op2 = visit(ctx.expr(1));
	    switch(ctx.op.getText()){
		   case("+"):
				return op1 + op2;
		   case("-"):
				return op1 - op2;	   
	   }
	   
      return null;
   }

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Integer visitExprNegativeNumber(CalculatorParser.ExprNegativeNumberContext ctx) {
      return -Integer.parseInt(ctx.Integer().getText());
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText());
   }

   @Override public Integer visitExprId(CalculatorParser.ExprIdContext ctx) {
	   if(!map.containsKey(ctx.ID().getText())){
		   System.err.println("variavel " + ctx.ID().getText() + "nao existe");
		   return null;
	   }
      return map.get(ctx.ID().getText());
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
       Integer op1 = visit(ctx.expr(0));
	   Integer op2 = visit(ctx.expr(1));
	   switch(ctx.op.getText()){
		   case("*"):
				return op1 * op2;
			case("/"):
				if(op2 == 0){
					System.err.println("operacao invalida");
					return null;
				}
				return op1 / op2;
			case("%"):
				if(op2 == 0){
					System.err.println("operacao invalida");
					return null;
				}
				return op1 % op2;		   
	   }
	   
      return null;
   }
}
