class Solution {
    public int getDay(String str){
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = 0;
        month += str.charAt(0) - '0';
        month *= 10;
        month += str.charAt(1) - '0';

        int day = 0;
        day += str.charAt(3) - '0';
        day *= 10;
        day += str.charAt(4) - '0';

        int ans = 0;
        

        int index = 0;
        while(index < month){
            if(index + 1 == month) ans += day;
            else ans += days[index];

            index++;
        }

        // System.out.println(str + " " + month + " " + day + " " + ans);
        return ans;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aa = getDay(arriveAlice);
        int la = getDay(leaveAlice);
        int ab = getDay(arriveBob);
        int lb = getDay(leaveBob);

        // System.out.println(aa + " " + la + " " + ab + " " + lb);

        if(aa < ab){
            if(la < ab) return 0;
            return Math.min(la, lb) - Math.max(aa, ab) + 1;
        }

        if(lb < aa) return 0;
        return Math.min(la, lb) - Math.max(aa, ab) + 1;
    }
}