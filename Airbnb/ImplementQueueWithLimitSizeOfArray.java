import java.util.*;
public class ImplementQueueWithLimitSizeOfArray {
    ArrayList<Object> headList, tailList;
    int head, tail, count;
    static final int LIMIT = 5;
    public ImplementQueueWithLimitSizeOfArray() {
        // have to have two lists to maintain the chain
        this.headList = new ArrayList<>();
        this.tailList = this.headList;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public Integer peek() {
        if (count == 0) return null;
        if (head == LIMIT - 1) {
            return (Integer)((ArrayList<Object>)headList.get(head)).get(0);
        }
        return (Integer)headList.get(head);
    }

    public Integer poll() {
        if (count == 0) return null;
        if (head == LIMIT - 1) {
            ArrayList<Object> tmp = (ArrayList<Object>)headList.get(head);
            headList.clear();
            head = 0;
            headList = tmp;
        }
        Integer val = (Integer)headList.get(head);
        head++;
        count--;
        return val;
    }

    public void offer(int i) {
        if (tail == LIMIT - 1) {
            ArrayList<Object> tmp = new ArrayList<>();
            tailList.add(tmp);
            tail = 0;
            tmp.add(i);
            tailList = tmp;
        } else {
            tailList.add(i);
        }
        count++;
        tail++;
    }
    public static void main(String args[]) {
        ImplementQueueWithLimitSizeOfArray m = new ImplementQueueWithLimitSizeOfArray();
        m.offer(1);
        m.offer(2);
        m.offer(3);
        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.peek());
        System.out.println(m.poll());
        m.offer(4);
        m.offer(5);
        m.offer(6);
        m.offer(7);
        m.offer(8);
        m.offer(9);
        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.peek());
        System.out.println(m.poll());
    }
}
