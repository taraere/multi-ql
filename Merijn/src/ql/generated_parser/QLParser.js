// Generated from C:/Users/mwijngaard/Documents/Projects/multi-ql/Merijn/src/ql\QL.g4 by ANTLR 4.5.1
// jshint ignore: start
var antlr4 = require('antlr4/index');
var QLListener = require('./QLListener').QLListener;
var QLVisitor = require('./QLVisitor').QLVisitor;

var grammarFileName = "QL.g4";

var serializedATN = ["\u0003\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd",
    "\u0003%i\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t\u0004",
    "\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004\b",
    "\t\b\u0004\t\t\t\u0003\u0002\u0003\u0002\u0003\u0002\u0003\u0002\u0003",
    "\u0003\u0003\u0003\u0007\u0003\u0019\n\u0003\f\u0003\u000e\u0003\u001c",
    "\u000b\u0003\u0003\u0003\u0003\u0003\u0003\u0004\u0003\u0004\u0003\u0004",
    "\u0003\u0004\u0005\u0004$\n\u0004\u0003\u0005\u0003\u0005\u0003\u0005",
    "\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005",
    "\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0005\u0005",
    "4\n\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006",
    "\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0005\u0006?\n\u0006",
    "\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007",
    "\u0003\u0007\u0003\u0007\u0003\u0007\u0005\u0007J\n\u0007\u0003\u0007",
    "\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007",
    "\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007",
    "\u0003\u0007\u0003\u0007\u0007\u0007[\n\u0007\f\u0007\u000e\u0007^\u000b",
    "\u0007\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0005\be\n\b\u0003\t",
    "\u0003\t\u0003\t\u0002\u0003\f\n\u0002\u0004\u0006\b\n\f\u000e\u0010",
    "\u0002\u0007\u0004\u0002\u0017\u0017\u001d\u001d\u0003\u0002\u0018\u0019",
    "\u0003\u0002\u0016\u0017\u0003\u0002\u0010\u0015\u0003\u0002\u0006\n",
    "p\u0002\u0012\u0003\u0002\u0002\u0002\u0004\u0016\u0003\u0002\u0002",
    "\u0002\u0006#\u0003\u0002\u0002\u0002\b3\u0003\u0002\u0002\u0002\n>",
    "\u0003\u0002\u0002\u0002\fI\u0003\u0002\u0002\u0002\u000ed\u0003\u0002",
    "\u0002\u0002\u0010f\u0003\u0002\u0002\u0002\u0012\u0013\u0007\u0003",
    "\u0002\u0002\u0013\u0014\u0007$\u0002\u0002\u0014\u0015\u0005\u0004",
    "\u0003\u0002\u0015\u0003\u0003\u0002\u0002\u0002\u0016\u001a\u0007\u000b",
    "\u0002\u0002\u0017\u0019\u0005\u0006\u0004\u0002\u0018\u0017\u0003\u0002",
    "\u0002\u0002\u0019\u001c\u0003\u0002\u0002\u0002\u001a\u0018\u0003\u0002",
    "\u0002\u0002\u001a\u001b\u0003\u0002\u0002\u0002\u001b\u001d\u0003\u0002",
    "\u0002\u0002\u001c\u001a\u0003\u0002\u0002\u0002\u001d\u001e\u0007\f",
    "\u0002\u0002\u001e\u0005\u0003\u0002\u0002\u0002\u001f$\u0005\b\u0005",
    "\u0002 !\u0005\n\u0006\u0002!\"\u0007\u000f\u0002\u0002\"$\u0003\u0002",
    "\u0002\u0002#\u001f\u0003\u0002\u0002\u0002# \u0003\u0002\u0002\u0002",
    "$\u0007\u0003\u0002\u0002\u0002%&\u0007\u0004\u0002\u0002&\'\u0007\r",
    "\u0002\u0002\'(\u0005\f\u0007\u0002()\u0007\u000e\u0002\u0002)*\u0005",
    "\u0004\u0003\u0002*4\u0003\u0002\u0002\u0002+,\u0007\u0004\u0002\u0002",
    ",-\u0007\r\u0002\u0002-.\u0005\f\u0007\u0002./\u0007\u000e\u0002\u0002",
    "/0\u0005\u0004\u0003\u000201\u0007\u0005\u0002\u000212\u0005\u0004\u0003",
    "\u000224\u0003\u0002\u0002\u00023%\u0003\u0002\u0002\u00023+\u0003\u0002",
    "\u0002\u00024\t\u0003\u0002\u0002\u000256\u0007\u001e\u0002\u000267",
    "\u0007$\u0002\u00027?\u0005\u0010\t\u000289\u0007\u001e\u0002\u0002",
    "9:\u0007$\u0002\u0002:;\u0005\u0010\t\u0002;<\u0007\u001a\u0002\u0002",
    "<=\u0005\f\u0007\u0002=?\u0003\u0002\u0002\u0002>5\u0003\u0002\u0002",
    "\u0002>8\u0003\u0002\u0002\u0002?\u000b\u0003\u0002\u0002\u0002@A\b",
    "\u0007\u0001\u0002AB\t\u0002\u0002\u0002BJ\u0005\f\u0007\bCD\u0007\r",
    "\u0002\u0002DE\u0005\f\u0007\u0002EF\u0007\u000e\u0002\u0002FJ\u0003",
    "\u0002\u0002\u0002GJ\u0005\u000e\b\u0002HJ\u0007$\u0002\u0002I@\u0003",
    "\u0002\u0002\u0002IC\u0003\u0002\u0002\u0002IG\u0003\u0002\u0002\u0002",
    "IH\u0003\u0002\u0002\u0002J\\\u0003\u0002\u0002\u0002KL\f\u0007\u0002",
    "\u0002LM\t\u0003\u0002\u0002M[\u0005\f\u0007\bNO\f\u0006\u0002\u0002",
    "OP\t\u0004\u0002\u0002P[\u0005\f\u0007\u0007QR\f\u0005\u0002\u0002R",
    "S\t\u0005\u0002\u0002S[\u0005\f\u0007\u0006TU\f\u0004\u0002\u0002UV",
    "\u0007\u001b\u0002\u0002V[\u0005\f\u0007\u0005WX\f\u0003\u0002\u0002",
    "XY\u0007\u001c\u0002\u0002Y[\u0005\f\u0007\u0004ZK\u0003\u0002\u0002",
    "\u0002ZN\u0003\u0002\u0002\u0002ZQ\u0003\u0002\u0002\u0002ZT\u0003\u0002",
    "\u0002\u0002ZW\u0003\u0002\u0002\u0002[^\u0003\u0002\u0002\u0002\\Z",
    "\u0003\u0002\u0002\u0002\\]\u0003\u0002\u0002\u0002]\r\u0003\u0002\u0002",
    "\u0002^\\\u0003\u0002\u0002\u0002_e\u0007#\u0002\u0002`e\u0007\u001e",
    "\u0002\u0002ae\u0007\u001f\u0002\u0002be\u0007 \u0002\u0002ce\u0007",
    "!\u0002\u0002d_\u0003\u0002\u0002\u0002d`\u0003\u0002\u0002\u0002da",
    "\u0003\u0002\u0002\u0002db\u0003\u0002\u0002\u0002dc\u0003\u0002\u0002",
    "\u0002e\u000f\u0003\u0002\u0002\u0002fg\t\u0006\u0002\u0002g\u0011\u0003",
    "\u0002\u0002\u0002\n\u001a#3>IZ\\d"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ 'null', "'Form'", "'if'", "'else'", "'boolean'", "'string'", 
                     "'integer'", "'float'", "'money'", "'{'", "'}'", "'('", 
                     "')'", "';'", "'=='", "'!='", "'>'", "'>='", "'<'", 
                     "'<='", "'+'", "'-'", "'*'", "'/'", "'='", "'&&'", 
                     "'||'", "'!'" ];

