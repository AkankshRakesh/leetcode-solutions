class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                ans.add(i);
                while(n % i == 0) n /= i;
            }
        }
        
        if(n >= 2) ans.add(n);
        return ans;
    }
}