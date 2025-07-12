class Solution {
public:
    void levelTrav(vector<vector<int>>& arr, queue<TreeNode*>& q) {
        if (q.empty()) return;

        int n = q.size();
        vector<int> curr;

        while (n--) {
            TreeNode* node = q.front();
            q.pop();
            curr.push_back(node->val);

            if (node->left) q.push(node->left);
            if (node->right) q.push(node->right);
        }

        arr.push_back(curr);
        levelTrav(arr, q); 
    }

    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> arr;
        if (!root) return arr;

        queue<TreeNode*> q;
        q.push(root);
        levelTrav(arr, q);
        return arr;
    }
};