var symbolicNames = [ 'null', "FORM", "IF", "ELSE", "TYPE_BOOLEAN", "TYPE_STRING", 
                      "TYPE_INTEGER", "TYPE_FLOAT", "TYPE_MONEY", "LEFT_BRACE", 
                      "RIGHT_BRACE", "LEFT_PAREN", "RIGHT_PAREN", "SEMICOL", 
                      "EQ", "NOT_EQ", "GT", "GT_EQ", "LT", "LT_EQ", "PLUS", 
                      "MINUS", "MUL", "DIV", "ASSIGN", "AND", "OR", "NOT", 
                      "STRING_LITERAL", "INTEGER_LITERAL", "FLOAT_LITERAL", 
                      "MONEY_LITERAL", "MONEY_LITERAL_CENTS", "BOOLEAN_LITERAL", 
                      "IDENTIFIER", "WHITESPACE" ];

var ruleNames =  [ "form", "block", "statement", "if_", "question", "expr", 
                   "literal", "type" ];

function QLParser (input) {
	antlr4.Parser.call(this, input);
    this._interp = new antlr4.atn.ParserATNSimulator(this, atn, decisionsToDFA, sharedContextCache);
    this.ruleNames = ruleNames;
    this.literalNames = literalNames;
    this.symbolicNames = symbolicNames;
    return this;
}

QLParser.prototype = Object.create(antlr4.Parser.prototype);
QLParser.prototype.constructor = QLParser;

Object.defineProperty(QLParser.prototype, "atn", {
	get : function() {
		return atn;
	}
});

QLParser.EOF = antlr4.Token.EOF;
QLParser.FORM = 1;
QLParser.IF = 2;
QLParser.ELSE = 3;
QLParser.TYPE_BOOLEAN = 4;
QLParser.TYPE_STRING = 5;
QLParser.TYPE_INTEGER = 6;
QLParser.TYPE_FLOAT = 7;
QLParser.TYPE_MONEY = 8;
QLParser.LEFT_BRACE = 9;
QLParser.RIGHT_BRACE = 10;
QLParser.LEFT_PAREN = 11;
QLParser.RIGHT_PAREN = 12;
QLParser.SEMICOL = 13;
QLParser.EQ = 14;
QLParser.NOT_EQ = 15;
QLParser.GT = 16;
QLParser.GT_EQ = 17;
QLParser.LT = 18;
QLParser.LT_EQ = 19;
QLParser.PLUS = 20;
QLParser.MINUS = 21;
QLParser.MUL = 22;
QLParser.DIV = 23;
QLParser.ASSIGN = 24;
QLParser.AND = 25;
QLParser.OR = 26;
QLParser.NOT = 27;
QLParser.STRING_LITERAL = 28;
QLParser.INTEGER_LITERAL = 29;
QLParser.FLOAT_LITERAL = 30;
QLParser.MONEY_LITERAL = 31;
QLParser.MONEY_LITERAL_CENTS = 32;
QLParser.BOOLEAN_LITERAL = 33;
QLParser.IDENTIFIER = 34;
QLParser.WHITESPACE = 35;

