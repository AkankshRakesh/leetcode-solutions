import java.util.Scanner;

public class B363 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int fence[] = new int[n];
        for(int i = 0; i < n; i++) fence[i] = sc.nextInt();
        
        int sum = 0;
        int index = 0;
        for(int i = 0; i < k; i++) sum += fence[i];
        int minSum = sum;
        
        for(int i = k; i < n; i++){
            sum -= fence[i - k];
            sum += fence[i];
            if(sum < minSum){
                minSum = sum;
                index = i - k + 1;
            }
        }
        System.out.print(index + 1);

        sc.close();
    }
}
