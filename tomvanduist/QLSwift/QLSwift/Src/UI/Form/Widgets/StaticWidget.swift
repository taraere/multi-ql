//
//  StaticWidget.swift
//  QLSwift
//
//  Created by Tom van Duist on 24/02/16.
//
//

import UIKit

//class StaticWidget: ViewWidget {
//    let expression: QLExpression
//    let textField: UITextField
//    
//    init(layout: Layout, delegate: WidgetDelegate?, expression: QLExpression) {
//        self.expression = expression
//        
//        textField = UITextField()
//        
//        super.init(layout: layout, delegate: delegate)
//        
//        textField.borderStyle = .Line
//        textField.textColor = UIColor.lightGrayColor()
//        textField.userInteractionEnabled = false
//    }
//    
//    required init?(coder aDecoder: NSCoder) {
//        fatalError("StoryBoards are not supported!")
//    }
//    
//    override func setupView(layout: Layout) {
//        
//        if textField.superview == nil {
//            
//            updateValue()
//            
//            self.addSubview(textField)
//            textField.snp_makeConstraints { [unowned self] (make) -> Void in
//                make.top.equalTo(self.snp_top).offset(layout.margin.top)
//                make.left.equalTo(self.snp_left).offset(layout.margin.left)
//                make.right.equalTo(self.snp_right).offset(layout.margin.right)
//                make.bottom.equalTo(self.snp_bottom).offset(layout.margin.bottom)
//                make.height.equalTo(50)
//            }
//        }
//    }
//    
//    override func reloadView() {
//        super.reloadView()
//        
//        updateValue()
//    }
//    
//    private func updateValue() {
//        if expression.type === QLBooleanType.self {
//            textField.text = (expression.eval() as! Bool) ? "Yes" : "No"
//        } else if expression.type === QLMoneyType.self {
//            textField.text = "€ \((expression.eval() as! Double) / 100)"
//        } else {
//            textField.text = "\(expression.eval())"
//        }
//    }
//}