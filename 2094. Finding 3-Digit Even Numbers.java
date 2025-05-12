class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        boolean map[] = new boolean[900];
        ArrayList<Integer> evenEle = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(digits[i] % 2 == 0){
                evenEle.add(i);
            }
        }
        int totEven = evenEle.size();

        int count = 0;
        for(int i = 0; i < n; i++){
            if(digits[i] == 0) continue;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                for(int k = 0; k < totEven; k++){
                    if(evenEle.get(k) == j || evenEle.get(k) == i) continue;
                    int ele = (digits[i] * 100) + (digits[j] * 10) + digits[evenEle.get(k)];
                    if(!map[ele - 100]){
                        map[ele-100] = true;
                        count++;
                    }
                }
            }
        }
        int ans[] = new int[count];
        int ind = 0;
        for(int i = 0; i < 900; i++){
            if(map[i]){
                ans[ind++] = i + 100;
            }
        }
        return ans;
    }
}