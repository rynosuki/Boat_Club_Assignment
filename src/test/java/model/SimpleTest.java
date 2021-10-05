package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import controller.MemberController;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;




public class SimpleTest {
  ArrayList<Member> members = new ArrayList<>();
  MemberController controller = new MemberController(members);

  @Test
  public void creationofMember() {
    Member sut = new Member("Robin", "199503231897", 
        new MemberId().generateMemberId("Robin", members));
    members.add(sut);

    assertTrue(members.size() > 0, "Member is not added to list.");
  }

  @Test
  public void deletionofAllMembers() {
    for (int i = 0; i < members.size(); i++) {
      members.remove(members.get(0));
    }
  
    assertTrue(members.size() == 0, "Still members in list.");
  }
  
}
