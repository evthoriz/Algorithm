package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class ImplementStackusingQueues {

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        ms.top();
        ms.pop();
        ms.top();
        ms.pop();
        ms.empty();
    }

    static class MyStack {
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> tmp = new LinkedList<Integer>();

        // Push element x onto stack.
        public void push(int x) {
            queue.add(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            int size = queue.size();
            for (int i = 0; i<size - 1; i++) {
                tmp.add(queue.poll());
            }
            queue.poll();
            for (int i = 0; i<size - 1; i++) {
                queue.add(tmp.poll());
            }

        }

        // Get the top element.
        public int top() {
            int size = queue.size();
            for (int i = 0; i<size - 1; i++) {
                tmp.add(queue.poll());
            }
            int x = queue.peek();
            tmp.add(queue.poll());
            for (int i = 0; i<size; i++) {
                queue.add(tmp.poll());
            }
            return x;
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue.size() == 0;
        }
    }
}
