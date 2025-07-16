/*
struct Node {
    int data;
    Node* left;
    Node* right;
    
    Node(int key) {
        data = key;
        left = right = nullptr;
    }
};
*/

class Solution {
public:
    // Function to check whether all nodes of a tree have the value equal to the sum of their child nodes.
    static int isSumProperty(Node* root) {
        if (root == nullptr) return 1;

        queue<Node*> q;
        q.push(root);

        while (!q.empty()) {
            Node* top = q.front(); q.pop();

            int leftVal = (top->left != nullptr) ? top->left->data : 0;
            int rightVal = (top->right != nullptr) ? top->right->data : 0;

            if (top->left || top->right) {
                if (top->data != leftVal + rightVal)
                    return 0;
            }

            if (top->left) q.push(top->left);
            if (top->right) q.push(top->right);
        }

        return 1;
    }
};
