class Solution {
    public int gcdComp(int a, int b){
        if(a == 0) return b;
        return gcdComp(b % a, a);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        for(int num : nums){
            int x = num;
            while(!st.isEmpty()){
                int top = st.peek();
                int gcd = gcdComp(top, x);
                if(gcd == 1) break;
            
                x /= gcd;
                x *= top;
                st.pop();
            }
            st.push(x);
        }

        while(!st.isEmpty()) res.add(st.pop());
        Collections.reverse(res);
        return res;
    }
}