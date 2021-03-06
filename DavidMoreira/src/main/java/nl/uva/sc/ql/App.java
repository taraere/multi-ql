package nl.uva.sc.ql;

import java.io.IOException;

import nl.uva.sc.ql.compiler.QLCompiler;
import nl.uva.sc.ql.compiler.parser.ast.Node;
import nl.uva.sc.ql.gui.QLGui;
import nl.uva.sc.ql.messages.MessagesHandler;
import nl.uva.sc.ql.messages.exceptions.CompilerException;

public class App {
	
	public static void main(String[] args) throws IOException {
        MessagesHandler messagesHandler = new MessagesHandler();
		QLCompiler compiler = new QLCompiler(messagesHandler);
		
        try {
        	Node ast = compiler.compile("/example.ql");
        	
            QLGui gui = new QLGui(ast);
            gui.start();

        } catch (CompilerException ce) {
        	System.err.println(ce.getMessage());
        }
        
        if(messagesHandler.asWarning()){
        	System.err.println(messagesHandler.toString());
        }        
	}
}
