/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool trav(TreeNode* node, TreeNode* nodeInv) {
        if(node == nullptr && nodeInv == nullptr) return true;
        else if((node == nullptr && nodeInv != nullptr) || (node != nullptr && nodeInv == nullptr)) return false;

        if(node->val != nodeInv->val) return false;

        return trav(node->left, nodeInv->right) && trav(node->right, nodeInv->left);
    }

    bool isSymmetric(TreeNode* root) {
        TreeNode* node = root;
        TreeNode* nodeInv = root;
        return trav(node, nodeInv);
    }
};
