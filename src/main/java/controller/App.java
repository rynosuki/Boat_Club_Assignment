package controller;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    // adapt to start the application in your way
    view.MemberView view = new view.MemberView();
    InputHandler input = new InputHandler();
    MemberController controller = new MemberController(view, input);
    controller.createMember("Robin", 3231897, 1);
    controller.getMember("Robin");
    System.out.println(controller.getMemberName());
    controller.createBoatAndAdd(1, "Sailboat", 150);
    System.out.println(controller.getBoat().getLength()); 

    controller.printMenu();
  }
}
