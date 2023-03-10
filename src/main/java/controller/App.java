package controller;

import model.LoadHandler;

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
    LoadHandler loadHandler = new LoadHandler();
    MemberController mcontroller = new MemberController(loadHandler.getMemberList());
    BoatController bcontroller = new BoatController();

    new MenuController(mcontroller, bcontroller);
  }
}
