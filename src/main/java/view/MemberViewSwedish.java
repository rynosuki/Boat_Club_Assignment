package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Member;

/**
 * Used for all the user inputs and user interface.
 */
public class MemberViewSwedish implements View {
  private InputHandler input = new InputHandler();

  private static final String add = "a";
  private static final String del = "d";
  private static final String change = "c";
  private static final String view = "v";
  private static final String verbose = "ve";
  private static final String compact = "co";
  private static final String quit = "q";

  /**
   * Prints out the main menu for members.
   */
  public void printView() {
    System.out.println("Huvudmeny - Medlemmar");
    System.out.println("--------------------");
    System.out.println(add + ". Lägg till medlem");
    System.out.println(del + ". Radera medlem");
    System.out.println(change + ". Ändra medlem");
    System.out.println(view + ". Visa detaljer för medlem");
    System.out.println(verbose + ". Visa fullständig lista");
    System.out.println(compact + ". Visa kompakt lista");
    System.out.println(quit + ". Återgå till menyn");
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
   * Sorts list.
   * 
   * @param list memberlist
   * @return sorted list.
   */
  public ArrayList<Member> sortList(ArrayList<Member> list) {
    Collections.sort(list, new Comparator<Member>() {
      @Override
      public int compare(Member s1, Member s2) {
        return s1.getMemberId().compareToIgnoreCase(s2.getMemberId());
      }
    });
    return list;
  }

  /**
   * Prints errormessage related to what the user is doing.
   */
  public void printErrorMessage(ErrorMessage message) {
    switch (message) {
      case ANYERROR:
        System.out.println("Du skrev in något fel, försöker igen. \n");
        break;
      case NAMEERROR:
        System.out.println("Ditt namn är för kort, 2+ bokstäver. \n");
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
    System.out.println("Välj en medlem: ");
    printMemberList(list);
    System.out.println("Välj en medlem:: ");
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
    System.out.println("Vad vill du ändra? (Namn, Personnummer)");
    String temp = input.getInputString();
    if (temp.equalsIgnoreCase("Namn")) {
      return ChoiceValue.NAME;
    } else if (temp.equalsIgnoreCase("Personnummer")) {
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
        return "Skriv in ditt namn (2+ bokstäver): ";
      case PERSONALNUMBER:
        return "Skriv ditt personnumber: ";
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
    System.out.println("Namn: " + model.getName());
    System.out.println("Personnummer: " + model.getPersonalNumber());
    System.out.println("Medlem ID: " + model.getMemberId());
    System.out.println("Tryck på valfri tangent för att fortsätta");
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
      System.out.println("- MEDLEM (Fullstandig lista) ---------");
      System.out.println("| Namn: " + m.getName() + " (" + m.getPersonalNumber() + ")");
      System.out.println("| Medlem ID: " + m.getMemberId());
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
      System.out.println("- MEDLEM (Kompakt lista) -----");
      System.out.println("| Namn: " + m.getName());
      System.out.println("| Medlem ID: " + m.getMemberId());

      int numberOfBoats = m.getBoatList().size();
      System.out.println("| Antal båtar: " + numberOfBoats);
      System.out.println("-----------------------------");
    }
  }

}
