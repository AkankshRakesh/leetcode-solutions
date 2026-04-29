class Solution {
public:
    Node* inorder(Node* node, Node* parent) {
        if (node == nullptr) return nullptr;

        Node* leftTree = inorder(node->left, node);
        node->next = parent;
        if (node->right != nullptr) {
            node->next = inorder(node->right, parent);
        }

        return leftTree == nullptr ? node : leftTree;
    }

    void populateNext(Node* root) {
        inorder(root, nullptr);
    }
};

