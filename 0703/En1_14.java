import java.util.Scanner;

public class En1_14{
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("正方形を表示します");

        do{
            System.out.print("段数を正の数で入力 :");
            n = stdIn.nextInt();
        }while(n <= 0);

        for (int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
