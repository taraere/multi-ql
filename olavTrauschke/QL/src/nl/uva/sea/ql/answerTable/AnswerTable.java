package nl.uva.sea.ql.answerTable;

import java.util.HashMap;
import java.util.Map;
import nl.uva.sea.ql.ast.expr.Ident;

/**
 * Class for representing symbol tables for QL. A <code>AnswerTable</code> maps
 * <code>Ident</code>s to <code>Value</code>s.
 * 
 * @author Olav Trauschke
 * @version 10-mar-2016
 */
public class AnswerTable {
    
    private final Map<Ident,Value> answerTable;
    
    /**
     * Constructor for objects of this class.
     * 
     * @param identifiers an <code>Iterable</code> over the <code>Ident</code>s
     *                      the constructed <code>AnswerTable</code> should map
     */
    public AnswerTable(Iterable<Ident> identifiers) {
        answerTable = new HashMap<>();
        for (Ident identifier : identifiers) {
            answerTable.put(identifier, null);
        }
    }
    
    /**
     * Update the <code>Value</code> for a given <code>Ident</code> in
     * <code>this AnswerTable</code>.
     * 
     * @param identifier the <code>Ident</code> to update the <code>Value</code>
     *                      of, that must be in <code>this AnswerTable</code>
     * @param newValue the new <code>Value this AnswerTable</code> should map
     *                  <code>identifier</code> to
     */
    public void update(Ident identifier, Value newValue) {
        assert answerTable.containsKey(identifier);
        answerTable.put(identifier, newValue);
    }
    
    /**
     * Get the <code>Value this AnswerTable</code> maps a given
     * <code>Ident</code> to.
     * 
     * @param identifier the <code>Ident</code> to get the <code>Value</code> of
     * @return the <code>Value this AnswerTable</code> maps <code>identifier</code>
     *          to
     */
    public Value get(Ident identifier) {
        return answerTable.get(identifier);
    }
    
}