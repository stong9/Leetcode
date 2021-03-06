/**
 * Problem Statement: Min Stack 
 * Link: https://oj.leetcode.com/problems/min-stack/
 * Hardness: **
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */


class MinStack {
    
    //maintain two stack, one for all numbers, one for min value
    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    
    
    public void push(int x) {
        stack.add(x);
        //also push to minStack, if input is smaller than min value in minStack
        if(minStack.size()==0 || x<=minStack.get(minStack.size()-1)){
           minStack.add(x);
        }
    }
    
    //pop elements
    //also pop it from min stack, if current pop value is on top of min stack
    public void pop() {
        int index = stack.size()-1;
        int minIndex = minStack.size()-1;
       
        
        if(stack.size()!=0){
             //note that here you are comparing two Integers rather than two ints, thus you need to use equals() rather than "=="
             if(stack.get(index).equals(minStack.get(minIndex))){
                minStack.remove(minIndex);
            }
            stack.remove(index);
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Round 2, 11/25/2014
class MinStack {
    
    //maintain two stacks, stack for all elements, minStack or elements that could be minimum
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    //push an element to minStack only when it is not larger than current min
    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || !(x > minStack.peek()))minStack.push(x);
    }

    //pop an element from minStack if current poped out element is equal to min
    public void pop() {
        if(stack.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
         return minStack.peek();
    }
}
