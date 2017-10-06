lexer grammar Ql2Lexer;

 import Ql2Fragments;

@header {
	package ql2.parser.generated;
}

// -------------------------
// Literals
FORM 	: 'form'		;
IF 		: 'if'		;
ELSE		: 'else'		;
THEN		: 'then' 	;
WHILE	: 'while'	;
END		: 'end'		;
QUESTIONNAIRE : 'questionnaire'	;
  
// -------------------------
// Comments

COMMENTS
 	: (DocComment
 	|  BlockComment
	|  LineComment ) -> channel(HIDDEN)
	;


INT	: DecimalNumeral 	
	;

STRING_LITERAL
	: SQuoteLiteral
	;

STRING_DQUOTE
	: DQuoteLiteral
	;


// -------------------------
// Punctuation

COLON		: Colon			;
COLONCOLON	: DColon		;
COMMA		: Comma			;
SEMI		: Semi			;
LPAREN		: LParen		;
RPAREN		: RParen		;
LBRACE		: LBrace		;
RBRACE		: RBrace		;
RARROW		: RArrow		;
//ASSIGN		: Equal			;
QUESTION	: Question		;
STAR		: Star			;
PLUS_ASSIGN	: PlusAssign	;
PLUS		: Plus			;
OR			: Pipe			;
DOLLAR		: Dollar		;
RANGE		: Range			;
DOT			: Dot			;
AT			: At			;
POUND		: Pound			;
NOT			: Tilde			;
DQUOTE		: DQuote		;


// -------------------------
// expr

EQ 		: Equal		;
NEQ		: NotEqual	;
LAND		: And		; //prefixed with L for logical and/or/not
LOR		: Or			;


LT 		: Lt			;
GT		: Gt 		;
GTE		: Gte		;
LTE		: Lte		;

// arithmatic
MINUS	: Minus	;
DIV		: Slash	;
MUL		: Star	;

// unary

LNOT		: Bang 		;

EQUALS : Equal		;

// Types

BOOLEAN
	: Boolean
	| Bool
	;

MONEY
	: Money
	;
LONG
	: Long
	;

FLOAT
	: Float
	;

INTEGER 	: Int;
SHORT 	: Short;
DOUBLE 	: Double;
STRING 	: String;
// Literals
// -------------------------

TRUE : True;
FALSE : False;

// -------------------------
// Identifiers 

ID	: NameStartChar NameChar* ;

//ESCAPED_QUOTE : '\\"';
//QUOTED_STRING :   '"' ( ESCAPED_QUOTE | ~('\n'|'\r') )*? '"';

//STR :  ('"'|'\\"') (.|~[\\"])*? ('"'|'\\"');

QUOTE_HELL : '"'|('\\"')
	;



//QTEXT : '"' ( '\\"' | . )*? '"';

//QTEXT : '"' (.|~[\\"])*? '"';

//STR: ('"'|ESCAPED_QUOTE) (.|~[\\"])*? ('"'|ESCAPED_QUOTE);
QTEXTv3 : ('"'|'\\"') (.)*? ('"'|'\\"');

// -------------------------
// Whitespace

//STRING	: ESCAPED_QUOTE ( . )*? ESCAPED_QUOTE ;

WS	:	( Hws | Vws )+	-> channel(HIDDEN)	;

ERRCHAR
	:	.	-> channel(HIDDEN)
	;