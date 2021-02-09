package domain.proposal;

public class Province {

  private final String name;

  public Province(String name) {
    this.name = name;
  }

  public boolean isValid() {
    if(name.equals("RS") || name.equals("PR") || name.equals("SC")) {
      return false;
    }
    return true;
  }
}
