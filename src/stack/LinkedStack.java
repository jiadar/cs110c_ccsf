package stack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

   private Node head=null;
   private int size=0;
   
   private class Node {
      public T data;
      public Node next;
   }

   public void push(T newEntry)
   {
      Node temp=head;
      head = new Node();
      head.data=newEntry;
      head.next=temp;
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
      }
   }

   public void pushAll(T[] a)
   {
      for(int i = 0; i < a.length; ++i)
         this.push(a[i]);
   }
}
