package controller;

import model.MemberID;
import view.MainView;

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
    MemberController mcontroller = new MemberController(view, input);
    BoatController bcontroller = new BoatController();
    mcontroller.addMember("Nicklas", "15326236");
    mcontroller.addMember("Pontus", "518966926");
    mcontroller.addMember("Adam", "51351635");
    mcontroller.addMember("Emelie", "15316746");
    mcontroller.addMember("Edin", "64378383");
    mcontroller.addMember("Alfons", "51612131");
    mcontroller.addMember("Elisa", "21516437");
    mcontroller.addMember("Anton", "6136278");
    mcontroller.addMember("Greger", "1624763572");
    mcontroller.addMember("Matias", "634738999");
    mcontroller.addMember("Robin", "199503231897");
    mcontroller.getMember("Robin");
    mcontroller.createBoatAndAdd(1, "Sailboat", 150);
    System.out.println(mcontroller.getBoat().getLength()); 

    MenuController menuController = new MenuController(input, mcontroller, bcontroller);
  }
}
