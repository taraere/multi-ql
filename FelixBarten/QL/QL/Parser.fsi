// Signature file for parser generated by fsyacc
module Parser
type token = 
  | EMPTY
  | EOF
  | EQ
  | LT
  | LE
  | GT
  | GE
  | COMMA
  | DOUBLE_QUOTE
  | MONEY
  | INTEGER
  | STRINGTYPE
  | AND
  | OR
  | BITWISEAND
  | BITWISEOR
  | IF
  | COLON
  | OPEN_BRACE
  | CLOSE_BRACE
  | OPEN_SQBRACKET
  | CLOSE_SQBRACKET
  | OPEN_BRACKET
  | CLOSE_BRACKET
  | QUESTION
  | FORM
  | FLOAT of (float)
  | INT of (int)
  | QTYPE of (string)
  | STRING of (string)
  | ID of (string)
type tokenId = 
    | TOKEN_EMPTY
    | TOKEN_EOF
    | TOKEN_EQ
    | TOKEN_LT
    | TOKEN_LE
    | TOKEN_GT
    | TOKEN_GE
    | TOKEN_COMMA
    | TOKEN_DOUBLE_QUOTE
    | TOKEN_MONEY
    | TOKEN_INTEGER
    | TOKEN_STRINGTYPE
    | TOKEN_AND
    | TOKEN_OR
    | TOKEN_BITWISEAND
    | TOKEN_BITWISEOR
    | TOKEN_IF
    | TOKEN_COLON
    | TOKEN_OPEN_BRACE
    | TOKEN_CLOSE_BRACE
    | TOKEN_OPEN_SQBRACKET
    | TOKEN_CLOSE_SQBRACKET
    | TOKEN_OPEN_BRACKET
    | TOKEN_CLOSE_BRACKET
    | TOKEN_QUESTION
    | TOKEN_FORM
    | TOKEN_FLOAT
    | TOKEN_INT
    | TOKEN_QTYPE
    | TOKEN_STRING
    | TOKEN_ID
    | TOKEN_end_of_input
    | TOKEN_error
type nonTerminalId = 
    | NONTERM__startstart
    | NONTERM_quest
    | NONTERM_form
    | NONTERM_start
    | NONTERM_questions
    | NONTERM_op
    | NONTERM_questionList
    | NONTERM_question
    | NONTERM_value
/// This function maps tokens to integer indexes
val tagOfToken: token -> int

/// This function maps integer indexes to symbolic token ids
val tokenTagToTokenId: int -> tokenId

/// This function maps production indexes returned in syntax errors to strings representing the non terminal that would be produced by that production
val prodIdxToNonTerminal: int -> nonTerminalId

/// This function gets the name of a token as a string
val token_to_string: token -> string
val start : (Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> token) -> Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> (Statements.Form) 
