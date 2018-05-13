import java.util.*;
public class ListOfListIterator {
    private Iterator<List<Integer>> rowIter;
    private Iterator<Integer> colIter;

    public ListOfListIterator(List<List<Integer>> list) {
        rowIter = list.iterator();
        colIter = null;
    }

    public Integer next() {
        return colIter.next();
    }

    public boolean hasNext() {
        // if has to be while loop since it would deal with the case of empty arraylist
        while(rowIter.hasNext() && (colIter == null || !colIter.hasNext()))
            colIter = rowIter.next().iterator();
        return colIter != null && colIter.hasNext()
    }

    public void remove() {
        // for the first time call remove
        // remove don't care about hasNext or not, it cares about current
        while(rowIter.hasNext() && colIter == null)
            colIter = rowIter.next().iterator();
        if colIter != null colIter.remove()
    }


    //follow Up 小哥二号出了道flattern 2D vector with remove的题，我虽然当时没有做过但也知道解法啊，秒了+thorough testcases。
    // 小哥二号说奥森！你能来几个testcases比如只print出奇数位的value吗？你能在某些情况下remove的同时print out一些msg吗，比如说这个list空了我要去下一层list之类的，一一秒了。

}
