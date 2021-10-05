package model;

import java.util.ArrayList;

public class Member {
  private String name;
  private long personalNumber;
  private String memberID;
  private ArrayList<Boat> boats = new ArrayList<>();

  /**
   * Creates a member object from input variables.
   * @param name Name of member.
   * @param personalNumber Personal number of member.
   * @param memberID Generated ID for member.
   */
  public Member(String name, long personalNumber, String memberID) {
    this.name = name;
    this.personalNumber = personalNumber;
    this.memberID = memberID;
  }

  public String getName() {
    return this.name;
  }

  public long getPersonalNumber() {
    return this.personalNumber;
  }

  public String getMemberID() {
    return this.memberID;
  }

  public ArrayList<Boat> getBoatList() {
    return this.boats;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setPersonalNumber(long personalNumber) {
    this.personalNumber = personalNumber;
  }

  public void addBoat(Boat boat) {
    this.boats.add(boat);
  }

  public void removeBoat(Boat boat) {
    this.boats.remove(boat);
  }
}