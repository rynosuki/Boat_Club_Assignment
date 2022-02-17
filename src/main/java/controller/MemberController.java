package controller;

import java.util.ArrayList;
import model.Boat;
import model.Member;
import model.MemberRegister;
// English view
import view.MemberView;
import view.View.ChoiceValue;
import view.View.ErrorMessage;
import view.View.MenuChoice;
import view.View.MessageRelated;

// Swedish view
//import view.MemberViewSwedish;

/**
 * Handles all the things related to the member object.
 */
public class MemberController {
  private Member model;
  private ArrayList<Member> list;
  private MemberRegister reg;

  // English view
  private MemberView view;

  // Swedish view
  // private MemberViewSwedish view;

  /**
   * Member controller.
   * 
   * @param memRegister Member register.
   * 
   */
  public MemberController(MemberRegister memRegister) {
    this.list = memRegister.getListCopy();
    this.reg = memRegister;

    // English view
    view = new MemberView();

    // Swedish view
    // view = new MemberViewSwedish();
  }

  public void setMemberName(String name) {
    model.setName(name);
  }

  public String getMemberName() {
    return model.getName();
  }

  public void setMemberPersonalNumber(String personalNumber) {
    model.setPersonalNumber(personalNumber);
  }

  public String getMemberPersonalNumber() {
    return model.getPersonalNumber();
  }

  public ArrayList<Boat> getMemberBoats() {
    return model.getBoatList();
  }

  public void setCurrentMember() {
    this.model = view.memberChoice(list);
  }

  protected Member getOwner() {
    return this.model;
  }

  /**
   * Used to create members and add them to the memberlist.
   */
  public void addMember() {
    String name = view.getInputValue(MessageRelated.NAME);
    // Just checks if name is longer than two letters otherwise try again.
    if (name.length() < 3) {
      view.printErrorMessage(ErrorMessage.NAMEERROR);
      addMember();
      return;
    }
    String personalNumber = view.getInputValue(MessageRelated.PERSONALNUMBER);

    // Asks memberregister to create the member with name and personalnumber,
    // then gets an updated copy of the list in return.
    this.list = this.reg.addMember(name, personalNumber);
  }

  public ArrayList<Member> getmemberlist() {
    return list;
  }

  public MenuChoice printMenu() {
    view.printView();
    return view.getMenuChoice();
  }

  public String getMemberId() {
    return model.getMemberId();
  }

  public void addBoatToMember(Boat boat) {
    model.addBoat(boat);
  }

  /**
   * Used to change member info, user provides which member needs to be changed.
   */
  public void changeMember() {
    this.model = view.memberChoice(list);
    ChoiceValue choice = view.changeChoice();
    switch (choice) {
      case NAME:
        setMemberName(view.getInputValue(MessageRelated.NAME));
        view.printMemberList(list);
        break;
      case PERSONALNUMBER:
        setMemberPersonalNumber(view.getInputValue(MessageRelated.PERSONALNUMBER));
        break;
      case QUIT:
        break;
      default:
        break;
    }
  }

  public void overviewMember() {
    Member memberChoice = view.memberChoice(list);
    view.showOverview(memberChoice);
  }

  /**
   * Delete member.
   */
  public void deleteMember() {
    Member memberChoice = view.memberChoice(list);
    reg.deleteMember(memberChoice);
    this.list = reg.getListCopy();
  }

  public void deleteBoat(Boat boat) {
    model.removeBoat(boat);
  }

  public void verboseList() {
    view.printVerboseList(list);
  }

  public void compactList() {
    view.printCompactList(list);
  }

}
