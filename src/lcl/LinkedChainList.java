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
       add(getLength(), newEntry);
    }

    public void add(int newPosition, T newEntry) {
       if (isEmpty())
          addFirstNode(new Node(newEntry));
       else
          addAfterNode(traverseToNodeAt(newPosition), new Node(newEntry));                                        
    }

    public T replace(int givenPosition, T newEntry) {
       addAfterNode(traverseToNodeAt(givenPosition), new Node(newEntry));

       if (givenPosition == 1)
          return removeFirstNode();

       return removeAfterNode(traverseToNodeAt(givenPosition-1));

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
