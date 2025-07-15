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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> arr;
        if (root == nullptr) return arr;

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            int size = q.size();
            vector<int> temp;

            while (size--) {
                TreeNode* top = q.front(); q.pop();
                temp.push_back(top->val);
                if (top->left) q.push(top->left);
                if (top->right) q.push(top->right);
            }

            arr.push_back(temp);
        }

        reverse(arr.begin(), arr.end());
        return arr;
    }
};
