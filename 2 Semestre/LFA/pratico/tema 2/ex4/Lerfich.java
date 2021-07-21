import java.util.*;
public class Lerfich extends LerfichBaseListener {
	HashMap <String,Integer> map = new HashMap <> ();
   
   @Override public void enterReadLine(LerfichParser.ReadLineContext ctx) {
	   map.put(ctx.Word().getText(),Integer.parseInt(ctx.Integer().getText()));   
   }  
}
