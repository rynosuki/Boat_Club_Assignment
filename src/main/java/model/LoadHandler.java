package model;

import java.util.ArrayList;

/**
 * Handles the loading of all elements of the program.
 */
public class LoadHandler implements FileHandler {
  ArrayList<Member> memberList = new ArrayList<>();
  //ArrayList<Boat> bList = new ArrayList<>();
  
  /**
   * Loads all the members.
   */
  public LoadHandler() {
    Member tempMember = new Member("Robin", "199503231897", 
        new MemberId().generateMemberId("Robin", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Emma", "199506251514", 
        new MemberId().generateMemberId("Emma", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Mattias", "199511185242", 
        new MemberId().generateMemberId("Mattias", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Karl", "199312218583", 
        new MemberId().generateMemberId("Karl", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Vendela", "199903184231", 
        new MemberId().generateMemberId("Vendela", memberList));
    memberList.add(tempMember);
    tempMember = new Member("Maja", "195212295321", 
        new MemberId().generateMemberId("Maja", memberList));
    memberList.add(tempMember);
  }

  public ArrayList<Member> getMemberList() {
    return memberList;
  }
}
