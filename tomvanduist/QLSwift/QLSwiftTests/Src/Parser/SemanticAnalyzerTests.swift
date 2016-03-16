//
//  SemanticAnalyzerTests.swift
//  QLSwift
//
//  Created by Tom van Duist on 16/02/16.
//
//

import XCTest
@testable import QLSwift

/**
 * Unit tests for testing the sememantic analyzer of the AST.
 */
class SemanticAnalyzerTests: XCTestCase {
    
    func testValid() {
        runValidForms("TypedValidForm")
    }
    
    func testInvalid() {
        runInvalidForms("TypedInvalidForms")
    }
    
    func testCyclicDependency() {
        runInvalidForms("CyclicDependency")
    }
    
    func testScoped() {
        runInvalidForms("ScopedInvalid")
    }
    
    func testValidTypeInference() {
        runValidForms("ValidTypeInference")
    }
    
    func runValidForms(file: String) {
        if let form = parseFile(file) {
            let sa = SemanticAnalyzer()
            
            do {
                try sa.analyze(form)
            }
            catch let error {
                print("\(error)")
                XCTAssertTrue(false, "\(error)")
            }
        } else {
            XCTFail("Parse error")
        }
    }
    
    func runInvalidForms(file: String) {
        let forms = parseFileMany(file)
        
        XCTAssertNotNil(forms)
        
        
        for form in forms {
            XCTAssertNotNil(form)
            
            guard form != nil
                else { continue }
            
            
            XCTAssertNotNil(form)
            guard form != nil
                else { continue }
            
            
            let sa = SemanticAnalyzer()
            
            
            do {
                try sa.analyze(form!)
                XCTAssertTrue(false)
            }
            catch {
                // Expected behaviour, move along!
            }
        }
    }
}