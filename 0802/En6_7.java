import java.util.Scanner;

class En6_7{
    static void insertSort(int[] a,int n){
        for(int i = 1; i < n; i++){
            for(int m = 0; m < n; m++){
                System.out.print((m == i) ? "  * " : "   ");
            }
            System.out.println();
            for(int m = 0; m < n; m++){
                System.out.printf("%3d", a[m]);
            }
            System.out.println();

            int j;
            int tmp = a[i];
            for(j = i; j > 0 && a[j - 1] > tmp; j--) a[j] = a[j - 1];
            a[j] = tmp;
            System.out.printf("a[%d]の%dをa[%d]に挿入　\n\n", i, tmp, j);
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("単純挿入ソート");
        System.out.print("要素数: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++){
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        insertSort(x, nx);

        System.out.println("昇順ソート完了");
        for(int i = 0; i< nx; i++){
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
