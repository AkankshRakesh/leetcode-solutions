class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        for(int num : nums){
            long curr = num;
            while(!st.isEmpty() && st.peek() == curr){
                curr += st.pop();
            }
            st.push(curr);
        }

        List<Long> arr = new ArrayList<>();
        while(!st.isEmpty()) arr.add(st.pop());
        Collections.reverse(arr);

        return arr;
    }
}