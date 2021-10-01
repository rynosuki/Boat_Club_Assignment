package controller;

import java.util.ArrayList;

import model.Member;
import view.MemberView;


public class MemberController {
  private Member model;
  private MemberView view;
  private ArrayList<Member> members = new ArrayList<>();

  public MemberController(Member model, MemberView view) {
    this.model = model;
    this.view = view;
  }

  public void setMemberName(String name) {
    model.setName(name);
  }

  public String getMemberName() {
    return model.getName();
  }

  public void setMemberPersonalNumber(int personalNumber) {
    model.setPersonalNumber(personalNumber);
  }

  public int getMemberPersonalNumber() {
    return model.getPersonalNumber();
  }

  public void createMember(String name, int personalNumber, int memberID) {
    this.members.add(new Member(name, personalNumber, memberID));
  }

  
}
