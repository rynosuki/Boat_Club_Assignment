package view;

/**
 * View for handling user inputs and user interface for Main Menu.
 */
public class MainViewSwedish implements View {
  InputHandler input = new InputHandler();

  private static final String member = "m";
  private static final String boat = "b";
  private static final String quit = "q";

  public MainViewSwedish() {
  }

  @Override
  public void printView() {
    System.out.println("Huvudmeny - Start");
    System.out.println("--------------------");
    System.out.println(member + ". Medlemmar");
    System.out.println(boat + ". Båtar");
    System.out.println(quit + ". Avsluta");
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

  public int getChoice() {
    return Integer.parseInt(input.getInputString());
  }

  @Override
  public void printErrorMessage(ErrorMessage message) {
  }
}
