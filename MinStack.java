// using only one stack
// class MinStack {
//     int min = Integer.MAX_VALUE;
//     Stack<Integer> stack = new Stack<Integer>();
//     // stack.push(min); // this is wrong, b/c we cannot push Integer.MAX_VALUE
//     public void push(int x) {
//         if (x <= min) { // need the equal sign here, b/c we pop twice whenever equal
//             /* 
//              * only push the old minimum value when the current 
//              * minimum value changes after pushing the new value x
//              */
//             stack.push(min);
//             min = x;
//         }
//         stack.push(x);
//     }

//     public void pop() {
//         /* 
//          * if pop operation could result in the changing of the current minimum value, 
//          * pop twice and change the current minimum value to the last minimum value.
//          */
//         if (stack.peek() == min) {
//             stack.pop();
//             min = stack.peek();
//             stack.pop();
//         } else {
//             stack.pop();
//         }
//         if (stack.empty()) min = Integer.MAX_VALUE;
//     }

//     public int top() {
//         return stack.peek();
//     }

//     public int getMin() {
//         return min;
//     }
// }

// using two stacks
class MinStack {
    public Stack<Integer> stack = new Stack<Integer>();
    public Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0 || minStack.peek() >= x) { // need the equal sign here, b/c we pop twice whenever equal
            minStack.push(x);
        }
    }

    public void pop() {
        if (minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}