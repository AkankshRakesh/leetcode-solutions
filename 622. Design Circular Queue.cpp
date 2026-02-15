class MyCircularQueue {
    struct Node {
        int val;
        Node* next;
        Node* prev;
        Node(int val) : val(val), next(nullptr), prev(nullptr) {}
    };
    Node* head = nullptr;
    Node* tail = nullptr;
    int capacity;
    int count = 0;

public:
    MyCircularQueue(int k) : capacity(k) {}

    bool enQueue(int value) {
        if (isFull()) return false;
        Node* node = new Node(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node->next = tail;
            tail->prev = node;
            tail = node;
        }
        capacity--;
        return true;
    }

    bool deQueue() {
        if (isEmpty()) return false;
        Node* nextHead = head->prev;
        if (nextHead == nullptr) {
            delete head;
            head = nullptr;
            tail = nullptr;
        } else {
            delete head;
            head = nextHead;
            head->next = nullptr;
        }
        capacity++;
        return true;
    }

    int Front() {
        if (isEmpty()) return -1;
        return head->val;
    }

    int Rear() {
        if (isEmpty()) return -1;
        return tail->val;
    }

    bool isEmpty() {
        return head == nullptr;
    }

    bool isFull() {
        return capacity == 0;
    }
};