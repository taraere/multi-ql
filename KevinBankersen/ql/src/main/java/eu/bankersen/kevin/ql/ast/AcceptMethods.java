package eu.bankersen.kevin.ql.ast;

import eu.bankersen.kevin.ql.context.Context;
import eu.bankersen.kevin.ql.context.SymbolTableBuilder;

public interface AcceptMethods {
    
    Context checkType(Context context);
}
