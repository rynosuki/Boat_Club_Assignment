package controller;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import model.MemberID;
import view.MemberView;


public class MemberController {
  private Member model;
  public ArrayList<Member> members;
  private MemberView view;

  public MemberController(ArrayList<Member> members) {
    this.members = members;
    view = new MemberView(members);
  }

  public void getMember(String name) {
    for (int i = 0; i < members.size(); i++) {
      if (members.get(i).getName().equals(name)) {
        this.model = members.get(i);
      }
    }
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

  public void addMember() {
    String name = view.getInputValue("Name of person: ");
    String personalNumber = view.getInputValue("Personalnumber: ");
    Member tempModel = new Member(name, personalNumber, new MemberID().generateMemberID(name, members));
    for (int i = 0; i < members.size(); i++){
      if (members.get(i).getPersonalNumber() == tempModel.getPersonalNumber()) {
        String temp = view.getInputValue("Your personal number already exists in our database. Try again Y/N?");
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

  public String getMemberID() {
    return model.getMemberID();
  }

  public boolean deleteMember(String personalNumber) {
    for (int j = 0; j < members.size(); j++) {
      if (members.get(j).getPersonalNumber().equals(personalNumber)) {
        members.remove(j);
        return true;
      }
    }
    return false;
  }

  public void addBoatToMember(Boat boat) {
    model.addBoat(boat);
  }

  public void printMessage(String message) {
    view.printMessage(message);
  }

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
    }
  }

  public void overviewMember() {
    view.showOverview(view.memberChoice());
  }

  public void deleteMember() {
    members.remove(view.memberChoice());
  }
}
