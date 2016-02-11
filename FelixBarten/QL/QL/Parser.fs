// Implementation file for parser generated by fsyacc
module Parser
#nowarn "64";; // turn off warnings that type variables used in production annotations are instantiated to concrete type
open Microsoft.FSharp.Text.Lexing
open Microsoft.FSharp.Text.Parsing.ParseHelpers
# 1 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
   
open Microsoft.FSharp.Collections
open Statements   

# 11 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
// This type is the type of tokens accepted by the parser
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
  | STRING of (string)
  | ID of (string)
// This type is used to give symbolic names to token indexes, useful for error messages
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
    | TOKEN_STRING
    | TOKEN_ID
    | TOKEN_end_of_input
    | TOKEN_error
// This type is used to give symbolic names to token indexes, useful for error messages
type nonTerminalId = 
    | NONTERM__startstart
    | NONTERM_start
    | NONTERM_question
    | NONTERM_value

// This function maps tokens to integer indexes
let tagOfToken (t:token) = 
  match t with
  | EMPTY  -> 0 
  | EOF  -> 1 
  | EQ  -> 2 
  | LT  -> 3 
  | LE  -> 4 
  | GT  -> 5 
  | GE  -> 6 
  | COMMA  -> 7 
  | DOUBLE_QUOTE  -> 8 
  | MONEY  -> 9 
  | INTEGER  -> 10 
  | STRINGTYPE  -> 11 
  | AND  -> 12 
  | OR  -> 13 
  | BITWISEAND  -> 14 
  | BITWISEOR  -> 15 
  | IF  -> 16 
  | COLON  -> 17 
  | OPEN_BRACE  -> 18 
  | CLOSE_BRACE  -> 19 
  | OPEN_SQBRACKET  -> 20 
  | CLOSE_SQBRACKET  -> 21 
  | OPEN_BRACKET  -> 22 
  | CLOSE_BRACKET  -> 23 
  | QUESTION  -> 24 
  | FORM  -> 25 
  | FLOAT _ -> 26 
  | INT _ -> 27 
  | STRING _ -> 28 
  | ID _ -> 29 

// This function maps integer indexes to symbolic token ids
let tokenTagToTokenId (tokenIdx:int) = 
  match tokenIdx with
  | 0 -> TOKEN_EMPTY 
  | 1 -> TOKEN_EOF 
  | 2 -> TOKEN_EQ 
  | 3 -> TOKEN_LT 
  | 4 -> TOKEN_LE 
  | 5 -> TOKEN_GT 
  | 6 -> TOKEN_GE 
  | 7 -> TOKEN_COMMA 
  | 8 -> TOKEN_DOUBLE_QUOTE 
  | 9 -> TOKEN_MONEY 
  | 10 -> TOKEN_INTEGER 
  | 11 -> TOKEN_STRINGTYPE 
  | 12 -> TOKEN_AND 
  | 13 -> TOKEN_OR 
  | 14 -> TOKEN_BITWISEAND 
  | 15 -> TOKEN_BITWISEOR 
  | 16 -> TOKEN_IF 
  | 17 -> TOKEN_COLON 
  | 18 -> TOKEN_OPEN_BRACE 
  | 19 -> TOKEN_CLOSE_BRACE 
  | 20 -> TOKEN_OPEN_SQBRACKET 
  | 21 -> TOKEN_CLOSE_SQBRACKET 
  | 22 -> TOKEN_OPEN_BRACKET 
  | 23 -> TOKEN_CLOSE_BRACKET 
  | 24 -> TOKEN_QUESTION 
  | 25 -> TOKEN_FORM 
  | 26 -> TOKEN_FLOAT 
  | 27 -> TOKEN_INT 
  | 28 -> TOKEN_STRING 
  | 29 -> TOKEN_ID 
  | 32 -> TOKEN_end_of_input
  | 30 -> TOKEN_error
  | _ -> failwith "tokenTagToTokenId: bad token"

