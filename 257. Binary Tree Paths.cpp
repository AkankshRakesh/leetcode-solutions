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
    void trav(TreeNode* node, vector<string>& arr, string curr) {
        if (node == nullptr) return;

        if (node->left == nullptr && node->right == nullptr) {
            arr.push_back(curr + to_string(node->val));
            return;
        }

        curr += to_string(node->val) + "->";
        if (node->left) trav(node->left, arr, curr);
        if (node->right) trav(node->right, arr, curr);
    }

    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> arr;
        trav(root, arr, "");
        return arr;
    }
};
