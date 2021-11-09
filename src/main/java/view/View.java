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

  public void printView();

  public void printMessage(String message);
}
