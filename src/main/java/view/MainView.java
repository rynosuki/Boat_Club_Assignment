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
    System.out.println(member + ". Member Menu");
    System.out.println(boat + ". Boat Menu");
    System.out.println(quit + ". Quit");
  }

  /**
   * Get menu choice.
   * 
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

  public void printErrorMessage(ErrorMessage message) {

  }

  public int getChoice() {
    return Integer.parseInt(input.getInputString());
  }
}
