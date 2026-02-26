/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    void buildPath(TreeNode* root, TreeNode* target, vector<TreeNode*>& path) {
        while (root->val != target->val) {
            path.push_back(root);
            if (root->val > target->val) {
                root = root->left;  
            } else {
                root = root->right;
            }
        }
    }

    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> path1, path2;
        buildPath(root, p, path1);
        buildPath(root, q, path2);
        path1.push_back(p);
        path2.push_back(q);

        int n = path1.size(), m = path2.size();
        for (int i = 1; i < n && i < m; i++) {
            if (path1[i]->val != path2[i]->val) return path1[i - 1];
        }

        return (n > m) ? path2[m - 1] : path1[n - 1];
    }
};
