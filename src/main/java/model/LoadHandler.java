package model;

import java.util.ArrayList;

/**
 * Handles the loading of all elements of the program.
 */
public class LoadHandler implements FileHandler {
  private ArrayList<Member> memberList = new ArrayList<>();
  private ArrayList<Boat> boatList = new ArrayList<>();

  /**
   * Loads all the members abd boats.
   */
  public LoadHandler() {
    Member tempMember = new Member("Robin", "199503231897", new MemberId().generateMemberId("Robin", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Emma", "199506251514", new MemberId().generateMemberId("Emma", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Mattias", "199511185242", new MemberId().generateMemberId("Mattias", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Karl", "199312218583", new MemberId().generateMemberId("Karl", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Vendela", "199903184231", new MemberId().generateMemberId("Vendela", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Maja", "195212295321", new MemberId().generateMemberId("Maja", memberList));
    memberList.add(tempMember);

    /* Boats */
    Boat tempBoat = new Boat("S790", "sailboat", 6.5);
    this.memberList.get(0).addBoat(tempBoat);

    tempBoat = new Boat("S540", "sailboat", 10.0);
    this.memberList.get(0).addBoat(tempBoat);

    tempBoat = new Boat("MS100", "motorsailor", 17.2);
    this.memberList.get(1).addBoat(tempBoat);

    tempBoat = new Boat("MS069", "motorsailor", 20);
    this.memberList.get(2).addBoat(tempBoat);

    tempBoat = new Boat("K023", "kayak", 5.5);
    this.memberList.get(3).addBoat(tempBoat);

    tempBoat = new Boat("K378", "kayak", 4.8);
    this.memberList.get(4).addBoat(tempBoat);

    tempBoat = new Boat("C902", "canoe", 4.9);
    this.memberList.get(5).addBoat(tempBoat);
  }

  public ArrayList<Member> getMemberList() {
    return memberList;
  }

  public ArrayList<Boat> getboatList() {
    return boatList;
  }
}
