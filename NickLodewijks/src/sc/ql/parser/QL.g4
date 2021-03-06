grammar QL;

@parser::header
{
import java.util.Map;
import java.util.HashMap;
import sc.ql.ast.*;
import static sc.ql.ast.Expression.*;
import static sc.ql.ast.Literal.*;
import static sc.ql.ast.Statement.*;
import static sc.ql.ast.ValueType.*;
}

@parser::members {
    private <T extends ASTNode> T addSource(ParserRuleContext context, T node){
        node.setSourceInfo(new SourceLocation(context));
        return (T) node;
    }
    
    private String unQuote(String text){
        return text.substring(1, text.length()-1);
    }
}

form returns [Form result]
    :   'form' + ID + block { $result = addSource($ctx, new Form($ID.text, $block.result)); }
    ;
    
statement returns [Statement result]
    : ifStat    { $result=$ifStat.result; }
    | question  { $result=$question.result; } 
    | block     { $result=$block.result; }
    ;
    
block returns [Block result]
    locals [
      List<Statement> statements = new ArrayList<>();
    ]
    @after{
        $result = addSource($ctx, new Block($ctx.statements));
    }
    : '{' + (statement { $ctx.statements.add($statement.result); })+ '}'
    
    ;
    
ifStat returns [Statement result]
    : 'if' + '(' + expr + ')' + block
    { 
        $result = addSource($ctx, new IfThen($expr.result, $block.result));
    }
    ;

question returns [Question result]
    : variableType + ID + STR + expr
    {
        $result = addSource($ctx, new ComputedQuestion($variableType.result, $ID.text,  unQuote($STR.text), $expr.result));
    }
    | variableType + ID + STR 
    { 
        $result = addSource($ctx, new NormalQuestion($variableType.result, $ID.text, unQuote($STR.text)));
    }
    ;
    
variableType returns [ValueType result]
    : BOOLEAN   { $result = addSource($ctx, new BooleanType()); }
    | STRING    { $result = addSource($ctx, new StringType());  }
    | INTEGER   { $result = addSource($ctx, new IntegerType()); }
    ;
    
expr returns [Expression result]
    : op=('+' | '-') exp=expr
    { 
      if ($op.text.equals("+")) {
        $result = addSource($ctx, new Positive($exp.result));
      }
      if ($op.text.equals("-")) {
        $result = addSource($ctx, new Negative($exp.result));
      }
    }
    | lhs=expr op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=expr 
    { 
      if ($op.text.equals("<")) {
        $result = addSource($ctx, new LessThan($lhs.result, $rhs.result));
      }
      if ($op.text.equals("<=")) {
        $result = addSource($ctx, new LessThanOrEqual($lhs.result, $rhs.result));      
      }
      if ($op.text.equals(">")) {
        $result = addSource($ctx, new GreaterThan($lhs.result, $rhs.result));
      }
      if ($op.text.equals(">=")) {
        $result = addSource($ctx, new GreaterThanOrEqual($lhs.result, $rhs.result));      
      }
      if ($op.text.equals("==")) {
        $result = addSource($ctx, new Equal($lhs.result, $rhs.result));
      }
      if ($op.text.equals("!=")) {
        $result = addSource($ctx, new NotEqual($lhs.result, $rhs.result));
      }
    }
    | lhs=expr op=('*' | '/') rhs=expr
    { 
      if ($op.text.equals("*")) {
        $result = addSource($ctx, new Multiply($lhs.result, $rhs.result));
      }
      if ($op.text.equals("/")) {
        $result = addSource($ctx, new Divide($lhs.result, $rhs.result));      
      }
    }
    | lhs=expr op=('+' | '-') rhs=expr
    { 
      if ($op.text.equals("+")) {
        $result = addSource($ctx, new Add($lhs.result, $rhs.result));
      }
      if ($op.text.equals("-")) {
        $result = addSource($ctx, new Subtract($lhs.result, $rhs.result));      
      }
    }
    | lhs=expr '&&' rhs=expr 
    { 
        $result = addSource($ctx, new And($lhs.result, $rhs.result));
    }
    | lhs=expr '||' rhs=expr 
    { 
        $result = addSource($ctx, new Or($lhs.result, $rhs.result));
    }
    | '!' exp=expr       { $result = addSource($ctx, new Not($exp.result)); }
    | '(' lhs=expr ')'   { $result = $lhs.result; }
    | literal            { $result = new LiteralExpr($literal.result); }
    | ID                 { $result = addSource($ctx, new VariableExpr($ID.text)); }
    ;
    
literal returns [Literal result]
    : INT   { $result = addSource($ctx, new IntegerLiteral(Integer.valueOf($INT.text))); }
    | STR   { $result = addSource($ctx, new StringLiteral(unQuote($STR.text))); }
    | BOOL  { $result = addSource($ctx, new BooleanLiteral(Boolean.valueOf($BOOL.text))); }
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
INT  :   ('0'..'9')+;
STR  :   '"' .*? '"';

ID   :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

