import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditor {
    private StringBuilder currentText;
    private Deque<String> historyStack;

    public TextEditor() {
        currentText = new StringBuilder();
        // Using Deque as a stack as requested
        historyStack = new ArrayDeque<>();
    }

    public void type(String text) {
        // Save current state before modifying
        historyStack.push(currentText.toString());
        currentText.append(text);
    }
    
    public void delete(int count) {
        if (count > 0 && currentText.length() > 0) {
            historyStack.push(currentText.toString());
            int end = currentText.length();
            int start = Math.max(0, end - count);
            currentText.delete(start, end);
        }
    }

    public void undo() {
        if (!historyStack.isEmpty()) {
            currentText = new StringBuilder(historyStack.pop());
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public String getText() {
        return currentText.toString();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        System.out.println("Typing 'Hello '");
        editor.type("Hello ");
        System.out.println("Current text: '" + editor.getText() + "'\n");

        System.out.println("Typing 'World!'");
        editor.type("World!");
        System.out.println("Current text: '" + editor.getText() + "'\n");
        
        System.out.println("Deleting 1 character");
        editor.delete(1);
        System.out.println("Current text: '" + editor.getText() + "'\n");

        System.out.println("Undoing last action (delete)...");
        editor.undo();
        System.out.println("Current text: '" + editor.getText() + "'\n");

        System.out.println("Undoing last action (type 'World!')...");
        editor.undo();
        System.out.println("Current text: '" + editor.getText() + "'\n");
        
        System.out.println("Undoing last action (type 'Hello ')...");
        editor.undo();
        System.out.println("Current text: '" + editor.getText() + "'\n");
        
        System.out.println("Undoing last action (empty)...");
        editor.undo();
    }
}
