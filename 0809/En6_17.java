import java.util.*;

class En6_17{
    static class datalist{
        String name;
        int height;
        double eyesight;

        datalist(String name,int height,double eyesight){
            this.name = name;
            this.height = height;
            this.eyesight = eyesight;
        }

        public String toString(){
            return name + " " + height + " " + eyesight;
        }

        static final Comparator<datalist> EYESIGHT_ORDER = new eyesightOrderComparator();

        private static class eyesightOrderComparator implements Comparator<datalist>{
            public int compare(datalist data1, datalist data2){
                if(data1.eyesight == data2.eyesight){
                    return 0;
                }
                else if(data1.eyesight > data2.eyesight){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        datalist[] x = {
            new datalist("赤坂忠雄", 162, 0.3),
            new datalist("加藤富明", 173, 0.7),
            new datalist("斉藤正二", 175, 2.0),
            new datalist("武田信也", 171, 1.5),
            new datalist("長浜良一", 168, 0.4),
            new datalist("浜田哲明", 174, 1.2),
            new datalist("松富明雄", 169, 0.8),
        };

        System.out.printf("ソート前\n");
        display(x);
        System.out.printf("\n");
        Arrays.sort(x,datalist.EYESIGHT_ORDER);
        System.out.printf("ソート後\n");
        display(x);
    }

    static void display(datalist[] x){
        System.out.println("■ 身体検査一覧表 ■");
        System.out.println("氏名      身長 視力");
        System.out.println("--------------------");
        for(int i=0;i<x.length;i++){
            System.out.printf("%-8s%3d%5.1f\n",x[i].name, x[i].height, x[i].eyesight);
        }
    }
}
