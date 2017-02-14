package stack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

   private Node head=null;
   private int size=0;
   private MinStack ms = new LinkedStack<MinFreq>();
   
   private class Node
   {
      public T data;
      public Node next;
   }

   private class MinFreq
   {
      public T data;
      public int freq;
   }
   
   public void push(T newEntry)
   {
      Node temp=new Node();
      temp.data=newEntry;
      temp.next=head;
      head=temp;
      ++size;
      if (newEntry == ms.peek().data)
      {
         MinFreq m = ms.pop();
         ++m.freq;
         ms.push(m);                  
      }
      if (newEntry < ms.peek().data)
      {
         MinFreq m = new MinFreq();
         m.data=newEntry;
         m.freq=1;
         ms.push(m);         
      }      
   }
   
   public T pop()
   {
      if (this.isEmpty()) return null;
      
      T data = head.data;
      head=head.next;
      --size;

      MinFreq m = new MinFreq();
      if (data == MinFreq.peek().data)
      {
         MinFreq m = ms.pop();
         if (m.data > 1)
         {
            --m.data;
            ms.push(m);
         }
      }

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

   public void display()
   {
      System.out.println(this);
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

   public void min()
   {      
      MinFreq mf = minstack.peek();
      if (mf.freq > 1)
      {
         --mf.freq;
         minstack.pop();
         minstack.push(mf);
      }
      else
         minstack.pop();
      
      return mf.data; 
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
