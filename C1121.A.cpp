import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(System.out);

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static String solve() throws IOException {
        int n = nextInt();
        int[] nums = new int[n];
        int[] og = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = nextInt();
            og[i] = nums[i];
        }
        
        Arrays.sort(nums);
        int last = -1;
        for(int i = 0; i < n; i++){
            if(og[i] != nums[i]){
                if(last == -1) last = og[i];
                else if(last <= og[i]){
                    return "NO";
                }
                else last = og[i];
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        int t = nextInt();

        while(t != 0){
            System.out.println(solve());
            t--;
        }
        

        out.flush();
    }
}