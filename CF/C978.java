import java.util.Scanner;

public class C978 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long[] buildings = new long[(int)n];
        for(int i = 0; i < n; i++) buildings[i] = sc.nextLong();
        
        int index = 0;
        long currSum = 0;
        for(int i = 0; i < m; i++){
            long room = sc.nextLong();
            while(index < n && buildings[index] + currSum < room){
                currSum += buildings[index];
                // room -= currSum;
                index++;
            }
            if(room > currSum) room -= currSum;
            System.out.println((index + 1) + " " + (room));
        }

        sc.close();
    }
}
