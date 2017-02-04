/* ===========================================================================
   $File: Test LinkedBag.java $
   $Date: Feb 3, 2017 $
   $Revision: 1.0 $
   $Creator: Ross Capdeville $
   $Notice: (C) Copyright 2017 by Ross Capdeville. All Rights Reserved. $
   =========================================================================== */

package linkedBag;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.logging.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestLinkedBag {

   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   @Test
   public void testTests()
   {
      assertEquals(true, true);
   }
   
   @Test
   public void testAdd()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      mybag.add(1);
      assertEquals(mybag.contains(1), true);
   }

   @Test
   public void testRemove()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      mybag.add(1);
      assertEquals(mybag.contains(1), true);
      mybag.remove(1);
      assertEquals(mybag.contains(1), false);
   }

   @Test
   public void testEmpty()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      assertEquals(mybag.isEmpty(), true);
      mybag.add(1);
      assertEquals(mybag.isEmpty(), false);
   }

   @Test
   public void testFrequency()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      assertEquals(mybag.getFrequencyOf(7), 0);
      mybag.add(7);
      assertEquals(mybag.getFrequencyOf(7), 1);
      mybag.add(7);
      assertEquals(mybag.getFrequencyOf(7), 2);
   }
 
   @Test
   public void testClear()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      mybag.add(7);
      mybag.add(17);
      mybag.add(123);
      mybag.clear();
      assertEquals(mybag.getCurrentSize(), 0);
   }

   @Test
   public void testCurrentSizeWithAdd()
   {
      int i;
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      assertEquals(mybag.getCurrentSize(), 0);
      for(i = 1; i < ThreadLocalRandom.current().nextInt(10, 100); ++i)
      {
         mybag.add(i);
         assertEquals(mybag.getCurrentSize(), i);
      }
   }

   @Test
   public void testVarious()
   {
      int i, j;
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      for(i = 1; i < 20; ++i)
      {
         mybag.add(i);
         for(j = 1; j <= i; ++j)
         {
            assertEquals(mybag.contains(i), true);
            assertEquals(mybag.contains(i+1), false);
         }
      }
      assertEquals(mybag.getCurrentSize(), 19);
      mybag.remove(17);
      assertEquals(mybag.contains(17), false);
      mybag.add(17);
      mybag.add(17);
      assertEquals(mybag.contains(17), true);
      mybag.remove(17);
      assertEquals(mybag.contains(17), true);
      mybag.remove(17);
      assertEquals(mybag.contains(17), false);
   }

   @Test
   public void testString()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      mybag.add(1);
      mybag.add(2);
      mybag.add(3);
      assertEquals(mybag.toString(),"3 -> 2 -> 1 -> null");
   }

   @Test
   public void testHasDuplicates()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      mybag.add(1);
      mybag.add(2);
      mybag.add(3);
      assertEquals(mybag.hasDuplicateEntries(), false);
      mybag.add(3);
      assertEquals(mybag.hasDuplicateEntries(), true);
      mybag.remove(3);
      assertEquals(mybag.hasDuplicateEntries(), false);
      mybag.add(1);
      assertEquals(mybag.hasDuplicateEntries(), true);
      mybag.remove(1);
      assertEquals(mybag.hasDuplicateEntries(), false);
   }

   @Test
   public void testBagEquals()
   {
      LinkedBag<Integer> mybag1 = new LinkedBag<Integer>();
      LinkedBag<Integer> mybag2 = new LinkedBag<Integer>();
      mybag1.add(1);
      mybag1.add(2);
      mybag1.add(3);
      mybag2.add(1);
      mybag2.add(2);
      mybag2.add(3);
      assertEquals(mybag1.equals(mybag2), true);
   }

   // public void main(String[] args)
   // {
   //    testAdd();
   //    testRemove();
   //    testEmpty();
   //    testFrequency();
   //    testVarious();
   //    testReduce();
   // }

   // public void assertEquals(Object value1, Object value2)
   // {
   //    StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
   //    StackTraceElement e = stacktrace[2];
   //    String methodName = e.getMethodName();
   //    String result;
   //    if (value1 == value2)
   //       result="PASS";
   //    else
   //       result="FAIL";
   //    System.out.println(e.getMethodName() + ": " + value1 + " == " + value2 + ": " + result);
   // }


}


