package stack;
import java.util.logging.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestStackStandalone {

   private static int tests=0;
   private static int passes=0;
   private static int fails=0;
   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   public static void testTests()
   {
      assertEquals(true, true);
   }

}
public static void main(String[] args) {
System.out.println("Total Tests: " + tests);
System.out.println("Tests Passed: " + passes);
System.out.println("Tests Failed: " + fails);
}}
