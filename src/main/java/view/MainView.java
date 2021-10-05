package view;

public class MainView implements View {
  InputHandler input = new InputHandler();

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

  public int getChoice() {
    return Integer.parseInt(input.getInputString()); 
  }
}
