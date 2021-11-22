package controller;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import model.MemberId;
import model.MemberRegister;
import view.MemberView;
import view.MemberView.ChoiceValue;
import view.View.MenuChoice;

/**
 * Handles all the things related to the member object.
 */
public class MemberController {
  private Member model;
  private ArrayList<Member> list;
  private MemberRegister reg;
  private MemberView view;

  /**
   * Member controller.
   * @param memRegister Member register.
   */
  public MemberController(MemberRegister memRegister) {
    this.list = memRegister.getListCopy();
    this.reg = memRegister;
    view = new MemberView();
  }

  public void setMemberName(String name) {
    model.setName(name);
  }

  public String getMemberName() {
    return model.getName();
  }

  public void setMemberPersonalNumber(String personalNumber) {
    model.setPersonalNumber(personalNumber);
  }

  public String getMemberPersonalNumber() {
    return model.getPersonalNumber();
  }

  public ArrayList<Boat> getMemberBoats() {
    return model.getBoatList();
  }

  public void setCurrentMember() {
    this.model = view.memberChoice(list);
  }

  /**
   * Used to create members and add them to the memberlist.
   */
  public void addMember() {
    try {
      String name = view.getInputValue("Name of person: (2+ characters)");
      String personalNumber = view.getInputValue("Personalnumber: ");
      Member tempModel = new Member(name, personalNumber, 
          new MemberId().generateMemberId(name, list));
      for (Member i : list) {
        if (i.getPersonalNumber().equals(tempModel.getPersonalNumber())) {
          String temp = view.getInputValue("Your personal number already exists in our database. " 
              + "Try again Y/N?");
          if (temp.equalsIgnoreCase("Y")) {
            personalNumber = view.getInputValue("Personalnumber: ");
            tempModel.setPersonalNumber(personalNumber);
          }
        }
      }
      reg.addMember(tempModel);
      this.list = reg.getListCopy();
    } catch (Exception e) {
      view.printMessage("There was an error in ur input, try again.");
      addMember();
    }
  }

  public MenuChoice printMenu() {
    view.printView();
    return view.getMenuChoice();
  }

  public String getMemberId() {
    return model.getMemberId();
  }

  public void addBoatToMember(Boat boat) {
    model.addBoat(boat);
  }

  /**
   * Used to change member info, user provides which member needs to be changed.
   */
  public void changeMember() {
    this.model = view.memberChoice(list);
    ChoiceValue choice = view.changeChoice();
    switch (choice) {
      case NAME:
        setMemberName(view.getInputValue("Enter new name for member:"));
        view.printMemberList(list);
        break;
      case PERSONALNUMBER:
        setMemberPersonalNumber(view.getInputValue("Enter new personalnumber for member:"));
        break;
      case NONE:
        break;
      default:
        break;
    }
  }

  public void overviewMember() {
    Member memberChoice = view.memberChoice(list);
    view.showOverview(memberChoice);
  }

  /**
   * Delete member.
   */
  public void deleteMember() {
    Member memberChoice = view.memberChoice(list);
    reg.deleteMember(memberChoice);
    this.list = reg.getListCopy();
  }

  public void deleteBoat(Boat boat) {
    model.removeBoat(boat);
  }

  public void verboseList() {
    view.printVerboseList(list);
  }

  public void compactList() {
    view.printCompactList(list);
  }

}
