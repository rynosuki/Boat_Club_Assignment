package model;

/**
 * Handles the loading of all elements of the program.
 */
public class LoadHandler implements FileHandler {
  private MemberRegister registry = new MemberRegister();

  /**
   * Loads all the members abd boats.
   */
  public LoadHandler() {
    registry.addMember("Robin", "199503231897");
    registry.addMember("Emma", "199506251514");
    registry.addMember("Mattias", "199511185242");
    registry.addMember("Karl", "199312218583");
    registry.addMember("Vendela", "199903184231");
    registry.addMember("Maja", "195212295321");

    /* Boats */
    registry.createBoat("S790", "sailboat", 6.5, registry.getListCopy().get(0));
    registry.createBoat("S540", "sailboat", 10.0, registry.getListCopy().get(0));
    registry.createBoat("MS100", "motorsailor", 17.2, registry.getListCopy().get(1));
    registry.createBoat("MS069", "motorsailor", 20, registry.getListCopy().get(2));
    registry.createBoat("K023", "kayak", 5.5, registry.getListCopy().get(3));
    registry.createBoat("K378", "kayak", 4.8, registry.getListCopy().get(4));
    registry.createBoat("C902", "canoe", 4.9, registry.getListCopy().get(5));
  }

  public MemberRegister getMemberRegistry() {
    return this.registry;
  }
}
