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
    vector<int> rightSideView(TreeNode* root) {
        queue<TreeNode*> levelQue;
        levelQue.push(root);
        vector<int> res;
        if(root == NULL) return res;
        res.push_back(root -> val);
        while(!levelQue.empty()){  
            int len = levelQue.size();
            for(int i = 0; i < len; i++){
                TreeNode* node = levelQue.front();
                levelQue.pop();
                if(node -> left) levelQue.push(node -> left);
                if(node -> right) levelQue.push(node -> right);
            }
            if(!levelQue.empty())res.push_back(levelQue.back() -> val);
        }
        return res;
    }
};