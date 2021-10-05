package view;

/**
 * Handles the user inputs and user interface for the boat.
 */
public class BoatView implements View {
  /**
   * Print the menu.
   */
  public void printView() {
    System.out.println("Main Menu - Boat");
    System.out.println("--------------------");
    System.out.println("1. Add Boat");
    System.out.println("2. Remove Boat");
    System.out.println("3. Change Boat");
  }

  public void printMessage(String message) {
    System.out.println(message);
  }
}
