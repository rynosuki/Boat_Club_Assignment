package controller;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import view.BoatView;
//import view.BoatViewSwedish;
import view.View.ChoiceValue;
import view.View.ErrorMessage;
import view.View.MenuChoice;
import view.View.MessageRelated;

/**
 * Handles all the things related to the boat object.
 */
public class BoatController {
  private Boat model = new Boat("temp", "temp", 1);
  // English view
  private BoatView view;

  // Swedish view
  // private BoatViewSwedish view;

  /**
   * Creates the controller to work with boats.
   */
  public BoatController() {
    // English view
    view = new BoatView();

    // Swedish view
    // view = new BoatViewSwedish();

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
        name = view.getInputValue(MessageRelated.NAME);
        denied = model.checkId(name, list);
        if (denied) {
          view.printErrorMessage(ErrorMessage.NAMEERROR);
        }
      } while (denied);

      String length = view.getInputValue(MessageRelated.BOATLENGTH);
      String type = view.getInputValue(MessageRelated.BOATTYPE);
      Boat tempModel = new Boat(name, type, Double.parseDouble(length), list);
      return tempModel;
    } catch (Exception e) {
      view.printErrorMessage(ErrorMessage.ANYERROR);
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
          denied = setBoatId(view.getInputValue(MessageRelated.NAME), mlist);
          if (denied) {
            view.printErrorMessage(ErrorMessage.ANYERROR);
          }
        } while (denied);
        break;
      case TYPE:
        setBoatType(view.getInputValue(MessageRelated.BOATTYPE));
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
