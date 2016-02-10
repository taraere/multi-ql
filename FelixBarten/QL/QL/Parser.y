﻿%{   
open Microsoft.FSharp.Collections
open Statements   
%}   
  
%token <string> ID   
%token <string> STRING
%token <int> INT   
%token <float> FLOAT   
  

%token QUESTION FORM 
// ()
%token OPEN_BRACKET CLOSE_BRACKET
// []
%token OPEN_SQBRACKET CLOSE_SQBRACKET
// {}
%token OPEN_BRACE CLOSE_BRACE
// :
%token COLON
%token IF 
%token AND OR BITWISEAND BITWISEOR

//refactor this out later
%token MONEY INTEGER STRINGTYPE
%token DOUBLE_QUOTE

%token COMMA   
%token EQ LT LE GT GE   
%token EOF   
%token EMPTY
  
// start   
%start start   

%type <Statements.Question> start   

%%   
  
start: 
	| question { $1 }

question: 
    STRING ID COLON ID	  { 
                            { QuestionText = $1;
                              Identifier = $2;
                              QuestionType = $4 }
                      }

value:   
    | INT                   { Int($1) }   
    | FLOAT                 { Float($1) }   
	| STRING			    { String($1) }
    | ID                    { String($1) }



%%