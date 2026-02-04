package com.designpatterns.behavioral.command;

/**
 * The abstract Command class declares an interface for all concrete commands.
 * It also implements the default behavior for the undo operation, which may
 * be overridden by concrete commands.
 * 
 * The editor instance acts both as the receiver and the invoker in this example, which is not a common practice.
 * In a more complex application, you might want to separate these roles.
 */
public abstract class Command {
    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}