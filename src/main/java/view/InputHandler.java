package view;

import java.util.Scanner;

/**
 * Used to handle inputs for easier usage.
 */
public class InputHandler {
  private Scanner sc = new Scanner(System.in, "UTF-8");

  /**
   * Get input as string.
   * @return .
   */
  public String getInputString() {
    try {
      return sc.nextLine();
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  /**
   * Get input as Double.
   * @return .
   */
  public double getInputDouble() {
    try {
      return sc.nextDouble();
    } catch (Exception e) {
      // TODO: handle exception
    }
    return 0;
  }
}
