package stack;
import java.util.logging.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestStackStandalone {

   private static int tests=0;
   private static int passes=0;
   private static int fails=0;
   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   public static void testLinkedStack() {
      Stack<Integer> s = new LinkedStack<Integer>();
      Integer d;
      assertEquals(s.peek(), null);

      s.push(1);
      s.push(2);
      s.push(3);
      assertEquals(s.peek(), (Integer) 3);
      assertEquals(s.peek2(), (Integer) 2);

      d = s.pop();
      assertEquals(d, (Integer) 3);
      assertEquals(s.peek(), (Integer) 2);
      assertEquals(s.peek2(), (Integer) 1);
      assertEquals(s.isEmpty(), false);
      assertEquals(s.toString(), "2, 1");

      d = s.pop();
      d = s.pop();
      assertEquals(s.isEmpty(), true);

      s.push(1);
      s.clear();
      assertEquals(s.isEmpty(), true);

      s.push(1);
      s.push(2);
      s.push(3);
      s.remove(2);
      assertEquals(s.peek(), (Integer) 1);

      s.pushAll(new Integer[]{2, 3, 4});
      assertEquals(s.toString(), "4, 3, 2, 1");

      s.remove(4);
      assertEquals(s.isEmpty(), true);
   }      

   public static void testArrayStack()
   {
      Stack<Integer> s = new ArrayStack<Integer>();
      Integer d;
      assertEquals(s.peek(), null);

      s.push(1);
      s.push(2);
      s.push(3);
      assertEquals(s.peek(), (Integer) 3);
      assertEquals(s.peek2(), (Integer) 2);

      d = s.pop();
      assertEquals(d, (Integer) 3);
      assertEquals(s.peek(), (Integer) 2);
      assertEquals(s.peek2(), (Integer) 1);
      assertEquals(s.isEmpty(), false);
      assertEquals(s.toString(), "2, 1");

      d = s.pop();
      d = s.pop();
      assertEquals(s.isEmpty(), true);

      s.push(1);
      s.clear();
      assertEquals(s.isEmpty(), true);

      s.push(1);
      s.push(2);
      s.push(3);
      s.remove(2);
      assertEquals(s.peek(), (Integer) 1);

   }      

   public static void testArrayPushAll()
   {
      Stack<Integer> s = new ArrayStack<Integer>();
      s.push(1);
      s.pushAll(new Integer[]{2, 3, 4});
      assertEquals(s.toString(), "5, 4, 3, 2, 1");
      s.remove(4);
      assertEquals(s.isEmpty(), true);
      
   }
   public static void testTests()
   {
      assertEquals(true, true);
   }

   public static void assertEquals(Comparable value1, Comparable value2)
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

   
public static void main(String[] args) {
testLinkedStack();
testArrayStack();
testArrayPushAll();
testTests();
System.out.println("Total Tests: " + tests);
System.out.println("Tests Passed: " + passes);
System.out.println("Tests Failed: " + fails);
}}
