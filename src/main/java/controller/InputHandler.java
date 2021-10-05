package controller;

import java.util.Scanner;

public class InputHandler {
  private Scanner sc = new Scanner(System.in);
  
  public String getInputString() {
    return sc.nextLine();
  }
}
