package controller;

import view.BoatView;

/**
 * Handles all things related to the boat object.
 */
public class BoatController {
  BoatView boatView = new BoatView();
  
  public void printMenu() {
    boatView.printView();
  }

  public void printMessage(String message) {
    boatView.printMessage(message);
  }
}
