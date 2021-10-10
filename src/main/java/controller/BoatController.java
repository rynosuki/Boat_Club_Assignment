package controller;

import java.util.ArrayList;

import model.Boat;
import view.BoatView;

/**
 * Handles all the things related to the member object.
 */
public class BoatController {
  private Boat model;
  public ArrayList<Boat> boats;
  private BoatView view;

  public BoatController(ArrayList<Boat> boats) {
    this.boats = boats;
    view = new BoatView(boats);
  }

  public void setBoatId(String name) {
    model.setBoatId(name);
  }

  public String getBoatName() {
    return model.getBoatId();
  }

  public void setBoatType(String type) {
    model.setType(type);
  }

  public String getBoatType() {
    return model.getType();
  }

  /**
   * Used to create boatss and add them to the members boatlist.
   */
  public void addMember() {
    String name = view.getInputValue("Name of boat: ");
    String length = view.getInputValue("Length: ");
    String type = view.getInputValue("Type of boat: ");
    Boat tempModel = new Boat(name, type, Integer.parseInt(length));
    for (int i = 0; i < boats.size(); i++) {
      if (boats.get(i).getBoatId().equals(tempModel.getBoatId())) {
        String temp = view.getInputValue("You already have a boat with that name. "
            + "Try again Y/N?");
        if (temp.equalsIgnoreCase("Y")) {
          name = view.getInputValue("Name: ");
          tempModel.setBoatId(name);
        }
      }
    }
    this.boats.add(tempModel);
  }

  public void printMenu() {
    this.view.printView();
  }

  public String getBoatId() {
    return model.getBoatId();
  }

  public void printMessage(String message) {
    view.printMessage(message);
  }

  /**
   * Used to change boat info, user provides which boat needs to be changed.
   */
  public void changeBoat() {
    this.model = view.boatChoice();
    int choice = view.changeChoice();
    switch (choice) {
      case 1:
        setBoatId(view.getInputValue("Enter new name for boat:"));
        view.printBoatList();
        break;
      case 2:
        setBoatType(view.getInputValue("Enter new type for boat:"));
        break;
      case 3:
        break;
      default:
        break;
    }
  }

  public void overviewMember() {
    view.showOverview(view.boatChoice());
  }

  public void deleteMember() {
    boats.remove(view.boatChoice());
  }
}


