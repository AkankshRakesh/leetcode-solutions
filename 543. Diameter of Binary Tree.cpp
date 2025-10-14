#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 */
// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *leftNode, TreeNode *rightNode)
//         : val(x), left(leftNode), right(rightNode) {}
// };

class Solution {
public:
    int ans = INT_MIN;
 
    int find(TreeNode* root) {
        if (root == nullptr) return 0;
        int left = find(root->left);
        int right = find(root->right);

        ans = max(ans, 1 + left + right);
        return 1 + max(left, right);
    }

    int diameterOfBinaryTree(TreeNode* root) {
        find(root);
        return ans - 1;
    }
};
