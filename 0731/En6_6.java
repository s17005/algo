import java.util.Scanner;

class En6_6{
    // a[idx1]とa[idx2]の交換
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    //単純選択ソート
    static void selectionSort(int[] a, int n){
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(a[j] < a[min]) min = j;
            }
            for(int k = 0; k < n; k++){
                System.out.print((k == i) ? "  * ": (k == min) ? " + ": "   ");
            }
            System.out.println();

            for (int k = 0; k < n; k++){
                System.out.printf("%3d", a[k]);
            }
            System.out.println("\n");
            swap(a, i, min); // 未ソートの先頭と最小を交換
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("単純選択ソート");
        System.out.print("要素数:");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i<nx; i++){
            System.out.print("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);

        System.out.println("昇順にソートしました");
        for(int i = 0; i < nx; i++){
            System.out.println("x[" + i + "]=" + x[i]);
        }
    }
}
