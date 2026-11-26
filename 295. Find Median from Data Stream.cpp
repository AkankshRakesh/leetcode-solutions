class MedianFinder {
    priority_queue<int> front;
    priority_queue<int, vector<int>, greater<int>> back;
public:
    MedianFinder() {}

    void addNum(int num) {
        if(front.empty()) front.push(num);
        else if(back.empty()) back.push(num);
        else {
            if(num > back.top()) {
                front.push(back.top());
                back.pop();
                back.push(num);
            } else {
                front.push(num);
            }

            if(front.size() - back.size() == 2) {
                back.push(front.top());
                front.pop();
            } else if(back.size() - front.size() == 2) {
                front.push(back.top());
                back.pop();
            }
        }
    }

    double findMedian() {
        if(front.size() == back.size()) {
            return (front.top() + back.top()) / 2.0;
        } else if(back.empty()) {
            return front.top();
        }
        return min(front.top(), back.top());
    }
};