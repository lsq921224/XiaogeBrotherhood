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
        while(rowIter.hasNext() && colIter == null)
            colIter = rowIter.next().iterator();
        if colIter != null colIter.remove()
    }
}
