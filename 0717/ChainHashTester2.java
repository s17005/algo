import java.util.Scanner;

class ChainHashTester2{
    static Scanner stdIn = new Scanner(System.in);

    // データ
    static class Data{
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        // キー
        String keyCode(){
            return name;
        }

        public String toString(){
            return Integer.toString(no);
        }

        void scanData(String guide, int sw){
            System.out.println(guide + "　するデータを入力");

            if ((sw & NO) == NO){
                System.out.print("番号:");
                no = stdIn.nextInt();
            }
            if((sw & NAME) == NAME){
                System.out.print("名前:");
                name = stdIn.next();
            }
        }
    }
    // メニュー列挙
    enum Menu{
        ADD(   "データ追加" ),
        REMOVE(   "データ削除" ),
        SEARCH(   "データ探索" ),
        DUMP(   "全データ表示" ),
        TERMINATE(   "終了" );

        private final String message;

        static Menu MenuAt(int idx){
            for (Menu m: Menu.values())
                if (m.ordinal() == idx) return m;
            return null;
        }

        Menu(String string){
            message = string;
        }

        String getMessage(){
            return message;
        }
    }

    // めにゅー選択
    static Menu SelectMenu(){
        int key;
        do{
            for (Menu m : Menu.values()){
                System.out.printf("(%d)%s ",m.ordinal(),m.getMessage());
                if((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
                    System.out.println();
            }
            System.out.print(":");
            key = stdIn.nextInt();
        }while(key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args){
        Menu menu;
        Data data;
        Data temp = new Data();

        ChainHash<String, Data> hash = new ChainHash<String, Data>(13);

        do{
            switch(menu = SelectMenu()){
                case ADD :   data = new Data();
                    data.scanData("追加", Data.NO| Data.NAME);
                    int k = hash.add(data.keyCode(),data);
                    switch(k){
                        case 1: System.out.println("そのキーは登録済み");
                            break;
                        case 2:System.out.println("ハッシュ表が満杯");
                            break;
                    }
                    break;

                case REMOVE:
                    temp.scanData("削除",Data.NAME);
                    hash.remove(temp.keyCode());
                    break;

                case SEARCH:
                    temp.scanData("探索",Data.NAME);
                    Data t = hash.search(temp.keyCode());
                    if (t != null)
                        System.out.println("そのキーをもつデータは"+t);
                    else
                        System.out.println("該当データはありません");
                    break;

                case DUMP:
                    hash.dump();
                    break;
            }
        }while (menu != Menu.TERMINATE);
    }
}
