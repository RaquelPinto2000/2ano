import java.util.*;
public class Interpreter extends MyGrammarBaseVisitor<String> {
   HashMap <String,String> map = new HashMap<>();
   Scanner sc = new Scanner(System.in);

   @Override public String visitPrint(MyGrammarParser.PrintContext ctx) {
      String res = visit(ctx.expr());
      if(res!=null){
         System.out.println(res);
      }
      return res;
   }

   @Override public String visitAssigment(MyGrammarParser.AssigmentContext ctx) {
      String nome = ctx.ID().getText();
      String res = visit(ctx.expr());
      if(res != null && !map.containsKey(nome)){
         map.put(nome,res);
         return res;
      }
      return null;
   }

   @Override public String visitExprReplace(MyGrammarParser.ExprReplaceContext ctx) {
      String nome=visit(ctx.expr(0));
      String s1 = visit(ctx.expr(1));
      String s2 = visit(ctx.expr(2));
      String res=null;
      if(nome!=null && s1!=null && s2!=null){
         res=nome.replaceAll(s1,s2);
      }
      return res;
   }

   @Override public String visitExprString(MyGrammarParser.ExprStringContext ctx) {
      return ctx.String().getText();
   }

   @Override public String visitExprConcatenate(MyGrammarParser.ExprConcatenateContext ctx) {
      String res=null;
      String s1=visit(ctx.expr(0));
      String s2 = visit(ctx.expr(1));
      if(s1!=null && s2!=null){
         res=s1+s2;
      }
      return res;
   }


   @Override public String visitExprInput(MyGrammarParser.ExprInputContext ctx) {
      String res =null;
      String message = visit(ctx.expr());
      if(message!=null){
         System.out.println(message);
         res = sc.nextLine();
      }
      return res;
   }

   @Override public String visitExprID(MyGrammarParser.ExprIDContext ctx) {
      String res= null;
      String id=ctx.ID().getText();
      if(id!=null){
         if( map.containsKey(id)){
            res=map.get(id);
         }else{
            System.err.println("ERRO: A variavel "+id+" nao existe");
         }
      }
     
      return res;
   }
}
