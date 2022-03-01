package model;

import java.util.ArrayList;

/**
 * Model of the member. With getters and setters.
 */
public class Member {
  private String name;
  private String personalNumber;
  private String memberId;
  private ArrayList<Boat> boats = new ArrayList<>();

  /**
   * Creates a member object from input variables.
   * 
   * @param name           Name of member.
   * 
   * @param personalNumber Personal number of member.
   * 
   * @param memberId       Generated ID for member.
   * 
   */
  public Member(String name, String personalNumber, String memberId) {
    this.name = name;
    this.personalNumber = personalNumber;
    this.memberId = memberId;
  }

  public String getName() {
    return this.name;
  }

  public String getPersonalNumber() {
    return this.personalNumber;
  }

  public String getMemberId() {
    return this.memberId;
  }

  public ArrayList<Boat> getBoatList() {
    return new ArrayList<Boat>(this.boats);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPersonalNumber(String personalNumber) {
    this.personalNumber = personalNumber;
  }

  public void addBoat(Boat boat) {
    this.boats.add(boat);
  }

  public void removeBoat(Boat boat) {
    this.boats.remove(boat);
  }
}