QLParser.RULE_form = 0;
QLParser.RULE_block = 1;
QLParser.RULE_statement = 2;
QLParser.RULE_if_ = 3;
QLParser.RULE_question = 4;
QLParser.RULE_expr = 5;
QLParser.RULE_literal = 6;
QLParser.RULE_type = 7;

function FormContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = QLParser.RULE_form;
    return this;
}

FormContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FormContext.prototype.constructor = FormContext;

FormContext.prototype.FORM = function() {
    return this.getToken(QLParser.FORM, 0);
};

FormContext.prototype.IDENTIFIER = function() {
    return this.getToken(QLParser.IDENTIFIER, 0);
};

FormContext.prototype.block = function() {
    return this.getTypedRuleContext(BlockContext,0);
};

FormContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterForm(this);
	}
};

FormContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitForm(this);
	}
};

FormContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitForm(this);
    } else {
        return visitor.visitChildren(this);
    }
};




QLParser.FormContext = FormContext;

QLParser.prototype.form = function() {

    var localctx = new FormContext(this, this._ctx, this.state);
    this.enterRule(localctx, 0, QLParser.RULE_form);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 16;
        this.match(QLParser.FORM);
        this.state = 17;
        this.match(QLParser.IDENTIFIER);
        this.state = 18;
        this.block();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function BlockContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = QLParser.RULE_block;
    return this;
}

BlockContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
BlockContext.prototype.constructor = BlockContext;

BlockContext.prototype.LEFT_BRACE = function() {
    return this.getToken(QLParser.LEFT_BRACE, 0);
};

BlockContext.prototype.RIGHT_BRACE = function() {
    return this.getToken(QLParser.RIGHT_BRACE, 0);
};

BlockContext.prototype.statement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(StatementContext);
    } else {
        return this.getTypedRuleContext(StatementContext,i);
    }
};

BlockContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterBlock(this);
	}
};

BlockContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitBlock(this);
	}
};

BlockContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitBlock(this);
    } else {
        return visitor.visitChildren(this);
    }
};




QLParser.BlockContext = BlockContext;

QLParser.prototype.block = function() {

    var localctx = new BlockContext(this, this._ctx, this.state);
    this.enterRule(localctx, 2, QLParser.RULE_block);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 20;
        this.match(QLParser.LEFT_BRACE);
        this.state = 24;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===QLParser.IF || _la===QLParser.STRING_LITERAL) {
            this.state = 21;
            this.statement();
            this.state = 26;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 27;
        this.match(QLParser.RIGHT_BRACE);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function StatementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = QLParser.RULE_statement;
    return this;
}

StatementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
StatementContext.prototype.constructor = StatementContext;


 
StatementContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function IfStatementCaseContext(parser, ctx) {
	StatementContext.call(this, parser);
    StatementContext.prototype.copyFrom.call(this, ctx);
    return this;
}

IfStatementCaseContext.prototype = Object.create(StatementContext.prototype);
IfStatementCaseContext.prototype.constructor = IfStatementCaseContext;

QLParser.IfStatementCaseContext = IfStatementCaseContext;

IfStatementCaseContext.prototype.if_ = function() {
    return this.getTypedRuleContext(If_Context,0);
};
IfStatementCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterIfStatementCase(this);
	}
};

IfStatementCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitIfStatementCase(this);
	}
};

IfStatementCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitIfStatementCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function QuestionStatementCaseContext(parser, ctx) {
	StatementContext.call(this, parser);
    StatementContext.prototype.copyFrom.call(this, ctx);
    return this;
}

QuestionStatementCaseContext.prototype = Object.create(StatementContext.prototype);
QuestionStatementCaseContext.prototype.constructor = QuestionStatementCaseContext;

QLParser.QuestionStatementCaseContext = QuestionStatementCaseContext;

QuestionStatementCaseContext.prototype.question = function() {
    return this.getTypedRuleContext(QuestionContext,0);
};

QuestionStatementCaseContext.prototype.SEMICOL = function() {
    return this.getToken(QLParser.SEMICOL, 0);
};
QuestionStatementCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterQuestionStatementCase(this);
	}
};

QuestionStatementCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitQuestionStatementCase(this);
	}
};

QuestionStatementCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitQuestionStatementCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};



QLParser.StatementContext = StatementContext;

