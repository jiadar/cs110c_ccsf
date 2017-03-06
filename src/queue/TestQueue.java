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

   @Test
   public void testNewInstance()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      assertEquals(q.isEmpty(), true);
      assertEquals(q.toString(), "empty");
   }

   @Test
   public void testEnqueue()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      assertEquals(q.toString(), "1, 2, 3, next");
   }

   @Test
   public void testGetFront()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      q.enqueue(1);
      assertEquals((Integer) q.getFront(), (Integer) 1);
      q.enqueue(2);
      assertEquals((Integer) q.getFront(), (Integer) 1);
   }

   @Test
   public void testDequeue()
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
   public void testClear()
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      q.enqueue(1);
      q.enqueue(2);
      assertEquals(q.toString(), "1, 2, next");
      q.clear();
      assertEquals(q.toString(), "empty");      
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
