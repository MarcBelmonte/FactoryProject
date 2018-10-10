package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import org.junit.*;

public class FactoryTest {

   final static Logger log = Logger.getLogger(Factory.class.getName());
   @Before
   public void setUp() {

   }

   @Test
   public void testFactory(){


      Command c = Factory.getInstance().getCommand("C1"); // Classloader (C1)
      Assert.assertEquals("C1",c.execute());

      c = Factory.getInstance().getCommand("C1");  // Cache (C1)
      Assert.assertEquals("C1",c.execute());

   }

}
