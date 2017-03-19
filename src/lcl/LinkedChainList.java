package lcl;

import java.util.Iterator;

/**
 * Created by schatz on 10/21/15.
 */
public class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T> {

    public LinkedChainList() {
        super();
    }

    public T remove(int givenPosition) {
        if (givenPosition < 1 || givenPosition > getLength()) {
            throw new IndexOutOfBoundsException("index: " + givenPosition);
        }

        if (givenPosition == 1) {
            return removeFirstNode();
        } else {
            Node nodeBefore = traverseToNodeAt(givenPosition);
            return removeAfterNode(nodeBefore);
        }
    }

    public void add(T newEntry) {
       Node nodeBefore = new Node();
       nodeBefore = traverseToNodeAt(getLength());
//       addAfterNode(nodeBefore, newEntry);
       
    }

    public void add(int newPosition, T newEntry) {

    }

    public T replace(int givenPosition, T newEntry) {
        return null;
    }

    public T getEntry(int givenPosition) {
        return null;
    }

    public boolean contains(T anEntry) {
        return false;
    }
    
    public Iterator<T> iterator() {
        return null;
    }
}
