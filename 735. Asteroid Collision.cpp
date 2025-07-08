class Solution {
public:
    std::vector<int> asteroidCollision(std::vector<int>& asteroids) {
        std::stack<int> stack;

        for (int asteroid : asteroids) {
            bool destroyed = false;

            if (asteroid < 0) {
                while (!stack.empty() && stack.top() > 0) {
                    int top = stack.top();
                    if (top < -asteroid) {
                        stack.pop();
                    } else if (top == -asteroid) {
                        stack.pop();
                        destroyed = true;
                        break;
                    } else {
                        destroyed = true;
                        break;
                    }
                }
                if (!destroyed) stack.push(asteroid);
            } else {
                stack.push(asteroid);
            }
        }

        // Transfer stack to vector in correct order
        std::vector<int> result(stack.size());
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.top();
            stack.pop();
        }

        return result;
    }
};
