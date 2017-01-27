package resizableArrayBag;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.logging.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestResizableArrayBag {

   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   @Test
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

   @Test

   public void testAddRemoveContains()
   {
      int i;
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
      mybag.remove(17);
      assertEquals(mybag.contains(17), false);
   }
   @Test
   public void testStub()
   {
      assertEquals(1,1);
   }
}
