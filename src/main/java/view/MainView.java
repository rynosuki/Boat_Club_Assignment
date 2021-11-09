package view;

/**
 * View for handling user inputs and user interface for Main Menu.
 */
public class MainView implements View {
  InputHandler input = new InputHandler();

  private static final String member = "1";
  private static final String boat = "2";
  private static final String quit = "3";

  public MainView() {
  }

  @Override
  public void printView() {
    System.out.println("Main Menu - Main");
    System.out.println("--------------------");
    System.out.println("1. Member Menu");
    System.out.println("2. Boat Menu");
    System.out.println("3. Quit");
  }

  public menuChoice getMenuChoice() {
    switch (input.getInputString()) {
    case member:
      return menuChoice.MEMBER;
    case boat:
      return menuChoice.BOAT;
    case quit:
      return menuChoice.QUIT;
    default:
      return null;
    }
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

  public int getChoice() {
    return Integer.parseInt(input.getInputString());
  }
}
