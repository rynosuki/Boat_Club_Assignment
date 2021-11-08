package controller;

import model.LoadHandler;
import model.MemberRegister;
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
    mcontroller.setCurrentMember();
    bcontroller.printMenu();
    int choice = mainView.getChoice();

    switch (choice) {
    case 1:
      mcontroller.addBoatToMember(bcontroller.addBoat());
      break;
    case 2:
      mcontroller.deleteBoat(bcontroller.chooseBoat(mcontroller.getMemberBoats()));
      break;
    case 3:
      bcontroller.changeBoat(mcontroller.getMemberBoats());
      break;
    case 4:
      printMain();
      break;
    default:
      break;
    }
    printMain();
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
      mcontroller.verboseList();
      break;
    case 6:
      mcontroller.compactList();
      break;
    case 7:
      printMain();
      break;
    default:
      break;
    }
    memberChoice();
  }
}
