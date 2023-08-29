package DS.implementations;
import DS.interfaces.Stack;

public class StackArray implements Stack{

    private Object[] stackArray;
    private int top;

    public StackArray(int length) {
        stackArray = new Object[length];
        top = -1;
    }

    public void push(Object object) {
        if (stackArray.length == size()) {
            resize();
        }
        stackArray[++top] = object;
    }

    public void resize() {
        Object[] newStackArray = new Object[stackArray.length + stackArray.length / 2];
        System.arraycopy(stackArray, 0, newStackArray, 0, stackArray.length);
        stackArray = newStackArray;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty!!!");
            return null;
        }
        var popped = stackArray[top--];
        System.out.println(popped);
        return popped;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {

        StringBuilder stringArray = new StringBuilder("[");
        for (var object : stackArray) {
            if (object != null) stringArray.append(" ").append(object);
        }
        stringArray.append(" ]");
        return stringArray.toString();
    }
}
