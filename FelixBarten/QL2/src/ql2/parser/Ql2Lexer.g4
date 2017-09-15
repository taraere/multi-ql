lexer grammar Ql2Lexer;

 import Ql2Fragments;

@header {
	package ql2.parser.generated;
}

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
ASSIGN		: Equal			;
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
// Literals
FORM 	: 'form'		;
IF 		: 'if'		;
ELSE		: 'else'		;
THEN		: 'then' 	;
WHILE	: 'while'	;
END		: 'end'		;

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

// unary

LNOT		: Bang 		;
MINUS 	: Minus 		;



// -------------------------
// Identifiers 

ID	: NameStartChar NameChar* ;

// -------------------------
// Whitespace

STRING : DQUOTE ( . )*? DQUOTE ;

WS	:	( Hws | Vws )+	-> channel(HIDDEN)	;

ERRCHAR
	:	.	-> channel(HIDDEN)
	;
