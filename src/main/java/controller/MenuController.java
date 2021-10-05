package controller;

import view.MainView;

public class MenuController {
  MainView mView = new MainView();
  BoatController bcontroller;
  MemberController mcontroller;

  public MenuController(MemberController mcontroller, BoatController bcontroller) {
    this.bcontroller = bcontroller;
    this.mcontroller = mcontroller;
    printMain();
  }
  
  private void printMain() {
    mView.printView();
    int choice = mView.getChoice();
    switch (choice) {
      case 1:
        memberChoice();
      case 2:
        bcontroller.printMenu();
        //boatChoice(mView.getChoice());
        break;
      case 3:
        System.exit(0);
    }
  }

  // private void boatChoice(int choice) {
  //   String temp;
  //   switch (choice) {
  //     case 1:
  //       bcontroller.printMessage("Enter boat: (BoatID,Type,Length)");
  //       temp = input.getInputString();
  //       String[] value = temp.split(",");
  //       //bcontroller.addBoat(Integer.parseInt(value[0]), value[1], Integer.parseInt(value[2]);
  //       break;
  //     case 2:
  //       bcontroller.printMessage("Enter boatID for deletion:");
  //       temp = input.getInputString();
  //       bcontroller.printMessage("Do you really want to delete? Y/N");
  //       if (input.getInputString().equals("Y")){
  //         //bcontroller.deleteBoat(Integer.parseInt(temp));
  //       }
  //       break;
  //     case 3:
  //       break;
  //     case 4:
  //       System.exit(0);
  //   }
  // }

  private void memberChoice() {
    mcontroller.printMenu();
    int choice = mView.getChoice();
    
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
      case 5:
        printMain();
      case 6:
        System.exit(0);
    }
    memberChoice();
  }
}
