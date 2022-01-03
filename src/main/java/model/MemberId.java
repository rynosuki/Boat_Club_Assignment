package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Handles creation of memberIDs and also returns it.
 */
public class MemberId {

  /**
   * Create memberid for the members.
   */
  public String generateMemberId(String name, ArrayList<Member> members) {
    Random rand = new Random();
    boolean check = true;
    do {
      String memberid = name.substring(0, 2);
      int number = rand.nextInt(90) + 10;
      int firstL = rand.nextInt(25);
      int secondL = rand.nextInt(25);

      memberid = memberid.concat(String.valueOf(number))
          .concat(Character.toString((char) (firstL + 65)))
          .concat(Character.toString((char) (secondL + 65)));

      if (isDuplicate(memberid, members) == false) {
        return memberid;
      }
    } while (check == true);
    return null;
  }

  private boolean isDuplicate(String memberid, ArrayList<Member> members) {
    for (Member m : members) {
      if (m.getMemberId().equals(memberid)) {
        return true;
      }
    }
    return false;
  }
}