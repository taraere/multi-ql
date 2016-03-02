//
//  QLParser.swift
//  ParserTest
//
//  Created by Julian Jansen on 24-02-16.
//  Copyright © 2016 Julian Jansen. All rights reserved.
//

import Foundation
import SwiftParsec

// Parsec to Swift
// <^> .map
// >>- .flatMap


class QLParser: NSObject {
    
    func parseStream(data: String) throws -> QLForm {
        return try parser().run(sourceName: "", input: data)
    }
    
    func parser() -> GenericParser<String, (), QLForm> {
        
        let ql = LanguageDefinition<()>.ql
        let lexer = GenericTokenParser(languageDefinition: ql)
        
        let symbol = lexer.symbol
        let noneOf = StringParser.noneOf
        let character = StringParser.character
        let stringLiteral = lexer.stringLiteral
        
        // Strings.
        let qlstring = lexer.identifier.map{ (str) -> QLString in
            print("String: \(str)")
            return QLString(string: str)
        }
        
        let qlstrings = qlstring.manyAccumulator{ (let current: QLString, var accumulated: [QLString]) in
            accumulated.append(current) // Doesn't return an instance of itself.
            return accumulated
        }
        
        // From the CSV example.
        let quotedChars = noneOf("\"") <|>
            StringParser.string("\"\"").attempt *>
            GenericParser(result: "\"")
        
        let quote = character("\"")
//        let quotedField = quote *> stringLiteral <* (quote <?> "quote at end of field")
//        let quotedField = quote *> quotedChars.many.stringValue.map{ question in QLQuestion(question: question) } <*
//            (quote <?> "quote at end of field")
        
        
        let quotedField = quote *> quotedChars.many.stringValue <* (quote <?> "quote at end of field")
        
//        let qlquestion = (quotedField <|> noneOf("\r\n,\n\r").many.stringValue).map{ question in QLQuestion(question: question) }
        let qlquestion = quotedField.map{ (question) -> QLQuestion in
            print("QLQuestion: \(question)")
            return QLQuestion(question: question)
        }
        
        
        
//        let quote = character("\"")
//        let quotedChars = noneOf("\"") <|> StringParser.string("\"\"").attempt *> GenericParser(result: "\"")
//        let qlquestion = quotedField <|> noneOf("\r\n,\n\r").many.stringValue
//        let qlquestion: GenericParser<String, (), QLStatement> = quotedChars.map{ question in QLQuestion(question: question) }
        
        
//        let qlquestion = quote *> qlstring <* (quote <?> "Quote at end of field")

//        let qlquestion = quote *> quotedChars.many.stringValue <* (quote <?> "Quote at end of field")
    
        let qlstatement = qlquestion
        
        let qlstatements: GenericParser<String, (), [QLStatement]> = qlstatement.manyAccumulator { (let statement, var accumulated) in
            print("Statement: \(statement.question)")
            accumulated.append(statement)
            return accumulated
        }

        
        let codeBlock = lexer.braces(qlstatements).map{ (let statements: [QLStatement]) -> QLCodeBlock in
            print("In codeBlock \(statements)")
            return QLCodeBlock(codeBlock: statements)
        }
        
//        let codeBlock = lexer.braces(qlstatements).map{ (statements) -> QLCodeBlock in
//            print("In codeBlock \(statements)")
//            return QLCodeBlock(codeBlock: statements)
//        }
        
        let form = symbol("form") *> qlstring.flatMap{ formName in
            return codeBlock.map{ (blocks) in QLForm(formName: formName, codeBlocks: blocks) }
        }
        
        return lexer.whiteSpace *> form
        
    }
    
}