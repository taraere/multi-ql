// Generated from C:/Users/mwijngaard/Documents/Projects/multi-ql/Merijn/src/generated_parser\QL.g4 by ANTLR 4.5.1
// jshint ignore: start
var antlr4 = require('antlr4/index');


var serializedATN = ["\u0003\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd",
    "\u0002$\u00d8\b\u0001\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004",
    "\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t",
    "\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004",
    "\f\t\f\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010",
    "\t\u0010\u0004\u0011\t\u0011\u0004\u0012\t\u0012\u0004\u0013\t\u0013",
    "\u0004\u0014\t\u0014\u0004\u0015\t\u0015\u0004\u0016\t\u0016\u0004\u0017",
    "\t\u0017\u0004\u0018\t\u0018\u0004\u0019\t\u0019\u0004\u001a\t\u001a",
    "\u0004\u001b\t\u001b\u0004\u001c\t\u001c\u0004\u001d\t\u001d\u0004\u001e",
    "\t\u001e\u0004\u001f\t\u001f\u0004 \t \u0004!\t!\u0004\"\t\"\u0004#",
    "\t#\u0004$\t$\u0003\u0002\u0003\u0002\u0003\u0002\u0003\u0002\u0003",
    "\u0002\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0004\u0003\u0004\u0003",
    "\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0003\u0005\u0003",
    "\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0006\u0003",
    "\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003",
    "\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003",
    "\u0007\u0003\u0007\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003",
    "\t\u0003\t\u0003\t\u0003\t\u0003\t\u0003\t\u0003\n\u0003\n\u0003\u000b",
    "\u0003\u000b\u0003\f\u0003\f\u0003\r\u0003\r\u0003\u000e\u0003\u000e",
    "\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u0010\u0003\u0010\u0003\u0010",
    "\u0003\u0011\u0003\u0011\u0003\u0012\u0003\u0012\u0003\u0012\u0003\u0013",
    "\u0003\u0013\u0003\u0014\u0003\u0014\u0003\u0014\u0003\u0015\u0003\u0015",
    "\u0003\u0016\u0003\u0016\u0003\u0017\u0003\u0017\u0003\u0018\u0003\u0018",
    "\u0003\u0019\u0003\u0019\u0003\u0019\u0003\u001a\u0003\u001a\u0003\u001a",
    "\u0003\u001b\u0003\u001b\u0003\u001c\u0003\u001c\u0007\u001c\u00a6\n",
    "\u001c\f\u001c\u000e\u001c\u00a9\u000b\u001c\u0003\u001c\u0003\u001c",
    "\u0003\u001d\u0006\u001d\u00ae\n\u001d\r\u001d\u000e\u001d\u00af\u0003",
    "\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001f\u0003\u001f\u0003",
    "\u001f\u0003\u001f\u0003 \u0003 \u0003 \u0003 \u0005 \u00be\n \u0003",
    "!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0005!\u00c9",
    "\n!\u0003\"\u0006\"\u00cc\n\"\r\"\u000e\"\u00cd\u0003#\u0006#\u00d1",
    "\n#\r#\u000e#\u00d2\u0003#\u0003#\u0003$\u0003$\u0002\u0002%\u0003\u0003",
    "\u0005\u0004\u0007\u0005\t\u0006\u000b\u0007\r\b\u000f\t\u0011\n\u0013",
    "\u000b\u0015\f\u0017\r\u0019\u000e\u001b\u000f\u001d\u0010\u001f\u0011",
    "!\u0012#\u0013%\u0014\'\u0015)\u0016+\u0017-\u0018/\u00191\u001a3\u001b",
    "5\u001c7\u001d9\u001e;\u001f= ?!A\"C#E$G\u0002\u0003\u0002\u0006\u0003",
    "\u0002$$\u0005\u0002C\\aac|\u0005\u0002\u000b\f\u000f\u000f\"\"\u0003",
    "\u00022;\u00dc\u0002\u0003\u0003\u0002\u0002\u0002\u0002\u0005\u0003",
    "\u0002\u0002\u0002\u0002\u0007\u0003\u0002\u0002\u0002\u0002\t\u0003",
    "\u0002\u0002\u0002\u0002\u000b\u0003\u0002\u0002\u0002\u0002\r\u0003",
    "\u0002\u0002\u0002\u0002\u000f\u0003\u0002\u0002\u0002\u0002\u0011\u0003",
    "\u0002\u0002\u0002\u0002\u0013\u0003\u0002\u0002\u0002\u0002\u0015\u0003",
    "\u0002\u0002\u0002\u0002\u0017\u0003\u0002\u0002\u0002\u0002\u0019\u0003",
    "\u0002\u0002\u0002\u0002\u001b\u0003\u0002\u0002\u0002\u0002\u001d\u0003",
    "\u0002\u0002\u0002\u0002\u001f\u0003\u0002\u0002\u0002\u0002!\u0003",
    "\u0002\u0002\u0002\u0002#\u0003\u0002\u0002\u0002\u0002%\u0003\u0002",
    "\u0002\u0002\u0002\'\u0003\u0002\u0002\u0002\u0002)\u0003\u0002\u0002",
    "\u0002\u0002+\u0003\u0002\u0002\u0002\u0002-\u0003\u0002\u0002\u0002",
    "\u0002/\u0003\u0002\u0002\u0002\u00021\u0003\u0002\u0002\u0002\u0002",
    "3\u0003\u0002\u0002\u0002\u00025\u0003\u0002\u0002\u0002\u00027\u0003",
    "\u0002\u0002\u0002\u00029\u0003\u0002\u0002\u0002\u0002;\u0003\u0002",
    "\u0002\u0002\u0002=\u0003\u0002\u0002\u0002\u0002?\u0003\u0002\u0002",
    "\u0002\u0002A\u0003\u0002\u0002\u0002\u0002C\u0003\u0002\u0002\u0002",
    "\u0002E\u0003\u0002\u0002\u0002\u0003I\u0003\u0002\u0002\u0002\u0005",
    "N\u0003\u0002\u0002\u0002\u0007Q\u0003\u0002\u0002\u0002\tV\u0003\u0002",
    "\u0002\u0002\u000b^\u0003\u0002\u0002\u0002\re\u0003\u0002\u0002\u0002",
    "\u000fm\u0003\u0002\u0002\u0002\u0011s\u0003\u0002\u0002\u0002\u0013",
    "y\u0003\u0002\u0002\u0002\u0015{\u0003\u0002\u0002\u0002\u0017}\u0003",
    "\u0002\u0002\u0002\u0019\u007f\u0003\u0002\u0002\u0002\u001b\u0081\u0003",
    "\u0002\u0002\u0002\u001d\u0083\u0003\u0002\u0002\u0002\u001f\u0086\u0003",
    "\u0002\u0002\u0002!\u0089\u0003\u0002\u0002\u0002#\u008b\u0003\u0002",
    "\u0002\u0002%\u008e\u0003\u0002\u0002\u0002\'\u0090\u0003\u0002\u0002",
    "\u0002)\u0093\u0003\u0002\u0002\u0002+\u0095\u0003\u0002\u0002\u0002",
    "-\u0097\u0003\u0002\u0002\u0002/\u0099\u0003\u0002\u0002\u00021\u009b",
    "\u0003\u0002\u0002\u00023\u009e\u0003\u0002\u0002\u00025\u00a1\u0003",
    "\u0002\u0002\u00027\u00a3\u0003\u0002\u0002\u00029\u00ad\u0003\u0002",
    "\u0002\u0002;\u00b1\u0003\u0002\u0002\u0002=\u00b5\u0003\u0002\u0002",
    "\u0002?\u00bd\u0003\u0002\u0002\u0002A\u00c8\u0003\u0002\u0002\u0002",
    "C\u00cb\u0003\u0002\u0002\u0002E\u00d0\u0003\u0002\u0002\u0002G\u00d6",
    "\u0003\u0002\u0002\u0002IJ\u0007H\u0002\u0002JK\u0007q\u0002\u0002K",
    "L\u0007t\u0002\u0002LM\u0007o\u0002\u0002M\u0004\u0003\u0002\u0002\u0002",
    "NO\u0007k\u0002\u0002OP\u0007h\u0002\u0002P\u0006\u0003\u0002\u0002",
    "\u0002QR\u0007g\u0002\u0002RS\u0007n\u0002\u0002ST\u0007u\u0002\u0002",
    "TU\u0007g\u0002\u0002U\b\u0003\u0002\u0002\u0002VW\u0007d\u0002\u0002",
    "WX\u0007q\u0002\u0002XY\u0007q\u0002\u0002YZ\u0007n\u0002\u0002Z[\u0007",
    "g\u0002\u0002[\\\u0007c\u0002\u0002\\]\u0007p\u0002\u0002]\n\u0003\u0002",
    "\u0002\u0002^_\u0007u\u0002\u0002_`\u0007v\u0002\u0002`a\u0007t\u0002",
    "\u0002ab\u0007k\u0002\u0002bc\u0007p\u0002\u0002cd\u0007i\u0002\u0002",
    "d\f\u0003\u0002\u0002\u0002ef\u0007k\u0002\u0002fg\u0007p\u0002\u0002",
    "gh\u0007v\u0002\u0002hi\u0007g\u0002\u0002ij\u0007i\u0002\u0002jk\u0007",
    "g\u0002\u0002kl\u0007t\u0002\u0002l\u000e\u0003\u0002\u0002\u0002mn",
    "\u0007h\u0002\u0002no\u0007n\u0002\u0002op\u0007q\u0002\u0002pq\u0007",
    "c\u0002\u0002qr\u0007v\u0002\u0002r\u0010\u0003\u0002\u0002\u0002st",
    "\u0007o\u0002\u0002tu\u0007q\u0002\u0002uv\u0007p\u0002\u0002vw\u0007",
    "g\u0002\u0002wx\u0007{\u0002\u0002x\u0012\u0003\u0002\u0002\u0002yz",
    "\u0007}\u0002\u0002z\u0014\u0003\u0002\u0002\u0002{|\u0007\u007f\u0002",
    "\u0002|\u0016\u0003\u0002\u0002\u0002}~\u0007*\u0002\u0002~\u0018\u0003",
    "\u0002\u0002\u0002\u007f\u0080\u0007+\u0002\u0002\u0080\u001a\u0003",
    "\u0002\u0002\u0002\u0081\u0082\u0007=\u0002\u0002\u0082\u001c\u0003",
    "\u0002\u0002\u0002\u0083\u0084\u0007?\u0002\u0002\u0084\u0085\u0007",
    "?\u0002\u0002\u0085\u001e\u0003\u0002\u0002\u0002\u0086\u0087\u0007",
    "#\u0002\u0002\u0087\u0088\u0007?\u0002\u0002\u0088 \u0003\u0002\u0002",
    "\u0002\u0089\u008a\u0007@\u0002\u0002\u008a\"\u0003\u0002\u0002\u0002",
    "\u008b\u008c\u0007@\u0002\u0002\u008c\u008d\u0007?\u0002\u0002\u008d",
    "$\u0003\u0002\u0002\u0002\u008e\u008f\u0007>\u0002\u0002\u008f&\u0003",
    "\u0002\u0002\u0002\u0090\u0091\u0007>\u0002\u0002\u0091\u0092\u0007",
    "?\u0002\u0002\u0092(\u0003\u0002\u0002\u0002\u0093\u0094\u0007-\u0002",
    "\u0002\u0094*\u0003\u0002\u0002\u0002\u0095\u0096\u0007/\u0002\u0002",
    "\u0096,\u0003\u0002\u0002\u0002\u0097\u0098\u0007,\u0002\u0002\u0098",
    ".\u0003\u0002\u0002\u0002\u0099\u009a\u00071\u0002\u0002\u009a0\u0003",
    "\u0002\u0002\u0002\u009b\u009c\u0007(\u0002\u0002\u009c\u009d\u0007",
    "(\u0002\u0002\u009d2\u0003\u0002\u0002\u0002\u009e\u009f\u0007~\u0002",
    "\u0002\u009f\u00a0\u0007~\u0002\u0002\u00a04\u0003\u0002\u0002\u0002",
    "\u00a1\u00a2\u0007#\u0002\u0002\u00a26\u0003\u0002\u0002\u0002\u00a3",
    "\u00a7\u0007$\u0002\u0002\u00a4\u00a6\n\u0002\u0002\u0002\u00a5\u00a4",
    "\u0003\u0002\u0002\u0002\u00a6\u00a9\u0003\u0002\u0002\u0002\u00a7\u00a5",
    "\u0003\u0002\u0002\u0002\u00a7\u00a8\u0003\u0002\u0002\u0002\u00a8\u00aa",
    "\u0003\u0002\u0002\u0002\u00a9\u00a7\u0003\u0002\u0002\u0002\u00aa\u00ab",
    "\u0007$\u0002\u0002\u00ab8\u0003\u0002\u0002\u0002\u00ac\u00ae\u0005",
    "G$\u0002\u00ad\u00ac\u0003\u0002\u0002\u0002\u00ae\u00af\u0003\u0002",
    "\u0002\u0002\u00af\u00ad\u0003\u0002\u0002\u0002\u00af\u00b0\u0003\u0002",
    "\u0002\u0002\u00b0:\u0003\u0002\u0002\u0002\u00b1\u00b2\u00059\u001d",
    "\u0002\u00b2\u00b3\u00070\u0002\u0002\u00b3\u00b4\u00059\u001d\u0002",
    "\u00b4<\u0003\u0002\u0002\u0002\u00b5\u00b6\u00059\u001d\u0002\u00b6",
    "\u00b7\u0007.\u0002\u0002\u00b7\u00b8\u0005? \u0002\u00b8>\u0003\u0002",
    "\u0002\u0002\u00b9\u00ba\u0005G$\u0002\u00ba\u00bb\u0005G$\u0002\u00bb",
    "\u00be\u0003\u0002\u0002\u0002\u00bc\u00be\u0007/\u0002\u0002\u00bd",
    "\u00b9\u0003\u0002\u0002\u0002\u00bd\u00bc\u0003\u0002\u0002\u0002\u00be",
    "@\u0003\u0002\u0002\u0002\u00bf\u00c0\u0007v\u0002\u0002\u00c0\u00c1",
    "\u0007t\u0002\u0002\u00c1\u00c2\u0007w\u0002\u0002\u00c2\u00c9\u0007",
    "g\u0002\u0002\u00c3\u00c4\u0007h\u0002\u0002\u00c4\u00c5\u0007c\u0002",
    "\u0002\u00c5\u00c6\u0007n\u0002\u0002\u00c6\u00c7\u0007u\u0002\u0002",
    "\u00c7\u00c9\u0007g\u0002\u0002\u00c8\u00bf\u0003\u0002\u0002\u0002",
    "\u00c8\u00c3\u0003\u0002\u0002\u0002\u00c9B\u0003\u0002\u0002\u0002",
    "\u00ca\u00cc\t\u0003\u0002\u0002\u00cb\u00ca\u0003\u0002\u0002\u0002",
    "\u00cc\u00cd\u0003\u0002\u0002\u0002\u00cd\u00cb\u0003\u0002\u0002\u0002",
    "\u00cd\u00ce\u0003\u0002\u0002\u0002\u00ceD\u0003\u0002\u0002\u0002",
    "\u00cf\u00d1\t\u0004\u0002\u0002\u00d0\u00cf\u0003\u0002\u0002\u0002",
    "\u00d1\u00d2\u0003\u0002\u0002\u0002\u00d2\u00d0\u0003\u0002\u0002\u0002",
    "\u00d2\u00d3\u0003\u0002\u0002\u0002\u00d3\u00d4\u0003\u0002\u0002\u0002",
    "\u00d4\u00d5\b#\u0002\u0002\u00d5F\u0003\u0002\u0002\u0002\u00d6\u00d7",
    "\t\u0005\u0002\u0002\u00d7H\u0003\u0002\u0002\u0002\t\u0002\u00a7\u00af",
    "\u00bd\u00c8\u00cd\u00d2\u0003\b\u0002\u0002"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

function QLLexer(input) {
	antlr4.Lexer.call(this, input);
    this._interp = new antlr4.atn.LexerATNSimulator(this, atn, decisionsToDFA, new antlr4.PredictionContextCache());
    return this;
}

QLLexer.prototype = Object.create(antlr4.Lexer.prototype);
QLLexer.prototype.constructor = QLLexer;

QLLexer.EOF = antlr4.Token.EOF;
QLLexer.FORM = 1;
QLLexer.IF = 2;
QLLexer.ELSE = 3;
QLLexer.TYPE_BOOLEAN = 4;
QLLexer.TYPE_STRING = 5;
QLLexer.TYPE_INTEGER = 6;
QLLexer.TYPE_FLOAT = 7;
QLLexer.TYPE_MONEY = 8;
QLLexer.LEFT_BRACE = 9;
QLLexer.RIGHT_BRACE = 10;
QLLexer.LEFT_PAREN = 11;
QLLexer.RIGHT_PAREN = 12;
QLLexer.SEMICOL = 13;
QLLexer.EQ = 14;
QLLexer.NOT_EQ = 15;
QLLexer.GT = 16;
QLLexer.GT_EQ = 17;
QLLexer.LT = 18;
QLLexer.LT_EQ = 19;
QLLexer.PLUS = 20;
QLLexer.MINUS = 21;
QLLexer.MUL = 22;
QLLexer.DIV = 23;
QLLexer.AND = 24;
QLLexer.OR = 25;
QLLexer.NOT = 26;
QLLexer.STRING_LITERAL = 27;
QLLexer.INTEGER_LITERAL = 28;
QLLexer.FLOAT_LITERAL = 29;
QLLexer.MONEY_LITERAL = 30;
QLLexer.MONEY_LITERAL_CENTS = 31;
QLLexer.BOOLEAN_LITERAL = 32;
QLLexer.IDENTIFIER = 33;
QLLexer.WHITESPACE = 34;


QLLexer.modeNames = [ "DEFAULT_MODE" ];

QLLexer.literalNames = [ 'null', "'Form'", "'if'", "'else'", "'boolean'", 
                         "'string'", "'integer'", "'float'", "'money'", 
                         "'{'", "'}'", "'('", "')'", "';'", "'=='", "'!='", 
                         "'>'", "'>='", "'<'", "'<='", "'+'", "'-'", "'*'", 
                         "'/'", "'&&'", "'||'", "'!'" ];

QLLexer.symbolicNames = [ 'null', "FORM", "IF", "ELSE", "TYPE_BOOLEAN", 
                          "TYPE_STRING", "TYPE_INTEGER", "TYPE_FLOAT", "TYPE_MONEY", 
                          "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAREN", "RIGHT_PAREN", 
                          "SEMICOL", "EQ", "NOT_EQ", "GT", "GT_EQ", "LT", 
                          "LT_EQ", "PLUS", "MINUS", "MUL", "DIV", "AND", 
                          "OR", "NOT", "STRING_LITERAL", "INTEGER_LITERAL", 
                          "FLOAT_LITERAL", "MONEY_LITERAL", "MONEY_LITERAL_CENTS", 
                          "BOOLEAN_LITERAL", "IDENTIFIER", "WHITESPACE" ];

QLLexer.ruleNames = [ "FORM", "IF", "ELSE", "TYPE_BOOLEAN", "TYPE_STRING", 
                      "TYPE_INTEGER", "TYPE_FLOAT", "TYPE_MONEY", "LEFT_BRACE", 
                      "RIGHT_BRACE", "LEFT_PAREN", "RIGHT_PAREN", "SEMICOL", 
                      "EQ", "NOT_EQ", "GT", "GT_EQ", "LT", "LT_EQ", "PLUS", 
                      "MINUS", "MUL", "DIV", "AND", "OR", "NOT", "STRING_LITERAL", 
                      "INTEGER_LITERAL", "FLOAT_LITERAL", "MONEY_LITERAL", 
                      "MONEY_LITERAL_CENTS", "BOOLEAN_LITERAL", "IDENTIFIER", 
                      "WHITESPACE", "DIGIT" ];

QLLexer.grammarFileName = "QL.g4";



exports.QLLexer = QLLexer;

