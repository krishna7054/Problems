#include <iostream>
#include <unordered_set>

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    bool hasCycle(ListNode* head) {
        std::unordered_set<ListNode*> visited;
        while (head != nullptr) {
            if (visited.find(head) != visited.end()) {
                return true;
            }
            visited.insert(head);
            head = head->next;
        }
        return false;
    }
};

int main() {
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = head;
    Solution solution;
    std::cout << std::boolalpha << solution.hasCycle(head) << std::endl;  // Output: true
    return 0;
}
