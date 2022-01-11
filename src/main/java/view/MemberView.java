package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Member;

/**
 * Used for all the user inputs and user interface.
 */
public class MemberView implements View {
  private InputHandler input = new InputHandler();

  private static final String add = "1";
  private static final String del = "2";
  private static final String change = "3";
  private static final String view = "4";
  private static final String verbose = "5";
  private static final String compact = "6";
  private static final String quit = "7";

  /**
   * Prints out the main menu for members.
   */
  public void printView() {
    System.out.println("Main Menu - Member");
    System.out.println("--------------------");
    System.out.println(add + ". Add member");
    System.out.println(del + ". Delete member");
    System.out.println(change + ". Change member");
    System.out.println(view + ". View member details");
    System.out.println(verbose + ". Show verbose list");
    System.out.println(compact + ". Show compact list");
    System.out.println(quit + ". Return to menu");
  }

  /**
   * Get menu choice.
   * 
   * @return
   */
  public MenuChoice getMenuChoice() {
    switch (input.getInputString()) {
      case add:
        return MenuChoice.ADD;
      case del:
        return MenuChoice.DEL;
      case change:
        return MenuChoice.CHANGE;
      case view:
        return MenuChoice.VIEW;
      case verbose:
        return MenuChoice.VERBOSE;
      case compact:
        return MenuChoice.COMPACT;
      case quit:
        return MenuChoice.QUIT;
      default:
        return null;
    }
  }

  /**
   * Sorts the list based on a preference.
   * 
   * @param list list of members.
   * @return sorted list.
   */
  public ArrayList<Member> sortList(ArrayList<Member> list) {
    Collections.sort(list, new Comparator<Member>() {
      @Override
      public int compare(Member s1, Member s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
      }
    });
    return list;
  }

  /**
   * Prints the error message related to what the user is doing.
   */
  public void printErrorMessage(ErrorMessage message) {
    switch (message) {
      case ANYERROR:
        System.out.println("There was an error in your input, try again! \n");
        break;
      case NAMEERROR:
        System.out.println("That name is to short 2+, try another one! \n");
        break;
      default:
        break;
    }
  }

  /**
   * Goes through the entire list and prints out the name + id.
   */
  public void printMemberList(ArrayList<Member> list) {
    list = sortList(list);

    for (Member m : list) {
      System.out.println(list.indexOf(m) + " " + m.getName() + " " + m.getMemberId());
    }
  }

  /**
   * Prints the list of members and allows the user to pick one.
   * 
   * @return returns the member that is at the chosen value.
   */
  public Member memberChoice(ArrayList<Member> list) {
    System.out.println("Select a member: ");
    printMemberList(list);
    System.out.println("Choose member: ");
    String temp = input.getInputString();
    try {
      return list.get(Integer.parseInt(temp));
    } catch (Exception e) {
      return memberChoice(list);
    }
  }

  /**
   * Deciding which part that user want to change.
   * 
   * @return the integer choice of the user.
   */
  public ChoiceValue changeChoice() {
    System.out.println("What do you want to change? (Name, Personalnumber)");
    String temp = input.getInputString();
    if (temp.equalsIgnoreCase("Name")) {
      return ChoiceValue.NAME;
    } else if (temp.equalsIgnoreCase("Personalnumber")) {
      return ChoiceValue.PERSONALNUMBER;
    }
    return ChoiceValue.QUIT;
  }

  public String getInputValue(MessageRelated choice) {
    System.out.println(retrieveInputValue(choice));
    return input.getInputString();
  }

  private String retrieveInputValue(MessageRelated choice) {
    switch (choice) {
      case NAME:
        return "Name of person: (2+ characters): ";
      case PERSONALNUMBER:
        return "Enter your personalnumber: ";
      default:
        return null;
    }
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
    list = sortList(list);

    for (Member m : list) {
      System.out.println();
      System.out.println("- MEMBER (Verbose list) ---------");
      System.out.println("| Name: " + m.getName() + " (" + m.getPersonalNumber() + ")");
      System.out.println("| Member ID: " + m.getMemberId());
      System.out.println("|");

      // Prints boat information
      view.boatInformation(m.getBoatList());

      System.out.println("---------------------------------");
    }
  }

  /**
   * Compact list: name, member id and number of boats.
   * 
   * @param list Member list.
   */
  public void printCompactList(ArrayList<Member> list) {
    list = sortList(list);

    for (Member m : list) {
      System.out.println();
      System.out.println("- MEMBER (Compact list) -----");
      System.out.println("| Name: " + m.getName());
      System.out.println("| Member ID: " + m.getMemberId());

      int numberOfBoats = m.getBoatList().size();
      System.out.println("| Number of boats: " + numberOfBoats);
      System.out.println("-----------------------------");
    }
  }

}
