public class Interpreter extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
		System.out.println("(" + visit(ctx.expr()) + ")");
      return visitChildren(ctx);
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

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
       Integer op1 = visit(ctx.expr(0));
	   Integer op2 = visit(ctx.expr(1));
	   switch(ctx.op.getText()){
		   case("*"):
				return op1 * op2;
			case("/"):
				return op1 / op2;
			case("%"):
				return op1 % op2;		   
	   }
	   
      return null;
   }
}
