/* ===========================================================================
   $File: $
   $Date: $
   $Revision: $
   $Creator: Ross Capdeville $
   $Notice: (C) Copyright 2017 by Ross Capdeville. All Rights Reserved. $
   =========================================================================== */

package queue;

public interface QueueInterface<T>
{
   // Adds new entry to the back of the queue
   public void enqueue(T entry);

   // Removes and returns the entry at the front of hte queue
   // Empty queue expection if the queue is empty before operations
   public T dequeue();

   //Get the etnry at the front of the queue
   public T getFront();

   //Detect if the queue is empty
   public boolean isEmpty();

   //Remove all elements from the queue
   public void clear();
   
}
