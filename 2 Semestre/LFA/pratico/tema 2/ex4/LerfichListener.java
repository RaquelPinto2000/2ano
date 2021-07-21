// Generated from Lerfich.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LerfichParser}.
 */
public interface LerfichListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LerfichParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LerfichParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LerfichParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LerfichParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LerfichParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(LerfichParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LerfichParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(LerfichParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadLine}
	 * labeled alternative in {@link LerfichParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReadLine(LerfichParser.ReadLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadLine}
	 * labeled alternative in {@link LerfichParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReadLine(LerfichParser.ReadLineContext ctx);
}