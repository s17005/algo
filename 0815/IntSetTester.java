// int型集合クラスIntSetの利用例

public class IntSetTester {

    public static void main(String[] args) {
        IntSet s1 = new IntSet(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        System.out.println("集合体s1の要素は" + s1);

        System.out.println("集合s1は" +
            (s1.isEmpty() ? "空である" : "空ではない"));
        System.out.println("集合s1は" +
            (s1.isFull() ? "満杯" : "満杯ではない"));

        s1.clear();
        System.out.println("集合体s1の要素" + s1);

        System.out.println("集合s1は" +
            (s1.isEmpty() ? "空である" : "空ではない"));
    }
}
