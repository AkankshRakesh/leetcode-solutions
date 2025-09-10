class MyStack {
public:
    queue<int> q;

    MyStack() {
    }

    void shift() {
        int size = q.size() - 1;
        while (size > 0) {
            q.push(q.front());
            q.pop();
            size--;
        }
    }

    void push(int x) {
        q.push(x);
    }

    int pop() {
        shift();
        int val = q.front();
        q.pop();
        return val;
    }

    int top() {
        shift();
        int val = q.front();
        q.pop();
        q.push(val); // put it back
        return val;
    }

    bool empty() {
        return q.empty();
    }
};

/**
 * Example usage:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */
