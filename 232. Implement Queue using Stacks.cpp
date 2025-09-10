class MyQueue {
public:
    stack<int> inStack;
    stack<int> outStack;

    MyQueue() {
    }

    void shiftStack() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
    }

    void push(int x) {
        inStack.push(x);
    }

    int pop() {
        shiftStack();
        int val = outStack.top();
        outStack.pop();
        return val;
    }

    int peek() {
        shiftStack();
        return outStack.top();
    }

    bool empty() {
        return inStack.empty() && outStack.empty();
    }
};

/**
 * Example usage:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
