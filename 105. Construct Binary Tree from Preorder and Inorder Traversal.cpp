class Solution {
public:
    TreeNode* build(queue<int>& preOrder, vector<int>& inorder, unordered_map<int, int>& hm, int lastInd) {
        if (preOrder.empty()) return nullptr;

        int val = preOrder.front();
        int index = hm[val];

        if (index > lastInd) return nullptr;

        preOrder.pop();
        TreeNode* curr = new TreeNode(val);
        curr->left = build(preOrder, inorder, hm, index);
        curr->right = build(preOrder, inorder, hm, lastInd);

        return curr;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> hm;
        for (int i = 0; i < (int)inorder.size(); i++) {
            hm[inorder[i]] = i;
        }

        queue<int> q;
        for (int node : preorder) q.push(node);

        return build(q, inorder, hm, inorder.size() - 1);
    }
};