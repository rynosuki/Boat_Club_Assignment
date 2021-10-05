package model;

import java.util.ArrayList;

public class LoadHandler {
  ArrayList<Member> mList = new ArrayList<>();
  ArrayList<Boat> bList = new ArrayList<>();
  
  public LoadHandler() {
    Member tempMember = new Member("Robin", "199503231897", new MemberID().generateMemberID("Robin", mList));
    mList.add(tempMember);
    tempMember = new Member("Emma", "199506251514", new MemberID().generateMemberID("Emma", mList));
    mList.add(tempMember);
    tempMember = new Member("Mattias", "199511185242", new MemberID().generateMemberID("Mattias", mList));
    mList.add(tempMember);
    tempMember = new Member("Karl", "199312218583", new MemberID().generateMemberID("Karl", mList));
    mList.add(tempMember);
    tempMember = new Member("Vendela", "199903184231", new MemberID().generateMemberID("Vendela", mList));
    mList.add(tempMember);
    tempMember = new Member("Maja", "195212295321", new MemberID().generateMemberID("Maja", mList));
    mList.add(tempMember);
  }

  public ArrayList<Member> getMemberList() {
    return mList;
  }
}
