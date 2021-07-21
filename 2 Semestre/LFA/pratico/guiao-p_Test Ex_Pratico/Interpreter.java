import java.util.*;
public class Interpreter extends TestBaseVisitor<String> {
   private static HashMap <String,String>sysbolTable = new HashMap<String,String>();
   private static Scanner sc = new Scanner(System.in);
   @Override public String visitProgram(TestParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitStat(TestParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitAssignment(TestParser.AssignmentContext ctx) {
      
      String expr = visit(ctx.expr());
      if(expr!=null){
         String id = ctx.ID().getText();
         sysbolTable.put(id,expr);
      }
      return expr;
   }

   @Override public String visitPrint(TestParser.PrintContext ctx) {
      String expr = visit(ctx.expr());
      if(expr!=null){
         System.out.print(expr);
      }
      return expr;
   }
   @Override public String visitExprInput(TestParser.ExprInputContext ctx) {
      String im = visit(ctx.expr());
      
      if(im!=null){
        
         System.out.print(im + ':');
         String s = sc.nextLine();
         System.out.println('\n' + s);
      }
      return im;
   }

   @Override public String visitExprID(TestParser.ExprIDContext ctx) {
      String id = ctx.ID().getText();
      if(!sysbolTable.containsKey(id)){
         System.err.println("ERRO: variavel "+ id + " nao existe");
         return null;
     }
     return sysbolTable.get(id);
   }

   @Override public String visitExprString(TestParser.ExprStringContext ctx) {
      return ctx.String().getText();
   }
}
