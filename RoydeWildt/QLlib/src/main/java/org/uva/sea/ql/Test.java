package org.uva.sea.ql;

import org.uva.sea.ql.ast.checker.*;
import org.uva.sea.ql.ast.tree.form.Form;
import org.uva.sea.ql.parser.*;

/**
 * Created by roydewildt on 04/02/16.
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        Form f1 = QLRunner.ParseFromPath("src/main/resources/undefined1.ql");
        Form f2 = QLRunner.ParseFromPath("src/main/resources/duplicate1.ql");
        Form f4 = QLRunner.ParseFromPath("src/main/resources/expressions2.ql");

        Checker chk = new Checker();
        chk.undefinedChecker(f1);
        chk.duplicateChecker(f2);
        chk.invalidConditionChecker(f4);

    }
}
