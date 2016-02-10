// Generated from /Users/roydewildt/Workspace/UvA/SC/multi-ql/RoydeWildt/QLJava/src/org/uva/sea/ql/parser/QL.g4 by ANTLR 4.5.1
package org.uva.sea.ql.parser;

import java.util.List;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.ast.val.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.var.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		WHITESPACE=25, COMMENT=26, True=27, False=28, Ident=29, Str=30, Int=31;
	public static final int
		RULE_form = 0, RULE_forms = 1, RULE_varDecl = 2, RULE_varAss = 3, RULE_question = 4, 
		RULE_stat = 5, RULE_stats = 6, RULE_primary = 7, RULE_unExpr = 8, RULE_mulExpr = 9, 
		RULE_addExpr = 10, RULE_relExpr = 11, RULE_andExpr = 12, RULE_orExpr = 13, 
		RULE_type = 14, RULE_bool = 15;
	public static final String[] ruleNames = {
		"form", "forms", "varDecl", "varAss", "question", "stat", "stats", "primary", 
		"unExpr", "mulExpr", "addExpr", "relExpr", "andExpr", "orExpr", "type", 
		"bool"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "'='", "'('", "')'", "':'", "'if'", "'else'", 
		"'+'", "'-'", "'!'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", 
		"'!='", "'&&'", "'||'", "'boolean'", "'money'", null, null, "'true'", 
		"'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "WHITESPACE", "COMMENT", "True", "False", "Ident", "Str", "Int"
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
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	public static List<Form> ParseForm(String path) {
			QLLexer lex = null;
			try {
				lex = new QLLexer(new ANTLRFileStream(path));
			} catch (IOException e) {
				e.printStackTrace();
			}

			CommonTokenStream tok = new CommonTokenStream(lex);
		    QLParser par = new QLParser(tok);

			List<Form> result = null;
		    try{
		        result = par.forms().result;
		    } catch (RecognitionException e) {
				e.printStackTrace();
		    }
			return result;
	}

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public Form result;
		public Token i;
		public StatsContext s;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			((FormContext)_localctx).i = match(Ident);
			setState(34);
			match(T__1);
			setState(35);
			((FormContext)_localctx).s = stats();
			setState(36);
			match(T__2);
			((FormContext)_localctx).result =  new Form((((FormContext)_localctx).i!=null?((FormContext)_localctx).i.getText():null), ((FormContext)_localctx).s.result);
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

	public static class FormsContext extends ParserRuleContext {
		public List<Form> result;
		public FormContext form;
		public List<FormContext> form() {
			return getRuleContexts(FormContext.class);
		}
		public FormContext form(int i) {
			return getRuleContext(FormContext.class,i);
		}
		public FormsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterForms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitForms(this);
		}
	}

	public final FormsContext forms() throws RecognitionException {
		FormsContext _localctx = new FormsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_forms);
		((FormsContext)_localctx).result =  new ArrayList<Form>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				((FormsContext)_localctx).form = form();
				_localctx.result.add(((FormsContext)_localctx).form.result);
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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

	public static class VarDeclContext extends ParserRuleContext {
		public Var result;
		public Token i;
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			((VarDeclContext)_localctx).i = match(Ident);
			((VarDeclContext)_localctx).result =  new Var((((VarDeclContext)_localctx).i!=null?((VarDeclContext)_localctx).i.getText():null));
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

	public static class VarAssContext extends ParserRuleContext {
		public Expr result;
		public OrExprContext x;
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public VarAssContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAss; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterVarAss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitVarAss(this);
		}
	}

	public final VarAssContext varAss() throws RecognitionException {
		VarAssContext _localctx = new VarAssContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varAss);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(49);
			match(T__3);
			setState(50);
			match(T__4);
			setState(51);
			((VarAssContext)_localctx).x = orExpr();
			setState(52);
			match(T__5);
			}
			((VarAssContext)_localctx).result =  ((VarAssContext)_localctx).x.result;
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

	public static class QuestionContext extends ParserRuleContext {
		public Stat result;
		public Token l;
		public VarDeclContext v;
		public TypeContext t;
		public VarAssContext e;
		public TerminalNode Str() { return getToken(QLParser.Str, 0); }
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarAssContext varAss() {
			return getRuleContext(VarAssContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question);
		try {
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				((QuestionContext)_localctx).l = match(Str);
				setState(57);
				((QuestionContext)_localctx).v = varDecl();
				setState(58);
				match(T__6);
				setState(59);
				((QuestionContext)_localctx).t = type();
				((QuestionContext)_localctx).result =  new Question((((QuestionContext)_localctx).l!=null?((QuestionContext)_localctx).l.getText():null), ((QuestionContext)_localctx).v.result, ((QuestionContext)_localctx).t.result);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				((QuestionContext)_localctx).l = match(Str);
				setState(63);
				((QuestionContext)_localctx).v = varDecl();
				setState(64);
				match(T__6);
				setState(65);
				((QuestionContext)_localctx).t = type();
				setState(66);
				((QuestionContext)_localctx).e = varAss();
				((QuestionContext)_localctx).result =  new Question((((QuestionContext)_localctx).l!=null?((QuestionContext)_localctx).l.getText():null), ((QuestionContext)_localctx).v.result, ((QuestionContext)_localctx).t.result, ((QuestionContext)_localctx).e.result);
				}
				break;
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

	public static class StatContext extends ParserRuleContext {
		public Stat result;
		public QuestionContext q;
		public OrExprContext c;
		public StatsContext s;
		public StatsContext i;
		public StatsContext e;
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public List<StatsContext> stats() {
			return getRuleContexts(StatsContext.class);
		}
		public StatsContext stats(int i) {
			return getRuleContext(StatsContext.class,i);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stat);
		try {
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((StatContext)_localctx).q = question();
				((StatContext)_localctx).result =  ((StatContext)_localctx).q.result;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(T__7);
				setState(75);
				match(T__4);
				setState(76);
				((StatContext)_localctx).c = orExpr();
				setState(77);
				match(T__5);
				setState(78);
				match(T__1);
				setState(79);
				((StatContext)_localctx).s = stats();
				setState(80);
				match(T__2);

				            LinkedHashMap<Expr, List<Stat>> map = new LinkedHashMap<Expr, List<Stat>>();
				            map.put(((StatContext)_localctx).c.result, ((StatContext)_localctx).s.result);
				            ((StatContext)_localctx).result =  new If(map);
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				match(T__7);
				setState(84);
				match(T__4);
				setState(85);
				((StatContext)_localctx).c = orExpr();
				setState(86);
				match(T__5);
				setState(87);
				match(T__1);
				setState(88);
				((StatContext)_localctx).i = stats();
				setState(89);
				match(T__2);
				setState(90);
				match(T__8);
				setState(91);
				match(T__1);
				setState(92);
				((StatContext)_localctx).e = stats();
				setState(93);
				match(T__2);

				            LinkedHashMap<Expr, List<Stat>> map = new LinkedHashMap<Expr, List<Stat>>();
				            map.put(((StatContext)_localctx).c.result, ((StatContext)_localctx).i.result);
				            map.put(null, ((StatContext)_localctx).e.result);
				            ((StatContext)_localctx).result =  new IfElse(map);
				        
				}
				break;
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

	public static class StatsContext extends ParserRuleContext {
		public List<Stat> result;
		public StatContext stat;
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stats; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStats(this);
		}
	}

	public final StatsContext stats() throws RecognitionException {
		StatsContext _localctx = new StatsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stats);
		((StatsContext)_localctx).result =  new ArrayList<Stat>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				((StatsContext)_localctx).stat = stat();
				_localctx.result.add(((StatsContext)_localctx).stat.result);
				}
				}
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__7 || _la==Str );
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

	public static class PrimaryContext extends ParserRuleContext {
		public Expr result;
		public Token x;
		public BoolContext y;
		public TerminalNode Int() { return getToken(QLParser.Int, 0); }
		public TerminalNode Ident() { return getToken(QLParser.Ident, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primary);
		try {
			setState(112);
			switch (_input.LA(1)) {
			case Int:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				((PrimaryContext)_localctx).x = match(Int);
				((PrimaryContext)_localctx).result =  new Int((((PrimaryContext)_localctx).x!=null?((PrimaryContext)_localctx).x.getText():null));
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				((PrimaryContext)_localctx).x = match(Ident);
				((PrimaryContext)_localctx).result =  new Var((((PrimaryContext)_localctx).x!=null?((PrimaryContext)_localctx).x.getText():null));
				}
				break;
			case True:
			case False:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				((PrimaryContext)_localctx).y = bool();
				((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).y.result;
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

	public static class UnExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext value;
		public PrimaryContext y;
		public UnExprContext unExpr() {
			return getRuleContext(UnExprContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterUnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitUnExpr(this);
		}
	}

	public final UnExprContext unExpr() throws RecognitionException {
		UnExprContext _localctx = new UnExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unExpr);
		try {
			setState(129);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(T__9);
				setState(115);
				((UnExprContext)_localctx).value = unExpr();
				 ((UnExprContext)_localctx).result =  new Pos(((UnExprContext)_localctx).value.result);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(T__10);
				setState(119);
				((UnExprContext)_localctx).value = unExpr();
				 ((UnExprContext)_localctx).result =  new Neg(((UnExprContext)_localctx).value.result);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(T__11);
				setState(123);
				((UnExprContext)_localctx).value = unExpr();
				 ((UnExprContext)_localctx).result =  new Not(((UnExprContext)_localctx).value.result);
				}
				break;
			case True:
			case False:
			case Ident:
			case Int:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				((UnExprContext)_localctx).y = primary();
				 ((UnExprContext)_localctx).result =  ((UnExprContext)_localctx).y.result; 
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

	public static class MulExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext lhs;
		public Token op;
		public UnExprContext rhs;
		public List<UnExprContext> unExpr() {
			return getRuleContexts(UnExprContext.class);
		}
		public UnExprContext unExpr(int i) {
			return getRuleContext(UnExprContext.class,i);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitMulExpr(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			((MulExprContext)_localctx).lhs = unExpr();
			 ((MulExprContext)_localctx).result = ((MulExprContext)_localctx).lhs.result; 
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || _la==T__13) {
				{
				{
				setState(133);
				((MulExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(134);
				((MulExprContext)_localctx).rhs = unExpr();
				 
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("*")) {
				        ((MulExprContext)_localctx).result =  new Mul(_localctx.result, ((MulExprContext)_localctx).rhs.result);
				      }
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("/")) {
				        ((MulExprContext)_localctx).result =  new Div(_localctx.result, ((MulExprContext)_localctx).rhs.result);
				      }
				    
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AddExprContext extends ParserRuleContext {
		public Expr result;
		public MulExprContext lhs;
		public Token op;
		public MulExprContext rhs;
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAddExpr(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((AddExprContext)_localctx).lhs = mulExpr();
			 ((AddExprContext)_localctx).result = ((AddExprContext)_localctx).lhs.result; 
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==T__10) {
				{
				{
				setState(144);
				((AddExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
					((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(145);
				((AddExprContext)_localctx).rhs = mulExpr();
				 
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("+")) {
				        ((AddExprContext)_localctx).result =  new Add(_localctx.result, ((AddExprContext)_localctx).rhs.result);
				      }
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("-")) {
				        ((AddExprContext)_localctx).result =  new Sub(_localctx.result, ((AddExprContext)_localctx).rhs.result);
				      }
				    
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class RelExprContext extends ParserRuleContext {
		public Expr result;
		public AddExprContext lhs;
		public Token op;
		public AddExprContext rhs;
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitRelExpr(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			((RelExprContext)_localctx).lhs = addExpr();
			 ((RelExprContext)_localctx).result = ((RelExprContext)_localctx).lhs.result; 
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) {
				{
				{
				setState(155);
				((RelExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
					((RelExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(156);
				((RelExprContext)_localctx).rhs = addExpr();
				 
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("<")) {
				        ((RelExprContext)_localctx).result =  new LT(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("<=")) {
				        ((RelExprContext)_localctx).result =  new LEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals(">")) {
				        ((RelExprContext)_localctx).result =  new GT(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals(">=")) {
				        ((RelExprContext)_localctx).result =  new GEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("==")) {
				        ((RelExprContext)_localctx).result =  new Eq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("!=")) {
				        ((RelExprContext)_localctx).result =  new NEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				    
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AndExprContext extends ParserRuleContext {
		public Expr result;
		public RelExprContext lhs;
		public RelExprContext rhs;
		public List<RelExprContext> relExpr() {
			return getRuleContexts(RelExprContext.class);
		}
		public RelExprContext relExpr(int i) {
			return getRuleContext(RelExprContext.class,i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAndExpr(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			((AndExprContext)_localctx).lhs = relExpr();
			 ((AndExprContext)_localctx).result = ((AndExprContext)_localctx).lhs.result; 
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(166);
				match(T__20);
				setState(167);
				((AndExprContext)_localctx).rhs = relExpr();
				 ((AndExprContext)_localctx).result =  new And(_localctx.result, ((AndExprContext)_localctx).rhs.result);
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class OrExprContext extends ParserRuleContext {
		public Expr result;
		public AndExprContext lhs;
		public AndExprContext rhs;
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitOrExpr(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			((OrExprContext)_localctx).lhs = andExpr();
			 ((OrExprContext)_localctx).result =  ((OrExprContext)_localctx).lhs.result; 
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(177);
				match(T__21);
				setState(178);
				((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).result =  new Or(_localctx.result, ((OrExprContext)_localctx).rhs.result); 
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TypeContext extends ParserRuleContext {
		public Val result;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		try {
			setState(190);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(T__22);
				((TypeContext)_localctx).result =  new Bool();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(T__23);
				((TypeContext)_localctx).result =  new Int();
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

	public static class BoolContext extends ParserRuleContext {
		public Val result;
		public Token value;
		public TerminalNode True() { return getToken(QLParser.True, 0); }
		public TerminalNode False() { return getToken(QLParser.False, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_bool);
		try {
			setState(196);
			switch (_input.LA(1)) {
			case True:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				((BoolContext)_localctx).value = match(True);
				((BoolContext)_localctx).result =  new Bool((((BoolContext)_localctx).value!=null?((BoolContext)_localctx).value.getText():null));
				}
				break;
			case False:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				((BoolContext)_localctx).value = match(False);
				((BoolContext)_localctx).result =  new Bool((((BoolContext)_localctx).value!=null?((BoolContext)_localctx).value.getText():null));
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u00c9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\6\3-\n\3\r\3\16\3.\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6H\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7c\n\7\3\b\3\b\3\b\6\bh\n"+
		"\b\r\b\16\bi\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ts\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0084\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u008c\n\13\f\13\16\13\u008f\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u00a2\n\r\f\r\16\r\u00a5\13\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00ad"+
		"\n\16\f\16\16\16\u00b0\13\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00b8"+
		"\n\17\f\17\16\17\u00bb\13\17\3\20\3\20\3\20\3\20\5\20\u00c1\n\20\3\21"+
		"\3\21\3\21\3\21\5\21\u00c7\n\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \2\5\3\2\17\20\3\2\f\r\3\2\21\26\u00c9\2\"\3\2\2\2\4,\3\2"+
		"\2\2\6\60\3\2\2\2\b\63\3\2\2\2\nG\3\2\2\2\fb\3\2\2\2\16g\3\2\2\2\20r\3"+
		"\2\2\2\22\u0083\3\2\2\2\24\u0085\3\2\2\2\26\u0090\3\2\2\2\30\u009b\3\2"+
		"\2\2\32\u00a6\3\2\2\2\34\u00b1\3\2\2\2\36\u00c0\3\2\2\2 \u00c6\3\2\2\2"+
		"\"#\7\3\2\2#$\7\37\2\2$%\7\4\2\2%&\5\16\b\2&\'\7\5\2\2\'(\b\2\1\2(\3\3"+
		"\2\2\2)*\5\2\2\2*+\b\3\1\2+-\3\2\2\2,)\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3"+
		"\2\2\2/\5\3\2\2\2\60\61\7\37\2\2\61\62\b\4\1\2\62\7\3\2\2\2\63\64\7\6"+
		"\2\2\64\65\7\7\2\2\65\66\5\34\17\2\66\67\7\b\2\2\678\3\2\2\289\b\5\1\2"+
		"9\t\3\2\2\2:;\7 \2\2;<\5\6\4\2<=\7\t\2\2=>\5\36\20\2>?\b\6\1\2?H\3\2\2"+
		"\2@A\7 \2\2AB\5\6\4\2BC\7\t\2\2CD\5\36\20\2DE\5\b\5\2EF\b\6\1\2FH\3\2"+
		"\2\2G:\3\2\2\2G@\3\2\2\2H\13\3\2\2\2IJ\5\n\6\2JK\b\7\1\2Kc\3\2\2\2LM\7"+
		"\n\2\2MN\7\7\2\2NO\5\34\17\2OP\7\b\2\2PQ\7\4\2\2QR\5\16\b\2RS\7\5\2\2"+
		"ST\b\7\1\2Tc\3\2\2\2UV\7\n\2\2VW\7\7\2\2WX\5\34\17\2XY\7\b\2\2YZ\7\4\2"+
		"\2Z[\5\16\b\2[\\\7\5\2\2\\]\7\13\2\2]^\7\4\2\2^_\5\16\b\2_`\7\5\2\2`a"+
		"\b\7\1\2ac\3\2\2\2bI\3\2\2\2bL\3\2\2\2bU\3\2\2\2c\r\3\2\2\2de\5\f\7\2"+
		"ef\b\b\1\2fh\3\2\2\2gd\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\17\3\2\2"+
		"\2kl\7!\2\2ls\b\t\1\2mn\7\37\2\2ns\b\t\1\2op\5 \21\2pq\b\t\1\2qs\3\2\2"+
		"\2rk\3\2\2\2rm\3\2\2\2ro\3\2\2\2s\21\3\2\2\2tu\7\f\2\2uv\5\22\n\2vw\b"+
		"\n\1\2w\u0084\3\2\2\2xy\7\r\2\2yz\5\22\n\2z{\b\n\1\2{\u0084\3\2\2\2|}"+
		"\7\16\2\2}~\5\22\n\2~\177\b\n\1\2\177\u0084\3\2\2\2\u0080\u0081\5\20\t"+
		"\2\u0081\u0082\b\n\1\2\u0082\u0084\3\2\2\2\u0083t\3\2\2\2\u0083x\3\2\2"+
		"\2\u0083|\3\2\2\2\u0083\u0080\3\2\2\2\u0084\23\3\2\2\2\u0085\u0086\5\22"+
		"\n\2\u0086\u008d\b\13\1\2\u0087\u0088\t\2\2\2\u0088\u0089\5\22\n\2\u0089"+
		"\u008a\b\13\1\2\u008a\u008c\3\2\2\2\u008b\u0087\3\2\2\2\u008c\u008f\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\25\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0091\5\24\13\2\u0091\u0098\b\f\1\2\u0092\u0093\t"+
		"\3\2\2\u0093\u0094\5\24\13\2\u0094\u0095\b\f\1\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0092\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\27\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\5\26\f\2\u009c\u00a3"+
		"\b\r\1\2\u009d\u009e\t\4\2\2\u009e\u009f\5\26\f\2\u009f\u00a0\b\r\1\2"+
		"\u00a0\u00a2\3\2\2\2\u00a1\u009d\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\31\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a7\5\30\r\2\u00a7\u00ae\b\16\1\2\u00a8\u00a9\7\27\2\2\u00a9\u00aa"+
		"\5\30\r\2\u00aa\u00ab\b\16\1\2\u00ab\u00ad\3\2\2\2\u00ac\u00a8\3\2\2\2"+
		"\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\33"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\5\32\16\2\u00b2\u00b9\b\17\1"+
		"\2\u00b3\u00b4\7\30\2\2\u00b4\u00b5\5\32\16\2\u00b5\u00b6\b\17\1\2\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\35\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd"+
		"\7\31\2\2\u00bd\u00c1\b\20\1\2\u00be\u00bf\7\32\2\2\u00bf\u00c1\b\20\1"+
		"\2\u00c0\u00bc\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\37\3\2\2\2\u00c2\u00c3"+
		"\7\35\2\2\u00c3\u00c7\b\21\1\2\u00c4\u00c5\7\36\2\2\u00c5\u00c7\b\21\1"+
		"\2\u00c6\u00c2\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7!\3\2\2\2\17.Gbir\u0083"+
		"\u008d\u0098\u00a3\u00ae\u00b9\u00c0\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}