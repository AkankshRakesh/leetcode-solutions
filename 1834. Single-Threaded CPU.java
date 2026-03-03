class Solution {
    public int[] getOrder(int[][] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[2], b[2]));
        int[][] tasks = new int[nums.length][3];
        for(int i = 0; i < nums.length; i++){
            tasks[i][0] = nums[i][0];
            tasks[i][1] = nums[i][1];
            tasks[i][2] = i;
        }
        Arrays.sort(tasks, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int time = tasks[0][0];
        int index = 0;
        for(index = 0; index < tasks.length && tasks[index][0] == time; index++) pq.offer(new int[]{tasks[index][0], tasks[index][1], tasks[index][2]});

        int ans[] = new int[tasks.length];
        int ind = 0;
        while(!pq.isEmpty()){
            int[] topTask = pq.poll();
            // System.out.println(topTask[2]);
            time += topTask[1];
            ans[ind++] = topTask[2];
            
            boolean foundTask = false;
            while(index < tasks.length && tasks[index][0] <= time){
                foundTask = true;
                pq.offer(new int[]{tasks[index][0], tasks[index][1], tasks[index][2]});
                index++;
            }
            if(!foundTask && index < tasks.length && pq.isEmpty()){
                time = tasks[index][0];
                pq.offer(new int[]{tasks[index][0], tasks[index][1], tasks[index][2]});
                index++;
            }
        }

        return ans;
    }
}