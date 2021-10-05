package view;

public class BoatView implements View {
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
