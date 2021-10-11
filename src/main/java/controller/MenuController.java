package controller;

import view.MainView;

/**
 * Controller for all things related to the menu.
 */
public class MenuController {
  MainView mainView = new MainView();
  BoatController bcontroller;
  MemberController mcontroller;

  /**
   * Creates the menu controller using the existing membercontroller + boatcontroller.

   * @param mcontroller Membercontroller used for displaying menus and working with the members.
   * 
   * @param bcontroller Boatcontroller used for displaying menus and working with the boats.
   */
  public MenuController(MemberController mcontroller, BoatController bcontroller) {
    this.bcontroller = bcontroller;
    this.mcontroller = mcontroller;
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
        bcontroller.printMenu();
        boatChoice(mainView.getChoice());
        break;
      case 3:
        System.exit(0);
        break;
      default: 
        break;
    }
  }

   private void boatChoice(int choice) {
     String temp;
     switch (choice) {
       case 1:
         bcontroller.addBoat();
         break;
       case 2:
         bcontroller.deleteBoat();
         break;
       case 3:
         break;
       case 4:
         System.exit(0);
     }
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
        printMain();
        break;
      case 6:
        System.exit(0);
        break;
      default:
        break;
    }
    memberChoice();
  }
}
