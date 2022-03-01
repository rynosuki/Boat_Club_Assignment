package model;

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
  protected Boat(String boatId, String type, double length) {
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
  protected void setBoatId(String boatId) {
    this.boatId = boatId;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
