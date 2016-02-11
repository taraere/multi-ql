grammar QL;

@parser::header
{
import java.util.Map;
import java.util.HashMap;
import org.uva.ql.ast.*;
import org.uva.ql.ast.literal.*;
import org.uva.ql.ast.expr.*;
import org.uva.ql.ast.stat.*;
import org.uva.ql.ast.form.*;
}

file :  questionnaire EOF
     ;
     
questionnaire returns [Questionnaire result]
    : forms { $result = new Questionnaire($forms.result); }
    ;
    
forms returns [List<Form> result]
    @init{
        $result = new ArrayList<Form>();
    }
    :   (form{ $result.add($form.result); })+
    ;

form returns [Form result]
    :   'form' + ID + block { $result = new Form($ID.text, $block.result); }
    ;
    
block returns [Block result]
    @init {
        $result = new Block();
    }
    : '{' + (ifStat { $result.add($ifStat.result); } | question { $result.add($question.result); } )+ '}'
    ;
    
ifStat returns [IFStat result]
    : 'if' + '(' + orExpr + ')' + block 
    { 
        $result = new IFStat($orExpr.result, $block.result);
    }
    ;

question returns [Question result]
    : variable + STR + orExpr
    {
         $result = new ComputedQuestion($variable.result, $STR.text, $orExpr.result);
    }
    | variable + STR 
    { 
        $result = new InputQuestion($variable.result, $STR.text);
    }
    ;
    
variable returns [VariableDecl result]
    :  variableType + identifier 
    { 
        $result = new VariableDecl($variableType.result, $identifier.result);
    }
    ;
    
variableType returns [VariableType result]
    : t=( BOOLEAN | STRING | INTEGER ) 
    { 
        $result = new VariableType($t.text);
    }
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


unExpr returns [Expr result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  z=primary    { $result = $z.result; }
    ;    
    
primary returns [Expr result]
    : literal        { $result = new LiteralExpr($literal.result); }
    | identifier     { $result = new VariableExpr($identifier.result); }
    | '(' orExpr ')' { $result = $orExpr.result; }
    ;
    
identifier returns [VariableIdentifier result]
    : ID
    {   
        $result = new VariableIdentifier($ID.text);
    }
    ;
    
literal returns [Literal result]
    : INT   { $result = new IntegerLiteral(Integer.valueOf($INT.text)); }
    | STR   { $result = new StringLiteral($STR.text); }
    | BOOL  { $result = new BooleanLiteral(Boolean.valueOf($BOOL.text)); }
    ;

orExpr returns [Expr result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, $rhs.result); } )*
    ;
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, $rhs.result); } )*
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
    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN);

COMMENT 
    :   '/*' .*? '*/' -> channel(HIDDEN);
    
LINE_COMMENT 
    :   '//' ~[\r\n]* -> channel(HIDDEN);
    
BOOLEAN :   'bool';
INTEGER :   'int';
STRING  :   'str';

BOOL :  'true' | 'false';
INT :   ('0'..'9')+;
STR :   '"' .*? '"';

ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
