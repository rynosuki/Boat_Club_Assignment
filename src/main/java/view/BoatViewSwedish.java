package view;

import java.util.ArrayList;

import model.Boat;

/**
 * Handles the user inputs and user interface for the boat.
 */
public class BoatViewSwedish implements View {
  private InputHandler input;

  private static final String add = "a";
  private static final String del = "d";
  private static final String change = "c";
  private static final String quit = "q";

  public BoatViewSwedish() {
    this.input = new InputHandler();
  }

  /**
   * Print the menu.
   */
  public void printView() {
    System.out.println("Huvudmeny - Båtar");
    System.out.println("--------------------");
    System.out.println(add + ". Lägg till båt");
    System.out.println(del + ". Ta bort båt");
    System.out.println(change + ". Ändra båt");
    System.out.println(quit + ". Återgå till menyn");
  }

  /**
   * Get menu choice.
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
      case quit:
        return MenuChoice.QUIT;
      default:
        return null;
    }
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

  /**
   * Goes through the entire list and prints out the name.
   */
  public void printBoatList(ArrayList<Boat> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + " " + list.get(i).getBoatId());
    }
  }

  /**
   * Prints the list of boats and allows the user to pick one.
   * 
   * @return returns the boat that is at the chosen value.
   */
  public Boat boatChoice(ArrayList<Boat> list) {
    System.out.println("Välj en båt: ");
    for (Boat b : list) {
      System.out.println(list.indexOf(b) + " " + b.getBoatId());
    }
    System.out.println();
    String temp = input.getInputString();
    return list.get(Integer.parseInt(temp));
  }

  /**
   * Deciding which part that user want to change.
   * 
   * @return the integer choice of the user.
   */
  public int changeChoice() {
    System.out.println("Vad vill du ändra? (Id, typ)");
    String temp = input.getInputString();
    if (temp.equalsIgnoreCase("Id")) {
      return 1;
    } else if (temp.equalsIgnoreCase("Typ")) {
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
  public void showOverview(Boat model) {
    System.out.println("iD: " + model.getBoatId());
    System.out.println("Längd: " + model.getLength());
    System.out.println("Typ: " + model.getType());
    System.out.println("Tryck på valfri tangent för att fortsätta");
    input.getInputString();
  }

  /**
   * Prints boat information.
   * 
   * @param boatList A list conatining boats.
   */
  public void boatInformation(ArrayList<Boat> boatList) {
    System.out.println("- Båtar ---");
    System.out.println("|");
    for (Boat boat : boatList) {
      System.out.println("| Båt ID: " + boat.getBoatId());
      System.out.println("| Typ: " + boat.getType());
      System.out.println("| Längd: " + boat.getLength());
      System.out.println("|");
    }
  }
}
