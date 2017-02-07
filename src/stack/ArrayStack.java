package stack;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

   private int size=0;
   private T[] data;
   private boolean initialized=false;
   private static final int DEFAULT_CAPACITY=25;
   private static final int MAX_CAPACITY=10000;
   
   public ArraStack(int initialCapacity)
   {
      checkCapacity(initialCapacity);
      @SuppressWarnings("unchecked");
      T[] tempData = (T[]new Object[initialCapacity]);
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
      max *= 2;
      T[] temp[max]; 
      temp = data;
   }
   
   public void push(T newEntry)
   {
      data[size]=newEntry;
      if (size == max)
         this.doubleSize();
      ++size;
   }
   
   public T pop()
   {
      if (head==null)
         return null;
      
      T data = head.data;
      head=head.next;
      --size;
      return data;
   }

   public T peek()
   {
      return (head==null ? null : head.data);
   }
   
   public T peek2()
   {
      if (size<2)
         throw new EmptyStackException();
      return head.next.data;
   }

   public boolean isEmpty()
   {
      return head==null;
   }

   public void clear()
   {
      head=null;
      size=0;
   }

   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      Node cur=head;
      while(cur != null)
      {
         sb.append(cur.data.toString());
         sb.append((cur.next==null ? "" : ", "));
         cur = cur.next;
      }
      return sb.toString();
}

   public void remove(int n)
   {
      T discard;
      Node cur = head;
      int count=0;
      while(cur != null && count<n)
      {
         discard=this.pop();
         ++count;
         --size;
      }
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

