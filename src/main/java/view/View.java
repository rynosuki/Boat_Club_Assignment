package view;

/**
 * Interface for all the views.
 */
public interface View {
  /**
   * Used as interface for views.
   */
  public enum MenuChoice {
    ADD, DEL, CHANGE, VIEW, VERBOSE, COMPACT, QUIT, BOAT, MEMBER
  }

  public enum MessageRelated {
    NAME, BOATTYPE, BOATLENGTH, PERSONALNUMBER,
  }

  public enum ErrorMessage {
    ANYERROR, NAMEERROR
  }

  public enum ChoiceValue {
    ID, TYPE, QUIT, NAME, PERSONALNUMBER
  }

  public void printView();

  public void printErrorMessage(ErrorMessage message);
}
