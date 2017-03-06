package queue;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.logging.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestQueue {

   private static int tests=0;
   private static int passes=0;
   private static int fails=0;
   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   // Start of Array Tests
   
   @Test
   public void testArrayNewInstance()
   {
      QueueInterface<Integer> q = new ArrayQueue<Integer>();
      assertEquals(q.isEmpty(), true);
   }

   @Test
   public void testArrayEnqueue()
   {
      QueueInterface<Integer> q = new ArrayQueue<Integer>();
      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      assertEquals(q.toString().substring(0,8), "[1, 2, 3");
   }

   @Test
   public void testArrayGetFront()
   {
      QueueInterface<Integer> q = new ArrayQueue<Integer>();
      q.enqueue(1);
      assertEquals((Integer) q.getFront(), (Integer) 1);
      q.enqueue(2);
      assertEquals((Integer) q.getFront(), (Integer) 1);
   }

   @Test
   public void testArrayDequeue()
   {
      QueueInterface<Integer> q = new ArrayQueue<Integer>();
      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      q.enqueue(4);
      assertEquals((Integer) q.getFront(), (Integer) 1);
      q.dequeue();
      assertEquals((Integer) q.getFront(), (Integer) 2);
      q.dequeue();
      assertEquals((Integer) q.getFront(), (Integer) 3);
      q.dequeue();
      assertEquals((Integer) q.getFront(), (Integer) 4);
      q.dequeue();
      assertEquals(q.isEmpty(), true);
   }

   @Test
   public void testArrayClear()
   {
      QueueInterface<Integer> q = new ArrayQueue<Integer>();
      q.enqueue(1);
      q.enqueue(2);
      assertEquals(q.toString().substring(0,5), "[1, 2");
      q.clear();
      assertEquals(q.isEmpty(), true);      
   }

    @Test
    public void testArraySplice()
    {
       QueueInterface<Integer> q1 = new ArrayQueue<Integer>();
       QueueInterface<Integer> q2 = new ArrayQueue<Integer>();
       q1.enqueue(1);
       q1.enqueue(2);
       q1.enqueue(3);
       q2.enqueue(4);
       q2.enqueue(5);
       q2.enqueue(6);
       q1.splice(q2);
       assertEquals(q1.toString().substring(0,17),"[1, 2, 3, 4, 5, 6");
    }

   @Test
   public void testArraySplice2OneEmpty()
   {
      ArrayQueue<Integer> q1 = new ArrayQueue<Integer>();
      ArrayQueue<Integer> q2 = new ArrayQueue<Integer>();
      q2.enqueue(4);
      q2.enqueue(5);
      q2.enqueue(6);
      q1.splice2(q2);
      assertEquals(q1.toString().substring(0,8),"[4, 5, 6");
   }

   @Test
   public void testArraySplice2()
   {
      ArrayQueue<Integer> q1 = new ArrayQueue<Integer>();
      ArrayQueue<Integer> q2 = new ArrayQueue<Integer>();
      q1.enqueue(1);
      q1.enqueue(2);
      q1.enqueue(3);
      assertEquals(q1.toString().substring(0,8),"[1, 2, 3");
      q2.enqueue(4);
      q2.enqueue(5);
      q2.enqueue(6);
      q1.splice2(q2);
      assertEquals(q1.toString().substring(0,17),"[1, 2, 3, 4, 5, 6");
   }

   // Start of Linked Tests
   
   @Test
   public void testLinkedNewInstance()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      assertEquals(q.isEmpty(), true);
      assertEquals(q.toString(), "empty");
   }

   @Test
   public void testLinkedEnqueue()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      assertEquals(q.toString(), "1, 2, 3, next");
   }

   @Test
   public void testLinkedGetFront()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      q.enqueue(1);
      assertEquals((Integer) q.getFront(), (Integer) 1);
      q.enqueue(2);
      assertEquals((Integer) q.getFront(), (Integer) 1);
   }

   @Test
   public void testLinkedDequeue()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      q.enqueue(1);
      assertEquals(q.toString(), "1, next");
      q.enqueue(2);
      assertEquals(q.toString(), "1, 2, next");
      q.enqueue(3);
      assertEquals(q.toString(), "1, 2, 3, next");
      q.enqueue(4);
      assertEquals(q.toString(), "1, 2, 3, 4, next");
      q.dequeue();
      assertEquals(q.toString(), "2, 3, 4, next, free");
      q.dequeue();
      assertEquals(q.toString(), "3, 4, next, free, free");
      q.dequeue();
      assertEquals(q.toString(), "4, next, free, free, free");
      q.dequeue();
      assertEquals(q.toString(), "empty");
   }

   @Test
   public void testLinkedClear()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      q.enqueue(1);
      q.enqueue(2);
      assertEquals(q.toString(), "1, 2, next");
      q.clear();
      assertEquals(q.toString(), "empty");      
   }

   @Test
   public void testLinkedSplice()
   {
      QueueInterface<Integer> q1 = new LinkedQueue<Integer>();
      QueueInterface<Integer> q2 = new LinkedQueue<Integer>();
      q1.enqueue(1);
      q1.enqueue(2);
      q1.enqueue(3);
      q2.enqueue(4);
      q2.enqueue(5);
      q2.enqueue(6);
      q1.splice(q2);
      assertEquals(q1.toString(),"1, 2, 3, 4, 5, 6, next");
   }

   @Test
   public void testLinkedSplice2Empty()
   {
      LinkedQueue<Integer> q1 = new LinkedQueue<Integer>();
      LinkedQueue<Integer> q2 = new LinkedQueue<Integer>();
      q2.enqueue(4);
      q2.enqueue(5);
      q2.enqueue(6);
      q1.splice2(q2);
      assertEquals(q1.toString(),"4, 5, 6, next");
      q1.clear();
      q2.clear();
   }      

   @Test
   public void testLinkedSplice2()
   {
      LinkedQueue<Integer> q1 = new LinkedQueue<Integer>();
      LinkedQueue<Integer> q2 = new LinkedQueue<Integer>();
      q1.enqueue(1);
      q1.enqueue(2);
      q1.enqueue(3);
      q2.enqueue(4);
      q2.enqueue(5);
      q2.enqueue(6);
      q1.splice2(q2);
      assertEquals(q1.toString(),"1, 2, 3, 4, 5, 6, next");
   }

   public void assertEqualsSEDMe(Comparable value1, Comparable value2)
   {
      ++tests;
      StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
      StackTraceElement e = stacktrace[2];
      String methodName = e.getMethodName();
      String result;
      if (value1 == null && value2 == null)
      {
         result="PASS";
         ++passes;
      }
      else if (value1.equals(value2))
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

   
} //end
