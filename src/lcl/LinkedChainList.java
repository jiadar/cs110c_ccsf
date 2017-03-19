package lcl;

/**
 * Created by schatz on 10/21/15.
 */
public class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T> {

    public LinkedChainList() {
        super();
    }

    // Here is an example of how LinkedChainList's methods can be implemented
    // using methods inherited from LinkedChainBase
    public T remove(int givenPosition) {
        // Make sure we have a good index
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

    // Stub
    public void add(T newEntry) {

    }

    // Stub
    public void add(int newPosition, T newEntry) {

    }

    // Stub
    public T replace(int givenPosition, T newEntry) {
        return null;
    }

    // Stub
    public T getEntry(int givenPosition) {
        return null;
    }

    // Stub
    public boolean contains(T anEntry) {
        return false;
    }
    
    // Stub
    public Iterator<T> iterator() {
        return null;
    }
}
