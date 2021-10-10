package model;

/**
 * Model of the boat class.
 */
public class Boat {
  private String boatId;
  private String type;
  private int length;
  
  /**
   * Creates a boat object from input variables.

   * @param boatId Unique id for boat.

   * @param type Type of boat(sailing boat, motorboat e.g).

   * @param length Length of boat.
   */
  public Boat(String boatId, String type, int length) {
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

  public int getLength() {
    return this.length;
  }
  
  public void setBoatId(String name) {
    this.boatId = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
