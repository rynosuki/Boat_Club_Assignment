package view;

import java.util.Scanner;

/**
 * Used to handle inputs for easier usage.
 */
public class InputHandler {
  private Scanner sc = new Scanner(System.in, "UTF-8");

  public String getInputString() {
    try {
      return sc.nextLine();
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }
}
