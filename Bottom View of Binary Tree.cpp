#include <vector>
#include <map>
#include <queue>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    
    Node(int key) {
        data = key;
        left = right = nullptr;
    }
};

class Solution {
public:
    vector<int> bottomView(Node* root) {
        vector<int> arr;
        if (!root) return arr;

        map<int, int> hm;
        queue<Node*> q;
        queue<int> distQ;

        q.push(root);
        distQ.push(0);

        while (!q.empty()) {
            Node* top = q.front(); q.pop();
            int dist = distQ.front(); distQ.pop();

            hm[dist] = top->data;

            if (top->left) {
                q.push(top->left);
                distQ.push(dist - 1);
            }
            if (top->right) {
                q.push(top->right);
                distQ.push(dist + 1);
            }
        }

        for (const auto& pair : hm)
            arr.push_back(pair.second);

        return arr;
    }
};
