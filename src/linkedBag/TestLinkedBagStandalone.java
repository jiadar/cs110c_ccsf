/* ===========================================================================
   $File: Test LinkedBag.java $
   $Date: Feb 3, 2017 $
   $Revision: 1.0 $
   $Creator: Ross Capdeville $
   $Notice: (C) Copyright 2017 by Ross Capdeville. All Rights Reserved. $
   =========================================================================== */

package linkedBag;
import java.util.logging.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestLinkedBagStandalone {

   private static tests=0;
   private static passes=0;
   private static fails=0;
   
   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   public static void testTests()
   {
      assertEquals(true, true);
   }
   
   public static void testAdd()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      mybag.add(1);
      assertEquals(mybag.contains(1), true);
   }

   public static void testRemove()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      mybag.add(1);
      assertEquals(mybag.contains(1), true);
      mybag.remove(1);
      assertEquals(mybag.contains(1), false);
   }

   public static void testEmpty()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      assertEquals(mybag.isEmpty(), true);
      mybag.add(1);
      assertEquals(mybag.isEmpty(), false);
   }

   public static void testFrequency()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      assertEquals(mybag.getFrequencyOf(7), 0);
      mybag.add(7);
      assertEquals(mybag.getFrequencyOf(7), 1);
      mybag.add(7);
      assertEquals(mybag.getFrequencyOf(7), 2);
   }
 
   public static void testClear()
   {
      LinkedBag<Integer> mybag = new LinkedBag<Integer>();
      mybag.add(7);
      mybag.add(17);
      mybag.add(123);
      mybag.clear();
      assertEquals(mybag.getCurrentSize(), 0);
   }

   public static void testCurrentSizeWithAdd()
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

   public static void testVarious()
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

   public static void testHasDuplicates()
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

   public static void testBagEquals1()
   {
      LinkedBag<Integer> mybag1 = new LinkedBag<Integer>();
      LinkedBag<Integer> mybag2 = new LinkedBag<Integer>();

      assertEquals(mybag1.equals(mybag2), true);

      mybag1.add(2);
      mybag1.add(2);
      mybag1.add(1);
      mybag2.add(2);
      mybag2.add(2);
      mybag2.add(1);
      assertEquals(mybag1.equals(mybag2), true);

      mybag2.remove(1);
      assertEquals(mybag1.equals(mybag2), false);

      mybag2.add(1);
      assertEquals(mybag1.equals(mybag2), true);
   }

   public static void testBagEquals2()
   {
      LinkedBag<Integer> mybag1 = new LinkedBag<Integer>();
      LinkedBag<Integer> mybag2 = new LinkedBag<Integer>();
      mybag1.add(1);
      mybag1.add(1);
      mybag1.add(1);
      mybag1.add(2);
      mybag1.add(3);
      mybag1.add(1);

      mybag2.add(3);
      mybag2.add(1);
      mybag2.add(1);
      mybag2.add(2);
      mybag2.add(1);
      assertEquals(mybag1.equals(mybag2), false);

      mybag1.remove(1);
      assertEquals(mybag1.equals(mybag2), true);
   
   }

   public static void assertEquals(Comparable value1, Comparable value2)
   {
      ++tests;
      StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
      StackTraceElement e = stacktrace[2];
      String methodName = e.getMethodName();
      String result;
      if (value1.equals(value2))
      {
         result="PASS";
         ++passes;
      }
      else
      {
         result="FAIL";
         ++fails;
      }
      System.out.println("Test #" + tests + " " + e.getMethodName() + ": " + value1 +
                         " == " + value2 + ": " + result);
   }



public static void main(String[] args) {
testTests();
testAdd();
testRemove();
testEmpty();
testFrequency();
testClear();
testCurrentSizeWithAdd();
testVarious();
testHasDuplicates();
testBagEquals1();
testBagEquals2();
System.out.println("Total Tests: " + tests);
System.out.println("Tests Passed: " + passes);
System.out.println("Tests Failed: " + fails);
}}
