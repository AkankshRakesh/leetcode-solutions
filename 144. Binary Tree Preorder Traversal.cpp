class Solution {
public:
    void trav(TreeNode* root, vector<int>& arr) {
        if (root == nullptr) return;

        arr.push_back(root->val);
        trav(root->left, arr);
        trav(root->right, arr);
    }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> arr;
        trav(root, arr);
        return arr;
    }
};
