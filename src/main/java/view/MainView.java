package view;

public class MainView implements View {
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
}
