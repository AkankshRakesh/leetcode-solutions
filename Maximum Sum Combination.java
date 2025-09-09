class Solution {
    public void reverse(int[] a){
        int left = 0;
        int right = a.length - 1;
        while(left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        reverse(a);
        reverse(b);
        PriorityQueue<int[]> pq = new PriorityQueue<>((first, second) -> Integer.compare(second[0], first[0]));
        HashSet<String> hs = new HashSet<>();
        
        pq.offer(new int[]{a[0] + b[0], 0, 0});
        hs.add("0-0");
        int n = a.length;
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(!pq.isEmpty() && k != 0){
            int[] top = pq.poll();
            arr.add(top[0]);
            
            int i = top[1];
            int j = top[2];
            int nextI = i + 1;
            int nextJ = j + 1;
            String first = nextI + "-" + j;
            String second = i + "-" + nextJ;
            if(i + 1 < n && !hs.contains(first)){
                pq.offer(new int[]{a[i + 1] + b[j], i + 1, j});
                hs.add(first);
            }
            if(j + 1 < n && !hs.contains(second)){
                pq.offer(new int[]{a[i] + b[j + 1], i, j + 1});
                hs.add(second);
            }
            k--;
        }
        
        return arr;
    }
}