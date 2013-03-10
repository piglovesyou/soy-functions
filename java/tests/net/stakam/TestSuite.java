package net.stakam;

import net.stakam.soy.*;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
 
public class TestSuite {
  public static void main(String[] args)
  {
    JUnitCore runner = new JUnitCore();
    runner.addListener(new TextListener(System.out));
    runner.run(
            SubstringTest.class); 
  }
}
