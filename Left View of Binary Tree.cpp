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
    // Function to return list containing elements of left view of binary tree.
    vector<int> leftView(Node* root) {
        vector<int> arr;
        if (root == nullptr) return arr;

        queue<Node*> q;
        q.push(root);
        int size = 1;
        bool flag = false;
        arr.push_back(root->data);

        while (!q.empty()) {
            Node* top = q.front();
            q.pop();

            if (top->left) q.push(top->left);
            if (top->right) q.push(top->right);

            size--;
            if (flag) {
                arr.push_back(top->data);
                flag = false;
            }
            if (size == 0) {
                size = q.size();
                flag = true;
            }
        }

        return arr;
    }
};
