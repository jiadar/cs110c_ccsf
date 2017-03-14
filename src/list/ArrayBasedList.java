package list;

import java.util.Arrays;

public class ArrayBasedList<T> implements ListInterface<T>
{
	private T[] list;   
	private int numberOfEntries;
   private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 3;
	private static final int MAX_CAPACITY = 15;
   
	public ArrayBasedList()
	{
		this(DEFAULT_CAPACITY);
	} 
   
	public ArrayBasedList(int initialCapacity)
	{
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else
         checkCapacity(initialCapacity);
      
      @SuppressWarnings("unchecked")
         T[] tempList = (T[])new Object[initialCapacity + 1];
      list = tempList;
      numberOfEntries = 0;
      initialized = true;
	} 
   
   public T[] toArray()
   {
		checkInitialization();
      
      @SuppressWarnings("unchecked")
         T[] result = (T[])new Object[numberOfEntries];
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = list[index + 1];
      }
      
      return result;
   }
   
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}

   private void ensureCapacity()
   {
      int capacity = list.length - 1;
      if (numberOfEntries >= capacity)
      {
         int newCapacity = 2 * capacity;
         checkCapacity(newCapacity);
         list = Arrays.copyOf(list, newCapacity + 1);
      }
   } 

   public void add(int newPosition, T newEntry)
   {
      checkInitialization();
      if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
      {
         if (newPosition <= numberOfEntries)
            makeRoom(newPosition);
         list[newPosition] = newEntry;
         numberOfEntries++;
         ensureCapacity(); 
      }
      else
         throw new IndexOutOfBoundsException(
            "Given position of add's new entry is out of bounds.");
   }

   public T remove(int givenPosition)
   {
      checkInitialization();
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         assert !isEmpty();
         T result = list[givenPosition]; // Get entry to be removed
         if (givenPosition < numberOfEntries)
            removeGap(givenPosition);
         numberOfEntries--;
         return result;
      }
      else
         throw new IndexOutOfBoundsException(
            "Illegal position given to remove operation.");
   }   

   public T replace(int givenPosition, T newEntry)
   {
      checkInitialization();
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         assert !isEmpty();
         T originalEntry = list[givenPosition];
         list[givenPosition] = newEntry;
         return originalEntry;
      }
      else
         throw new IndexOutOfBoundsException(
            "Illegal position given to replace operation.");
   }

   public T getEntry(int givenPosition)
   {
      checkInitialization();
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         assert !isEmpty();
         return list[givenPosition];
      }
      else
         throw new IndexOutOfBoundsException(
            "Illegal position given to getEntry operation.");
   }

   public boolean contains(T anEntry)
   {
      checkInitialization();
      boolean found = false;
      int index = 1;
      while (!found && (index <= numberOfEntries))
      {
         if (anEntry.equals(list[index]))
            found = true;
         index++;
      }
      return found;
   } 

   public void add(T newEntry)
   {
      checkInitialization();
      list[numberOfEntries + 1] = newEntry;
      numberOfEntries++;
      ensureCapacity();
   } 

   private void makeRoom(int newPosition)
   {
      int newIndex = newPosition;
      int lastIndex = numberOfEntries;
      for (int index = lastIndex; index >= newIndex; index--)
         list[index + 1] = list[index];
   }
}


