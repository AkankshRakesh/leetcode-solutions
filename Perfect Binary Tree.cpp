/*
struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int data) {
        this->data = data;
        left = right = nullptr;
    }
};
*/

class Solution {
public:
    int leafLevel = 0;

    bool trav(Node* root, int level) {
        if (root == nullptr) return true;

        if ((root->left == nullptr && root->right != nullptr) ||
            (root->left != nullptr && root->right == nullptr))
            return false;

        if (root->left == nullptr && root->right == nullptr && level != leafLevel)
            return false;

        return trav(root->left, level + 1) && trav(root->right, level + 1);
    }

    bool isPerfect(Node* root) {
        Node* node = root;
        int count = 0;
        while (node != nullptr) {
            count++;
            node = node->left;
        }
        leafLevel = count;
        return trav(root, 1);
    }
};
