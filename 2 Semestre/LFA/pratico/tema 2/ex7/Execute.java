public class Execute extends CalculatorBaseVisitor<String> {

   @Override public String visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitStat(CalculatorParser.StatContext ctx) {
     if(ctx.assignment()!= null){
       System.out.println(visit(ctx.assignment()) + "\n");
     }

     if(ctx.expr()!= null){
       System.out.println(visit(ctx.expr()) + "\n");
     }
     return null;
   }

   @Override public String visitAssignment(CalculatorParser.AssignmentContext ctx) {
      return ctx.ID()+ " = " + visit(ctx.expr());
   }

   @Override public String visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
     return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + ctx.op.getText();
   }

   @Override public String visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitExprNegativeNumber(CalculatorParser.ExprNegativeNumberContext ctx) {
     return "-" + ctx.Integer().getText();
   }

   @Override public String visitExprUnary(CalculatorParser.ExprUnaryContext ctx) {
      return visit(ctx.expr()) + " " + "!" + " " + ctx.unaryOp.getText()     ;
   }

   @Override public String visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return ctx.Integer().getText();
   }

   @Override public String visitExprId(CalculatorParser.ExprIdContext ctx) {
      return ctx.ID().getText();
   }

   @Override public String visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + ctx.op.getText();
   }
}
