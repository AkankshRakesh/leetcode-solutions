class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (!root) return result;

        queue<TreeNode*> q;
        q.push(root);
        bool reverse = false;

        while (!q.empty()) {
            int size = q.size();
            vector<int> currArr;

            while (size-- > 0) {
                TreeNode* node = q.front();
                q.pop();
                currArr.push_back(node->val);

                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }

            if (reverse) std::reverse(currArr.begin(), currArr.end());
            result.push_back(currArr);
            reverse = !reverse;
        }

        return result;
    }
};
