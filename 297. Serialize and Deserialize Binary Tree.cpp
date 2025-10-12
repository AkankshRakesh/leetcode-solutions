class Codec {
public:
    string serialize(TreeNode* root) {
        if (!root) return "null-";
        string res;
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                TreeNode* node = q.front();
                q.pop();
                if (!node) {
                    res += "null+";
                } else {
                    res += to_string(node->val) + "+";
                    q.push(node->left);
                    q.push(node->right);
                }
            }
        }
        return res;
    }

    TreeNode* deserialize(string data) {
        if (data.empty()) return nullptr;
        vector<string> arr;
        string temp;
        for (char c : data) {
            if (c == '+') {
                arr.push_back(temp);
                temp.clear();
            } else {
                temp.push_back(c);
            }
        }
        arr.erase(remove_if(arr.begin(), arr.end(), [](const string& s){ return s.empty(); }), arr.end());
        if (arr.empty() || arr[0] == "null") return nullptr;
        TreeNode* root = new TreeNode(stoi(arr[0]));
        queue<TreeNode*> q;
        q.push(root);
        int ind = 1;
        while (ind < (int)arr.size()) {
            TreeNode* node = q.front();
            q.pop();
            if (ind < (int)arr.size()) {
                string left = arr[ind++];
                if (left != "null") {
                    TreeNode* leftNode = new TreeNode(stoi(left));
                    node->left = leftNode;
                    q.push(leftNode);
                }
            }
            if (ind < (int)arr.size()) {
                string right = arr[ind++];
                if (right != "null") {
                    TreeNode* rightNode = new TreeNode(stoi(right));
                    node->right = rightNode;
                    q.push(rightNode);
                }
            }
        }
        return root;
    }
};
