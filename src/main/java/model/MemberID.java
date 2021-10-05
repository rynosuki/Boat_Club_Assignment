package model;

import java.util.ArrayList;
import java.util.Random;

public class MemberID {
  public String generateMemberID(String name, ArrayList<Member> members) {
    Random rand = new Random();
    boolean check = true;
    do {
      String name1 = name.substring(0,2);
      int number = rand.nextInt(9);
      int number1 = rand.nextInt(9);
      int firstL = rand.nextInt(26);
      int secondL = rand.nextInt(26);
      name1 = name1.concat(String.valueOf(number)).concat(String.valueOf(number1)).concat(Character.toString((char)firstL+65)).concat(Character.toString((char)secondL+65));
      if (isDuplicate(name1, members) == false) {
        check = false;
        return name1;
      }
    } while(check == true);
    return null;
  }

  private boolean isDuplicate(String name, ArrayList<Member> members) {
    if ( members.size() != 0) {
      for (int i = 0; i < members.size(); i++) {
        if (name.equals(members.get(i).getMemberID())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }

}