/// This function maps production indexes returned in syntax errors to strings representing the non terminal that would be produced by that production
let prodIdxToNonTerminal (prodIdx:int) = 
  match prodIdx with
    | 0 -> NONTERM__startstart 
    | 1 -> NONTERM_start 
    | 2 -> NONTERM_question 
    | 3 -> NONTERM_value 
    | 4 -> NONTERM_value 
    | 5 -> NONTERM_value 
    | 6 -> NONTERM_value 
    | _ -> failwith "prodIdxToNonTerminal: bad production index"

let _fsyacc_endOfInputTag = 32 
let _fsyacc_tagOfErrorTerminal = 30

// This function gets the name of a token as a string
let token_to_string (t:token) = 
  match t with 
  | EMPTY  -> "EMPTY" 
  | EOF  -> "EOF" 
  | EQ  -> "EQ" 
  | LT  -> "LT" 
  | LE  -> "LE" 
  | GT  -> "GT" 
  | GE  -> "GE" 
  | COMMA  -> "COMMA" 
  | DOUBLE_QUOTE  -> "DOUBLE_QUOTE" 
  | MONEY  -> "MONEY" 
  | INTEGER  -> "INTEGER" 
  | STRINGTYPE  -> "STRINGTYPE" 
  | AND  -> "AND" 
  | OR  -> "OR" 
  | BITWISEAND  -> "BITWISEAND" 
  | BITWISEOR  -> "BITWISEOR" 
  | IF  -> "IF" 
  | COLON  -> "COLON" 
  | OPEN_BRACE  -> "OPEN_BRACE" 
  | CLOSE_BRACE  -> "CLOSE_BRACE" 
  | OPEN_SQBRACKET  -> "OPEN_SQBRACKET" 
  | CLOSE_SQBRACKET  -> "CLOSE_SQBRACKET" 
  | OPEN_BRACKET  -> "OPEN_BRACKET" 
  | CLOSE_BRACKET  -> "CLOSE_BRACKET" 
  | QUESTION  -> "QUESTION" 
  | FORM  -> "FORM" 
  | FLOAT _ -> "FLOAT" 
  | INT _ -> "INT" 
  | STRING _ -> "STRING" 
  | ID _ -> "ID" 

// This function gets the data carried by a token as an object
let _fsyacc_dataOfToken (t:token) = 
  match t with 
  | EMPTY  -> (null : System.Object) 
  | EOF  -> (null : System.Object) 
  | EQ  -> (null : System.Object) 
  | LT  -> (null : System.Object) 
  | LE  -> (null : System.Object) 
  | GT  -> (null : System.Object) 
  | GE  -> (null : System.Object) 
  | COMMA  -> (null : System.Object) 
  | DOUBLE_QUOTE  -> (null : System.Object) 
  | MONEY  -> (null : System.Object) 
  | INTEGER  -> (null : System.Object) 
  | STRINGTYPE  -> (null : System.Object) 
  | AND  -> (null : System.Object) 
  | OR  -> (null : System.Object) 
  | BITWISEAND  -> (null : System.Object) 
  | BITWISEOR  -> (null : System.Object) 
  | IF  -> (null : System.Object) 
  | COLON  -> (null : System.Object) 
  | OPEN_BRACE  -> (null : System.Object) 
  | CLOSE_BRACE  -> (null : System.Object) 
  | OPEN_SQBRACKET  -> (null : System.Object) 
  | CLOSE_SQBRACKET  -> (null : System.Object) 
  | OPEN_BRACKET  -> (null : System.Object) 
  | CLOSE_BRACKET  -> (null : System.Object) 
  | QUESTION  -> (null : System.Object) 
  | FORM  -> (null : System.Object) 
  | FLOAT _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
  | INT _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
  | STRING _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
  | ID _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
