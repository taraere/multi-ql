// Generated from A:\Users\sander\Documents\NetBeansProjects\multi-ql\savahu\QL\src\ql\antlr\QL.g4 by ANTLR 4.5.2

    package ql.antlr;

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
		T__17=18, WS=19, COMMENT=20, Ident=21, Int=22, Str=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "WS", "COMMENT", "Ident", "Int", "Str"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'('", "')'", "'true'", "'false'", "'+'", "'-'", "'!'", 
		"'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "WS", "COMMENT", "Ident", "Int", 
		"Str"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u008c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25n\n\25\f\25"+
		"\16\25q\13\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\7\26z\n\26\f\26\16\26"+
		"}\13\26\3\27\6\27\u0080\n\27\r\27\16\27\u0081\3\30\3\30\7\30\u0086\n\30"+
		"\f\30\16\30\u0089\13\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\3\2\5\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\u008f\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61"+
		"\3\2\2\2\5\66\3\2\2\2\78\3\2\2\2\t:\3\2\2\2\13?\3\2\2\2\rE\3\2\2\2\17"+
		"G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2\31Q\3\2\2\2"+
		"\33T\3\2\2\2\35V\3\2\2\2\37Y\3\2\2\2!\\\3\2\2\2#_\3\2\2\2%b\3\2\2\2\'"+
		"e\3\2\2\2)i\3\2\2\2+w\3\2\2\2-\177\3\2\2\2/\u0083\3\2\2\2\61\62\7h\2\2"+
		"\62\63\7q\2\2\63\64\7t\2\2\64\65\7o\2\2\65\4\3\2\2\2\66\67\7*\2\2\67\6"+
		"\3\2\2\289\7+\2\29\b\3\2\2\2:;\7v\2\2;<\7t\2\2<=\7w\2\2=>\7g\2\2>\n\3"+
		"\2\2\2?@\7h\2\2@A\7c\2\2AB\7n\2\2BC\7u\2\2CD\7g\2\2D\f\3\2\2\2EF\7-\2"+
		"\2F\16\3\2\2\2GH\7/\2\2H\20\3\2\2\2IJ\7#\2\2J\22\3\2\2\2KL\7,\2\2L\24"+
		"\3\2\2\2MN\7\61\2\2N\26\3\2\2\2OP\7>\2\2P\30\3\2\2\2QR\7>\2\2RS\7?\2\2"+
		"S\32\3\2\2\2TU\7@\2\2U\34\3\2\2\2VW\7@\2\2WX\7?\2\2X\36\3\2\2\2YZ\7?\2"+
		"\2Z[\7?\2\2[ \3\2\2\2\\]\7#\2\2]^\7?\2\2^\"\3\2\2\2_`\7(\2\2`a\7(\2\2"+
		"a$\3\2\2\2bc\7~\2\2cd\7~\2\2d&\3\2\2\2ef\t\2\2\2fg\3\2\2\2gh\b\24\2\2"+
		"h(\3\2\2\2ij\7\61\2\2jk\7,\2\2ko\3\2\2\2ln\13\2\2\2ml\3\2\2\2nq\3\2\2"+
		"\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7,\2\2st\7\61\2\2tu\3\2\2"+
		"\2uv\b\25\2\2v*\3\2\2\2w{\t\3\2\2xz\t\4\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2"+
		"\2\2{|\3\2\2\2|,\3\2\2\2}{\3\2\2\2~\u0080\4\62;\2\177~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082.\3\2\2\2\u0083\u0087"+
		"\7$\2\2\u0084\u0086\13\2\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u008a\u008b\7$\2\2\u008b\60\3\2\2\2\7\2o{\u0081\u0087\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}