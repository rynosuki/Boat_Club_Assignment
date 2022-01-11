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

  /**
   * Creates a temp boat.
   * 
   * @param boatId Unique id for boat.
   * 
   * @param type   Type of boat(sailing boat, motorboat e.g).
   * 
   * @param length Length of boat.
   */
  public Boat(String boatId, String type, double length) {
    this.boatId = boatId;
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

  /**
   * Sets name of boat.
   * 
   * @param boatId name of boat.
   * @param list   list of current members.
   * @return if it worked.
   */
  public boolean setBoatId(String boatId, ArrayList<Member> list) {
    if (checkId(boatId, list)) {
      return true;
    } else {
      finalizeBoatId(boatId);
      return false;
    }
  }

  private void finalizeBoatId(String boatId) {
    this.boatId = boatId;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setLength(int length) {
    this.length = length;
  }

  /**
   * Checks all names of boats.
   * 
   * @param name name of boat.
   * @param list list of current members.
   * @return if it worked.
   */
  public boolean checkId(String name, ArrayList<Member> list) {
    for (Member m : list) {
      ArrayList<Boat> boatlist = m.getBoatList();
      if (!boatlist.isEmpty()) {
        for (Boat b : boatlist) {
          if (b.getBoatId() != null) {
            if (b.getBoatId().equals(name)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}
