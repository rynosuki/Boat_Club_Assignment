package controller;

import java.util.ArrayList;
import model.Boat;
import model.Member;
import model.MemberId;
import view.MemberView;

/**
 * Handles all the things related to the member object.
 */
public class MemberController {
  private Member model;
  private ArrayList<Member> members;
  private MemberView view;

  public MemberController(ArrayList<Member> members) {
    this.members = members;
    view = new MemberView(members);
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

  public ArrayList<Boat> getMemberBoats(Member model) {
    return model.getBoatList();
  }

  /**
   * Used to create members and add them to the memberlist.
   */
  public void addMember() {
    String name = view.getInputValue("Name of person: ");
    String personalNumber = view.getInputValue("Personalnumber: ");
    Member tempModel = new Member(name, personalNumber, 
        new MemberId().generateMemberId(name, members));
    for (int i = 0; i < members.size(); i++) {
      if (members.get(i).getPersonalNumber().equals(tempModel.getPersonalNumber())) {
        String temp = view.getInputValue("Your personal number already exists in our database. "
            + "Try again Y/N?");
        if (temp.equalsIgnoreCase("Y")) {
          personalNumber = view.getInputValue("Personalnumber: ");
          tempModel.setPersonalNumber(personalNumber);
        }
      }
    }
    this.members.add(tempModel);
  }

  public void printMenu() {
    this.view.printView();
  }

  public String getMemberId() {
    return model.getMemberId();
  }

  public void addBoatToMember(Boat boat) {
    model.addBoat(boat);
  }

  public void printMessage(String message) {
    view.printMessage(message);
  }

  /**
   * Used to change member info, user provides which member needs to be changed.
   */
  public void changeMember() {
    this.model = view.memberChoice();
    int choice = view.changeChoice();
    switch (choice) {
      case 1:
        setMemberName(view.getInputValue("Enter new name for member:"));
        view.printMemberList();
        break;
      case 2:
        setMemberPersonalNumber(view.getInputValue("Enter new personalnumber for member:"));
        break;
      case 3:
        break;
      default:
        break;
    }
  }

  public void overviewMember() {
    view.showOverview(view.memberChoice());
  }

  public void deleteMember() {
    members.remove(view.memberChoice());
  }
}
