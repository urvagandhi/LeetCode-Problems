class MinStack {
    private Stack<Integer> first;
    private Stack<Integer> min;

    public MinStack() {
        first = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        first.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }

    public void pop() {
        if (!first.isEmpty()) {
            int removed = first.pop();
            if (!min.isEmpty() && min.peek() == removed)
                min.pop();
        }
    }

    public int top() {
        return first.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */