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
    long long kthLargestLevelSum(TreeNode* root, int k) {
        queue<TreeNode*> q;
        q.push(root);
        priority_queue<long long> pqSum;
        while(!q.empty()){
            int len = q.size();
            long long sum = 0;
            for(int i = 0; i < len; i++){
                TreeNode* n = q.front();
                sum += n -> val;
                q.pop();
                if(n -> left){
                    q.push(n -> left);
                }
                if(n -> right){
                    q.push(n -> right);
                }
            }
            pqSum.push(sum);
        }
        k--;
        if(pqSum.size() <= k) return -1;
        while(k){
            pqSum.pop();
            k--;
        }
        return pqSum.top();
    }
};