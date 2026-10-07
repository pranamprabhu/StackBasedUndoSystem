# Report: Stack-Based Undo System

## Objective
The goal was to implement a simple text editor simulation where recent changes can be undone using a stack, reinforcing the understanding of stack-based state management.

## Implementation Details
- **Language**: Java
- **Data Structures**:
  - `StringBuilder` for maintaining the current text efficiently.
  - `java.util.Deque` (specifically `ArrayDeque`) used as a stack to store the history of text states.
- **Operations**:
  - `type(String text)`: Adds text to the current state.
  - `delete(int count)`: Removes a specified number of characters from the end.
  - `undo()`: Reverts to the previous state by popping from the stack.

## Testing
The `main` method includes test cases simulating typing, deleting, and multiple consecutive undo operations. The console output verifies that states are correctly saved before mutations and correctly restored upon undo.
