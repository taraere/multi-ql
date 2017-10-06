parser grammar Ql2Parser;

options {
	tokenVocab = Ql2Lexer;
}

@header {
	package ql2.parser.generated;

	import java.util.ArrayList;

	import ql2.ast.*;
	import ql2.ast.expression.*;
	import ql2.ast.expression.arithmatic.*;
	import ql2.ast.statement.*;
	import ql2.ast.literal.*;
	import ql2.ast.type.*;
}

questionnaire returns [Questionnaire result]
	:   forms { $result = new Questionnaire($forms.result); }
		EOF
	;

forms returns [List<Form> result]
	locals [ List<Form> formsList = new ArrayList<Form>(); ]
	@after { $result = $ctx.formsList; }
	:   (form{ $ctx.formsList.add($form.result); })*
	;

form returns [Form result]
	: FORM formname block { $result = new Form($formname.result, $block.result); }
	;

formname returns [String result]
	: ID { $result = $ID.text; }
	;

block returns [Block result]
	locals [
				List<Statement> statementsList = new ArrayList<Statement>();
	 		 	List<Question> questionsList = new ArrayList<Question>();
	 	   ]
	@after { $result = new Block($ctx.statementsList, $ctx.questionsList); }
	:
	LBRACE
	(question { $ctx.questionsList.add($question.result); }
	|statementz {$ctx.statementsList.add($statementz.result); })*?
	RBRACE
	;
/*
questions returns [List<Question> result]
	locals [ List<Question> questionsList = new ArrayList<Question>(); ]
	@after { $result = $ctx.questionsList; }
	: question+ { $ctx.questionsList.add($question.result); }
	;
*/

statements returns [List<Statement> result]
	locals [	 List<Statement> statementsList = new ArrayList<Statement>(); ]
	@after { $result = $ctx.statementsList; }
	: ifstatement { $ctx.statementsList.add($ifstatement.result); }
	| ifelsestatement { $ctx.statementsList.add($ifelsestatement.result); }
	| whilestatement { $ctx.statementsList.add($whilestatement.result); }
	;

statementz returns [Statement result] // name wrong
	:  ifstatement { $result = ($ifstatement.result); }
	| ifelsestatement { $result = ($ifelsestatement.result); }
	| whilestatement { $result = ($whilestatement.result); }
	;

question returns [Question result]
	:	inputquestion { $result = $inputquestion.result; }
	| 	calculatedquestion { $result = $calculatedquestion.result; }
	;

inputquestion returns [InputQuestion result]
	: qtext=questiontext qname=questionname COLON qtype=questiontype
	{ $result = new InputQuestion($qname.result, $qtext.result, $qtype.result); }
	;

calculatedquestion returns [CalculatedQuestion result]
	: qtext=questiontext qname=questionname COLON qtype=questiontype EQUALS conditions
	{ $result = new CalculatedQuestion($qtext.result, $qname.result, $qtype.result, $conditions.result); }
	;

questiontext returns [String result]
	: x=STRING_DQUOTE { $result = $x.text; }
	;

questionname returns [String result]
	: ID { $result = $ID.text; }
	;

questiontype returns [QuestionType result]
	: BOOLEAN { $result = new BooleanType(); }
	| INT	  { $result = new IntegerType(); }
	| DOUBLE { $result = new DoubleType(); }
	| FLOAT { $result = new FloatType(); }
	| MONEY { $result = new CurrencyType(); }
	| STRING { $result = new StringType(); }
	| LONG  { $result = new LongType(); }
	;

ifstatement returns [IfStatement result]
	: IF conditions block { $result = new IfStatement($conditions.result, $block.result);}
	;

ifelsestatement returns [IfElseStatement result]
	: x=ifstatement ELSE block { $result = new IfElseStatement($x.result, $block.result);}
	;

ifelseifstatement returns [IfElseIfStatement result]
	: x=ifstatement ELSE IF block { $result = new IfElseIfStatement($x.result, $block.result); }
	;

whilestatement returns [WhileStatement result]
	: WHILE conditions THEN block END { $result = new WhileStatement($conditions.result, $block.result); }
	;

conditions returns [Expr result]
	: LPAREN x=condition RPAREN {$result = $x.result; }
	;

condition returns [Expr result]
	: x=expr { $result = $x.result; }
	;
/*
statement returns [Statement result]
	: conditions { $result = $conditions.result; }
	| expr 		 { $result = $expr.result; }
	;
*/

expr returns [Expr result]
	: b=binaryexpr  { $result = $b.result; } // binary expr??????????
	| u=unaryexpr { $result = new UnaryExpr($u.result); } //unaryexpR
	;

binaryexpr returns [Expr result]
	: addExpr {$result = $addExpr.result; }
	/*
	| expr LOR expr
	| expr GT expr
	| expr LT  expr
	| expr EQ expr
	| expr GT expr
	| expr GTE expr
	| expr NEQ expr
	*/
	| unaryexpr {$result = $unaryexpr.result; } // ???
	;

arithmaticexpr returns [Expr result]
	: expr PLUS expr
	| expr MINUS expr
	| expr MUL expr
	| expr DIV expr
	;

addExpr returns [Expr result]
	: lhs=unaryexpr PLUS rhs=unaryexpr {$result = new AddExpr($lhs.result, $rhs.result); }
	;

/*
and : expr LAND expr	;
or  : expr LOR expr	;

eq  : expr EQ expr	;
neq : expr NEQ expr	;

ge  : expr GT expr	;
lt  : expr LT  expr	;
lte : expr GT expr	;
gte : expr GTE expr	;

*/


unaryexpr returns [Expr result]
	: notexpr
	| negexpr
	| posexpr
	| value {$result = new LiteralExpr($value.result); }
	;

posexpr returns [Expr result]
	: PLUS expr {$result = new PosExpr($expr.result); }
	;

negexpr returns [Expr result]
	: LNOT expr {$result = new NotExpr($expr.result); }
	;

notexpr returns [NegExpr result]
	: MINUS expr {$result = new NegExpr($expr.result); }
	;

value returns [Literal result]
	: ID { $result = new StringLiteral($ID.text); }
	| z=intliteral {$result = new IntegerLiteral(Integer.parseInt($z.text)); }
	| x=booleanliteral {$result = new BooleanLiteral(Boolean.valueOf($x.text)); }
	; // more logic for other literals.

name returns [String result]
	: ID
	;

booleanliteral returns [Boolean result]
	: TRUE {$result = true; }
	| FALSE {$result = false; }
	;

intliteral
	: (INT)+
	;