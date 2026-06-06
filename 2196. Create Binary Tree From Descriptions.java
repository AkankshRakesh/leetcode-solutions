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
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        unordered_map<int, TreeNode*> tree;
        unordered_set<int> children;

        for(auto&arr : descriptions){
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            children.insert(child);
            if(tree.find(parent) == tree.end()){
                tree[parent] = new TreeNode(parent);
            }
            if(tree.find(child) == tree.end()){
                tree[child] = new TreeNode(child);
            }
            if(isLeft){
                tree[parent] -> left = tree[child];
            }
            else{
                tree[parent] -> right = tree[child];
            }
        }
        int root = -1;
        for(auto&arr : descriptions){
            if(children.find(arr[0]) == children.end()){
                root = arr[0];
                break;
            }
        }
        return tree[root];
    }
};