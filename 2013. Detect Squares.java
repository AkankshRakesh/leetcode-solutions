class DetectSquares {
    HashMap<String, Integer> hm = new HashMap<>();
    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        StringBuilder sb = new StringBuilder();
        sb.append(point[0]);
        sb.append("#");
        sb.append(point[1]);

        String key = sb.toString();
        hm.put(key, hm.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        // add(point);

        int ans = 0;
        for(Map.Entry<String, Integer> ele : hm.entrySet()){
            String str = ele.getKey();
            int x = 0, y = 0;
            int index = 0;
            while(str.charAt(index) != '#'){
                x *= 10;
                x += str.charAt(index) - '0';
                index++;
            }
            index++;
            while(index < str.length()){
                y *= 10;
                y += str.charAt(index) - '0';
                index++;
            }
            // System.out.println(x + " " + y);

            // not adjacent
            if(point[1] != y) continue;
            
            // parallel to x axis
            int dist = Math.abs(point[0] - x);

            if (dist == 0) continue;

            String next1 = point[0] + "#" + (point[1] + dist);
            String next2 = x + "#" + (y + dist);

            if(hm.containsKey(next1) && hm.containsKey(next2)) 
                ans += (hm.get(next1) * hm.get(next2) * ele.getValue());
            
            if(point[1] - dist < 0 || y - dist < 0) continue;

            // point[0], point[1] - dist
            // x, y - dist

            next1 = point[0] + "#" + (point[1] - dist);
            next2 = x + "#" + (y - dist);

            if(!hm.containsKey(next1) || !hm.containsKey(next2)) continue;

            ans += (hm.get(next1) * hm.get(next2) * ele.getValue());

        }

        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */