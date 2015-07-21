package leetcode;

import java.util.Stack;

/**
 * Created by evtHoriz on 15/7/16.
 * Email: evthoriz@gmail.com
 */
public class ImplementQueueusingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        for (int i = 1; i < 5; i++) {
            queue.push(i);
        }

        for (int i = 1; i < 5; i++) {
            System.out.println(queue.peek());
            queue.pop();
        }
    }

    public static class MyQueue {
        // Push element x to the back of queue.

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();

        public void push(int x) {
            stack.push(x);
        }

        private void moveOut(Stack<Integer> from, Stack<Integer> to) {
            while (!from.isEmpty()) {
                int t = from.peek();
                from.pop();
                to.push(t);
            }
        }

        // Removes the element from in front of queue.
        public void pop() {
            moveOut(stack, temp);
            temp.pop();
            moveOut(temp, stack);

        }

        // Get the front element.
        public int peek() {
            moveOut(stack, temp);
            int e = temp.peek();
            moveOut(temp, stack);
            return e;
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return stack.size() == 0;
        }
    }
}
