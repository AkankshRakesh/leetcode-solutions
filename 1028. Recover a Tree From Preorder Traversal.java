import java.util.AbstractMap.SimpleEntry;

public class Solution {

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<SimpleEntry<TreeNode, Integer>> stack = new Stack<>();
        int index = 0;
        TreeNode root = null;

        while (index < traversal.length()) {
            int depth = 0;
            while (
                index < traversal.length() && traversal.charAt(index) == '-'
            ) {
                depth++;
                index++;
            }

            int value = 0;
            while (
                index < traversal.length() &&
                Character.isDigit(traversal.charAt(index))
            ) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(value);

            if (depth == 0) {
                root = node;
            } else {
                while (stack.size() > depth) {
                    stack.pop();
                }

                if (stack.peek().getKey().left == null) {
                    stack.peek().getKey().left = node;
                } else {
                    stack.peek().getKey().right = node;
                }
            }

            stack.push(new SimpleEntry<>(node, depth));
        }
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek().getKey();
    }
}