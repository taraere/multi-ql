// Signature file for parser generated by fsyacc
module Parser
type token = 
  | EOF
  | ASC
  | DESC
  | SELECT
  | FROM
  | WHERE
  | ORDER
  | BY
  | JOIN
  | INNER
  | LEFT
  | RIGHT
  | ON
  | EQ
  | LT
  | LE
  | GT
  | GE
  | COMMA
  | AND
  | OR
  | DOUBLEPOINT
  | ENDBRACKET
  | STARTBRACKET
  | FORM
  | FLOAT of (float)
  | INT of (int)
  | QUESTION of (string)
  | ID of (string)
type tokenId = 
    | TOKEN_EOF
    | TOKEN_ASC
    | TOKEN_DESC
    | TOKEN_SELECT
    | TOKEN_FROM
    | TOKEN_WHERE
    | TOKEN_ORDER
    | TOKEN_BY
    | TOKEN_JOIN
    | TOKEN_INNER
    | TOKEN_LEFT
    | TOKEN_RIGHT
    | TOKEN_ON
    | TOKEN_EQ
    | TOKEN_LT
    | TOKEN_LE
    | TOKEN_GT
    | TOKEN_GE
    | TOKEN_COMMA
    | TOKEN_AND
    | TOKEN_OR
    | TOKEN_DOUBLEPOINT
    | TOKEN_ENDBRACKET
    | TOKEN_STARTBRACKET
    | TOKEN_FORM
    | TOKEN_FLOAT
    | TOKEN_INT
    | TOKEN_QUESTION
    | TOKEN_ID
    | TOKEN_end_of_input
    | TOKEN_error
type nonTerminalId = 
    | NONTERM__startstart
    | NONTERM_start
    | NONTERM_questions
    | NONTERM_questionList
    | NONTERM_questionType
/// This function maps tokens to integer indexes
val tagOfToken: token -> int

/// This function maps integer indexes to symbolic token ids
val tokenTagToTokenId: int -> tokenId

/// This function maps production indexes returned in syntax errors to strings representing the non terminal that would be produced by that production
val prodIdxToNonTerminal: int -> nonTerminalId

/// This function gets the name of a token as a string
val token_to_string: token -> string
val start : (Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> token) -> Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> (Statements.Form) 
