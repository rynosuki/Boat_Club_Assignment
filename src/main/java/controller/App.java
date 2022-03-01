package controller;

import model.LoadHandler;
// English view
import view.MainView;
// Swedish view
//import view.MainViewSwedish;
import view.View.MenuChoice;

/**
 * Responsible for staring the application.
 */
public class App {
  private MemberController mcontroller;
  private BoatController bcontroller;

  // English view
  private MainView mainView;

  // Swedish view
  // private MainViewSwedish mainView;

  /**
   * Application starting point.
   * 
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    App g = new App();
    g.start();
  }

  private void start() {
    LoadHandler lhandler = new LoadHandler();
    this.mcontroller = new MemberController(lhandler.getMemberRegistry());
    this.bcontroller = new BoatController(lhandler.getMemberRegistry());

    // English view
    this.mainView = new MainView();

    // Swedish view
    // this.mainView = new MainViewSwedish();

    printMain();
  }

  private void printMain() {
    mainView.printView();
    MenuChoice choice;
    do {
      choice = mainView.getMenuChoice();
    } while (choice == null);
    switch (choice) {
      case MEMBER:
        memberChoice();
        break;
      case BOAT:
        boatChoice();
        break;
      case QUIT:
        System.exit(0);
        break;
      default:
        break;
    }
  }

  private void boatChoice() {
    mcontroller.setCurrentMember();
    MenuChoice choice = bcontroller.printMenu();

    switch (choice) {
      case ADD:
        bcontroller.addBoat(mcontroller.getOwner());
        break;
      case DEL:
        mcontroller.deleteBoat(bcontroller.chooseBoat(mcontroller.getMemberBoats()));
        break;
      case CHANGE:
        bcontroller.changeBoat(mcontroller.getMemberBoats(), mcontroller.getmemberlist());
        break;
      case QUIT:
        printMain();
        break;
      default:
        break;
    }
    printMain();
  }

  private void memberChoice() {
    MenuChoice choice = mcontroller.printMenu();

    switch (choice) {
      case ADD:
        mcontroller.addMember();
        break;
      case DEL:
        mcontroller.deleteMember();
        break;
      case CHANGE:
        mcontroller.changeMember();
        break;
      case VIEW:
        mcontroller.overviewMember();
        break;
      case VERBOSE:
        mcontroller.verboseList();
        break;
      case COMPACT:
        mcontroller.compactList();
        break;
      case QUIT:
        printMain();
        break;
      default:
        break;
    }
    memberChoice();
  }
}
