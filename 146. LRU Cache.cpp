class Node {
public:
    int val;
    int key;
    Node* next;
    Node* prev;

    Node(int val, int key) {
        this->val = val;
        this->key = key;
        next = nullptr;
        prev = nullptr;
    }
};

class LRUCache {
    unordered_map<int, Node*> hm;
    Node* head = nullptr;
    Node* tail = nullptr;
    int capacity;
    int currCap = 0;

public:
    LRUCache(int capacity) {
        this->capacity = capacity;
    }

    void markUsed(int key) {
        Node* node = hm[key];

        if (head == tail || head == node) return;
        else if (tail == node) {
            Node* next = node->next;
            next->prev = nullptr;
            tail = next;

            node->prev = head;
            head->next = node;
            head = node;
        }
        else {
            Node* prev = node->prev;
            Node* next = node->next;
            next->prev = prev;
            prev->next = next;

            node->prev = head;
            head->next = node;
            head = node;
        }
    }

    void deleteNode() {
        hm.erase(tail->key);

        if (head == tail) {
            head = nullptr;
            tail = nullptr;
        }
        else {
            Node* next = tail->next;
            next->prev = nullptr;
            tail = next;
        }
    }

    int get(int key) {
        if (hm.find(key) == hm.end()) return -1;

        Node* node = hm[key];
        markUsed(key);

        return node->val;
    }

    void put(int key, int value) {
        if (hm.find(key) != hm.end()) {
            Node* node = hm[key];
            node->val = value;
            markUsed(key);
        }
        else {
            currCap++;
            Node* node = new Node(value, key);
            hm[key] = node;

            if (head == nullptr) {
                head = node;
                tail = node;
            }
            else {
                node->prev = head;
                head->next = node;
                head = node;

                if (currCap > capacity) {
                    deleteNode();
                    currCap--;
                }
            }
        }
    }
};