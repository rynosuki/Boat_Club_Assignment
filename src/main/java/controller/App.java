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
    mcontroller.addMember("Nicklas", 1251614, new MemberID().generateMemberID("Nicklas", mcontroller.members));
    mcontroller.addMember("Pontus", 6163634, new MemberID().generateMemberID("Pontus", mcontroller.members));
    mcontroller.addMember("Adam", 4262462, new MemberID().generateMemberID("Adam", mcontroller.members));
    mcontroller.addMember("Emelie", 151596, new MemberID().generateMemberID("Emelie", mcontroller.members));
    mcontroller.addMember("Edin", 5432958, new MemberID().generateMemberID("Edin", mcontroller.members));
    mcontroller.addMember("Alfons", 5139695, new MemberID().generateMemberID("Alfons", mcontroller.members));
    mcontroller.addMember("Elisa", 2405862, new MemberID().generateMemberID("Elisa", mcontroller.members));
    mcontroller.addMember("Anton", 15938513, new MemberID().generateMemberID("Anton", mcontroller.members));
    mcontroller.addMember("Greger", 40396306, new MemberID().generateMemberID("Greger", mcontroller.members));
    mcontroller.addMember("Matias", 49235633, new MemberID().generateMemberID("Matias", mcontroller.members));
    mcontroller.addMember("Robin", 3231897, new MemberID().generateMemberID("Robin", mcontroller.members));
    mcontroller.getMember("Robin");
    System.out.println(mcontroller.getMemberID());
    System.out.println(mcontroller.getMemberName());
    mcontroller.createBoatAndAdd(1, "Sailboat", 150);
    System.out.println(mcontroller.getBoat().getLength()); 

    MenuController menuController = new MenuController(input, mcontroller, bcontroller);
  }
}
