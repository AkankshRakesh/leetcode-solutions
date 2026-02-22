class Solution {
public:
    int pickOrNot(TreeNode* node, unordered_map<TreeNode*, int>& hm) {
        if (node == nullptr) return 0;
        if (hm.find(node) != hm.end()) return hm[node];

        int nodeleftleft = 0, nodeleftright = 0, noderightleft = 0, noderightright = 0;
        if (node->left != nullptr) {
            nodeleftleft = pickOrNot(node->left->left, hm);
            nodeleftright = pickOrNot(node->left->right, hm);
        }
        if (node->right != nullptr) {
            noderightleft = pickOrNot(node->right->left, hm);
            noderightright = pickOrNot(node->right->right, hm);
        }

        int val = max(node->val + nodeleftleft + nodeleftright + noderightleft + noderightright,
                           pickOrNot(node->left, hm) + pickOrNot(node->right, hm));
        hm[node] = val;
        return val;
    }

    int rob(TreeNode* root) {
        unordered_map<TreeNode*, int> hm;
        return pickOrNot(root, hm);
    }
};