package controller;

import view.BoatView;

public class BoatController {
  BoatView bView = new BoatView();
  
  public void printMenu() {
    bView.printView();
  }

  public void printMessage(String message) {
    bView.printMessage(message);
  }
}