QLParser.prototype.statement = function() {

    var localctx = new StatementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 4, QLParser.RULE_statement);
    try {
        this.state = 33;
        switch(this._input.LA(1)) {
        case QLParser.IF:
            localctx = new IfStatementCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 29;
            this.if_();
            break;
        case QLParser.STRING_LITERAL:
            localctx = new QuestionStatementCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 30;
            this.question();
            this.state = 31;
            this.match(QLParser.SEMICOL);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function If_Context(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = QLParser.RULE_if_;
    return this;
}

If_Context.prototype = Object.create(antlr4.ParserRuleContext.prototype);
If_Context.prototype.constructor = If_Context;


 
If_Context.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function IfElseCaseContext(parser, ctx) {
	If_Context.call(this, parser);
    If_Context.prototype.copyFrom.call(this, ctx);
    return this;
}

IfElseCaseContext.prototype = Object.create(If_Context.prototype);
IfElseCaseContext.prototype.constructor = IfElseCaseContext;

QLParser.IfElseCaseContext = IfElseCaseContext;

IfElseCaseContext.prototype.IF = function() {
    return this.getToken(QLParser.IF, 0);
};

IfElseCaseContext.prototype.LEFT_PAREN = function() {
    return this.getToken(QLParser.LEFT_PAREN, 0);
};

IfElseCaseContext.prototype.expr = function() {
    return this.getTypedRuleContext(ExprContext,0);
};

IfElseCaseContext.prototype.RIGHT_PAREN = function() {
    return this.getToken(QLParser.RIGHT_PAREN, 0);
};

IfElseCaseContext.prototype.block = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(BlockContext);
    } else {
        return this.getTypedRuleContext(BlockContext,i);
    }
};

IfElseCaseContext.prototype.ELSE = function() {
    return this.getToken(QLParser.ELSE, 0);
};
IfElseCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterIfElseCase(this);
	}
};

IfElseCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitIfElseCase(this);
	}
};

IfElseCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitIfElseCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function IfCaseContext(parser, ctx) {
	If_Context.call(this, parser);
    If_Context.prototype.copyFrom.call(this, ctx);
    return this;
}

IfCaseContext.prototype = Object.create(If_Context.prototype);
IfCaseContext.prototype.constructor = IfCaseContext;

QLParser.IfCaseContext = IfCaseContext;

IfCaseContext.prototype.IF = function() {
    return this.getToken(QLParser.IF, 0);
};

IfCaseContext.prototype.LEFT_PAREN = function() {
    return this.getToken(QLParser.LEFT_PAREN, 0);
};

IfCaseContext.prototype.expr = function() {
    return this.getTypedRuleContext(ExprContext,0);
};

IfCaseContext.prototype.RIGHT_PAREN = function() {
    return this.getToken(QLParser.RIGHT_PAREN, 0);
};

IfCaseContext.prototype.block = function() {
    return this.getTypedRuleContext(BlockContext,0);
};
IfCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterIfCase(this);
	}
};

IfCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitIfCase(this);
	}
};

IfCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitIfCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};



QLParser.If_Context = If_Context;

QLParser.prototype.if_ = function() {

    var localctx = new If_Context(this, this._ctx, this.state);
    this.enterRule(localctx, 6, QLParser.RULE_if_);
    try {
        this.state = 49;
        var la_ = this._interp.adaptivePredict(this._input,2,this._ctx);
        switch(la_) {
        case 1:
            localctx = new IfCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 35;
            this.match(QLParser.IF);
            this.state = 36;
            this.match(QLParser.LEFT_PAREN);
            this.state = 37;
            this.expr(0);
            this.state = 38;
            this.match(QLParser.RIGHT_PAREN);
            this.state = 39;
            this.block();
            break;

        case 2:
            localctx = new IfElseCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 41;
            this.match(QLParser.IF);
            this.state = 42;
            this.match(QLParser.LEFT_PAREN);
            this.state = 43;
            this.expr(0);
            this.state = 44;
            this.match(QLParser.RIGHT_PAREN);
            this.state = 45;
            this.block();
            this.state = 46;
            this.match(QLParser.ELSE);
            this.state = 47;
            this.block();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function QuestionContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = QLParser.RULE_question;
    return this;
}

QuestionContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
QuestionContext.prototype.constructor = QuestionContext;


 
QuestionContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function QuestionCaseContext(parser, ctx) {
	QuestionContext.call(this, parser);
    QuestionContext.prototype.copyFrom.call(this, ctx);
    return this;
}

QuestionCaseContext.prototype = Object.create(QuestionContext.prototype);
QuestionCaseContext.prototype.constructor = QuestionCaseContext;

QLParser.QuestionCaseContext = QuestionCaseContext;

QuestionCaseContext.prototype.STRING_LITERAL = function() {
    return this.getToken(QLParser.STRING_LITERAL, 0);
};

QuestionCaseContext.prototype.IDENTIFIER = function() {
    return this.getToken(QLParser.IDENTIFIER, 0);
};

QuestionCaseContext.prototype.type = function() {
    return this.getTypedRuleContext(TypeContext,0);
};
QuestionCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterQuestionCase(this);
	}
};

QuestionCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitQuestionCase(this);
	}
};

QuestionCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitQuestionCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function ExprQuestionCaseContext(parser, ctx) {
	QuestionContext.call(this, parser);
    QuestionContext.prototype.copyFrom.call(this, ctx);
    return this;
}

ExprQuestionCaseContext.prototype = Object.create(QuestionContext.prototype);
ExprQuestionCaseContext.prototype.constructor = ExprQuestionCaseContext;

QLParser.ExprQuestionCaseContext = ExprQuestionCaseContext;

ExprQuestionCaseContext.prototype.STRING_LITERAL = function() {
    return this.getToken(QLParser.STRING_LITERAL, 0);
};

ExprQuestionCaseContext.prototype.IDENTIFIER = function() {
    return this.getToken(QLParser.IDENTIFIER, 0);
};

ExprQuestionCaseContext.prototype.type = function() {
    return this.getTypedRuleContext(TypeContext,0);
};

