class Solution {
    int index = -1;
public:
    TreeNode* buildTree(const vector<int>& preorder, unordered_map<int, int>& hm, int l, int r) {
        if (l > r) return nullptr;

        index++;
        int mid = hm[preorder[index]];
        TreeNode* node = new TreeNode(preorder[index]);

        node->left = buildTree(preorder, hm, l, mid - 1);
        node->right = buildTree(preorder, hm, mid + 1, r);

        return node;
    }

    TreeNode* bstFromPreorder(vector<int>& preorder) {
        vector<int> inorder = preorder;
        sort(inorder.begin(), inorder.end());
        unordered_map<int, int> hm;
        for (int i = 0; i < (int)inorder.size(); i++) {
            hm[inorder[i]] = i;
        }

        return buildTree(preorder, hm, 0, (int)preorder.size() - 1);
    }
};