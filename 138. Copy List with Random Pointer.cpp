/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (!head) return nullptr;

    // Step 1: Create new nodes and insert them next to the original nodes
        Node* current = head;
        while (current) {
            Node* newNode = new Node(current->val);
            newNode->next = current->next;
            current->next = newNode;
            current = newNode->next;
        }
        current = head;
        while (current) {
            if (current->random) {
                current->next->random = current->random->next;
            }
            current = current->next->next;
        }

        // Step 3: Separate the newly created list from the original list
        current = head;
        Node* newHead = head->next;
        Node* copy = newHead;
        while (current) {
            current->next = current->next->next;
            if (copy->next) {
                copy->next = copy->next->next;
            }
            current = current->next;
            copy = copy->next;
        }

        return newHead;
    }
};