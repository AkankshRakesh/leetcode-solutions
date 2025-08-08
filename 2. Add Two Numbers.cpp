class Solution {
public:
    void add(vector<int>& arr1, vector<int>& arr2, int ind1, int ind2, vector<int>& res, int carry) {
        if (ind1 < 0 && ind2 < 0) {
            if (carry == 1) res.push_back(1);
            return;
        } else if (ind1 < 0 && ind2 >= 0) {
            if (carry == 1 && arr2[ind2] == 9) {
                res.push_back(0);
                add(arr1, arr2, ind1, ind2 - 1, res, 1);
            } else {
                res.push_back(arr2[ind2] + carry);
                add(arr1, arr2, ind1, ind2 - 1, res, 0);
            }
        } else if (ind1 >= 0 && ind2 < 0) {
            if (carry == 1 && arr1[ind1] == 9) {
                res.push_back(0);
                add(arr1, arr2, ind1 - 1, ind2, res, 1);
            } else {
                res.push_back(arr1[ind1] + carry);
                add(arr1, arr2, ind1 - 1, ind2, res, 0);
            }
        } else {
            int sum = arr1[ind1] + arr2[ind2] + carry;
            if (sum >= 10) {
                res.push_back(sum % 10);
                add(arr1, arr2, ind1 - 1, ind2 - 1, res, 1);
            } else {
                res.push_back(sum);
                add(arr1, arr2, ind1 - 1, ind2 - 1, res, 0);
            }
        }
    }

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        vector<int> arr1, arr2;

        while (l1 != nullptr) {
            arr1.push_back(l1->val);
            l1 = l1->next;
        }
        while (l2 != nullptr) {
            arr2.push_back(l2->val);
            l2 = l2->next;
        }

        reverse(arr1.begin(), arr1.end());
        reverse(arr2.begin(), arr2.end());

        vector<int> res;
        add(arr1, arr2, arr1.size() - 1, arr2.size() - 1, res, 0);

        ListNode* head = new ListNode(res[0]);
        ListNode* curr = head;
        for (int i = 1; i < res.size(); i++) {
            curr->next = new ListNode(res[i]);
            curr = curr->next;
        }

        return head;
    }
};
