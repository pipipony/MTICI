public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(10);

        System.out.println(stack.isEmpty());

        stack.push("lalala");
        stack.push("what");
        stack.push("help");
        System.out.println(stack.size());
        System.out.println();
        stack.printStack();
        System.out.println();

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println();
        stack.printStack();
        System.out.println();

        stack.push("cringe");
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
    }
}