ExprQuestionCaseContext.prototype.ASSIGN = function() {
    return this.getToken(QLParser.ASSIGN, 0);
};

ExprQuestionCaseContext.prototype.expr = function() {
    return this.getTypedRuleContext(ExprContext,0);
};
ExprQuestionCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterExprQuestionCase(this);
	}
};

ExprQuestionCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitExprQuestionCase(this);
	}
};

ExprQuestionCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitExprQuestionCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};



QLParser.QuestionContext = QuestionContext;

QLParser.prototype.question = function() {

    var localctx = new QuestionContext(this, this._ctx, this.state);
    this.enterRule(localctx, 8, QLParser.RULE_question);
    try {
        this.state = 60;
        var la_ = this._interp.adaptivePredict(this._input,3,this._ctx);
        switch(la_) {
        case 1:
            localctx = new QuestionCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 51;
            this.match(QLParser.STRING_LITERAL);
            this.state = 52;
            this.match(QLParser.IDENTIFIER);
            this.state = 53;
            this.type();
            break;

        case 2:
            localctx = new ExprQuestionCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 54;
            this.match(QLParser.STRING_LITERAL);
            this.state = 55;
            this.match(QLParser.IDENTIFIER);
            this.state = 56;
            this.type();
            this.state = 57;
            this.match(QLParser.ASSIGN);
            this.state = 58;
            this.expr(0);
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function ExprContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = QLParser.RULE_expr;
    return this;
}

ExprContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ExprContext.prototype.constructor = ExprContext;


 
ExprContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};

function UnaryPrefixExprCaseContext(parser, ctx) {
	ExprContext.call(this, parser);
    ExprContext.prototype.copyFrom.call(this, ctx);
    return this;
}

UnaryPrefixExprCaseContext.prototype = Object.create(ExprContext.prototype);
UnaryPrefixExprCaseContext.prototype.constructor = UnaryPrefixExprCaseContext;

QLParser.UnaryPrefixExprCaseContext = UnaryPrefixExprCaseContext;

UnaryPrefixExprCaseContext.prototype.expr = function() {
    return this.getTypedRuleContext(ExprContext,0);
};

UnaryPrefixExprCaseContext.prototype.NOT = function() {
    return this.getToken(QLParser.NOT, 0);
};

UnaryPrefixExprCaseContext.prototype.MINUS = function() {
    return this.getToken(QLParser.MINUS, 0);
};
UnaryPrefixExprCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterUnaryPrefixExprCase(this);
	}
};

UnaryPrefixExprCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitUnaryPrefixExprCase(this);
	}
};

UnaryPrefixExprCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitUnaryPrefixExprCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function ParenExprCaseContext(parser, ctx) {
	ExprContext.call(this, parser);
    ExprContext.prototype.copyFrom.call(this, ctx);
    return this;
}

ParenExprCaseContext.prototype = Object.create(ExprContext.prototype);
ParenExprCaseContext.prototype.constructor = ParenExprCaseContext;

QLParser.ParenExprCaseContext = ParenExprCaseContext;

ParenExprCaseContext.prototype.LEFT_PAREN = function() {
    return this.getToken(QLParser.LEFT_PAREN, 0);
};

ParenExprCaseContext.prototype.expr = function() {
    return this.getTypedRuleContext(ExprContext,0);
};

ParenExprCaseContext.prototype.RIGHT_PAREN = function() {
    return this.getToken(QLParser.RIGHT_PAREN, 0);
};
ParenExprCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterParenExprCase(this);
	}
};

ParenExprCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitParenExprCase(this);
	}
};

ParenExprCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitParenExprCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function InfixExprCaseContext(parser, ctx) {
	ExprContext.call(this, parser);
    ExprContext.prototype.copyFrom.call(this, ctx);
    return this;
}

InfixExprCaseContext.prototype = Object.create(ExprContext.prototype);
InfixExprCaseContext.prototype.constructor = InfixExprCaseContext;

QLParser.InfixExprCaseContext = InfixExprCaseContext;

InfixExprCaseContext.prototype.expr = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ExprContext);
    } else {
        return this.getTypedRuleContext(ExprContext,i);
    }
};

InfixExprCaseContext.prototype.MUL = function() {
    return this.getToken(QLParser.MUL, 0);
};

InfixExprCaseContext.prototype.DIV = function() {
    return this.getToken(QLParser.DIV, 0);
};

InfixExprCaseContext.prototype.PLUS = function() {
    return this.getToken(QLParser.PLUS, 0);
};

InfixExprCaseContext.prototype.MINUS = function() {
    return this.getToken(QLParser.MINUS, 0);
};

InfixExprCaseContext.prototype.EQ = function() {
    return this.getToken(QLParser.EQ, 0);
};

InfixExprCaseContext.prototype.NOT_EQ = function() {
    return this.getToken(QLParser.NOT_EQ, 0);
};

InfixExprCaseContext.prototype.GT = function() {
    return this.getToken(QLParser.GT, 0);
};

InfixExprCaseContext.prototype.GT_EQ = function() {
    return this.getToken(QLParser.GT_EQ, 0);
};

InfixExprCaseContext.prototype.LT = function() {
    return this.getToken(QLParser.LT, 0);
};

InfixExprCaseContext.prototype.LT_EQ = function() {
    return this.getToken(QLParser.LT_EQ, 0);
};

InfixExprCaseContext.prototype.AND = function() {
    return this.getToken(QLParser.AND, 0);
};

