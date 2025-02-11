class Solution {

    public String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();
        int strLength = s.length();
        int partLength = part.length();

        for (int index = 0; index < strLength; index++) {
            stk.push(s.charAt(index));

            if (stk.size() >= partLength && checkMatch(stk, part, partLength)) {
                for (int j = 0; j < partLength; j++) {
                    stk.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        result.reverse();

        return result.toString();
    }

    public boolean checkMatch(
        Stack<Character> stk,
        String part,
        int partLength
    ) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stk);

        for (int partIndex = partLength - 1; partIndex >= 0; partIndex--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(partIndex)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}