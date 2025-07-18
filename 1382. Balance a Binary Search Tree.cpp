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
    vector<TreeNode*> nodes;
    TreeNode* balanceBST(TreeNode* root) {
        if(root == NULL) return NULL;
        if(root -> left) balanceBST(root -> left);
        nodes.push_back(root);
        if(root -> right) balanceBST(root -> right);
        return buildBST(nodes, 0, nodes.size() - 1);
    }
    TreeNode* buildBST(vector<TreeNode*>& nodes, int left, int right){
        if(left > right) return NULL;
        int mid = left + ((right - left)/2);

        TreeNode* node = nodes[mid];
        node -> left = buildBST(nodes, left, mid - 1);
        node -> right = buildBST(nodes, mid + 1, right);
        return node;
    }
};