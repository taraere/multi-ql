// Generated from C:/xampp/htdocs/Software Construction/multi-ql/GorjanJovanovski\QLGrammar.g4 by ANTLR 4.5.1
// jshint ignore: start
var antlr4 = require('antlr4/index');


var serializedATN = ["\u0003\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd",
    "\u0002!\u0118\b\u0001\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004",
    "\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t",
    "\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004",
    "\f\t\f\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010",
    "\t\u0010\u0004\u0011\t\u0011\u0004\u0012\t\u0012\u0004\u0013\t\u0013",
    "\u0004\u0014\t\u0014\u0004\u0015\t\u0015\u0004\u0016\t\u0016\u0004\u0017",
    "\t\u0017\u0004\u0018\t\u0018\u0004\u0019\t\u0019\u0004\u001a\t\u001a",
    "\u0004\u001b\t\u001b\u0004\u001c\t\u001c\u0004\u001d\t\u001d\u0004\u001e",
    "\t\u001e\u0004\u001f\t\u001f\u0004 \t \u0003\u0002\u0003\u0002\u0003",
    "\u0002\u0003\u0002\u0003\u0002\u0003\u0003\u0003\u0003\u0003\u0004\u0003",
    "\u0004\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003",
    "\u0005\u0003\u0005\u0003\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0003",
    "\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0007\u0003",
    "\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003",
    "\u0007\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003",
    "\t\u0003\t\u0003\t\u0003\t\u0003\t\u0003\t\u0003\n\u0003\n\u0003\n\u0003",
    "\n\u0003\n\u0003\n\u0003\n\u0003\n\u0003\n\u0003\u000b\u0003\u000b\u0003",
    "\u000b\u0003\u000b\u0003\u000b\u0003\f\u0003\f\u0003\r\u0003\r\u0003",
    "\r\u0003\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0003",
    "\u000f\u0003\u000f\u0003\u0010\u0003\u0010\u0003\u0011\u0003\u0011\u0003",
    "\u0012\u0003\u0012\u0003\u0013\u0003\u0013\u0003\u0013\u0003\u0013\u0005",
    "\u0013\u0094\n\u0013\u0003\u0014\u0003\u0014\u0003\u0015\u0003\u0015",
    "\u0003\u0015\u0003\u0015\u0003\u0015\u0003\u0015\u0005\u0015\u009e\n",
    "\u0015\u0003\u0016\u0003\u0016\u0003\u0016\u0003\u0016\u0005\u0016\u00a4",
    "\n\u0016\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017",
    "\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017",
    "\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017",
    "\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017",
    "\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017",
    "\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017",
    "\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017\u0003\u0017",
    "\u0003\u0017\u0003\u0017\u0003\u0017\u0005\u0017\u00d2\n\u0017\u0003",
    "\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0003",
    "\u0018\u0003\u0018\u0003\u0018\u0005\u0018\u00dd\n\u0018\u0003\u0019",
    "\u0003\u0019\u0003\u001a\u0003\u001a\u0007\u001a\u00e3\n\u001a\f\u001a",
    "\u000e\u001a\u00e6\u000b\u001a\u0003\u001b\u0006\u001b\u00e9\n\u001b",
    "\r\u001b\u000e\u001b\u00ea\u0003\u001b\u0003\u001b\u0003\u001c\u0006",
    "\u001c\u00f0\n\u001c\r\u001c\u000e\u001c\u00f1\u0003\u001d\u0006\u001d",
    "\u00f5\n\u001d\r\u001d\u000e\u001d\u00f6\u0003\u001d\u0005\u001d\u00fa",
    "\n\u001d\u0003\u001d\u0005\u001d\u00fd\n\u001d\u0003\u001d\u0007\u001d",
    "\u0100\n\u001d\f\u001d\u000e\u001d\u0103\u000b\u001d\u0003\u001e\u0006",
    "\u001e\u0106\n\u001e\r\u001e\u000e\u001e\u0107\u0003\u001e\u0003\u001e",
    "\u0003\u001f\u0003\u001f\u0003 \u0003 \u0003 \u0003 \u0007 \u0112\n",
    " \f \u000e \u0115\u000b \u0003 \u0003 \u0002\u0002!\u0003\u0003\u0005",
    "\u0004\u0007\u0005\t\u0006\u000b\u0007\r\b\u000f\t\u0011\n\u0013\u000b",
    "\u0015\f\u0017\r\u0019\u000e\u001b\u000f\u001d\u0010\u001f\u0011!\u0012",
    "#\u0013%\u0014\'\u0015)\u0016+\u0017-\u0018/\u00191\u001a3\u001b5\u001c",
    "7\u001d9\u001e;\u001f= ?!\u0003\u0002\f\u0004\u0002,,11\u0004\u0002",
    "--//\u0004\u0002C\\c|\u0005\u00022;C\\c|\u0004\u0002\f\f\u000f\u000f",
    "\u0003\u00022;\u0004\u0002\u000b\u000b\"\"\u0004\u0002}}\u007f\u007f",
    "\u0006\u0002\f\f\u000f\u000f$$^^\u0004\u0002$$^^\u012d\u0002\u0003\u0003",
    "\u0002\u0002\u0002\u0002\u0005\u0003\u0002\u0002\u0002\u0002\u0007\u0003",
    "\u0002\u0002\u0002\u0002\t\u0003\u0002\u0002\u0002\u0002\u000b\u0003",
    "\u0002\u0002\u0002\u0002\r\u0003\u0002\u0002\u0002\u0002\u000f\u0003",
    "\u0002\u0002\u0002\u0002\u0011\u0003\u0002\u0002\u0002\u0002\u0013\u0003",
    "\u0002\u0002\u0002\u0002\u0015\u0003\u0002\u0002\u0002\u0002\u0017\u0003",
    "\u0002\u0002\u0002\u0002\u0019\u0003\u0002\u0002\u0002\u0002\u001b\u0003",
    "\u0002\u0002\u0002\u0002\u001d\u0003\u0002\u0002\u0002\u0002\u001f\u0003",
    "\u0002\u0002\u0002\u0002!\u0003\u0002\u0002\u0002\u0002#\u0003\u0002",
    "\u0002\u0002\u0002%\u0003\u0002\u0002\u0002\u0002\'\u0003\u0002\u0002",
    "\u0002\u0002)\u0003\u0002\u0002\u0002\u0002+\u0003\u0002\u0002\u0002",
    "\u0002-\u0003\u0002\u0002\u0002\u0002/\u0003\u0002\u0002\u0002\u0002",
    "1\u0003\u0002\u0002\u0002\u00023\u0003\u0002\u0002\u0002\u00025\u0003",
    "\u0002\u0002\u0002\u00027\u0003\u0002\u0002\u0002\u00029\u0003\u0002",
    "\u0002\u0002\u0002;\u0003\u0002\u0002\u0002\u0002=\u0003\u0002\u0002",
    "\u0002\u0002?\u0003\u0002\u0002\u0002\u0003A\u0003\u0002\u0002\u0002",
    "\u0005F\u0003\u0002\u0002\u0002\u0007H\u0003\u0002\u0002\u0002\tJ\u0003",
    "\u0002\u0002\u0002\u000bR\u0003\u0002\u0002\u0002\rZ\u0003\u0002\u0002",
    "\u0002\u000fb\u0003\u0002\u0002\u0002\u0011i\u0003\u0002\u0002\u0002",
    "\u0013o\u0003\u0002\u0002\u0002\u0015x\u0003\u0002\u0002\u0002\u0017",
    "}\u0003\u0002\u0002\u0002\u0019\u007f\u0003\u0002\u0002\u0002\u001b",
    "\u0082\u0003\u0002\u0002\u0002\u001d\u0087\u0003\u0002\u0002\u0002\u001f",
    "\u0089\u0003\u0002\u0002\u0002!\u008b\u0003\u0002\u0002\u0002#\u008d",
    "\u0003\u0002\u0002\u0002%\u0093\u0003\u0002\u0002\u0002\'\u0095\u0003",
    "\u0002\u0002\u0002)\u009d\u0003\u0002\u0002\u0002+\u00a3\u0003\u0002",
    "\u0002\u0002-\u00d1\u0003\u0002\u0002\u0002/\u00dc\u0003\u0002\u0002",
    "\u00021\u00de\u0003\u0002\u0002\u00023\u00e0\u0003\u0002\u0002\u0002",
    "5\u00e8\u0003\u0002\u0002\u00027\u00ef\u0003\u0002\u0002\u00029\u00f4",
    "\u0003\u0002\u0002\u0002;\u0105\u0003\u0002\u0002\u0002=\u010b\u0003",
    "\u0002\u0002\u0002?\u010d\u0003\u0002\u0002\u0002AB\u0007h\u0002\u0002",
    "BC\u0007q\u0002\u0002CD\u0007t\u0002\u0002DE\u0007o\u0002\u0002E\u0004",
    "\u0003\u0002\u0002\u0002FG\u0007}\u0002\u0002G\u0006\u0003\u0002\u0002",
    "\u0002HI\u0007\u007f\u0002\u0002I\b\u0003\u0002\u0002\u0002JK\u0007",
    "f\u0002\u0002KL\u0007g\u0002\u0002LM\u0007e\u0002\u0002MN\u0007k\u0002",
    "\u0002NO\u0007o\u0002\u0002OP\u0007c\u0002\u0002PQ\u0007n\u0002\u0002",
    "Q\n\u0003\u0002\u0002\u0002RS\u0007k\u0002\u0002ST\u0007p\u0002\u0002",
    "TU\u0007v\u0002\u0002UV\u0007g\u0002\u0002VW\u0007i\u0002\u0002WX\u0007",
    "g\u0002\u0002XY\u0007t\u0002\u0002Y\f\u0003\u0002\u0002\u0002Z[\u0007",
    "d\u0002\u0002[\\\u0007q\u0002\u0002\\]\u0007q\u0002\u0002]^\u0007n\u0002",
    "\u0002^_\u0007g\u0002\u0002_`\u0007c\u0002\u0002`a\u0007p\u0002\u0002",
    "a\u000e\u0003\u0002\u0002\u0002bc\u0007u\u0002\u0002cd\u0007v\u0002",
    "\u0002de\u0007t\u0002\u0002ef\u0007k\u0002\u0002fg\u0007p\u0002\u0002",
    "gh\u0007i\u0002\u0002h\u0010\u0003\u0002\u0002\u0002ij\u0007o\u0002",
    "\u0002jk\u0007q\u0002\u0002kl\u0007p\u0002\u0002lm\u0007g\u0002\u0002",
    "mn\u0007{\u0002\u0002n\u0012\u0003\u0002\u0002\u0002op\u0007e\u0002",
    "\u0002pq\u0007w\u0002\u0002qr\u0007t\u0002\u0002rs\u0007t\u0002\u0002",
    "st\u0007g\u0002\u0002tu\u0007p\u0002\u0002uv\u0007e\u0002\u0002vw\u0007",
    "{\u0002\u0002w\u0014\u0003\u0002\u0002\u0002xy\u0007f\u0002\u0002yz",
    "\u0007c\u0002\u0002z{\u0007v\u0002\u0002{|\u0007g\u0002\u0002|\u0016",
    "\u0003\u0002\u0002\u0002}~\u0007?\u0002\u0002~\u0018\u0003\u0002\u0002",
    "\u0002\u007f\u0080\u0007k\u0002\u0002\u0080\u0081\u0007h\u0002\u0002",
    "\u0081\u001a\u0003\u0002\u0002\u0002\u0082\u0083\u0007g\u0002\u0002",
    "\u0083\u0084\u0007n\u0002\u0002\u0084\u0085\u0007u\u0002\u0002\u0085",
    "\u0086\u0007g\u0002\u0002\u0086\u001c\u0003\u0002\u0002\u0002\u0087",
    "\u0088\u0007*\u0002\u0002\u0088\u001e\u0003\u0002\u0002\u0002\u0089",
    "\u008a\u0007+\u0002\u0002\u008a \u0003\u0002\u0002\u0002\u008b\u008c",
    "\t\u0002\u0002\u0002\u008c\"\u0003\u0002\u0002\u0002\u008d\u008e\t\u0003",
    "\u0002\u0002\u008e$\u0003\u0002\u0002\u0002\u008f\u0090\u0007(\u0002",
    "\u0002\u0090\u0094\u0007(\u0002\u0002\u0091\u0092\u0007~\u0002\u0002",
    "\u0092\u0094\u0007~\u0002\u0002\u0093\u008f\u0003\u0002\u0002\u0002",
    "\u0093\u0091\u0003\u0002\u0002\u0002\u0094&\u0003\u0002\u0002\u0002",
    "\u0095\u0096\u0007#\u0002\u0002\u0096(\u0003\u0002\u0002\u0002\u0097",
    "\u009e\u0007>\u0002\u0002\u0098\u0099\u0007>\u0002\u0002\u0099\u009e",
    "\u0007?\u0002\u0002\u009a\u009e\u0007@\u0002\u0002\u009b\u009c\u0007",
    "@\u0002\u0002\u009c\u009e\u0007?\u0002\u0002\u009d\u0097\u0003\u0002",
    "\u0002\u0002\u009d\u0098\u0003\u0002\u0002\u0002\u009d\u009a\u0003\u0002",
    "\u0002\u0002\u009d\u009b\u0003\u0002\u0002\u0002\u009e*\u0003\u0002",
    "\u0002\u0002\u009f\u00a0\u0007#\u0002\u0002\u00a0\u00a4\u0007?\u0002",
    "\u0002\u00a1\u00a2\u0007?\u0002\u0002\u00a2\u00a4\u0007?\u0002\u0002",
    "\u00a3\u009f\u0003\u0002\u0002\u0002\u00a3\u00a1\u0003\u0002\u0002\u0002",
    "\u00a4,\u0003\u0002\u0002\u0002\u00a5\u00a6\u0007f\u0002\u0002\u00a6",
    "\u00a7\u0007g\u0002\u0002\u00a7\u00a8\u0007e\u0002\u0002\u00a8\u00a9",
    "\u0007k\u0002\u0002\u00a9\u00aa\u0007o\u0002\u0002\u00aa\u00ab\u0007",
    "c\u0002\u0002\u00ab\u00d2\u0007n\u0002\u0002\u00ac\u00ad\u0007k\u0002",
    "\u0002\u00ad\u00ae\u0007p\u0002\u0002\u00ae\u00af\u0007v\u0002\u0002",
    "\u00af\u00b0\u0007g\u0002\u0002\u00b0\u00b1\u0007i\u0002\u0002\u00b1",
    "\u00b2\u0007g\u0002\u0002\u00b2\u00d2\u0007t\u0002\u0002\u00b3\u00b4",
    "\u0007d\u0002\u0002\u00b4\u00b5\u0007q\u0002\u0002\u00b5\u00b6\u0007",
    "q\u0002\u0002\u00b6\u00b7\u0007n\u0002\u0002\u00b7\u00b8\u0007g\u0002",
    "\u0002\u00b8\u00b9\u0007c\u0002\u0002\u00b9\u00d2\u0007p\u0002\u0002",
    "\u00ba\u00bb\u0007u\u0002\u0002\u00bb\u00bc\u0007v\u0002\u0002\u00bc",
    "\u00bd\u0007t\u0002\u0002\u00bd\u00be\u0007k\u0002\u0002\u00be\u00bf",
    "\u0007p\u0002\u0002\u00bf\u00d2\u0007i\u0002\u0002\u00c0\u00c1\u0007",
    "o\u0002\u0002\u00c1\u00c2\u0007q\u0002\u0002\u00c2\u00c3\u0007p\u0002",
    "\u0002\u00c3\u00c4\u0007g\u0002\u0002\u00c4\u00d2\u0007{\u0002\u0002",
    "\u00c5\u00c6\u0007e\u0002\u0002\u00c6\u00c7\u0007w\u0002\u0002\u00c7",
    "\u00c8\u0007t\u0002\u0002\u00c8\u00c9\u0007t\u0002\u0002\u00c9\u00ca",
    "\u0007g\u0002\u0002\u00ca\u00cb\u0007p\u0002\u0002\u00cb\u00cc\u0007",
    "e\u0002\u0002\u00cc\u00d2\u0007{\u0002\u0002\u00cd\u00ce\u0007f\u0002",
    "\u0002\u00ce\u00cf\u0007c\u0002\u0002\u00cf\u00d0\u0007v\u0002\u0002",
    "\u00d0\u00d2\u0007g\u0002\u0002\u00d1\u00a5\u0003\u0002\u0002\u0002",
    "\u00d1\u00ac\u0003\u0002\u0002\u0002\u00d1\u00b3\u0003\u0002\u0002\u0002",
    "\u00d1\u00ba\u0003\u0002\u0002\u0002\u00d1\u00c0\u0003\u0002\u0002\u0002",
    "\u00d1\u00c5\u0003\u0002\u0002\u0002\u00d1\u00cd\u0003\u0002\u0002\u0002",
    "\u00d2.\u0003\u0002\u0002\u0002\u00d3\u00d4\u0007v\u0002\u0002\u00d4",
    "\u00d5\u0007t\u0002\u0002\u00d5\u00d6\u0007w\u0002\u0002\u00d6\u00dd",
    "\u0007g\u0002\u0002\u00d7\u00d8\u0007h\u0002\u0002\u00d8\u00d9\u0007",
    "c\u0002\u0002\u00d9\u00da\u0007n\u0002\u0002\u00da\u00db\u0007u\u0002",
    "\u0002\u00db\u00dd\u0007g\u0002\u0002\u00dc\u00d3\u0003\u0002\u0002",
    "\u0002\u00dc\u00d7\u0003\u0002\u0002\u0002\u00dd0\u0003\u0002\u0002",
    "\u0002\u00de\u00df\u0007<\u0002\u0002\u00df2\u0003\u0002\u0002\u0002",
    "\u00e0\u00e4\t\u0004\u0002\u0002\u00e1\u00e3\t\u0005\u0002\u0002\u00e2",
    "\u00e1\u0003\u0002\u0002\u0002\u00e3\u00e6\u0003\u0002\u0002\u0002\u00e4",
    "\u00e2\u0003\u0002\u0002\u0002\u00e4\u00e5\u0003\u0002\u0002\u0002\u00e5",
    "4\u0003\u0002\u0002\u0002\u00e6\u00e4\u0003\u0002\u0002\u0002\u00e7",
    "\u00e9\t\u0006\u0002\u0002\u00e8\u00e7\u0003\u0002\u0002\u0002\u00e9",
    "\u00ea\u0003\u0002\u0002\u0002\u00ea\u00e8\u0003\u0002\u0002\u0002\u00ea",
    "\u00eb\u0003\u0002\u0002\u0002\u00eb\u00ec\u0003\u0002\u0002\u0002\u00ec",
    "\u00ed\b\u001b\u0002\u0002\u00ed6\u0003\u0002\u0002\u0002\u00ee\u00f0",
    "\t\u0007\u0002\u0002\u00ef\u00ee\u0003\u0002\u0002\u0002\u00f0\u00f1",
    "\u0003\u0002\u0002\u0002\u00f1\u00ef\u0003\u0002\u0002\u0002\u00f1\u00f2",
    "\u0003\u0002\u0002\u0002\u00f28\u0003\u0002\u0002\u0002\u00f3\u00f5",
    "\t\u0007\u0002\u0002\u00f4\u00f3\u0003\u0002\u0002\u0002\u00f5\u00f6",
    "\u0003\u0002\u0002\u0002\u00f6\u00f4\u0003\u0002\u0002\u0002\u00f6\u00f7",
    "\u0003\u0002\u0002\u0002\u00f7\u00f9\u0003\u0002\u0002\u0002\u00f8\u00fa",
    "\u00070\u0002\u0002\u00f9\u00f8\u0003\u0002\u0002\u0002\u00f9\u00fa",
    "\u0003\u0002\u0002\u0002\u00fa\u00fc\u0003\u0002\u0002\u0002\u00fb\u00fd",
    "\u0007.\u0002\u0002\u00fc\u00fb\u0003\u0002\u0002\u0002\u00fc\u00fd",
    "\u0003\u0002\u0002\u0002\u00fd\u0101\u0003\u0002\u0002\u0002\u00fe\u0100",
    "\t\u0007\u0002\u0002\u00ff\u00fe\u0003\u0002\u0002\u0002\u0100\u0103",
    "\u0003\u0002\u0002\u0002\u0101\u00ff\u0003\u0002\u0002\u0002\u0101\u0102",
    "\u0003\u0002\u0002\u0002\u0102:\u0003\u0002\u0002\u0002\u0103\u0101",
    "\u0003\u0002\u0002\u0002\u0104\u0106\t\b\u0002\u0002\u0105\u0104\u0003",
    "\u0002\u0002\u0002\u0106\u0107\u0003\u0002\u0002\u0002\u0107\u0105\u0003",
    "\u0002\u0002\u0002\u0107\u0108\u0003\u0002\u0002\u0002\u0108\u0109\u0003",
    "\u0002\u0002\u0002\u0109\u010a\b\u001e\u0002\u0002\u010a<\u0003\u0002",
    "\u0002\u0002\u010b\u010c\t\t\u0002\u0002\u010c>\u0003\u0002\u0002\u0002",
    "\u010d\u0113\u0007$\u0002\u0002\u010e\u0112\n\n\u0002\u0002\u010f\u0110",
    "\u0007^\u0002\u0002\u0110\u0112\t\u000b\u0002\u0002\u0111\u010e\u0003",
    "\u0002\u0002\u0002\u0111\u010f\u0003\u0002\u0002\u0002\u0112\u0115\u0003",
    "\u0002\u0002\u0002\u0113\u0111\u0003\u0002\u0002\u0002\u0113\u0114\u0003",
    "\u0002\u0002\u0002\u0114\u0116\u0003\u0002\u0002\u0002\u0115\u0113\u0003",
    "\u0002\u0002\u0002\u0116\u0117\u0007$\u0002\u0002\u0117@\u0003\u0002",
    "\u0002\u0002\u0012\u0002\u0093\u009d\u00a3\u00d1\u00dc\u00e4\u00ea\u00f1",
    "\u00f6\u00f9\u00fc\u0101\u0107\u0111\u0113\u0003\b\u0002\u0002"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

function QLGrammarLexer(input) {
	antlr4.Lexer.call(this, input);
    this._interp = new antlr4.atn.LexerATNSimulator(this, atn, decisionsToDFA, new antlr4.PredictionContextCache());
    return this;
}

QLGrammarLexer.prototype = Object.create(antlr4.Lexer.prototype);
QLGrammarLexer.prototype.constructor = QLGrammarLexer;

QLGrammarLexer.EOF = antlr4.Token.EOF;
QLGrammarLexer.T__0 = 1;
QLGrammarLexer.T__1 = 2;
QLGrammarLexer.T__2 = 3;
QLGrammarLexer.T__3 = 4;
QLGrammarLexer.T__4 = 5;
QLGrammarLexer.T__5 = 6;
QLGrammarLexer.T__6 = 7;
QLGrammarLexer.T__7 = 8;
QLGrammarLexer.T__8 = 9;
QLGrammarLexer.T__9 = 10;
QLGrammarLexer.T__10 = 11;
QLGrammarLexer.T__11 = 12;
QLGrammarLexer.T__12 = 13;
QLGrammarLexer.T__13 = 14;
QLGrammarLexer.T__14 = 15;
QLGrammarLexer.MULTDIVOP = 16;
QLGrammarLexer.ADDSUBOP = 17;
QLGrammarLexer.BOOLOP = 18;
QLGrammarLexer.NOTOP = 19;
QLGrammarLexer.COMPOP = 20;
QLGrammarLexer.BOOLCOMOP = 21;
QLGrammarLexer.TYPE = 22;
QLGrammarLexer.BOOLEAN = 23;
QLGrammarLexer.DELIMITER = 24;
QLGrammarLexer.LABEL = 25;
QLGrammarLexer.NEWLINE = 26;
QLGrammarLexer.NUMBER = 27;
QLGrammarLexer.DECIMAL = 28;
QLGrammarLexer.WHITESPACE = 29;
QLGrammarLexer.BRACKETS = 30;
QLGrammarLexer.STRING = 31;


QLGrammarLexer.modeNames = [ "DEFAULT_MODE" ];

QLGrammarLexer.literalNames = [ 'null', "'form'", "'{'", "'}'", "'decimal'", 
                                "'integer'", "'boolean'", "'string'", "'money'", 
                                "'currency'", "'date'", "'='", "'if'", "'else'", 
                                "'('", "')'", 'null', 'null', 'null', "'!'", 
                                'null', 'null', 'null', 'null', "':'" ];

QLGrammarLexer.symbolicNames = [ 'null', 'null', 'null', 'null', 'null', 
                                 'null', 'null', 'null', 'null', 'null', 
                                 'null', 'null', 'null', 'null', 'null', 
                                 'null', "MULTDIVOP", "ADDSUBOP", "BOOLOP", 
                                 "NOTOP", "COMPOP", "BOOLCOMOP", "TYPE", 
                                 "BOOLEAN", "DELIMITER", "LABEL", "NEWLINE", 
                                 "NUMBER", "DECIMAL", "WHITESPACE", "BRACKETS", 
                                 "STRING" ];

QLGrammarLexer.ruleNames = [ "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", 
                             "T__6", "T__7", "T__8", "T__9", "T__10", "T__11", 
                             "T__12", "T__13", "T__14", "MULTDIVOP", "ADDSUBOP", 
                             "BOOLOP", "NOTOP", "COMPOP", "BOOLCOMOP", "TYPE", 
                             "BOOLEAN", "DELIMITER", "LABEL", "NEWLINE", 
                             "NUMBER", "DECIMAL", "WHITESPACE", "BRACKETS", 
                             "STRING" ];

QLGrammarLexer.grammarFileName = "QLGrammar.g4";



exports.QLGrammarLexer = QLGrammarLexer;

