package lcl;

import java.util.Iterator;
import java.lang.UnsupportedOperationException;
import java.lang.NullPointerException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

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
      return traverseToNodeAt(givenPosition).getData();
   }

   public boolean contains(T anEntry) {
      return false;
   }
    
   public Iterator<T> iterator() {
      return new IteratorForLinkedChainList();
   }

   private class IteratorForLinkedChainList implements Iterator<T>
   {
      private int count = 0;
      private Node curNode = null;
      
      private IteratorForLinkedChainList()
      {
         if (isEmpty())
            throw new NullPointerException("List is empty");
          
         curNode=getFirstNode();
      }
       
      public boolean hasNext()
      {
         return curNode != null;
      }

      public T next()
      {
         if ( ! hasNext())
            throw new NoSuchElementException();

         T data = curNode.getData();
         curNode = curNode.getNextNode();
         count++;
         
         return data;
      }

      public void remove()
      {
         if (count == 1)
         {
            removeFirstNode();
         }
         else
         {
            Node tmp = traverseToNodeAt(count-1);
            removeAfterNode(tmp);
         }
         count--;
      }
   }
}

