class Solution {
public:
    void dfs(Node* original, Node* clone, std::unordered_map<int, Node*>& hm) {
        std::vector<Node*>& clonedNeig = clone->neighbors;

        for (Node* neig : original->neighbors) {
            if (hm.find(neig->val) == hm.end()) {
                Node* next = new Node(neig->val, {});
                hm[neig->val] = next;
                clonedNeig.push_back(next);
                dfs(neig, next, hm);
            } else {
                clonedNeig.push_back(hm[neig->val]);
            }
        }
    }

    Node* cloneGraph(Node* node) {
        if (node == nullptr) return nullptr;
        Node* clone = new Node(node->val, {});
        std::unordered_map<int, Node*> hm;

        hm[node->val] = clone;
        dfs(node, clone, hm);

        return clone;
    }
};