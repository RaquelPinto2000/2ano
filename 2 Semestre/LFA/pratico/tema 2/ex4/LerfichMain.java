import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
public class LerfichMain { // tem de ler do ficheiro "numbers_ex3.txt"
   public static void main(String[] args) throws Exception {
	   
		try{
		
		   
			  // create a CharStream that reads from standard input:
			  CharStream input = CharStreams.fromStream(System.in);
			  // create a lexer that feeds off of input CharStream:
			  LerfichLexer lexer = new LerfichLexer(input);
			  // create a buffer of tokens pulled from the lexer:
			  CommonTokenStream tokens = new CommonTokenStream(lexer);
			  // create a parser that feeds off the tokens buffer:
			  LerfichParser parser = new LerfichParser(tokens);
			  // replace error listener:
			  //parser.removeErrorListeners(); // remove ConsoleErrorListener
			  //parser.addErrorListener(new ErrorHandlingListener());
			  // begin parsing at line rule:
			  ParseTree tree = parser.line();
			  if (parser.getNumberOfSyntaxErrors() == 0) {
				 // print LISP-style tree:
				 // System.out.println(tree.toStringTree(parser));
				 ParseTreeWalker walker = new ParseTreeWalker();
				 Lerfich listener0 = new Lerfich();
				 walker.walk(listener0,tree);
			  }
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}catch (RecognitionException e){
			e.printStackTrace();
			System.exit(1);
		}
   }
}
