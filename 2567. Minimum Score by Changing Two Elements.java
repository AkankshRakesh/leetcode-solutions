class Solution {
    public int minimizeSum(int[] nums) {
        if(nums.length == 3) return 0;

        int sm = Integer.MAX_VALUE, sSm = Integer.MAX_VALUE, tSm = Integer.MAX_VALUE;
        int la = Integer.MIN_VALUE, sLa = Integer.MIN_VALUE, tLa = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num < sm){
                tSm = sSm;
                sSm = sm;
                sm = num;
            }
            else if(num < sSm){
                tSm = sSm;
                sSm = num;
            }
            else if(num < tSm){
                tSm = num;
            }

            if(num > la){
                tLa = sLa;
                sLa = la;
                la = num;
            }
            else if(num > sLa){
                tLa = sLa;
                sLa = num;
            }
            else if(num > tLa){
                tLa = num;
            }
        }

        // System.out.println(sm + " " + sSm + " " + tSm);
        // System.out.println(la + " " + sLa + " " + tLa);

        return Math.min(tLa - sm, Math.min(la - tSm, sLa - sSm));
    }
}