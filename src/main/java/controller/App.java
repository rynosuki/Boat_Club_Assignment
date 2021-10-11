package controller;

import model.LoadHandler;
import view.MainView;

/**
 * Responsible for staring the application.
 */
public class App {
  private MemberController mcontroller;
  private BoatController bcontroller;
  private MainView mainView;

  /**
   * Application starting point.
   * 
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    // adapt to start the application in your way
    // LoadHandler loadHandler = new LoadHandler();
    // this.mcontroller = new MemberController(loadHandler.getMemberList());
    // this.bcontroller = new BoatController();
    // this.mainView = new MainView();

    // printMain();
    App g = new App();
    g.start();
  }

  private void start() {
    LoadHandler lhandler = new LoadHandler();
    this.mcontroller = new MemberController(lhandler.getMemberList());
    this.bcontroller = new BoatController();
    this.mainView = new MainView();

    printMain();
  }

  private void printMain() {
    mainView.printView();
    int choice = mainView.getChoice();
    switch (choice) {
      case 1:
        memberChoice();
        break;
      case 2:
        boatChoice();
        break;
      case 3:
        System.exit(0);
        break;
      default:
        break;
    }
  }

  private void boatChoice() {
    bcontroller.printMenu();
    int choice = mainView.getChoice();

    switch (choice) {
      case 1:
        bcontroller.addBoat();
        break;
      case 2:
        mcontroller.setCurrentMember();
        mcontroller.deleteBoat(bcontroller.chooseBoat(mcontroller.getMemberBoats()));
        break;
      case 3:
        break;
      case 4:
        printMain();
    }
    boatChoice();
  }

  private void memberChoice() {
    mcontroller.printMenu();
    int choice = mainView.getChoice();

    switch (choice) {
      case 1:
        mcontroller.addMember();
        break;
      case 2:
        mcontroller.deleteMember();
        break;
      case 3:
        mcontroller.changeMember();
        break;
      case 4:
        mcontroller.overviewMember();
        break;
      case 5:
        break;
      case 6:
        printMain();
        break;
      default:
        break;
    }
    memberChoice();
  }
}
