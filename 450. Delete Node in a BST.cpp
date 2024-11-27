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
    TreeNode* findMin(TreeNode* root){
        if(root == nullptr) return root;
        while(root != nullptr && root -> left != nullptr){
            root = root -> left;
        }
        return root;
    }
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL) return root;
        if(root -> val > key){
            root -> left = deleteNode(root -> left, key);
        }
        else if(root -> val < key){
            root -> right = deleteNode(root -> right, key);
        }
        else{
            if(root -> left == NULL){
                TreeNode* temp = root -> right;
                delete root;
                return temp;
            }
            if(root -> right == NULL){
                TreeNode* temp = root -> left;
                delete root;
                return temp;
            }

            TreeNode* leastInRight = findMin(root -> right);
            root -> val = leastInRight -> val;
            root -> right = deleteNode(root -> right, root -> val);
        }
        return root;
    }
};