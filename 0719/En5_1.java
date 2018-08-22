import java.util.Scanner;

class En5_1{
    //　負の数でない整数値nの階乗値を返す
    static int factorial(int n){
        int fact = 1;

        while (n > 1) fact *= n--;
        return (fact);
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("整数を入力: ");
        int x = stdIn.nextInt();

        System.out.println(x + "の階乗は" + factorial(x) + "です");
    }
}
