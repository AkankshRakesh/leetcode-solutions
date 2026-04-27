class Codec {
public:
    void preorder(TreeNode* node, string& sb) {
        if (node == nullptr) return;

        sb += to_string(node->val) + "#";
        preorder(node->left, sb);
        preorder(node->right, sb);
    }

    string serialize(TreeNode* root) {
        string sb = "";
        preorder(root, sb);
        return sb;
    }

    int index = 0;
    TreeNode* buildTree(const vector<int>& preorder, int left, int right) {
        if (index >= (int)preorder.size()) return nullptr;
        if (preorder[index] < left || preorder[index] > right) {
            index--;
            return nullptr;
        }

        TreeNode* node = new TreeNode(preorder[index]);
        int val = preorder[index];

        index++;
        node->left = buildTree(preorder, left, val);

        index++;
        node->right = buildTree(preorder, val, right);

        return node;
    }

    TreeNode* deserialize(const string& data) {
        if (data.empty()) return nullptr;

        vector<int> preorder;
        stringstream ss(data);
        string token;
        while (getline(ss, token, '#')) {
            if (!token.empty()) {
                preorder.push_back(stoi(token));
            }
        }

        index = 0;
        return buildTree(preorder, INT_MIN, INT_MAX);
    }
};