let _fsyacc_gotos = [| 0us; 65535us; 1us; 65535us; 0us; 1us; 1us; 65535us; 0us; 2us; 0us; 65535us; |]
let _fsyacc_sparseGotoTableRowOffsets = [|0us; 1us; 3us; 5us; |]
let _fsyacc_stateToProdIdxsTableElements = [| 1us; 0us; 1us; 0us; 1us; 1us; 1us; 2us; 1us; 2us; 1us; 2us; 1us; 2us; |]
let _fsyacc_stateToProdIdxsTableRowOffsets = [|0us; 2us; 4us; 6us; 8us; 10us; 12us; |]
let _fsyacc_action_rows = 7
let _fsyacc_actionTableElements = [|1us; 32768us; 28us; 3us; 0us; 49152us; 0us; 16385us; 1us; 32768us; 29us; 4us; 1us; 32768us; 17us; 5us; 1us; 32768us; 29us; 6us; 0us; 16386us; |]
let _fsyacc_actionTableRowOffsets = [|0us; 2us; 3us; 4us; 6us; 8us; 10us; |]
let _fsyacc_reductionSymbolCounts = [|1us; 1us; 4us; 1us; 1us; 1us; 1us; |]
let _fsyacc_productionToNonTerminalTable = [|0us; 1us; 2us; 3us; 3us; 3us; 3us; |]
let _fsyacc_immediateActions = [|65535us; 49152us; 16385us; 65535us; 65535us; 65535us; 16386us; |]
let _fsyacc_reductions ()  =    [| 
# 249 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : Statements.Question)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
                      raise (Microsoft.FSharp.Text.Parsing.Accept(Microsoft.FSharp.Core.Operators.box _1))
                   )
                 : '_startstart));
# 258 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'question)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 41 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                                   _1 
                   )
# 41 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                 : Statements.Question));
# 269 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            let _2 = (let data = parseState.GetInput(2) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            let _4 = (let data = parseState.GetInput(4) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 44 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                                                
                                                 { QuestionText = _1;
                                                   Identifier = _2;
                                                   QuestionType = _4 }
                                           
                   )
# 44 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                 : 'question));
# 286 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : int)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 51 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                                                   Int(_1) 
                   )
# 51 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                 : 'value));
# 297 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : float)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 52 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                                                   Float(_1) 
                   )
# 52 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                 : 'value));
# 308 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 53 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                                       String(_1) 
                   )
# 53 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                 : 'value));
# 319 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 54 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                                                   String(_1) 
                   )
# 54 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.y"
                 : 'value));
|]
# 331 "G:\Version Control\Git\multi-ql\FelixBarten\QL\QL\Parser.fs"
let tables () : Microsoft.FSharp.Text.Parsing.Tables<_> = 
  { reductions= _fsyacc_reductions ();
    endOfInputTag = _fsyacc_endOfInputTag;
    tagOfToken = tagOfToken;
    dataOfToken = _fsyacc_dataOfToken; 
    actionTableElements = _fsyacc_actionTableElements;
    actionTableRowOffsets = _fsyacc_actionTableRowOffsets;
    stateToProdIdxsTableElements = _fsyacc_stateToProdIdxsTableElements;
    stateToProdIdxsTableRowOffsets = _fsyacc_stateToProdIdxsTableRowOffsets;
    reductionSymbolCounts = _fsyacc_reductionSymbolCounts;
    immediateActions = _fsyacc_immediateActions;
    gotos = _fsyacc_gotos;
    sparseGotoTableRowOffsets = _fsyacc_sparseGotoTableRowOffsets;
    tagOfErrorTerminal = _fsyacc_tagOfErrorTerminal;
    parseError = (fun (ctxt:Microsoft.FSharp.Text.Parsing.ParseErrorContext<_>) -> 
                              match parse_error_rich with 
                              | Some f -> f ctxt
                              | None -> parse_error ctxt.Message);
    numTerminals = 33;
    productionToNonTerminalTable = _fsyacc_productionToNonTerminalTable  }
let engine lexer lexbuf startState = (tables ()).Interpret(lexer, lexbuf, startState)
let start lexer lexbuf : Statements.Question =
    Microsoft.FSharp.Core.Operators.unbox ((tables ()).Interpret(lexer, lexbuf, 0))
