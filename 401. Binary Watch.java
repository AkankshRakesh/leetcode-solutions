class Solution {
    public void backtrack(int leds, int[] hours, int[] minutes, HashSet<String> ans){
        if(leds == 0){
            int hour = 0;
            for(int i = 0; i < 4; i++){
                hour = hour | hours[i];
                if(i != 3) hour = hour << 1;
            }
            int minute = 0;
            for(int i = 0; i < 6; i++){
                minute = minute | minutes[i];
                if(i != 5) minute = minute << 1;
            }

            if(minute > 59 || hour > 11) return;
            String strHour = Integer.toString(hour);
            String strMinute = Integer.toString(minute);
            if(strMinute.length() == 1) strMinute = "0" + strMinute;
            ans.add(strHour + ":" + strMinute);
            return;
        }

        for(int i = 0; i < 6; i++){
            if(minutes[i] == 0){
                minutes[i] = 1;
                backtrack(leds - 1, hours, minutes, ans);
                minutes[i] = 0;
            }
        }
        for(int i = 0; i < 4; i++){
            if(hours[i] == 0){
                hours[i] = 1;
                backtrack(leds - 1, hours, minutes, ans);
                hours[i] = 0;
            }
        }
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        int[] hours = new int[4];
        int[] minutes = new int[6];
        backtrack(turnedOn, hours, minutes, hs);
        for(String str : hs) ans.add(str);
        return ans;
    }
}