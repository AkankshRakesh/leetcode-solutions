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
    bool pathFinder(TreeNode* root, vector<TreeNode*>& n1, TreeNode* n){
        if(root == nullptr) return false;
        n1.push_back(root);
        if(root -> val == n -> val){
            return true;
        }

        if(pathFinder(root -> left, n1, n) || pathFinder(root -> right,n1,n)){
            return true;
        }

        n1.pop_back();
        return false;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> p1, p2;
        pathFinder(root, p1, p);
        pathFinder(root, p2, q);

        int i = 0;
        while(i < p1.size() && i < p2.size()){
            if(p1[i] != p2[i]){
                return p1[i - 1];
            }
            i++;
        }
        return p1[i - 1];  
    }
};