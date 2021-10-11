package controller;

import java.util.ArrayList;

import model.Boat;
import view.BoatView;

/**
 * Handles all the things related to the boat object.
 */
public class BoatController {
  private Boat model;
  private BoatView view;

  public BoatController() {
    view = new BoatView();
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
   * Used to create boatss and add them to the boats boatlist.
   */
  public Boat addBoat() {
    String name = view.getInputValue("Name of boat: ");
    String length = view.getInputValue("Length: ");
    String type = view.getInputValue("Type of boat: ");
    Boat tempModel = new Boat(name, type, Double.parseDouble(length));
    return tempModel;
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
  public void changeBoat(ArrayList<Boat> list) {
    this.model = view.boatChoice(list);
    int choice = view.changeChoice();
    switch (choice) {
      case 1:
        setBoatId(view.getInputValue("Enter new name for boat:"));
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

  public void overviewBoat(ArrayList<Boat> list) {
    view.showOverview(view.boatChoice(list));
  }

  public Boat chooseBoat(ArrayList<Boat> list) {
    return view.boatChoice(list);
  }
}
