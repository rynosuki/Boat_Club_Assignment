package view;

import java.util.ArrayList;
import model.Member;

public class MemberView implements View {
  private ArrayList<Member> list;

  public void printView() {
    System.out.println("Main Menu - Member");
    System.out.println("------------------");
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

  public void boatID() {
    System.out.print("Enter the boat ID: ");
  }
}
