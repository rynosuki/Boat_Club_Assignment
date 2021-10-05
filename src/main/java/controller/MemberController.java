package controller;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import view.MemberView;


public class MemberController {
  private Member model;
  private MemberView view;
  public ArrayList<Member> members = new ArrayList<>();
  private InputHandler input;

  public MemberController(MemberView view, InputHandler input) {
    this.view = view;
    this.input = input;
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

  public void setMemberPersonalNumber(long personalNumber) {
    model.setPersonalNumber(personalNumber);
  }

  public long getMemberPersonalNumber() {
    return model.getPersonalNumber();
  }

  public boolean addMember(String name, long personalNumber, String memberID) {
    Member tempModel = new Member(name, personalNumber, memberID);
    for (int i = 0; i < members.size(); i++){
      if (members.get(i).getPersonalNumber() == personalNumber) {
        return false;
      }
    }
    this.members.add(tempModel);
    return true;
  }

  public void printMenu() {
    this.view.printView();
  }

  public void printCompactList() {
    // this.view.showCompactList;
  }

  public void printVerboseList() {
    // this.view.showVerboseList;
  }

  public String getMemberID() {
    return model.getMemberID();
  }

  public boolean deleteMember(Long personalNumber) {
    for (int j = 0; j < members.size(); j++) {
      if (members.get(j).getPersonalNumber() == personalNumber) {
        members.remove(j);
        return true;
      }
    }
    return false;
  }

  public void addBoatToMember(Boat boat) {
    model.addBoat(boat);
  }

  public void createBoatAndAdd(int boatID, String type, int length) {
    model.addBoat(new Boat(boatID, type, length));
  }

  public Boat getBoat() {
    if (model.getBoatList().size() == 1) {
      return model.getBoatList().get(0);
    } else {
      view.printMessage("Which boatID?");
      int i = Integer.parseInt(input.getInputString());
      for (int d = 0; d < model.getBoatList().size(); d++) {
        if (model.getBoatList().get(d).getBoatID() == i) {
          return model.getBoatList().get(d);
        }
      }
    }
    return null;
  }

  public void printMessage(String message) {
    view.printMessage(message);
  }

  public void printMembers() {
    for (int i = 0; i < members.size(); i++) {
      view.printMessage(members.get(i).getPersonalNumber());
    }
  }
}
