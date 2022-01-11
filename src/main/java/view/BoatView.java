package view;

import java.util.ArrayList;

import model.Boat;

/**
 * Handles the user inputs and user interface for the boat.
 */
public class BoatView implements View {
  public enum ChoiceValue {
    ID, TYPE, QUIT
  }

  private InputHandler input;

  private static final String add = "1";
  private static final String del = "2";
  private static final String change = "3";
  private static final String quit = "4";

  public BoatView() {
    this.input = new InputHandler();
  }

  /**
   * Print the menu.
   */
  public void printView() {
    System.out.println("Main Menu - Boat");
    System.out.println("--------------------");
    System.out.println(add + ". Add Boat");
    System.out.println(del + ". Remove Boat");
    System.out.println(change + ". Change Boat");
    System.out.println(quit + ". Back to menu");
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
    System.out.println("Select a boat: ");
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
  public ChoiceValue changeChoice() {
    System.out.println("What do you want to change? (Id, type)");
    String temp = input.getInputString();
    if (temp.equalsIgnoreCase("Id")) {
      return ChoiceValue.ID;
    } else if (temp.equalsIgnoreCase("Type")) {
      return ChoiceValue.TYPE;
    }
    return ChoiceValue.QUIT;
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
    System.out.println("Length: " + model.getLength());
    System.out.println("Type: " + model.getType());
    System.out.println("Press any key to continue.");
    input.getInputString();
  }

  /**
   * Prints boat information.
   * 
   * @param boatList A list conatining boats.
   */
  public void boatInformation(ArrayList<Boat> boatList) {
    System.out.println("- Boats ---");
    System.out.println("|");
    for (Boat boat : boatList) {
      System.out.println("| Boat ID: " + boat.getBoatId());
      System.out.println("| Type: " + boat.getType());
      System.out.println("| Length: " + boat.getLength());
      System.out.println("|");
    }
  }
}
