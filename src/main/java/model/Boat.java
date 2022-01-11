package model;

import java.util.ArrayList;

/**
 * Model of the boat class.
 */
public class Boat {
  private String boatId;
  private String type;
  private double length;

  /**
   * Creates a boat object from input variables.
   * 
   * @param boatId Unique id for boat.
   * 
   * @param type   Type of boat(sailing boat, motorboat e.g).
   * 
   * @param length Length of boat.
   */
  public Boat(String boatId, String type, double length, ArrayList<Member> list) {
    setBoatId(boatId, list);
    this.type = type;
    this.length = length;
  }

  public String getBoatId() {
    return this.boatId;
  }

  public String getType() {
    return this.type;
  }

  public double getLength() {
    return this.length;
  }

  public void setBoatId(String boatId, ArrayList<Member> list) {
    for (Member m : list) {
      ArrayList<Boat> boatlist = m.getBoatList();
      for (Boat b : boatlist) {
        if (b.getBoatId().equals(boatId)){
          //TODO implement what happens if duplicate is found
        }
        else{
          this.boatId = boatId;  //TODO move to seperate private method
        }
      }
    }
    this.boatId = boatId;  //TODO Delete this line
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
