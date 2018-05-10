import java.util.*;
public class TenWizard {
    public class Wizard implements Comparable<Wizard>{
        int id, dist;
        public Wizard(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
        public int compareTo(Wizard w2) {
            return this.dist - w2.dist;
        }
    }
    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
        int n = wizards.size();
        Map<Integer, Wizard> map = new HashMap<>();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new Wizard(i, i == 0 ? 0 : Integer.MAX_VALUE));
        }
        Queue<Wizard> pq = new PriorityQueue<Wizard>(n);
        pq.offer(map.get(0));
        while(!pq.isEmpty()) {
            Wizard curr = pq.poll();
            for (int f : wizards.get(curr.id)) {
                Wizard next = map.get(f);
                int w = (next.id - curr.id) * (next.id - curr.id);
                if (next.dist > curr.dist + w) {
                    pq.remove(next);
                    next.dist = curr.dist + w;
                    pq.offer(next);
                    parent[next.id] = curr.id;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int t = target;
        while(t != source) {
            res.add(t);
            t = parent[t];
        }
        res.add(t);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TenWizard sol = new TenWizard();
        int[][] ids = {{1, 5, 9}, {2, 3, 9}, {4}, {}, {}, {9}, {}, {}, {}, {}};
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            List<Integer> wizard = new ArrayList<>();
            for (int j = 0; j < ids[i].length; j++) {
                wizard.add(ids[i][j]);
            }
            wizards.add(wizard);
        }
        List<Integer> res = sol.getShortestPath(wizards, 0, 9);
        for (int i : res) System.out.println(i);//0, 5, 9
    }
}
