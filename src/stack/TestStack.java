package stack;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.logging.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestStack {

   private static int tests=0;
   private static int passes=0;
   private static int fails=0;
   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   @Test
   public void testLinkedStack() {
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

   @Test
   public void testTests()
   {
      assertEquals(true, true);
   }

}