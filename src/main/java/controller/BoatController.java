package controller;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import view.BoatView;
import view.BoatView.ChoiceValue;
import view.View.MenuChoice;

// English view
// import view.BoatView;

// Swedish view
import view.BoatViewSwedish;


/**
 * Handles all the things related to the boat object.
 */
public class BoatController {
  private Boat model = new Boat("temp", "temp", 1);
  private BoatView view;

  public BoatController() {
    // English view
    // view = new BoatView();

    // Swedish view
    view = new BoatViewSwedish();

  }

  public boolean setBoatId(String name, ArrayList<Member> list) {
    return model.setBoatId(name, list);
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
      String name;
      boolean denied;
      do {
        name = view.getInputValue("Name of boat: ");
        denied = model.checkId(name, list);
        if (denied) {
          view.printMessage("There's a boat with that name, try again. \n");
        }
      } while (denied);

      String length = view.getInputValue("Length: ");
      String type = view.getInputValue("Type of boat: ");
      Boat tempModel = new Boat(name, type, Double.parseDouble(length), list);
      return tempModel;
    } catch (Exception e) {
      System.out.println(e);
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
  public void changeBoat(ArrayList<Boat> list, ArrayList<Member> mlist) {
    this.model = view.boatChoice(list);
    ChoiceValue choice = view.changeChoice();
    switch (choice) {
      case ID:
        boolean denied;
        do {
          denied = setBoatId(view.getInputValue("Enter new name for boat:"), mlist);
          if (denied) {
            view.printMessage("There is a boat with that name, try again. \n");
          }
        } while (denied);
        break;
      case TYPE:
        setBoatType(view.getInputValue("Enter new type for boat:"));
        break;
      case QUIT:
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
