package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class SimpleTest {

  @Test
  public void testMessageLengthGreaterThanZero() {
    Boat sut = new Boat(0, null, 0);

    assertTrue(sut.getLength() > 0, "Message length should be greater that zero");
  }
  
}
