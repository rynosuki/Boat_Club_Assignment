package model;

import java.util.ArrayList;

public class Member {
  private String name;
  private int personalNumber;
  private int memberID;
  private ArrayList<Boat> boats = new ArrayList<>();

  /**
   * Creates a member object from input variables.
   * @param name Name of member.
   * @param personalNumber Personal number of member.
   * @param memberID Generated ID for member.
   */
  public Member(String name, int personalNumber, int memberID) {
    this.name = name;
    this.personalNumber = personalNumber;
    this.memberID = memberID;
  }

  public String getName() {
    return this.name;
  }

  public int getPersonalNumber() {
    return this.personalNumber;
  }

  public int getMemberID() {
    return this.memberID;
  }

  public ArrayList<Boat> getBoatList() {
    return this.boats;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setPersonalNumber(int personalNumber) {
    this.personalNumber = personalNumber;
  }

  public void addBoat(Boat boat) {
    this.boats.add(boat);
  }

  public void removeBoat(Boat boat) {
    this.boats.remove(boat);
  }
}