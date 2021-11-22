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

  public void addMember(Member member) {
    list.add(member);
  }

  public void deleteMember(Member model) {
    this.list.remove(model);
  }

  public int getListSize() {
    return list.size();
  }
}
