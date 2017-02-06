package stack;

public interface Stack<T> {
   public void push(T newEntry);
   public T pop();
   public T peek();
   public boolean isEmpty();
   public void clear(); 
   public T peek2();
   public String toString();
   public void remove(int n);
   public void pushAll(T[] a);
}
