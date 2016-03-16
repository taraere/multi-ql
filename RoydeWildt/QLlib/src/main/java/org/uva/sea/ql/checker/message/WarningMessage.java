package org.uva.sea.ql.checker.message;

import org.uva.sea.ql.ast.tree.Node;

/**
 * Created by roydewildt on 12/02/16.
 */
public class WarningMessage extends Message {

    public WarningMessage(String msgStr, Node msgNode) {
        super(msgStr, msgNode);
    }

    @Override
    public Type getType() {
        return Type.ERROR;
    }


}