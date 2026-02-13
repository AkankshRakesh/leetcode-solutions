class Solution {
    public void addVariations(int[] ele, HashSet<String> ends, Queue<int[]> q){     
        StringBuilder sb = new StringBuilder();
        sb.append(ele[0] + "");
        sb.append(ele[1] + "");
        sb.append(ele[2] + "");
        sb.append(ele[3] + "");


        for(int i = 0; i < 4; i++){
            char original = sb.charAt(i);
            if(ele[i] == 0) sb.setCharAt(i, '9');
            else sb.setCharAt(i, (char)('0' + (ele[i] - 1)));
            String temp = sb.toString();

            if(!ends.contains(temp)){
                ends.add(temp);
                q.offer(new int[]{temp.charAt(0) - '0', temp.charAt(1) - '0', temp.charAt(2) - '0', temp.charAt(3) - '0'});
            }

            if(ele[i] == 9) sb.setCharAt(i, '0');
            else sb.setCharAt(i, (char)('0' + (ele[i] + 1)));
            temp = sb.toString();

            if(!ends.contains(temp)){
                ends.add(temp);
                q.offer(new int[]{temp.charAt(0) - '0', temp.charAt(1) - '0', temp.charAt(2) - '0', temp.charAt(3) - '0'});
            }
            
            sb.setCharAt(i, original);
        }
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> ends = new HashSet<>();
        for(String str : deadends) ends.add(str);
        if (ends.contains("0000")) return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0,0});
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] ele = q.poll();
                if(target.charAt(0) - '0' == ele[0] && target.charAt(1) - '0' == ele[1] && target.charAt(2) - '0' == ele[2] && target.charAt(3) - '0' == ele[3]) return ans;
                addVariations(ele, ends, q);
            }
            ans++;
        }

        return -1;
    }
}