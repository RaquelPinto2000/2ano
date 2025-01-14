// Generated from /home/lucia/Desktop/lfa1920-g12/analiseLang/analiseDimensional.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class analiseDimensionalLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "Bool", "BINARY", "OR", "AND", 
		"NOT", "ID", "String", "Real", "Integer", "WS", "COMMENT", "ERROR"
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


	public analiseDimensionalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "analiseDimensional.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0119\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00d2\n \3!\3"+
		"!\5!\u00d6\n!\3\"\3\"\3\"\5\"\u00db\n\"\3#\3#\3#\3#\5#\u00e1\n#\3$\3$"+
		"\3$\3$\3%\6%\u00e8\n%\r%\16%\u00e9\3&\3&\7&\u00ee\n&\f&\16&\u00f1\13&"+
		"\3&\3&\3\'\7\'\u00f6\n\'\f\'\16\'\u00f9\13\'\3\'\3\'\6\'\u00fd\n\'\r\'"+
		"\16\'\u00fe\3(\6(\u0102\n(\r(\16(\u0103\3)\6)\u0107\n)\r)\16)\u0108\3"+
		")\3)\3*\3*\7*\u010f\n*\f*\16*\u0112\13*\3*\3*\3*\3*\3+\3+\4\u00ef\u0110"+
		"\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\5\4\2C\\c|\3\2\62;\5\2\13\f\17\17"+
		"\"\"\2\u0123\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5_\3\2\2\2\7d\3\2\2\2\tl\3\2\2\2\13s\3"+
		"\2\2\2\rw\3\2\2\2\17y\3\2\2\2\21{\3\2\2\2\23}\3\2\2\2\25\177\3\2\2\2\27"+
		"\u0081\3\2\2\2\31\u0083\3\2\2\2\33\u0089\3\2\2\2\35\u008c\3\2\2\2\37\u008f"+
		"\3\2\2\2!\u0094\3\2\2\2#\u0099\3\2\2\2%\u009d\3\2\2\2\'\u00a3\3\2\2\2"+
		")\u00aa\3\2\2\2+\u00b1\3\2\2\2-\u00b3\3\2\2\2/\u00b5\3\2\2\2\61\u00b7"+
		"\3\2\2\2\63\u00b9\3\2\2\2\65\u00bb\3\2\2\2\67\u00bd\3\2\2\29\u00bf\3\2"+
		"\2\2;\u00c2\3\2\2\2=\u00c5\3\2\2\2?\u00d1\3\2\2\2A\u00d5\3\2\2\2C\u00da"+
		"\3\2\2\2E\u00e0\3\2\2\2G\u00e2\3\2\2\2I\u00e7\3\2\2\2K\u00eb\3\2\2\2M"+
		"\u00f7\3\2\2\2O\u0101\3\2\2\2Q\u0106\3\2\2\2S\u010c\3\2\2\2U\u0117\3\2"+
		"\2\2WX\7k\2\2XY\7p\2\2YZ\7v\2\2Z[\7g\2\2[\\\7i\2\2\\]\7g\2\2]^\7t\2\2"+
		"^\4\3\2\2\2_`\7t\2\2`a\7g\2\2ab\7c\2\2bc\7n\2\2c\6\3\2\2\2de\7d\2\2ef"+
		"\7q\2\2fg\7q\2\2gh\7n\2\2hi\7g\2\2ij\7c\2\2jk\7p\2\2k\b\3\2\2\2lm\7u\2"+
		"\2mn\7v\2\2no\7t\2\2op\7k\2\2pq\7p\2\2qr\7i\2\2r\n\3\2\2\2st\7h\2\2tu"+
		"\7q\2\2uv\7t\2\2v\f\3\2\2\2wx\7*\2\2x\16\3\2\2\2yz\7?\2\2z\20\3\2\2\2"+
		"{|\7=\2\2|\22\3\2\2\2}~\7+\2\2~\24\3\2\2\2\177\u0080\7}\2\2\u0080\26\3"+
		"\2\2\2\u0081\u0082\7\177\2\2\u0082\30\3\2\2\2\u0083\u0084\7y\2\2\u0084"+
		"\u0085\7j\2\2\u0085\u0086\7k\2\2\u0086\u0087\7n\2\2\u0087\u0088\7g\2\2"+
		"\u0088\32\3\2\2\2\u0089\u008a\7f\2\2\u008a\u008b\7q\2\2\u008b\34\3\2\2"+
		"\2\u008c\u008d\7k\2\2\u008d\u008e\7h\2\2\u008e\36\3\2\2\2\u008f\u0090"+
		"\7v\2\2\u0090\u0091\7j\2\2\u0091\u0092\7g\2\2\u0092\u0093\7p\2\2\u0093"+
		" \3\2\2\2\u0094\u0095\7g\2\2\u0095\u0096\7n\2\2\u0096\u0097\7u\2\2\u0097"+
		"\u0098\7g\2\2\u0098\"\3\2\2\2\u0099\u009a\7g\2\2\u009a\u009b\7p\2\2\u009b"+
		"\u009c\7f\2\2\u009c$\3\2\2\2\u009d\u009e\7r\2\2\u009e\u009f\7t\2\2\u009f"+
		"\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7v\2\2\u00a2&\3\2\2\2\u00a3"+
		"\u00a4\7k\2\2\u00a4\u00a5\7o\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7q\2\2"+
		"\u00a7\u00a8\7t\2\2\u00a8\u00a9\7v\2\2\u00a9(\3\2\2\2\u00aa\u00ab\7t\2"+
		"\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af"+
		"\7t\2\2\u00af\u00b0\7p\2\2\u00b0*\3\2\2\2\u00b1\u00b2\7`\2\2\u00b2,\3"+
		"\2\2\2\u00b3\u00b4\7,\2\2\u00b4.\3\2\2\2\u00b5\u00b6\7\61\2\2\u00b6\60"+
		"\3\2\2\2\u00b7\u00b8\7-\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7/\2\2\u00ba"+
		"\64\3\2\2\2\u00bb\u00bc\7@\2\2\u00bc\66\3\2\2\2\u00bd\u00be\7>\2\2\u00be"+
		"8\3\2\2\2\u00bf\u00c0\7>\2\2\u00c0\u00c1\7?\2\2\u00c1:\3\2\2\2\u00c2\u00c3"+
		"\7@\2\2\u00c3\u00c4\7?\2\2\u00c4<\3\2\2\2\u00c5\u00c6\7?\2\2\u00c6\u00c7"+
		"\7?\2\2\u00c7>\3\2\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb"+
		"\7w\2\2\u00cb\u00d2\7g\2\2\u00cc\u00cd\7h\2\2\u00cd\u00ce\7c\2\2\u00ce"+
		"\u00cf\7n\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d2\7g\2\2\u00d1\u00c8\3\2\2"+
		"\2\u00d1\u00cc\3\2\2\2\u00d2@\3\2\2\2\u00d3\u00d6\5E#\2\u00d4\u00d6\5"+
		"C\"\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6B\3\2\2\2\u00d7\u00d8"+
		"\7Q\2\2\u00d8\u00db\7T\2\2\u00d9\u00db\7~\2\2\u00da\u00d7\3\2\2\2\u00da"+
		"\u00d9\3\2\2\2\u00dbD\3\2\2\2\u00dc\u00dd\7C\2\2\u00dd\u00de\7P\2\2\u00de"+
		"\u00e1\7F\2\2\u00df\u00e1\7(\2\2\u00e0\u00dc\3\2\2\2\u00e0\u00df\3\2\2"+
		"\2\u00e1F\3\2\2\2\u00e2\u00e3\7P\2\2\u00e3\u00e4\7Q\2\2\u00e4\u00e5\7"+
		"V\2\2\u00e5H\3\2\2\2\u00e6\u00e8\t\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00eaJ\3\2\2\2\u00eb"+
		"\u00ef\7$\2\2\u00ec\u00ee\13\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2"+
		"\2\2\u00ef\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\7$\2\2\u00f3L\3\2\2\2\u00f4\u00f6\t\3\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fc\7\60\2\2\u00fb"+
		"\u00fd\t\3\2\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2"+
		"\2\2\u00fe\u00ff\3\2\2\2\u00ffN\3\2\2\2\u0100\u0102\t\3\2\2\u0101\u0100"+
		"\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"P\3\2\2\2\u0105\u0107\t\4\2\2\u0106\u0105\3\2\2\2\u0107\u0108\3\2\2\2"+
		"\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b"+
		"\b)\2\2\u010bR\3\2\2\2\u010c\u0110\7%\2\2\u010d\u010f\13\2\2\2\u010e\u010d"+
		"\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111"+
		"\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7\f\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\u0116\b*\2\2\u0116T\3\2\2\2\u0117\u0118\13\2\2\2\u0118V\3\2"+
		"\2\2\16\2\u00d1\u00d5\u00da\u00e0\u00e9\u00ef\u00f7\u00fe\u0103\u0108"+
		"\u0110\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}