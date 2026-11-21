class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 1);

        int[][] points = new int[buildings.length * 2][2];
        int index = 0;
        for(int i = 0; i < buildings.length; i++){
            points[index][0] = buildings[i][0];
            points[index][1] = -buildings[i][2];

            index++;

            points[index][0] = buildings[i][1];
            points[index][1] = buildings[i][2];

            index++;
        }

        Arrays.sort(points, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int maxH = 0;
        for(int i = 0; i < points.length; i++){
            int curr = points[i][0];
            int currH = points[i][1];

            if(currH < 0){
                tm.put(-currH, tm.getOrDefault(-currH, 0) + 1);
                // System.out.println(tm.get(-currH) + " " + currH);
            }
            else{
                // if(!tm.containsKey(currH)) System.out.println(currH);
                int count = tm.get(currH);
                if(count == 1) tm.remove(currH);
                else tm.put(currH, count - 1);
            }

            int maxTm = tm.lastKey();
            if(maxH != maxTm){
                maxH = maxTm;

                List<Integer> temp = new ArrayList<>();
                temp.add(curr);
                temp.add(maxTm);
                ans.add(temp);
            }
        }

        return ans;
    }
}