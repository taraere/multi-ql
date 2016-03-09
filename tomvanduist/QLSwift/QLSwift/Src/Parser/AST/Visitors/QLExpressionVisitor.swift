//
//  QLStatementVisitor.swift
//  QLSwift
//
//  Created by Tom van Duist on 03/03/16.
//
//

import Foundation


protocol QLExpressionVisitable {
    func accept<T: QLExpressionVisitor>(visitor: T, param: T.QLExpressionVisitorParam) -> T.QLExpressionVisitorReturn
}


protocol QLExpressionVisitor {
    typealias QLExpressionVisitorParam
    typealias QLExpressionVisitorReturn
    
    func visit(node: QLVariable, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLNeg, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLAdd, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLSub, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLMul, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLDiv, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLPow, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLEq, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLNe, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLGe, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLGt, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLLe, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLLt, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLAnd, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLOr, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLNot, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
    func visit(node: QLLiteralExpression, param: QLExpressionVisitorParam) -> QLExpressionVisitorReturn
}