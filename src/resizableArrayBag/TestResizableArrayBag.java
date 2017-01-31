package resizableArrayBag;

//import static org.junit.Assert.*;
//import org.junit.Test;
import java.util.logging.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestResizableArrayBag {

   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   public static void main(String[] args)
   {
      TestResizableArrayBag.testAdd();
      this.testRemove();
      this.testEmpty();
      this.testFrequency();
      this.testVarious();
      this.testReduce();
   }

   public void assertEquals(Object value1, Object value2)
   {
      StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
      StackTraceElement e = stacktrace[2];
      String methodName = e.getMethodName();
      lmsg.info(e.getMethodName() + ": " + value1==value2 ? "PASS" : "FAIL");
   }

//   @Test
   public void testAdd()
   {
      ResizableArrayBag<Integer> mybag = new ResizableArrayBag<Integer>();
      mybag.add(1);
      assertEquals(mybag.contains(1), true);
   }

//   @Test
   public void testRemove()
   {
      ResizableArrayBag<Integer> mybag = new ResizableArrayBag<Integer>();
      mybag.add(1);
      assertEquals(mybag.contains(1), true);
      mybag.remove(1);
      assertEquals(mybag.contains(1), false);
   }

//   @Test
   public void testEmpty()
   {
      ResizableArrayBag<Integer> mybag = new ResizableArrayBag<Integer>();
      assertEquals(mybag.isEmpty(), true);
      mybag.add(1);
      assertEquals(mybag.isEmpty(), false);
   }

//   @Test
   public void testFrequency()
   {
      ResizableArrayBag<Integer> mybag = new ResizableArrayBag<Integer>();
      assertEquals(mybag.getFrequencyOf(7), 0);
      mybag.add(7);
      assertEquals(mybag.getFrequencyOf(7), 1);
      mybag.add(7);
      assertEquals(mybag.getFrequencyOf(7), 2);
   }
   
//   @Test
   public void testClear()
   {
      ResizableArrayBag<Integer> mybag = new ResizableArrayBag<Integer>();
      mybag.add(7);
      mybag.add(17);
      mybag.add(123);
      mybag.clear();
      assertEquals(mybag.getCurrentSize(), 0);
   }

//   @Test
   public void testCurrentSizeWithAdd()
   {
      int i;
      ResizableArrayBag<Integer> mybag = new ResizableArrayBag<Integer>(25);
      assertEquals(mybag.getCurrentSize(), 0);
      for(i = 1; i < ThreadLocalRandom.current().nextInt(10, 100); ++i)
      {
         mybag.add(i);
         assertEquals(mybag.getCurrentSize(), i);
      }
   }

//   @Test
   public void testVarious()
   {
      int i, j;
      ResizableArrayBag<Integer> mybag = new ResizableArrayBag<Integer>();
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

//   @Test
   public void testReduce() {
      int i,j;
      ResizableArrayBag<Integer> mybag = new ResizableArrayBag<Integer>();

      for(i = 1; i < 100; ++i)
         mybag.add(i);

      for(i = 100; i > 1; --i)
      {
         mybag.remove(i);
         assertEquals(mybag.contains(i), false);
         for (j = 1; j < i; ++j) 
            assertEquals(mybag.contains(j), true); 
      }
      
   }
}

