import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B799 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        boolean[] used = new boolean[n];
        int[] prices = new int[n];
        int[] front = new int[n];
        int[] back = new int[n];

        for(int i = 0; i < n; i++) prices[i] = sc.nextInt();
        for(int i = 0; i < n; i++) front[i] = sc.nextInt();
        for(int i = 0; i < n; i++) back[i] = sc.nextInt();

        for(int i = 0; i < n; i++){
            PriorityQueue<Integer> pq1 = hm.getOrDefault(front[i], new PriorityQueue<>((a, b) -> Integer.compare(prices[a], prices[b])));
            pq1.offer(i);
            hm.put(front[i], pq1);
            PriorityQueue<Integer> pq2 = hm.getOrDefault(back[i], new PriorityQueue<>((a, b) -> Integer.compare(prices[a], prices[b])));
            pq2.offer(i);
            hm.put(back[i], pq2);
        }

        int queries = sc.nextInt();
        int[] q = new int[queries];
        for(int i = 0; i < queries; i++) q[i] = sc.nextInt();
        int[] ans = new int[queries];
        for(int i = 0; i < queries; i++){
            // System.out.println(q[i]);
            if(!hm.containsKey(q[i])) ans[i] = -1;
            else{
                PriorityQueue<Integer> pq = hm.get(q[i]);
                while(!pq.isEmpty() && used[pq.peek()]) pq.poll();
                if(pq.isEmpty()) ans[i] = -1;
                else{
                    ans[i] = prices[pq.peek()];
                    used[pq.peek()] = true;
                }
            }
        }

        for(int ansVal : ans) System.out.print(ansVal + " ");

        sc.close();
    }
}
