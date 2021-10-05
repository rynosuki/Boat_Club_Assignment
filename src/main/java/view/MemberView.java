package view;

import java.util.ArrayList;
import model.Member;

public class MemberView implements View {
  private ArrayList<Member> list;
  private InputHandler input;

  public MemberView(ArrayList<Member> list) {
    this.input = new InputHandler();
    this.list = list;
  }

  public void printView() {
    System.out.println("Main Menu - Member");
    System.out.println("--------------------");
    System.out.println("1. Add member");
    System.out.println("2. Delete member");
    System.out.println("3. Change member");
    System.out.println("4. Show verbose list");
    System.out.println("5. Show compact list");
    System.out.println("6. Quit");
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

  public void printMemberList() {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + " " + list.get(i).getName() + " " + list.get(i).getMemberID());
    }
  }

  public Member memberChoice() {
    if (list.size() > 0) {
      for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " " + list.get(i).getName() + " " + list.get(i).getMemberID());
      }
      System.out.println("Choose member: ");
      String temp = input.getInputString();
      return list.get(Integer.parseInt(temp));
    }
    return null;
  }

  public int changeChoice() {
    System.out.println("What do you want to change? (Name, Personalnumber)");
    String temp = input.getInputString();
    if (temp.equalsIgnoreCase("Name")) {
      return 1;
    } else if (temp.equalsIgnoreCase("Personalnumber")) {
      return 2;
    }
    return 3;
  }

  public String getInputValue(String choice) {
    System.out.println(choice);
    return input.getInputString();
  }

  public void showOverview(Member model) {
    System.out.println("Name: " + model.getName());
    System.out.println("Personalnumber: " + model.getPersonalNumber());
    System.out.println("MemberID: " + model.getMemberID());
    System.out.println("Press any key to continue.");
    input.getInputString();
  }
}
