package model;

import java.util.ArrayList;

public class MemberRegister {
  private ArrayList<Member> list;

  public MemberRegister() {
    this.list = new ArrayList<>();
  }

  public ArrayList<Member> getListCopy() {
    ArrayList<Member> tempList = new ArrayList<>(list);
    return tempList;
  }

  /**
   * Create member to add to list.
   * 
   * @param name           Name of member.
   * @param personalNumber Personalnumber of member.
   * @return list copy.
   */
  public ArrayList<Member> addMember(String name, String personalNumber) {
    Member tempMember = new Member(
        name, personalNumber, new MemberId().generateMemberId(name, this.getListCopy()));
    this.list.add(tempMember);
    return getListCopy();
  }

  public void deleteMember(Member model) {
    this.list.remove(model);
  }

  public int getListSize() {
    return list.size();
  }

  /**
   * Create boat.
   * @param name name of boat.
   * @param type type of boat.
   * @param length length of boat.
   * @param owner the owner of the boat.
   * @return trua/false.
   */
  public Boolean createBoat(String name, String type, double length, Member owner) {
    if (checkBoatId(name)) {
      Boat tempBoat = new Boat(name, type, length);
      list.get(list.indexOf(owner)).addBoat(tempBoat);
      return true;
    }
    return false;
  }

  /**
   * CHange boat id(name).
   * @param name boat name.
   * @param boat the boat object.
   * @return true/false.
   */
  public boolean changeBoatId(String name, Boat boat) {
    if (checkBoatId(name)) {
      boat.setBoatId(name);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Check boat id(name).
   * @param name name.
   * @return true/false
   */
  public boolean checkBoatId(String name) {
    for (Member m : list) {
      ArrayList<Boat> boatlist = m.getBoatList();
      if (!boatlist.isEmpty()) {
        for (Boat b : boatlist) {
          if (b.getBoatId() != null) {
            if (b.getBoatId().equals(name)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}
