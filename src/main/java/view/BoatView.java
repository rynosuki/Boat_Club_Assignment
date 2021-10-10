package view;

import java.util.ArrayList;

import model.Boat;

/**
 * Handles the user inputs and user interface for the boat.
 */
public class BoatView implements View {
  private ArrayList<Boat> list;
  private InputHandler input;

  public BoatView(ArrayList<Boat> list) {
    this.input = new InputHandler();
    this.list = list;
  }
  /**
   * Print the menu.
   */
  public void printView() {
    System.out.println("Main Menu - Boat");
    System.out.println("--------------------");
    System.out.println("1. Add Boat");
    System.out.println("2. Remove Boat");
    System.out.println("3. Change Boat");
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

  /**
   * Prints the list of boats and allows the user to pick one.

   * @return returns the boat that is at the chosen value.
   */
  public Boat boatChoice() {
    if (list.size() > 0) {
      for (int i = 0; i < list.size(); i++) {
        System.out.println(i + " " + list.get(i).getBoatId());
      }
      System.out.println("Choose boat: ");
      String temp = input.getInputString();
      return list.get(Integer.parseInt(temp));
    }
    return null;
  }

  /**
   * Deciding which part that user want to change.

   * @return the integer choice of the user.
   */
  public int changeChoice() {
    System.out.println("What do you want to change? (Id, type)");
    String temp = input.getInputString();
    if (temp.equalsIgnoreCase("Id")) {
      return 1;
    } else if (temp.equalsIgnoreCase("Type")) {
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

   * @param model model is the member that is currently looked at.
   */
  public void showOverview(Boat model) {
    System.out.println("iD: " + model.getBoatId());
    System.out.println("Length: " + model.getLength());
    System.out.println("Type: " + model.getType());
    System.out.println("Press any key to continue.");
    input.getInputString();
  }
}
