package view;

/**
 * View for handling user inputs and user interface for Main Menu.
 */
public class MainViewSwedish implements View {
  InputHandler input = new InputHandler();

  private static final String member = "1";
  private static final String boat = "2";
  private static final String quit = "3";

  public MainViewSwedish() {
  }

  @Override
  public void printView() {
    System.out.println("Huvudmeny - Start");
    System.out.println("--------------------");
    System.out.println("1. Medlemmar");
    System.out.println("2. Båtar");
    System.out.println("3. Avsluta");
  }

  /**
   * Get menu choice.
   * @return
   */
  public MenuChoice getMenuChoice() {
    switch (input.getInputString()) {
      case member:
        return MenuChoice.MEMBER;
      case boat:
        return MenuChoice.BOAT;
      case quit:
        return MenuChoice.QUIT;
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
