class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (root == nullptr) return "";
        vector<int> arr;
        queue<TreeNode*> q;
        q.push(root);
        arr.push_back(root->val);
        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();
            if (node->left == nullptr) arr.push_back(1001);
            else {
                arr.push_back(node->left->val);
                q.push(node->left);
            }

            if (node->right == nullptr) arr.push_back(1001);
            else {
                arr.push_back(node->right->val);
                q.push(node->right);
            }
        }

        // Optional: print the array values (commented out)
        // for (int num : arr) cout << num << " ";

        stringstream ss;
        for (size_t i = 0; i < arr.size(); i++) {
            ss << arr[i];
            ss << "#";
        }

        return ss.str();
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(const string& data) {
        if (data.empty()) return nullptr;
        vector<string> vals;
        string token;
        stringstream ss(data);
        while (getline(ss, token, '#')) {
            if (!token.empty())
                vals.push_back(token);
        }

        TreeNode* root = new TreeNode(stoi(vals[0]));
        queue<TreeNode*> q;
        q.push(root);
        int index = 1;

        while (!q.empty() && index < (int)vals.size()) {
            TreeNode* curr = q.front();
            q.pop();

            if (vals[index] != "1001") {
                curr->left = new TreeNode(stoi(vals[index]));
                q.push(curr->left);
            }
            index++;

            if (index < (int)vals.size() && vals[index] != "1001") {
                curr->right = new TreeNode(stoi(vals[index]));
                q.push(curr->right);
            }
            index++;
        }

        return root;
    }
};