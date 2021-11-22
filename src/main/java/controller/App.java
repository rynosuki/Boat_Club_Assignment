package controller;

import model.LoadHandler;
import model.MemberRegister;
import view.MainView;
import view.View.MenuChoice;

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
    App g = new App();
    g.start();
  }

  private void start() {
    LoadHandler lhandler = new LoadHandler();
    this.mcontroller = new MemberController(new MemberRegister(lhandler.getMemberList()));
    this.bcontroller = new BoatController();
    this.mainView = new MainView();

    printMain();
  }

  private void printMain() {
    mainView.printView();
    MenuChoice choice = mainView.getMenuChoice();
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
      mcontroller.addBoatToMember(bcontroller.addBoat());
      break;
    case DEL:
      mcontroller.deleteBoat(bcontroller.chooseBoat(mcontroller.getMemberBoats()));
      break;
    case CHANGE:
      bcontroller.changeBoat(mcontroller.getMemberBoats());
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
