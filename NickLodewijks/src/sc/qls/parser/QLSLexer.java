// Generated from QLS.g4 by ANTLR 4.5.3
package sc.qls.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		WS=25, COMMENT=26, LINE_COMMENT=27, BOOLEAN=28, INTEGER=29, STRING=30, 
		BOOL=31, INT=32, STR=33, ID=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "WS", "COMMENT", 
		"LINE_COMMENT", "BOOLEAN", "INTEGER", "STRING", "BOOL", "INT", "STR", 
		"ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'question'", 
		"'widget'", "'slider'", "'('", "')'", "'default'", "'spinner'", "'text'", 
		"'checkbox'", "'radio'", "'dropdown'", "','", "'color'", "':'", "'width'", 
		"'height'", "'fontSize'", "'font'", "'fontStyle'", null, null, null, "'bool'", 
		"'int'", "'str'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "WS", "COMMENT", "LINE_COMMENT", "BOOLEAN", "INTEGER", "STRING", 
		"BOOL", "INT", "STR", "ID"
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


	public QLSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QLS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2$\u0124\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\7\33\u00e3\n\33\f\33\16\33\u00e6\13\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u00f1\n\34\f\34\16\34\u00f4"+
		"\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u010e\n \3!\6!\u0111\n!\r!\16"+
		"!\u0112\3\"\3\"\7\"\u0117\n\"\f\"\16\"\u011a\13\"\3\"\3\"\3#\3#\7#\u0120"+
		"\n#\f#\16#\u0123\13#\4\u00e4\u0118\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\6\5\2\13\f\17\17\""+
		"\"\4\2\f\f\17\17\4\2C\\c|\6\2\62;C\\aac|\u0129\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5R\3\2\2\2\7T\3\2\2\2"+
		"\tV\3\2\2\2\13[\3\2\2\2\rc\3\2\2\2\17l\3\2\2\2\21s\3\2\2\2\23z\3\2\2\2"+
		"\25|\3\2\2\2\27~\3\2\2\2\31\u0086\3\2\2\2\33\u008e\3\2\2\2\35\u0093\3"+
		"\2\2\2\37\u009c\3\2\2\2!\u00a2\3\2\2\2#\u00ab\3\2\2\2%\u00ad\3\2\2\2\'"+
		"\u00b3\3\2\2\2)\u00b5\3\2\2\2+\u00bb\3\2\2\2-\u00c2\3\2\2\2/\u00cb\3\2"+
		"\2\2\61\u00d0\3\2\2\2\63\u00da\3\2\2\2\65\u00de\3\2\2\2\67\u00ec\3\2\2"+
		"\29\u00f7\3\2\2\2;\u00fc\3\2\2\2=\u0100\3\2\2\2?\u010d\3\2\2\2A\u0110"+
		"\3\2\2\2C\u0114\3\2\2\2E\u011d\3\2\2\2GH\7u\2\2HI\7v\2\2IJ\7{\2\2JK\7"+
		"n\2\2KL\7g\2\2LM\7u\2\2MN\7j\2\2NO\7g\2\2OP\7g\2\2PQ\7v\2\2Q\4\3\2\2\2"+
		"RS\7}\2\2S\6\3\2\2\2TU\7\177\2\2U\b\3\2\2\2VW\7r\2\2WX\7c\2\2XY\7i\2\2"+
		"YZ\7g\2\2Z\n\3\2\2\2[\\\7u\2\2\\]\7g\2\2]^\7e\2\2^_\7v\2\2_`\7k\2\2`a"+
		"\7q\2\2ab\7p\2\2b\f\3\2\2\2cd\7s\2\2de\7w\2\2ef\7g\2\2fg\7u\2\2gh\7v\2"+
		"\2hi\7k\2\2ij\7q\2\2jk\7p\2\2k\16\3\2\2\2lm\7y\2\2mn\7k\2\2no\7f\2\2o"+
		"p\7i\2\2pq\7g\2\2qr\7v\2\2r\20\3\2\2\2st\7u\2\2tu\7n\2\2uv\7k\2\2vw\7"+
		"f\2\2wx\7g\2\2xy\7t\2\2y\22\3\2\2\2z{\7*\2\2{\24\3\2\2\2|}\7+\2\2}\26"+
		"\3\2\2\2~\177\7f\2\2\177\u0080\7g\2\2\u0080\u0081\7h\2\2\u0081\u0082\7"+
		"c\2\2\u0082\u0083\7w\2\2\u0083\u0084\7n\2\2\u0084\u0085\7v\2\2\u0085\30"+
		"\3\2\2\2\u0086\u0087\7u\2\2\u0087\u0088\7r\2\2\u0088\u0089\7k\2\2\u0089"+
		"\u008a\7p\2\2\u008a\u008b\7p\2\2\u008b\u008c\7g\2\2\u008c\u008d\7t\2\2"+
		"\u008d\32\3\2\2\2\u008e\u008f\7v\2\2\u008f\u0090\7g\2\2\u0090\u0091\7"+
		"z\2\2\u0091\u0092\7v\2\2\u0092\34\3\2\2\2\u0093\u0094\7e\2\2\u0094\u0095"+
		"\7j\2\2\u0095\u0096\7g\2\2\u0096\u0097\7e\2\2\u0097\u0098\7m\2\2\u0098"+
		"\u0099\7d\2\2\u0099\u009a\7q\2\2\u009a\u009b\7z\2\2\u009b\36\3\2\2\2\u009c"+
		"\u009d\7t\2\2\u009d\u009e\7c\2\2\u009e\u009f\7f\2\2\u009f\u00a0\7k\2\2"+
		"\u00a0\u00a1\7q\2\2\u00a1 \3\2\2\2\u00a2\u00a3\7f\2\2\u00a3\u00a4\7t\2"+
		"\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7f\2\2\u00a7\u00a8"+
		"\7q\2\2\u00a8\u00a9\7y\2\2\u00a9\u00aa\7p\2\2\u00aa\"\3\2\2\2\u00ab\u00ac"+
		"\7.\2\2\u00ac$\3\2\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7q\2\2\u00af\u00b0"+
		"\7n\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7t\2\2\u00b2&\3\2\2\2\u00b3\u00b4"+
		"\7<\2\2\u00b4(\3\2\2\2\u00b5\u00b6\7y\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8"+
		"\7f\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7j\2\2\u00ba*\3\2\2\2\u00bb\u00bc"+
		"\7j\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7i\2\2\u00bf"+
		"\u00c0\7j\2\2\u00c0\u00c1\7v\2\2\u00c1,\3\2\2\2\u00c2\u00c3\7h\2\2\u00c3"+
		"\u00c4\7q\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7U\2\2"+
		"\u00c7\u00c8\7k\2\2\u00c8\u00c9\7|\2\2\u00c9\u00ca\7g\2\2\u00ca.\3\2\2"+
		"\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf"+
		"\7v\2\2\u00cf\60\3\2\2\2\u00d0\u00d1\7h\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3"+
		"\7p\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7U\2\2\u00d5\u00d6\7v\2\2\u00d6"+
		"\u00d7\7{\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7g\2\2\u00d9\62\3\2\2\2\u00da"+
		"\u00db\t\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b\32\2\2\u00dd\64\3\2\2"+
		"\2\u00de\u00df\7\61\2\2\u00df\u00e0\7,\2\2\u00e0\u00e4\3\2\2\2\u00e1\u00e3"+
		"\13\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e5\3\2\2\2"+
		"\u00e4\u00e2\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8"+
		"\7,\2\2\u00e8\u00e9\7\61\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\b\33\2\2"+
		"\u00eb\66\3\2\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00ee\7\61\2\2\u00ee\u00f2"+
		"\3\2\2\2\u00ef\u00f1\n\3\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f5\u00f6\b\34\2\2\u00f68\3\2\2\2\u00f7\u00f8\7d\2\2\u00f8\u00f9"+
		"\7q\2\2\u00f9\u00fa\7q\2\2\u00fa\u00fb\7n\2\2\u00fb:\3\2\2\2\u00fc\u00fd"+
		"\7k\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7v\2\2\u00ff<\3\2\2\2\u0100\u0101"+
		"\7u\2\2\u0101\u0102\7v\2\2\u0102\u0103\7t\2\2\u0103>\3\2\2\2\u0104\u0105"+
		"\7v\2\2\u0105\u0106\7t\2\2\u0106\u0107\7w\2\2\u0107\u010e\7g\2\2\u0108"+
		"\u0109\7h\2\2\u0109\u010a\7c\2\2\u010a\u010b\7n\2\2\u010b\u010c\7u\2\2"+
		"\u010c\u010e\7g\2\2\u010d\u0104\3\2\2\2\u010d\u0108\3\2\2\2\u010e@\3\2"+
		"\2\2\u010f\u0111\4\62;\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113B\3\2\2\2\u0114\u0118\7$\2\2\u0115"+
		"\u0117\13\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0119\3"+
		"\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011c\7$\2\2\u011cD\3\2\2\2\u011d\u0121\t\4\2\2\u011e\u0120\t\5\2\2\u011f"+
		"\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122F\3\2\2\2\u0123\u0121\3\2\2\2\t\2\u00e4\u00f2\u010d\u0112\u0118"+
		"\u0121\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}