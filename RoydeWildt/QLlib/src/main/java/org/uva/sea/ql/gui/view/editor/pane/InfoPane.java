package org.uva.sea.ql.gui.view.editor.pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.uva.sea.ql.gui.view.editor.Position;

/**
 * Created by roy on 3/28/16.
 */
public class InfoPane extends Label{

    public InfoPane() {
        Position position = new Position(1, 0);
        this.setAlignment(Pos.TOP_LEFT);
        this.setPadding(new Insets(0,0,0,5));
        this.setText(position.toString());
    }

    public void setPosition(TextArea textArea) {
        Position pos = getLineFromOffset(textArea);
        this.setText(pos.toString());
    }

    private Position getLineFromOffset(TextArea textArea){
        String[] stringList = textArea.getText().split("\n",-1);

        int line = 1;
        int currentOffset = 0;
        int caretOffset = textArea.getCaretPosition();

        for(String str : stringList){

            if(caretOffset <= currentOffset + str.length()){
                return new Position(line, caretOffset - currentOffset);
            }

            //also count the newline
            currentOffset += str.length() + 1;
            line++;
        }

        return new Position(0,0);
    }


}
