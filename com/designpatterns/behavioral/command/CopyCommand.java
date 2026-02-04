package com.designpatterns.behavioral.command;

public class CopyCommand extends Command {
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        backup();
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }

}
