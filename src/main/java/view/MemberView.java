package view;

import java.util.ArrayList;
import model.Member;

public class MemberView implements View {
  private ArrayList<Member> list;

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

  public void setCurrentList(ArrayList<Member> list) {
    this.list = list;
  }

  public void printMessage(String message) {
    System.out.println(message);
  }
  
  public void printMessage(long message) {
    System.out.println(message);
  }

  public void printMemberList(ArrayList<Member> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + " " + list.get(i).getName() + " " + list.get(i).getMemberID());
    }
  }
}
