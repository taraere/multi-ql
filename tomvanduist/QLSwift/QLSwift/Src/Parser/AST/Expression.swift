//
//  Expression.swift
//  QLSwift
//
//  Created by Tom van Duist on 10/02/16.
//
//

import Foundation


protocol Expression: FormNode {
    var type: FormNodeType { get }
    
    func eval() -> NSValue?
}

class Identifier: Expression {
    private let _type: TypeThunk<Identifier, NSValue> = TypeThunk(IdentifierType())
    var type: FormNodeType {
        get {
            if let expression = expression {
                return expression.type
            } else {
                return UnknownType()
            }
        }
    }
    
    let id: String
    var expression: Expression?
    
    init(id: String, expression: Expression?) {
        self.id = id
        self.expression = expression
    }
    
    func eval() -> NSValue? {
        return self._type.eval(self)
    }
}

class BooleanField: Expression {
    let type: FormNodeType = BooleanType()
    var value: NSValue?
    
    func eval() -> NSValue? {
        return value
    }
}

class StringField: Expression {
    let type: FormNodeType = StringType()
    var value: NSValue?
    
    func eval() -> NSValue? {
        return value
    }
}

class MoneyField: Expression {
    let type: FormNodeType = NumberType()
    let expression: Expression?
    
    init(expression: Expression?) {
        self.expression = expression
    }
    
    func eval() -> NSValue? {
        return expression?.eval()
    }
}

class StringLiteral: Expression {
    let type: FormNodeType = StringType()
    let string: String
    
    init(string: String) {
        self.string = string
    }
    
    func eval() -> NSValue? {
        return NSValue(pointer: string)
    }
}

class IntegerLiteral: Expression {
    let type: FormNodeType = NumberType()
    let integer: NSInteger
    
    init(integer: NSInteger) {
        self.integer = integer
    }
    
    func eval() -> NSValue? {
        return integer
    }
}

class FloatLiteral: Expression {
    let type: FormNodeType = NumberType()
    let float: Double
    
    init(float: Double) {
        self.float = float
    }
    
    func eval() -> NSValue? {
        return float
    }
}

class BooleanLiteral: Expression {
    let type: FormNodeType = BooleanType()
    let bool: Bool
    
    init (bool: Bool) {
        self.bool = bool
    }
    
    func eval() -> NSValue? {
        return bool
    }
}

class Neg: Expression {
    private var _type: FormNodeType = BooleanType()
    var type: FormNodeType { return _type }
    
    let rhs: Expression
    
    init (rhs: Expression) {
        self.rhs = rhs
    }
    
    func eval() -> NSValue? {
        return rhs.eval() == false
    }
}

class Not: Expression {
    private var _type: FormNodeType = BooleanType()
    var type: FormNodeType { return _type }
    
    let rhs: Expression
    
    init (rhs: Expression) {
        self.rhs = rhs
    }
    
    func eval() -> NSValue? {
        return rhs.eval() as! Double * -1
    }
}

class Infix {
    private var _type: FormNodeType = UnknownType()
    var type: FormNodeType { return _type }
    
    let lhs, rhs: Expression
    
    init(lhs: Expression, rhs: Expression) {
        self.lhs = lhs
        self.rhs = rhs
    }
    
    func eval() -> NSValue? {
        fatalError("Override")
    }
}

class Add: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = NumberType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Double) + (rhs.eval() as! Double)
    }
}

class Sub: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = NumberType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Double) - (rhs.eval() as! Double)
    }
}

class Mul: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = NumberType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Double) * (rhs.eval() as! Double)
    }
}

class Div: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = NumberType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Double) / (rhs.eval() as! Double)
    }
}

class Pow: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = NumberType()
    }
    
    override func eval() -> NSValue? {
        return pow((lhs.eval() as! Double), (rhs.eval() as! Double))
    }
}

class Eq: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = BooleanType()
    }
    
    override func eval() -> NSValue? {
        return lhs.eval() == rhs.eval()
    }
}

class Ne: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = BooleanType()
    }
    
    override func eval() -> NSValue? {
        return lhs.eval() != rhs.eval()
    }
}

class Ge: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = BooleanType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Double) >= (rhs.eval() as! Double)
    }
}

class Gt: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = BooleanType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Double) > (rhs.eval() as! Double)
    }
}

class Le: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = BooleanType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Double) <= (rhs.eval() as! Double)
    }
}

class Lt: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = BooleanType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Double) < (rhs.eval() as! Double)
    }
}

class And: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = BooleanType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Bool) && (rhs.eval() as! Bool)
    }
}

class Or: Infix, Expression {
    override init(lhs: Expression, rhs: Expression) {
        super.init(lhs: lhs, rhs: rhs)
        
        _type = BooleanType()
    }
    
    override func eval() -> NSValue? {
        return (lhs.eval() as! Bool) || (rhs.eval() as! Bool)
    }
}