class LRUCache {
    struct Node {
        int val;
        Node* left;
        Node* right;
        Node(int v) : val(v), left(nullptr), right(nullptr) {}
    };

    struct Pair {
        int value;
        int count;
        Pair(int v, int c) : value(v), count(c) {}
    };

    unordered_map<int, Pair*> hm;
    Node* head;
    Node* tail;
    int maxCap;

public:
    LRUCache(int capacity) {
        maxCap = capacity;
        head = new Node(-1);
        tail = new Node(-1);
    }
    
    int get(int key) {
        if (hm.find(key) == hm.end()) return -1;

        int val = hm[key]->value;
        hm[key]->count++;

        Node* node = new Node(key);
        node->right = head;
        head->left = node;
        head = node;

        return val;
    }
    
    void put(int key, int value) {
        if (hm.find(key) != hm.end()) {
            hm[key]->value = value;
            hm[key]->count++;
        } else {
            hm[key] = new Pair(value, 1);
        }

        Node* node = new Node(key);
        node->right = head;
        head->left = node;
        head = node;

        if (tail->val == -1) tail = head;

        while ((int)hm.size() > maxCap) {
            int tailKey = tail->val;
            if (hm[tailKey]->count == 1) {
                delete hm[tailKey];
                hm.erase(tailKey);
            } else {
                hm[tailKey]->count--;
            }

            Node* prev = tail->left;
            if (prev) prev->right = nullptr;
            tail = prev;
        }
    }
};
