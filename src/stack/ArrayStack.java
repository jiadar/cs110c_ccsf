package stack;
import java.util.EmptyStackException;
import java.util.Arrays;
import java.util.logging.*;

public class ArrayStack<T> implements Stack<T> {

   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   private int size=0;
   private T[] data;
   private boolean initialized=false;
   private static final int DEFAULT_CAPACITY=25;
   private static final int MAX_CAPACITY=10000;
   
   public ArrayStack(int initialCapacity)
   {
      checkCapacity(initialCapacity);
      @SuppressWarnings("unchecked")
         T[] tempData = (T[]) new Object[initialCapacity];
      data = tempData;
      size = 0;
      initialized = true;
   }

   public ArrayStack()
   {
      this(DEFAULT_CAPACITY);
   }

   private void doubleSize()
   {
      checkCapacity(size*2);
      data = Arrays.copyOf(data, size*2);
      size *= 2; 
   }

   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to exceed maximum allowed capacity");
   }
   
   public void push(T newEntry)
   {
      data[size]=newEntry;
      if (size == MAX_CAPACITY-1)
         this.doubleSize();
      ++size;
      lmsg("Pushed " + data[size] + " size=" + size);
   }
   
   public T pop()
   {
      if (size==0)
         return null;

      --size;
      lmsg("Popped " + data[size] + " size=" + size);
      return data[size];
   }

   public T peek()
   {
      return (size==0 ? null : data[size-1]);
   }
   
   public T peek2()
   {
      if (size<2)
         throw new EmptyStackException();
      return data[size-2];
   }

   public boolean isEmpty()
   {
      return size==0;
   }

   public void clear()
   {
      size=0;
   }

   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      if (size > 0)
      {
         for(int i = size-1; i >= 0; --i)
         {
            lmsg.info("processing: " + i + "\n");
            sb.append(data[i].toString());
            sb.append((i == 0 ? "" : ", "));  
         }          
      }
      
      return sb.toString();
}

   public void remove(int n)
   {
      size -= n;
   }

   public void pushAll(T[] a)
   {
      for(int i = 0; i < a.length; ++i)
      {
         this.push(a[i]);
         ++size;
      }
   }
}

