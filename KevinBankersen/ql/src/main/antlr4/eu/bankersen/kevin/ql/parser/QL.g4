grammar QL;

@parser::header
{
	import eu.bankersen.kevin.ql.ast.expr.*;
import eu.bankersen.kevin.ql.ast.expr.logic.*;
import eu.bankersen.kevin.ql.ast.expr.math.*;
import eu.bankersen.kevin.ql.ast.stat.*;
import eu.bankersen.kevin.ql.ast.form.*;
import eu.bankersen.kevin.ql.ast.*;
}

form returns [Form result]
	:	('Form'|'form') + ID + block + EOF { $result = new Form($ID.text, $block.result); }
	;

block returns [Block result]
	@init {
		$result = new Block();
	}
	: '{' + (ifStat[$result] | question[$result] ) + '}'
	;

question[Block result]
	
	: STR + ID + type + '=' + '(' + orExpr + ')'
	{
		$result.add(new Question(new Variable($ID.text, $type.result, $orExpr.result), $STR.text));
	}
		
	|	STR + ID + type
	
	{  
		$result.add(new Question(new Variable($ID.text, $type.result, new Identifier($ID.text)), $STR.text));
	}
	;

ifStat[Block arg]
	:	'if' + '(' + orExpr + ')' + block { $arg.add(new IFStat($orExpr.result, $block.result)); }
	;

mulExpr returns [Expr result]
	:   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
	{ 
		if ($op.text.equals("*")) {
			$result = new Mul($result, $rhs.result);
		}
		if ($op.text.equals("/")) {
			$result = new Div($result, $rhs.result);      
		}
	})*
	;


addExpr returns [Expr result]
	:   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
	{ 
		if ($op.text.equals("+")) {
			$result = new Add($result, $rhs.result);
		}
		if ($op.text.equals("-")) {
			$result = new Sub($result, $rhs.result);      
		}
	})*
	;

relExpr returns [Expr result]
	:   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
	{ 
		if ($op.text.equals("<")) {
			$result = new LT($result, $rhs.result);
		}
		if ($op.text.equals("<=")) {
			$result = new LEq($result, $rhs.result);      
		}
		if ($op.text.equals(">")) {
			$result = new GT($result, $rhs.result);
		}
		if ($op.text.equals(">=")) {
			$result = new GEq($result, $rhs.result);      
		}
		if ($op.text.equals("==")) {
			$result = new Eq($result, $rhs.result);
		}
		if ($op.text.equals("!=")) {
			$result = new NEq($result, $rhs.result);
		}
	})*
	;


unExpr returns [Expr result]
	:	'+' x=unExpr 	{ $result = new Pos($x.result); }
	|	'-' x=unExpr 	{ $result = new Neg($x.result); }
	|	'!' x=unExpr 	{ $result = new Not($x.result); }
	|	y=primary    	{ $result = $y.result; }
	;    

	
primary returns [Expr result]
	: literal 		{ $result = $literal.result; }
	| identifier 		{ $result = $identifier.result; }
	| '(' + orExpr + ')' 	{ $result = $orExpr.result; }
	;

literal returns [Expr result]
	: INT 	{ $result = new Literal(Integer.valueOf($INT.text), Type.INTEGER); } 
	| STR 	{ $result = new Literal($STR.text, Type.STRING); } 
	| BOOL 	{ $result = new Literal(Boolean.valueOf($BOOL.text), Type.BOOLEAN); }
	;
	
identifier returns [Expr result]
	: ID	{ $result = new Identifier($ID.text); }
	;
	
type returns [Type result]
	: BOOLEAN	{ $result = Type.BOOLEAN; }
	| STRING	{ $result = Type.STRING; }
	| INTEGER	{ $result = Type.INTEGER; }
	| MONEY		{ $result = Type.MONEY; }
	;

orExpr returns [Expr result]
	:   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, $rhs.result); } )*
	;

andExpr returns [Expr result]
	:   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, $rhs.result); } )*
	;
	

// Tokens
COMMENT 		:   '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT 	:   '//' ~[\r\n]* -> channel(HIDDEN);
WS  	:	(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN);

BOOLEAN :   'boolean';
INTEGER :   'integer';
STRING  :   'string';
MONEY  	:   'money';

BOOL	:	'true' | 'false';
INT		:   ('0'..'9')+;
STR 	:   '"' .*? '"';
ID		:	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;