InfixExprCaseContext.prototype.OR = function() {
    return this.getToken(QLParser.OR, 0);
};
InfixExprCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterInfixExprCase(this);
	}
};

InfixExprCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitInfixExprCase(this);
	}
};

InfixExprCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitInfixExprCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function IdentifierExprCaseContext(parser, ctx) {
	ExprContext.call(this, parser);
    ExprContext.prototype.copyFrom.call(this, ctx);
    return this;
}

IdentifierExprCaseContext.prototype = Object.create(ExprContext.prototype);
IdentifierExprCaseContext.prototype.constructor = IdentifierExprCaseContext;

QLParser.IdentifierExprCaseContext = IdentifierExprCaseContext;

IdentifierExprCaseContext.prototype.IDENTIFIER = function() {
    return this.getToken(QLParser.IDENTIFIER, 0);
};
IdentifierExprCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterIdentifierExprCase(this);
	}
};

IdentifierExprCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitIdentifierExprCase(this);
	}
};

IdentifierExprCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitIdentifierExprCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function LiteralExprCaseContext(parser, ctx) {
	ExprContext.call(this, parser);
    ExprContext.prototype.copyFrom.call(this, ctx);
    return this;
}

LiteralExprCaseContext.prototype = Object.create(ExprContext.prototype);
LiteralExprCaseContext.prototype.constructor = LiteralExprCaseContext;

QLParser.LiteralExprCaseContext = LiteralExprCaseContext;

LiteralExprCaseContext.prototype.literal = function() {
    return this.getTypedRuleContext(LiteralContext,0);
};
LiteralExprCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterLiteralExprCase(this);
	}
};

LiteralExprCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitLiteralExprCase(this);
	}
};

LiteralExprCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitLiteralExprCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};



QLParser.prototype.expr = function(_p) {
	if(_p===undefined) {
	    _p = 0;
	}
    var _parentctx = this._ctx;
    var _parentState = this.state;
    var localctx = new ExprContext(this, this._ctx, _parentState);
    var _prevctx = localctx;
    var _startState = 10;
    this.enterRecursionRule(localctx, 10, QLParser.RULE_expr, _p);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 71;
        switch(this._input.LA(1)) {
        case QLParser.MINUS:
        case QLParser.NOT:
            localctx = new UnaryPrefixExprCaseContext(this, localctx);
            this._ctx = localctx;
            _prevctx = localctx;

            this.state = 63;
            _la = this._input.LA(1);
            if(!(_la===QLParser.MINUS || _la===QLParser.NOT)) {
            this._errHandler.recoverInline(this);
            }
            else {
                this.consume();
            }
            this.state = 64;
            this.expr(6);
            break;
        case QLParser.LEFT_PAREN:
            localctx = new ParenExprCaseContext(this, localctx);
            this._ctx = localctx;
            _prevctx = localctx;
            this.state = 65;
            this.match(QLParser.LEFT_PAREN);
            this.state = 66;
            this.expr(0);
            this.state = 67;
            this.match(QLParser.RIGHT_PAREN);
            break;
        case QLParser.STRING_LITERAL:
        case QLParser.INTEGER_LITERAL:
        case QLParser.FLOAT_LITERAL:
        case QLParser.MONEY_LITERAL:
        case QLParser.BOOLEAN_LITERAL:
            localctx = new LiteralExprCaseContext(this, localctx);
            this._ctx = localctx;
            _prevctx = localctx;
            this.state = 69;
            this.literal();
            break;
        case QLParser.IDENTIFIER:
            localctx = new IdentifierExprCaseContext(this, localctx);
            this._ctx = localctx;
            _prevctx = localctx;
            this.state = 70;
            this.match(QLParser.IDENTIFIER);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this._ctx.stop = this._input.LT(-1);
        this.state = 90;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,6,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                if(this._parseListeners!==null) {
                    this.triggerExitRuleEvent();
                }
                _prevctx = localctx;
                this.state = 88;
                var la_ = this._interp.adaptivePredict(this._input,5,this._ctx);
                switch(la_) {
                case 1:
                    localctx = new InfixExprCaseContext(this, new ExprContext(this, _parentctx, _parentState));
                    this.pushNewRecursionContext(localctx, _startState, QLParser.RULE_expr);
                    this.state = 73;
                    if (!( this.precpred(this._ctx, 5))) {
                        throw new antlr4.error.FailedPredicateException(this, "this.precpred(this._ctx, 5)");
                    }
                    this.state = 74;
                    _la = this._input.LA(1);
                    if(!(_la===QLParser.MUL || _la===QLParser.DIV)) {
                    this._errHandler.recoverInline(this);
                    }
                    else {
                        this.consume();
                    }
                    this.state = 75;
                    this.expr(6);
                    break;

                case 2:
                    localctx = new InfixExprCaseContext(this, new ExprContext(this, _parentctx, _parentState));
                    this.pushNewRecursionContext(localctx, _startState, QLParser.RULE_expr);
                    this.state = 76;
                    if (!( this.precpred(this._ctx, 4))) {
                        throw new antlr4.error.FailedPredicateException(this, "this.precpred(this._ctx, 4)");
                    }
                    this.state = 77;
                    _la = this._input.LA(1);
                    if(!(_la===QLParser.PLUS || _la===QLParser.MINUS)) {
                    this._errHandler.recoverInline(this);
                    }
                    else {
                        this.consume();
                    }
                    this.state = 78;
                    this.expr(5);
                    break;

                case 3:
                    localctx = new InfixExprCaseContext(this, new ExprContext(this, _parentctx, _parentState));
                    this.pushNewRecursionContext(localctx, _startState, QLParser.RULE_expr);
                    this.state = 79;
                    if (!( this.precpred(this._ctx, 3))) {
                        throw new antlr4.error.FailedPredicateException(this, "this.precpred(this._ctx, 3)");
                    }
                    this.state = 80;
                    _la = this._input.LA(1);
                    if(!((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << QLParser.EQ) | (1 << QLParser.NOT_EQ) | (1 << QLParser.GT) | (1 << QLParser.GT_EQ) | (1 << QLParser.LT) | (1 << QLParser.LT_EQ))) !== 0))) {
                    this._errHandler.recoverInline(this);
                    }
                    else {
                        this.consume();
                    }
                    this.state = 81;
                    this.expr(4);
                    break;

                case 4:
                    localctx = new InfixExprCaseContext(this, new ExprContext(this, _parentctx, _parentState));
                    this.pushNewRecursionContext(localctx, _startState, QLParser.RULE_expr);
                    this.state = 82;
                    if (!( this.precpred(this._ctx, 2))) {
                        throw new antlr4.error.FailedPredicateException(this, "this.precpred(this._ctx, 2)");
                    }
                    this.state = 83;
                    this.match(QLParser.AND);
                    this.state = 84;
                    this.expr(3);
                    break;

                case 5:
                    localctx = new InfixExprCaseContext(this, new ExprContext(this, _parentctx, _parentState));
                    this.pushNewRecursionContext(localctx, _startState, QLParser.RULE_expr);
                    this.state = 85;
                    if (!( this.precpred(this._ctx, 1))) {
                        throw new antlr4.error.FailedPredicateException(this, "this.precpred(this._ctx, 1)");
                    }
                    this.state = 86;
                    this.match(QLParser.OR);
                    this.state = 87;
                    this.expr(2);
                    break;

                } 
            }
            this.state = 92;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,6,this._ctx);
        }

    } catch( error) {
        if(error instanceof antlr4.error.RecognitionException) {
	        localctx.exception = error;
	        this._errHandler.reportError(this, error);
	        this._errHandler.recover(this, error);
	    } else {
	    	throw error;
	    }
    } finally {
        this.unrollRecursionContexts(_parentctx)
    }
    return localctx;
};

function LiteralContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = QLParser.RULE_literal;
    return this;
}

LiteralContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
LiteralContext.prototype.constructor = LiteralContext;


 
LiteralContext.prototype.copyFrom = function(ctx) {
    antlr4.ParserRuleContext.prototype.copyFrom.call(this, ctx);
};


function IntegerLiteralCaseContext(parser, ctx) {
	LiteralContext.call(this, parser);
    LiteralContext.prototype.copyFrom.call(this, ctx);
    return this;
}

IntegerLiteralCaseContext.prototype = Object.create(LiteralContext.prototype);
IntegerLiteralCaseContext.prototype.constructor = IntegerLiteralCaseContext;

QLParser.IntegerLiteralCaseContext = IntegerLiteralCaseContext;

IntegerLiteralCaseContext.prototype.INTEGER_LITERAL = function() {
    return this.getToken(QLParser.INTEGER_LITERAL, 0);
};
IntegerLiteralCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterIntegerLiteralCase(this);
	}
};

IntegerLiteralCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitIntegerLiteralCase(this);
	}
};

IntegerLiteralCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitIntegerLiteralCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function MoneyLiteralCaseContext(parser, ctx) {
	LiteralContext.call(this, parser);
    LiteralContext.prototype.copyFrom.call(this, ctx);
    return this;
}

MoneyLiteralCaseContext.prototype = Object.create(LiteralContext.prototype);
MoneyLiteralCaseContext.prototype.constructor = MoneyLiteralCaseContext;

QLParser.MoneyLiteralCaseContext = MoneyLiteralCaseContext;

MoneyLiteralCaseContext.prototype.MONEY_LITERAL = function() {
    return this.getToken(QLParser.MONEY_LITERAL, 0);
};
MoneyLiteralCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterMoneyLiteralCase(this);
	}
};

MoneyLiteralCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitMoneyLiteralCase(this);
	}
};

MoneyLiteralCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitMoneyLiteralCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function BooleanLiteralCaseContext(parser, ctx) {
	LiteralContext.call(this, parser);
    LiteralContext.prototype.copyFrom.call(this, ctx);
    return this;
}

BooleanLiteralCaseContext.prototype = Object.create(LiteralContext.prototype);
BooleanLiteralCaseContext.prototype.constructor = BooleanLiteralCaseContext;

QLParser.BooleanLiteralCaseContext = BooleanLiteralCaseContext;

BooleanLiteralCaseContext.prototype.BOOLEAN_LITERAL = function() {
    return this.getToken(QLParser.BOOLEAN_LITERAL, 0);
};
BooleanLiteralCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterBooleanLiteralCase(this);
	}
};

BooleanLiteralCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitBooleanLiteralCase(this);
	}
};

BooleanLiteralCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitBooleanLiteralCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function StringLiteralCaseContext(parser, ctx) {
	LiteralContext.call(this, parser);
    LiteralContext.prototype.copyFrom.call(this, ctx);
    return this;
}

