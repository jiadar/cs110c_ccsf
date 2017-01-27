package resizableArrayBag;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestResizableArrayBag {

   @Test
   public void testCurrentSize
   {
      int[] contents = new int[15]
         for(i=0; i<15; i++) {
            contents[i]=i;
         }
      ResizableArrayBag mybag1 = new ResizableArrayBag(contents);
      ResizableArrayBag mybag2 = new ResizeableArrayBag();
      ResizableArrayBag mybag2 = new ResizeableArrayBag(125);
      assertEquals(mybag1.getCurrentSize(), 15);
      assertEquals(mybag1.getCurrentSize(), 25);
      assertEquals(mybag1.getCurrentSize(), 125);
   }

   @Test
   public void testStub()
   {
      assertEquals(1,1);
   }
}
