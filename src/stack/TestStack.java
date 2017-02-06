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
   public void testTests()
   {
      assertEquals(true, true);
   }

}