StringLiteralCaseContext.prototype = Object.create(LiteralContext.prototype);
StringLiteralCaseContext.prototype.constructor = StringLiteralCaseContext;

QLParser.StringLiteralCaseContext = StringLiteralCaseContext;

StringLiteralCaseContext.prototype.STRING_LITERAL = function() {
    return this.getToken(QLParser.STRING_LITERAL, 0);
};
StringLiteralCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterStringLiteralCase(this);
	}
};

StringLiteralCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitStringLiteralCase(this);
	}
};

StringLiteralCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitStringLiteralCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};


function FloatLiteralCaseContext(parser, ctx) {
	LiteralContext.call(this, parser);
    LiteralContext.prototype.copyFrom.call(this, ctx);
    return this;
}

FloatLiteralCaseContext.prototype = Object.create(LiteralContext.prototype);
FloatLiteralCaseContext.prototype.constructor = FloatLiteralCaseContext;

QLParser.FloatLiteralCaseContext = FloatLiteralCaseContext;

FloatLiteralCaseContext.prototype.FLOAT_LITERAL = function() {
    return this.getToken(QLParser.FLOAT_LITERAL, 0);
};
FloatLiteralCaseContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterFloatLiteralCase(this);
	}
};

FloatLiteralCaseContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitFloatLiteralCase(this);
	}
};

FloatLiteralCaseContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitFloatLiteralCase(this);
    } else {
        return visitor.visitChildren(this);
    }
};



QLParser.LiteralContext = LiteralContext;

QLParser.prototype.literal = function() {

    var localctx = new LiteralContext(this, this._ctx, this.state);
    this.enterRule(localctx, 12, QLParser.RULE_literal);
    try {
        this.state = 98;
        switch(this._input.LA(1)) {
        case QLParser.BOOLEAN_LITERAL:
            localctx = new BooleanLiteralCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 1);
            this.state = 93;
            this.match(QLParser.BOOLEAN_LITERAL);
            break;
        case QLParser.STRING_LITERAL:
            localctx = new StringLiteralCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 2);
            this.state = 94;
            this.match(QLParser.STRING_LITERAL);
            break;
        case QLParser.INTEGER_LITERAL:
            localctx = new IntegerLiteralCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 3);
            this.state = 95;
            this.match(QLParser.INTEGER_LITERAL);
            break;
        case QLParser.FLOAT_LITERAL:
            localctx = new FloatLiteralCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 4);
            this.state = 96;
            this.match(QLParser.FLOAT_LITERAL);
            break;
        case QLParser.MONEY_LITERAL:
            localctx = new MoneyLiteralCaseContext(this, localctx);
            this.enterOuterAlt(localctx, 5);
            this.state = 97;
            this.match(QLParser.MONEY_LITERAL);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};

function TypeContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = QLParser.RULE_type;
    return this;
}

TypeContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
TypeContext.prototype.constructor = TypeContext;

TypeContext.prototype.TYPE_BOOLEAN = function() {
    return this.getToken(QLParser.TYPE_BOOLEAN, 0);
};

TypeContext.prototype.TYPE_STRING = function() {
    return this.getToken(QLParser.TYPE_STRING, 0);
};

TypeContext.prototype.TYPE_INTEGER = function() {
    return this.getToken(QLParser.TYPE_INTEGER, 0);
};

TypeContext.prototype.TYPE_FLOAT = function() {
    return this.getToken(QLParser.TYPE_FLOAT, 0);
};

TypeContext.prototype.TYPE_MONEY = function() {
    return this.getToken(QLParser.TYPE_MONEY, 0);
};

TypeContext.prototype.enterRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.enterType(this);
	}
};

TypeContext.prototype.exitRule = function(listener) {
    if(listener instanceof QLListener ) {
        listener.exitType(this);
	}
};

TypeContext.prototype.accept = function(visitor) {
    if ( visitor instanceof QLVisitor ) {
        return visitor.visitType(this);
    } else {
        return visitor.visitChildren(this);
    }
};




QLParser.TypeContext = TypeContext;

QLParser.prototype.type = function() {

    var localctx = new TypeContext(this, this._ctx, this.state);
    this.enterRule(localctx, 14, QLParser.RULE_type);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 100;
        _la = this._input.LA(1);
        if(!((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << QLParser.TYPE_BOOLEAN) | (1 << QLParser.TYPE_STRING) | (1 << QLParser.TYPE_INTEGER) | (1 << QLParser.TYPE_FLOAT) | (1 << QLParser.TYPE_MONEY))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
            this.consume();
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


QLParser.prototype.sempred = function(localctx, ruleIndex, predIndex) {
	switch(ruleIndex) {
	case 5:
			return this.expr_sempred(localctx, predIndex);
    default:
        throw "No predicate with index:" + ruleIndex;
   }
};

QLParser.prototype.expr_sempred = function(localctx, predIndex) {
	switch(predIndex) {
		case 0:
			return this.precpred(this._ctx, 5);
		case 1:
			return this.precpred(this._ctx, 4);
		case 2:
			return this.precpred(this._ctx, 3);
		case 3:
			return this.precpred(this._ctx, 2);
		case 4:
			return this.precpred(this._ctx, 1);
		default:
			throw "No predicate with index:" + predIndex;
	}
};


exports.QLParser = QLParser;
