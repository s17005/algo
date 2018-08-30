import java.util.*;
import java.util.Map.Entry;

public class En0830{
    static String[][] rank;
    static void printRank(Map<String, int[]> r) {
        for (String key : r.keySet()) {
            int[] nin = r.get(key);
            System.out.println(key + nin[0] + " " + nin[1] + " " + nin[2]);
        }
    }
    static void printList(List<Entry<String, int[]>> l){
        for(Entry<String, int[]> entry : l){
            int[] nin = entry.getValue();
            System.out.println(entry.getKey() + "  " + nin[0] + "  " + nin[1] + "  " + nin[2]);
        }
    }
    static final Comparator<Entry<String, int[]>> RANK_ORDER = new RankOrderComparator();

    private static class RankOrderComparator implements Comparator<Entry<String, int[]>> {
        public int compare(Entry<String, int[]> s1, Entry<String, int[]> s2){
            int[] d1 = s1.getValue();
            int[] d2 = s2.getValue();
            int ret;

            if(d1[0] > d2[0]) ret = -1;
            else if(d1[0] < d2[0]) ret = 1;
            else{
                if(d1[1] > d2[1]) ret = -1;
                else if(d1[1] < d2[1]) ret = 1;
                else ret = 0;
            }
            return ret;
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, int[]> rank = new HashMap<String, int[]>();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            String[] array = s.split(",");
            String seibetu = array[3];
            String pref = array[6];
            if(!rank.containsKey(pref)){
                int[] nin = {0,0,1};
                if(seibetu.equals("男")) nin[0]++;
                else nin[1]++;

                rank.put(pref, nin);
            }
            else{
                int[] nin = rank.get(pref);
                nin[2]++;
                if(seibetu.equals("男")) nin[0]++;
                else nin[1]++;

                rank.put(pref, nin);
            }
        }

            List<Entry<String, int []>> list_entries = new ArrayList<Entry<String, int[]>>(rank.entrySet());
            Collections.sort(list_entries, RANK_ORDER);
            printList(list_entries);
    }
}
