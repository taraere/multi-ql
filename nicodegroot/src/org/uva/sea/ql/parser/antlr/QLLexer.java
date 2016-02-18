// Generated from QL.g4 by ANTLR 4.5.2

	package org.uva.sea.ql.parser.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, WHITESPACE=27, COMMENT=28, LINE_COMMENT=29, BOOLEAN=30, 
		IDENTIFIER=31, INTEGER=32, STRING=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "WHITESPACE", "COMMENT", "LINE_COMMENT", "BOOLEAN", "IDENTIFIER", 
		"INTEGER", "STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "':'", "'='", "'('", "')'", "'if'", "'else'", 
		"'!'", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>'", "'>='", "'<'", 
		"'<='", "'&&'", "'||'", "'integer'", "'string'", "'boolean'", "'money'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "WHITESPACE", "COMMENT", "LINE_COMMENT", "BOOLEAN", 
		"IDENTIFIER", "INTEGER", "STRING"
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


	public QLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u00dd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\6"+
		"\34\u009d\n\34\r\34\16\34\u009e\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00a7"+
		"\n\35\f\35\16\35\u00aa\13\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\7\36\u00b5\n\36\f\36\16\36\u00b8\13\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00c8\n\37\3 \3 \6 \u00cc"+
		"\n \r \16 \u00cd\3!\6!\u00d1\n!\r!\16!\u00d2\3\"\3\"\7\"\u00d7\n\"\f\""+
		"\16\"\u00da\13\"\3\"\3\"\5\u00a8\u00b6\u00d8\2#\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2\6\5\2\13"+
		"\f\17\17\"\"\3\2c|\5\2\62;C\\c|\3\2\62;\u00e3\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5J\3\2\2\2\7L\3\2\2\2\tN\3\2\2\2"+
		"\13P\3\2\2\2\rR\3\2\2\2\17T\3\2\2\2\21V\3\2\2\2\23Y\3\2\2\2\25^\3\2\2"+
		"\2\27`\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2\2!k\3\2\2"+
		"\2#n\3\2\2\2%p\3\2\2\2\'s\3\2\2\2)u\3\2\2\2+x\3\2\2\2-{\3\2\2\2/~\3\2"+
		"\2\2\61\u0086\3\2\2\2\63\u008d\3\2\2\2\65\u0095\3\2\2\2\67\u009c\3\2\2"+
		"\29\u00a2\3\2\2\2;\u00b0\3\2\2\2=\u00c7\3\2\2\2?\u00c9\3\2\2\2A\u00d0"+
		"\3\2\2\2C\u00d4\3\2\2\2EF\7h\2\2FG\7q\2\2GH\7t\2\2HI\7o\2\2I\4\3\2\2\2"+
		"JK\7}\2\2K\6\3\2\2\2LM\7\177\2\2M\b\3\2\2\2NO\7<\2\2O\n\3\2\2\2PQ\7?\2"+
		"\2Q\f\3\2\2\2RS\7*\2\2S\16\3\2\2\2TU\7+\2\2U\20\3\2\2\2VW\7k\2\2WX\7h"+
		"\2\2X\22\3\2\2\2YZ\7g\2\2Z[\7n\2\2[\\\7u\2\2\\]\7g\2\2]\24\3\2\2\2^_\7"+
		"#\2\2_\26\3\2\2\2`a\7,\2\2a\30\3\2\2\2bc\7\61\2\2c\32\3\2\2\2de\7-\2\2"+
		"e\34\3\2\2\2fg\7/\2\2g\36\3\2\2\2hi\7?\2\2ij\7?\2\2j \3\2\2\2kl\7#\2\2"+
		"lm\7?\2\2m\"\3\2\2\2no\7@\2\2o$\3\2\2\2pq\7@\2\2qr\7?\2\2r&\3\2\2\2st"+
		"\7>\2\2t(\3\2\2\2uv\7>\2\2vw\7?\2\2w*\3\2\2\2xy\7(\2\2yz\7(\2\2z,\3\2"+
		"\2\2{|\7~\2\2|}\7~\2\2}.\3\2\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\u0081"+
		"\7v\2\2\u0081\u0082\7g\2\2\u0082\u0083\7i\2\2\u0083\u0084\7g\2\2\u0084"+
		"\u0085\7t\2\2\u0085\60\3\2\2\2\u0086\u0087\7u\2\2\u0087\u0088\7v\2\2\u0088"+
		"\u0089\7t\2\2\u0089\u008a\7k\2\2\u008a\u008b\7p\2\2\u008b\u008c\7i\2\2"+
		"\u008c\62\3\2\2\2\u008d\u008e\7d\2\2\u008e\u008f\7q\2\2\u008f\u0090\7"+
		"q\2\2\u0090\u0091\7n\2\2\u0091\u0092\7g\2\2\u0092\u0093\7c\2\2\u0093\u0094"+
		"\7p\2\2\u0094\64\3\2\2\2\u0095\u0096\7o\2\2\u0096\u0097\7q\2\2\u0097\u0098"+
		"\7p\2\2\u0098\u0099\7g\2\2\u0099\u009a\7{\2\2\u009a\66\3\2\2\2\u009b\u009d"+
		"\t\2\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\34\2\2\u00a18\3\2\2\2"+
		"\u00a2\u00a3\7\61\2\2\u00a3\u00a4\7,\2\2\u00a4\u00a8\3\2\2\2\u00a5\u00a7"+
		"\13\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a9\3\2\2\2"+
		"\u00a8\u00a6\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac"+
		"\7,\2\2\u00ac\u00ad\7\61\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\b\35\2\2"+
		"\u00af:\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1\u00b2\7\61\2\2\u00b2\u00b6"+
		"\3\2\2\2\u00b3\u00b5\13\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2"+
		"\u00b6\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6"+
		"\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00bd\b\36\2\2\u00bd<\3\2\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7t\2\2\u00c0"+
		"\u00c1\7w\2\2\u00c1\u00c8\7g\2\2\u00c2\u00c3\7h\2\2\u00c3\u00c4\7c\2\2"+
		"\u00c4\u00c5\7n\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c8\7g\2\2\u00c7\u00be"+
		"\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c8>\3\2\2\2\u00c9\u00cb\t\3\2\2\u00ca"+
		"\u00cc\t\4\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce@\3\2\2\2\u00cf\u00d1\t\5\2\2\u00d0\u00cf"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"B\3\2\2\2\u00d4\u00d8\7$\2\2\u00d5\u00d7\13\2\2\2\u00d6\u00d5\3\2\2\2"+
		"\u00d7\u00da\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00db"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7$\2\2\u00dcD\3\2\2\2\n\2\u009e"+
		"\u00a8\u00b6\u00c7\u00cd\u00d2\u00d8\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}