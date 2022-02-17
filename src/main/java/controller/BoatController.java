package controller;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import model.MemberRegister;
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
  private Boat model;
  // English view
  private BoatView view;
  private MemberRegister registry;

  // Swedish view
  // private BoatViewSwedish view;

  /**
   * Creates the controller to work with boats.
   */
  public BoatController(MemberRegister registry) {
    // English view
    view = new BoatView();

    // Swedish view
    // view = new BoatViewSwedish();

    this.registry = registry;
  }

  public boolean setBoatId(String name) {
    return registry.changeBoatId(name, model);
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
  public void addBoat(Member owner) {
    try {
      String name;
      boolean denied;
      do {
        name = view.getInputValue(MessageRelated.NAME);
        denied = registry.checkBoatId(name);
        if (!denied) {
          view.printErrorMessage(ErrorMessage.NAMEERROR);
        }
      } while (!denied);

      String length = view.getInputValue(MessageRelated.BOATLENGTH);
      String type = view.getInputValue(MessageRelated.BOATTYPE);
      registry.createBoat(name, type, Double.parseDouble(length), owner);
    } catch (Exception e) {
      view.printErrorMessage(ErrorMessage.ANYERROR);
      addBoat(owner);
    }

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
          denied = setBoatId(view.getInputValue(MessageRelated.NAME));
          if (!denied) {
            view.printErrorMessage(ErrorMessage.ANYERROR);
          }
        } while (!denied);
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
