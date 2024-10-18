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
    TreeNode* build(queue<int>& preQ, vector<int> inOrder){
        if(inOrder.empty()) return nullptr;

        int val = preQ.front();
        preQ.pop();
        auto it = find(inOrder.begin(), inOrder.end(), val);
        int idx = it - inOrder.begin();

        TreeNode* root = new TreeNode(val);

        vector<int> left(inOrder.begin(), inOrder.begin() + idx);
        vector<int> right(inOrder.begin() + idx + 1, inOrder.end());

        root -> left = build(preQ, left);
        root -> right = build(preQ, right);

        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        queue<int> preQueue(preorder.begin(), preorder.end());
        return build(preQueue, inorder);
    }
};