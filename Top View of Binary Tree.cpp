/* A binary tree node structure
struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};
*/

class Solution {
public:
    // Function to return a list of nodes visible from the top view from left to right
    static vector<int> topView(Node* root) {
        vector<int> arr;
        if (root == nullptr) return arr;

        map<int, int> hm; // map to store horizontal distance -> node value
        queue<Node*> q;
        queue<int> distQ;

        q.push(root);
        distQ.push(0);

        while (!q.empty()) {
            Node* top = q.front();
            q.pop();
            int topDist = distQ.front();
            distQ.pop();

            if (hm.find(topDist) == hm.end()) {
                hm[topDist] = top->data;
            }

            if (top->left) {
                q.push(top->left);
                distQ.push(topDist - 1);
            }

            if (top->right) {
                q.push(top->right);
                distQ.push(topDist + 1);
            }
        }

        for (auto& pair : hm) {
            arr.push_back(pair.second);
        }

        return arr;
    }
};
