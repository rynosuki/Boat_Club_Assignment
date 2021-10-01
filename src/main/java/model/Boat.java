package model;

public class Boat {
  private int boatID;
  private String type;
  private int length;
  
  /**
   * Creates a boat object from input variables.
   * @param boatID Unique id for boat.
   * @param type Type of boat(sailing boat, motorboat e.g).
   * @param length Length of boat.
   */
  public Boat(int boatID, String type, int length) {
    this.boatID = boatID;
    this.type = type;
    this.length = length;
  }

  public int getBoatID() {
    return this.boatID;
  }

  public String getType() {
    return this.type;
  }

  public int getLength() {
    return this.length;
  }
  
  public void setBoatID(int boatID) {
    this.boatID = boatID;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
