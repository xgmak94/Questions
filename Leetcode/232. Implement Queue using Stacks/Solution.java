/* https://leetcode.com/problems/implement-queue-using-stacks/description/

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

*/

public class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> reverse = new Stack<Integer>();
        while(!queue.isEmpty()) {
            reverse.push(queue.pop());
        }
        
        queue.push(x);

        while(!reverse.isEmpty()) {
            queue.push(reverse.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
