// Most of this code copied from book

package queue;

import java.util.Arrays;

public class ArrayQueue<T> implements QueueInterface<T>
{
   private T[] queue;
   private int frontIndex;
   private int backIndex;
   private boolean initialized = false;
   private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
   
   public ArrayQueue()
   {
      this(DEFAULT_CAPACITY);
   } 
   
   public ArrayQueue(int initialCapacity)
   {
      checkCapacity(initialCapacity);
      
      @SuppressWarnings("unchecked")
      T[] tempQueue = (T[]) new Object[initialCapacity + 1];
      queue = tempQueue;
      frontIndex = 0;
      backIndex = initialCapacity;
      initialized = true;
   }

   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to exceed maximum allowed capacity");
   }

   private void checkInitialization()
   {
      if (!initialized)
         throw new SecurityException ("Uninitialized object used ");
   }
   
   public void enqueue(T newEntry)
   {
      checkInitialization();
      ensureCapacity();
      backIndex = (backIndex + 1) % queue.length;
      queue[backIndex] = newEntry;
   }

   public T getFront()
   {
      checkInitialization();
      if (isEmpty())
         throw new NullPointerException("Queue Empty");
      else
         return queue[frontIndex];
   }


   public T dequeue()
   {
      checkInitialization();
      if (isEmpty())
         throw new NullPointerException("Queue Empty");
      else
      {
         T front = queue[frontIndex];
         queue[frontIndex] = null;
         frontIndex = (frontIndex + 1) % queue.length;
         return front;
      }
   }

   private void growCapacity()
   {
      T[] oldQueue = queue;
      int oldSize = oldQueue.length;
      int newSize = 2 * oldSize;
      checkCapacity(newSize);

      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
         T[] tempQueue = (T[]) new Object[2 * oldSize];
      queue = tempQueue;
      for (int index = 0; index < oldSize - 1; index++)
      {
         queue[index] = oldQueue[frontIndex];
         frontIndex = (frontIndex + 1) % oldSize;
      }

      frontIndex = 0;
      backIndex = oldSize - 2;
      
   }


   private void ensureCapacity()
   {
      if (frontIndex == ((backIndex + 2) % queue.length)) 
         growCapacity();
   }
   
   public boolean isEmpty()
   {
      return frontIndex == ((backIndex + 1) % queue.length);
   }

   public void splice2(ArrayQueue<T> q)
   {
      // this array needs to be at least | q.backIndex - q.frontIndex |
      // find out how much capacity we need and how much capacity remains
      // in this
      int capacityNeeded = Math.abs(q.backIndex - q.frontIndex);
      int thisCapacity = Math.abs(backIndex - frontIndex);

      // while we don't have enough capacity in this, make more
      while (thisCapacity < capacityNeeded)
      {
         growCapacity();
         thisCapacity = Math.abs(backIndex - frontIndex);
      }
      
      if (isEmpty())
      {
         queue = q.queue;
      }
      else
      {
         // copy the elements from q to this
         int i = q.frontIndex; 
         while (i != (q.backIndex + 1)) 
         {
            this.backIndex = (this.backIndex + 1) % this.queue.length;
            this.queue[this.backIndex] = q.queue[i];
            i = (i + 1) % q.queue.length;
         }
      }
   }

   public void clear()
   {
      frontIndex = 0;
      backIndex = queue.length-1;
   }

   public String toString()
   {
      return Arrays.toString(queue);
   }

   public void splice(QueueInterface<T> q)
   {
      // O(n) if we can not access the memory / references directly
      while(! q.isEmpty())
         this.enqueue(q.dequeue());
   }

}
