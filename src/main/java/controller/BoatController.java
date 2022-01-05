package controller;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import view.BoatView;
import view.View.MenuChoice;

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
   * Used to create boats and add them to the boats boatlist.
   */
  public Boat addBoat(ArrayList<Member> list) {
    try {
      String name = view.getInputValue("Name of boat: ");
      
      String length = view.getInputValue("Length: ");
      String type = view.getInputValue("Type of boat: ");for (Member m : list) {
        ArrayList<Boat> boatlist = m.getBoatList();
        for (Boat b : boatlist) {
          if (b.getBoatId().equals(name)){
            view.printMessage("A boat with that name already exists try something else");
            addBoat(list);
          }
        }
      }
      Boat tempModel = new Boat(name, type, Double.parseDouble(length));
      return tempModel;
    } catch (Exception e) {
      view.printMessage("One of the inputs was invalid, try again.");
      addBoat(list);
    }
    return null;
  }

  public MenuChoice printMenu() {
    this.view.printView();
    return this.view.getMenuChoice();
  }

  public String getBoatId() {
    return model.getBoatId();
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
