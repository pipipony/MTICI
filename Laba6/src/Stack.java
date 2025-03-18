public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new StackOverflowError("Стек переполнен, невозможно добавить ещё одно значение");
        }
        data[size] = element;
        size = size + 1;
    }

    public T pop() {
        if (size == 0) {
            throw new CustomEmptyStackException("Стек пуст. Невозможно выполнить операцию.");
        }
        size = size - 1;
        T top = data[size];
//        data[size] = null;
        return top;
    }

    public T peek() {
        if (size == 0) {
            throw new CustomEmptyStackException("Стек пуст. Невозможно выполнить операцию.");
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printStack() {
        if (size == 0) {
            System.out.println("Стек пуст.");
            return;
        }
        System.out.println("Элементы в стеке:");
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }
}