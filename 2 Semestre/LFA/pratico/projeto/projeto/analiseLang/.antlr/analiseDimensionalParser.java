// Generated from /home/lucia/Desktop/lfa1920-g12/analiseLang/analiseDimensional.g4 by ANTLR 4.7.1

        import java.util.Map;
        import java.util.HashMap;
        import lib.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class analiseDimensionalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, Bool=31, BINARY=32, 
		OR=33, AND=34, NOT=35, ID=36, String=37, Real=38, Integer=39, WS=40, COMMENT=41, 
		ERROR=42;
	public static final int
		RULE_main = 0, RULE_program = 1, RULE_type = 2, RULE_loopFor = 3, RULE_loopWhile = 4, 
		RULE_doWhile = 5, RULE_ifCond = 6, RULE_assignment = 7, RULE_declaration = 8, 
		RULE_print = 9, RULE_importFile = 10, RULE_function = 11, RULE_expr = 12;
	public static final String[] ruleNames = {
		"main", "program", "type", "loopFor", "loopWhile", "doWhile", "ifCond", 
		"assignment", "declaration", "print", "importFile", "function", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'integer'", "'real'", "'boolean'", "'string'", "'for'", "'('", 
		"'='", "';'", "')'", "'{'", "'}'", "'while'", "'do'", "'if'", "'then'", 
		"'else'", "'end'", "'print'", "'import'", "'return'", "'^'", "'*'", "'/'", 
		"'+'", "'-'", "'>'", "'<'", "'<='", "'>='", "'=='", null, null, null, 
		null, "'NOT'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "Bool", "BINARY", "OR", "AND", 
		"NOT", "ID", "String", "Real", "Integer", "WS", "COMMENT", "ERROR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "analiseDimensional.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	        static protected Map<String,Symbol> symbolTable = new HashMap<>();

	public analiseDimensionalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(analiseDimensionalParser.EOF, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18))) != 0)) {
				{
				{
				setState(26);
				program();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatForContext extends ProgramContext {
		public LoopForContext loopFor() {
			return getRuleContext(LoopForContext.class,0);
		}
		public StatForContext(ProgramContext ctx) { copyFrom(ctx); }
	}
	public static class StatImportContext extends ProgramContext {
		public ImportFileContext importFile() {
			return getRuleContext(ImportFileContext.class,0);
		}
		public StatImportContext(ProgramContext ctx) { copyFrom(ctx); }
	}
	public static class StatIfCondContext extends ProgramContext {
		public IfCondContext ifCond() {
			return getRuleContext(IfCondContext.class,0);
		}
		public StatIfCondContext(ProgramContext ctx) { copyFrom(ctx); }
	}
	public static class StatAssingContext extends ProgramContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatAssingContext(ProgramContext ctx) { copyFrom(ctx); }
	}
	public static class StatPrintContext extends ProgramContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatPrintContext(ProgramContext ctx) { copyFrom(ctx); }
	}
	public static class StatWhileContext extends ProgramContext {
		public LoopWhileContext loopWhile() {
			return getRuleContext(LoopWhileContext.class,0);
		}
		public StatWhileContext(ProgramContext ctx) { copyFrom(ctx); }
	}
	public static class StatDoContext extends ProgramContext {
		public DoWhileContext doWhile() {
			return getRuleContext(DoWhileContext.class,0);
		}
		public StatDoContext(ProgramContext ctx) { copyFrom(ctx); }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
				_localctx = new StatAssingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				assignment();
				}
				break;
			case T__17:
				_localctx = new StatPrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				print();
				}
				break;
			case T__4:
				_localctx = new StatForContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				loopFor();
				}
				break;
			case T__11:
				_localctx = new StatWhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				loopWhile();
				}
				break;
			case T__12:
				_localctx = new StatDoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				doWhile();
				}
				break;
			case T__13:
				_localctx = new StatIfCondContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				ifCond();
				}
				break;
			case T__18:
				_localctx = new StatImportContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(40);
				importFile();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type res;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(T__0);
				((TypeContext)_localctx).res =  new IntegerType();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__1);
				((TypeContext)_localctx).res =  new RealType();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(T__2);
				((TypeContext)_localctx).res =  new BooleanType();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(T__3);
				((TypeContext)_localctx).res =  new StringType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopForContext extends ParserRuleContext {
		public Token var;
		public Token n;
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode ID() { return getToken(analiseDimensionalParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Integer() { return getToken(analiseDimensionalParser.Integer, 0); }
		public TerminalNode Real() { return getToken(analiseDimensionalParser.Real, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public LoopForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopFor; }
	}

	public final LoopForContext loopFor() throws RecognitionException {
		LoopForContext _localctx = new LoopForContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_loopFor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__4);
			setState(54);
			match(T__5);
			setState(55);
			((LoopForContext)_localctx).var = match(ID);
			setState(56);
			match(T__6);
			setState(57);
			((LoopForContext)_localctx).n = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Real || _la==Integer) ) {
				((LoopForContext)_localctx).n = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(58);
			match(T__7);
			setState(59);
			((LoopForContext)_localctx).e1 = expr(0);
			setState(60);
			match(T__7);
			setState(61);
			((LoopForContext)_localctx).e2 = expr(0);
			setState(62);
			match(T__8);
			setState(63);
			match(T__9);
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				program();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18))) != 0) );
			setState(69);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopWhileContext extends ParserRuleContext {
		public ExprContext e;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public LoopWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopWhile; }
	}

	public final LoopWhileContext loopWhile() throws RecognitionException {
		LoopWhileContext _localctx = new LoopWhileContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_loopWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__11);
			setState(72);
			match(T__5);
			setState(73);
			((LoopWhileContext)_localctx).e = expr(0);
			setState(74);
			match(T__8);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(75);
				match(T__9);
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76);
					program();
					}
					}
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18))) != 0) );
				setState(81);
				match(T__10);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoWhileContext extends ParserRuleContext {
		public LoopWhileContext loopWhile() {
			return getRuleContext(LoopWhileContext.class,0);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public DoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhile; }
	}

	public final DoWhileContext doWhile() throws RecognitionException {
		DoWhileContext _localctx = new DoWhileContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_doWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__12);
			setState(86);
			match(T__9);
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				program();
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18))) != 0) );
			setState(92);
			match(T__10);
			setState(93);
			loopWhile();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfCondContext extends ParserRuleContext {
		public ProgramContext trueSL;
		public ProgramContext falseSL;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public IfCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCond; }
	}

	public final IfCondContext ifCond() throws RecognitionException {
		IfCondContext _localctx = new IfCondContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifCond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__13);
			setState(96);
			expr(0);
			setState(97);
			match(T__14);
			setState(98);
			((IfCondContext)_localctx).trueSL = program();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(99);
				match(T__15);
				setState(100);
				((IfCondContext)_localctx).falseSL = program();
				}
			}

			setState(103);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public ExprContext e;
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			declaration();
			setState(106);
			match(T__6);
			setState(107);
			((AssignmentContext)_localctx).e = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(analiseDimensionalParser.ID, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			type();
			setState(110);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public Token var;
		public TerminalNode ID() { return getToken(analiseDimensionalParser.ID, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__17);
			setState(113);
			((PrintContext)_localctx).var = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportFileContext extends ParserRuleContext {
		public Token s;
		public TerminalNode String() { return getToken(analiseDimensionalParser.String, 0); }
		public ImportFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importFile; }
	}

	public final ImportFileContext importFile() throws RecognitionException {
		ImportFileContext _localctx = new ImportFileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_importFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__18);
			setState(116);
			((ImportFileContext)_localctx).s = match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Token name;
		public Token r;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(analiseDimensionalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(analiseDimensionalParser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			type();
			setState(119);
			((FunctionContext)_localctx).name = match(ID);
			setState(120);
			match(T__5);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__24) | (1L << Bool) | (1L << NOT) | (1L << ID) | (1L << String) | (1L << Real) | (1L << Integer))) != 0)) {
				{
				{
				setState(121);
				expr(0);
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			match(T__8);
			setState(128);
			match(T__9);
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129);
				program();
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18))) != 0) );
			setState(134);
			match(T__19);
			setState(135);
			((FunctionContext)_localctx).r = match(ID);
			setState(136);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Type ti;
		public String var;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.ti = ctx.ti;
			this.var = ctx.var;
		}
	}
	public static class ExprStringContext extends ExprContext {
		public TerminalNode String() { return getToken(analiseDimensionalParser.String, 0); }
		public ExprStringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprParentContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprParentContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprNumberUnityContext extends ExprContext {
		public Token n;
		public Token Unity;
		public TerminalNode Integer() { return getToken(analiseDimensionalParser.Integer, 0); }
		public TerminalNode Real() { return getToken(analiseDimensionalParser.Real, 0); }
		public TerminalNode ID() { return getToken(analiseDimensionalParser.ID, 0); }
		public ExprNumberUnityContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprNotContext extends ExprContext {
		public TerminalNode NOT() { return getToken(analiseDimensionalParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprNotContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprNewDimensionContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprNewDimensionContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprAddSubContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprPowContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprPowContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class BoolBinaryContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BINARY() { return getToken(analiseDimensionalParser.BINARY, 0); }
		public BoolBinaryContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class BoolLiteralContext extends ExprContext {
		public TerminalNode Bool() { return getToken(analiseDimensionalParser.Bool, 0); }
		public BoolLiteralContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class BoolComparatorContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BoolComparatorContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprRealContext extends ExprContext {
		public TerminalNode Real() { return getToken(analiseDimensionalParser.Real, 0); }
		public ExprRealContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprIntegerContext extends ExprContext {
		public TerminalNode Integer() { return getToken(analiseDimensionalParser.Integer, 0); }
		public ExprIntegerContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprIDContext extends ExprContext {
		public TerminalNode ID() { return getToken(analiseDimensionalParser.ID, 0); }
		public ExprIDContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(139);
				match(Bool);
				}
				break;
			case 2:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(NOT);
				setState(141);
				expr(7);
				}
				break;
			case 3:
				{
				_localctx = new ExprParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(T__5);
				setState(143);
				expr(0);
				setState(144);
				match(T__8);
				}
				break;
			case 4:
				{
				_localctx = new ExprNumberUnityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(146);
					match(T__24);
					}
				}

				setState(149);
				((ExprNumberUnityContext)_localctx).n = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Real || _la==Integer) ) {
					((ExprNumberUnityContext)_localctx).n = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(150);
					((ExprNumberUnityContext)_localctx).Unity = match(ID);
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(String);
				}
				break;
			case 6:
				{
				_localctx = new ExprRealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(Real);
				}
				break;
			case 7:
				{
				_localctx = new ExprIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(Integer);
				}
				break;
			case 8:
				{
				_localctx = new ExprIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprPowContext(new ExprContext(_parentctx, _parentState));
						((ExprPowContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						{
						setState(160);
						match(T__20);
						}
						setState(161);
						((ExprPowContext)_localctx).e2 = expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprNewDimensionContext(new ExprContext(_parentctx, _parentState));
						((ExprNewDimensionContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(163);
						((ExprNewDimensionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((ExprNewDimensionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						((ExprNewDimensionContext)_localctx).e2 = expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ExprAddSubContext(new ExprContext(_parentctx, _parentState));
						((ExprAddSubContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(166);
						((ExprAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((ExprAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(167);
						((ExprAddSubContext)_localctx).e2 = expr(12);
						}
						break;
					case 4:
						{
						_localctx = new BoolComparatorContext(new ExprContext(_parentctx, _parentState));
						((BoolComparatorContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(169);
						((BoolComparatorContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
							((BoolComparatorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(170);
						((BoolComparatorContext)_localctx).e2 = expr(11);
						}
						break;
					case 5:
						{
						_localctx = new BoolBinaryContext(new ExprContext(_parentctx, _parentState));
						((BoolBinaryContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(171);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(172);
						((BoolBinaryContext)_localctx).op = match(BINARY);
						setState(173);
						((BoolBinaryContext)_localctx).e2 = expr(10);
						}
						break;
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4\66\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5D\n\5\r\5"+
		"\16\5E\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\6\6P\n\6\r\6\16\6Q\3\6\3\6\5\6"+
		"V\n\6\3\7\3\7\3\7\6\7[\n\7\r\7\16\7\\\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bh\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\7\r}\n\r\f\r\16\r\u0080\13\r\3\r\3\r\3\r\6\r\u0085"+
		"\n\r\r\r\16\r\u0086\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u0096\n\16\3\16\3\16\5\16\u009a\n\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00a0\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u00b1\n\16\f\16\16\16\u00b4\13\16\3\16"+
		"\2\3\32\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\6\3\2()\3\2\30\31\3\2\32"+
		"\33\4\2\t\t\34 \2\u00c7\2\37\3\2\2\2\4+\3\2\2\2\6\65\3\2\2\2\b\67\3\2"+
		"\2\2\nI\3\2\2\2\fW\3\2\2\2\16a\3\2\2\2\20k\3\2\2\2\22o\3\2\2\2\24r\3\2"+
		"\2\2\26u\3\2\2\2\30x\3\2\2\2\32\u009f\3\2\2\2\34\36\5\4\3\2\35\34\3\2"+
		"\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7"+
		"\2\2\3#\3\3\2\2\2$,\5\20\t\2%,\5\24\13\2&,\5\b\5\2\',\5\n\6\2(,\5\f\7"+
		"\2),\5\16\b\2*,\5\26\f\2+$\3\2\2\2+%\3\2\2\2+&\3\2\2\2+\'\3\2\2\2+(\3"+
		"\2\2\2+)\3\2\2\2+*\3\2\2\2,\5\3\2\2\2-.\7\3\2\2.\66\b\4\1\2/\60\7\4\2"+
		"\2\60\66\b\4\1\2\61\62\7\5\2\2\62\66\b\4\1\2\63\64\7\6\2\2\64\66\b\4\1"+
		"\2\65-\3\2\2\2\65/\3\2\2\2\65\61\3\2\2\2\65\63\3\2\2\2\66\7\3\2\2\2\67"+
		"8\7\7\2\289\7\b\2\29:\7&\2\2:;\7\t\2\2;<\t\2\2\2<=\7\n\2\2=>\5\32\16\2"+
		">?\7\n\2\2?@\5\32\16\2@A\7\13\2\2AC\7\f\2\2BD\5\4\3\2CB\3\2\2\2DE\3\2"+
		"\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\r\2\2H\t\3\2\2\2IJ\7\16\2\2JK\7"+
		"\b\2\2KL\5\32\16\2LU\7\13\2\2MO\7\f\2\2NP\5\4\3\2ON\3\2\2\2PQ\3\2\2\2"+
		"QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\r\2\2TV\3\2\2\2UM\3\2\2\2UV\3\2\2\2"+
		"V\13\3\2\2\2WX\7\17\2\2XZ\7\f\2\2Y[\5\4\3\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3"+
		"\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\r\2\2_`\5\n\6\2`\r\3\2\2\2ab\7\20\2\2"+
		"bc\5\32\16\2cd\7\21\2\2dg\5\4\3\2ef\7\22\2\2fh\5\4\3\2ge\3\2\2\2gh\3\2"+
		"\2\2hi\3\2\2\2ij\7\23\2\2j\17\3\2\2\2kl\5\22\n\2lm\7\t\2\2mn\5\32\16\2"+
		"n\21\3\2\2\2op\5\6\4\2pq\7&\2\2q\23\3\2\2\2rs\7\24\2\2st\7&\2\2t\25\3"+
		"\2\2\2uv\7\25\2\2vw\7\'\2\2w\27\3\2\2\2xy\5\6\4\2yz\7&\2\2z~\7\b\2\2{"+
		"}\5\32\16\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081"+
		"\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\13\2\2\u0082\u0084\7\f\2\2\u0083"+
		"\u0085\5\4\3\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\26\2\2\u0089"+
		"\u008a\7&\2\2\u008a\u008b\7\r\2\2\u008b\31\3\2\2\2\u008c\u008d\b\16\1"+
		"\2\u008d\u00a0\7!\2\2\u008e\u008f\7%\2\2\u008f\u00a0\5\32\16\t\u0090\u0091"+
		"\7\b\2\2\u0091\u0092\5\32\16\2\u0092\u0093\7\13\2\2\u0093\u00a0\3\2\2"+
		"\2\u0094\u0096\7\33\2\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0099\t\2\2\2\u0098\u009a\7&\2\2\u0099\u0098\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u00a0\3\2\2\2\u009b\u00a0\7\'\2\2\u009c"+
		"\u00a0\7(\2\2\u009d\u00a0\7)\2\2\u009e\u00a0\7&\2\2\u009f\u008c\3\2\2"+
		"\2\u009f\u008e\3\2\2\2\u009f\u0090\3\2\2\2\u009f\u0095\3\2\2\2\u009f\u009b"+
		"\3\2\2\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\u00b2\3\2\2\2\u00a1\u00a2\f\17\2\2\u00a2\u00a3\7\27\2\2\u00a3\u00b1\5"+
		"\32\16\17\u00a4\u00a5\f\16\2\2\u00a5\u00a6\t\3\2\2\u00a6\u00b1\5\32\16"+
		"\17\u00a7\u00a8\f\r\2\2\u00a8\u00a9\t\4\2\2\u00a9\u00b1\5\32\16\16\u00aa"+
		"\u00ab\f\f\2\2\u00ab\u00ac\t\5\2\2\u00ac\u00b1\5\32\16\r\u00ad\u00ae\f"+
		"\13\2\2\u00ae\u00af\7\"\2\2\u00af\u00b1\5\32\16\f\u00b0\u00a1\3\2\2\2"+
		"\u00b0\u00a4\3\2\2\2\u00b0\u00a7\3\2\2\2\u00b0\u00aa\3\2\2\2\u00b0\u00ad"+
		"\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\33\3\2\2\2\u00b4\u00b2\3\2\2\2\21\37+\65EQU\\g~\u0086\u0095\u0099\u009f"+
		"\u00b0\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}