package view;

import java.util.ArrayList;

import model.Member;

/**
 * Used for all the user inputs and user interface.
 */
public class MemberView implements View {
  private ArrayList<Member> list;
  private InputHandler input;

  public MemberView(ArrayList<Member> list) {
    this.input = new InputHandler();
    this.list = list;
  }

  /**
   * Prints out the main menu for members.
   */
  public void printView() {
    System.out.println("Main Menu - Member");
    System.out.println("--------------------");
    System.out.println("1. Add member");
    System.out.println("2. Delete member");
    System.out.println("3. Change member");
    System.out.println("4. View member details");
    System.out.println("5. Show verbose list");
    System.out.println("6. Show compact list");
    System.out.println("7. Return to menu");
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

  /**
   * Goes through the entire list and prints out the name + id.
   */
  public void printMemberList() {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + " " + list.get(i).getName() + " " + list.get(i).getMemberId());
    }
  }

  /**
   * Prints the list of members and allows the user to pick one.
   * 
   * @return returns the member that is at the chosen value.
   */
  public Member memberChoice() {
    if (list.size() > 0) {
      for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " " + list.get(i).getName() + " " + list.get(i).getMemberId());
      }
      System.out.println("Choose member: ");
      String temp = input.getInputString();
      return list.get(Integer.parseInt(temp));
    }
    return null;
  }

  /**
   * Deciding which part that user want to change.
   * 
   * @return the integer choice of the user.
   */
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

  /**
   * Prints out the data from the model and then waits for input.
   * 
   * @param model model is the member that is currently looked at.
   */
  public void showOverview(Member model) {
    System.out.println("Name: " + model.getName());
    System.out.println("Personalnumber: " + model.getPersonalNumber());
    System.out.println("MemberID: " + model.getMemberId());
    System.out.println("Press any key to continue.");
    input.getInputString();
  }

  /**
   * Verbose list: name, personal number, member id and boats with boat
   * information.
   * 
   * @param list Member list.
   */
  public void printVerboseList(ArrayList<Member> list) {
    BoatView view = new BoatView();

    for (Member member : list) {
      System.out.println();
      System.out.println("- MEMBER (Verbose list) ---------");
      System.out.println("| Name: " + member.getName() + " (" + member.getPersonalNumber() + ")");
      System.out.println("| Member ID: " + member.getMemberId());
      System.out.println("|");

      // Prints boat information
      view.boatInformation(member.getBoatList());

      System.out.println("---------------------------------");
    }
  }

  /**
   * Compact list: name, member id and number of boats.
   * 
   * @param list Member list.
   */
  public void printCompactList(ArrayList<Member> list) {
    for (Member member : list) {

      System.out.println();
      System.out.println("- MEMBER (Compact list) -----");
      System.out.println("| Name: " + member.getName());
      System.out.println("| Member ID: " + member.getMemberId());

      int numberOfBoats = member.getBoatList().size();
      System.out.println("| Number of boats: " + numberOfBoats);
      System.out.println("-----------------------------");
    }
  }

}
