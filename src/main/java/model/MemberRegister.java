package model;

import java.util.ArrayList;

public class MemberRegister {
  private ArrayList<Member> list;

  public MemberRegister(ArrayList<Member> list) {
    this.list = list;
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
   * @return
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
}
