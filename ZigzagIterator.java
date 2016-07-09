public class ZigzagIterator {
    /**
     * Uses a linkedlist to store the iterators in different vectors. 
     * Every time we call next(), we pop an element from the list, and re-add it to the end to cycle through the lists.
     */ 
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if (!v1.isEmpty()) list.add(v1.iterator());
        if (!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator iter = list.remove();
        int rs = (int) iter.next();
        if (iter.hasNext()) list.add(iter);
        return rs;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */