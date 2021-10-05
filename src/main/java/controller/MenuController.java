package controller;

import view.MainView;

public class MenuController {
  MainView mView = new MainView();
  InputHandler input;
  BoatController bcontroller;
  MemberController mcontroller;

  public MenuController(InputHandler input, MemberController mcontroller, BoatController bcontroller) {
    this.input = input;
    this.bcontroller = bcontroller;
    this.mcontroller = mcontroller;
    printMain();
  }
  
  private void printMain() {
    mView.printView();
    int choice = Integer.parseInt(input.getInputString());
    switch (choice) {
      case 1:
        mcontroller.printMenu();
        memberChoice(Integer.parseInt(input.getInputString()));
        break;
      case 2:
        bcontroller.printMenu();
        boatChoice(Integer.parseInt(input.getInputString()));
        break;
      case 3:
        System.exit(0);
    }
  }

  private void boatChoice(int choice) {
    String temp;
    switch (choice) {
      case 1:
        bcontroller.printMessage("Enter boat: (BoatID,Type,Length)");
        temp = input.getInputString();
        String[] value = temp.split(",");
        //bcontroller.addBoat(Integer.parseInt(value[0]), value[1], Integer.parseInt(value[2]);
        break;
      case 2:
        bcontroller.printMessage("Enter boatID for deletion:");
        temp = input.getInputString();
        bcontroller.printMessage("Do you really want to delete? Y/N");
        if (input.getInputString().equals("Y")){
          //bcontroller.deleteBoat(Integer.parseInt(temp));
        }
        break;
      case 3:
        break;
      case 4:
        System.exit(0);
    }
  }

  private void memberChoice(int choice) {
    String temp;
    switch (choice) {
      case 1:
        mcontroller.printMessage("Enter the member data: (name,personalnumber");
        temp = input.getInputString();
        String[] tempList = temp.split(",");
        boolean c = mcontroller.addMember(tempList[0], tempList[1]);
        if (c == true) {
          mcontroller.printMessage("Member successfully added.");
          mcontroller.printMemberIDs();
          break;
        } else {
          memberChoice(1);
        }
        break;
      case 2:
        mcontroller.printMessage("Enter personalnumber to delete:");
        temp = input.getInputString();
        bcontroller.printMessage("Do you really want to delete? Y/N");
        if (input.getInputString().equals("Y")){
          if (mcontroller.deleteMember(temp) == false) {
            mcontroller.printMessage("Try again!");
            memberChoice(2);
          }
        }
        break;
      case 3:
        mcontroller.printMemberIDs();
        mcontroller.printMessage("Select member: ");
        temp = input.getInputString();
        mcontroller.printMessage("What do you want to change? (name, personalnumber)");
        break;
      case 4:
        mcontroller.printMemberIDs();
        mcontroller.printMessage("Select member: ");
        temp = input.getInputString();
      case 6:
        System.exit(0);
    }
  }
}
