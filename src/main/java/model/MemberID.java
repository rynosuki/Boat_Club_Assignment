package model;

import java.util.ArrayList;
import java.util.Random;

public class MemberID {
  public String generateMemberID(String name, ArrayList<Member> members) {
    Random rand = new Random();
    String name1 = name.substring(0, 2);
    int number = rand.nextInt(9);
    int number1 = rand.nextInt(9);
    int firstL = rand.nextInt(24);
    int secondL = rand.nextInt(24);
    boolean check = true;
    do {
      name1 = name1.concat(String.valueOf(number)).concat(String.valueOf(number1)).concat(Character.toString((char)firstL+65)).concat(Character.toString((char)secondL+65));
      if (isDuplicate(name1, members) == true) {
        name1 = name.substring(0,2);
        number = rand.nextInt(9);
        number1 = rand.nextInt(9);
        firstL = rand.nextInt(27);
        secondL = rand.nextInt(27);
      } else {
        check = false;
      }
    } while(check == true);
    return name1;
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
