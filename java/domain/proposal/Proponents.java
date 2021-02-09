package domain.proposal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Proponents {

  private Map<String, Proponent> proponents = new LinkedHashMap<>();
  private Optional<Proponent> main = Optional.empty();

  public void addProponent(Proponent proponent) {
    this.proponents.put(proponent.getId(), proponent);
  }

  public void setMain(Proponent proponent) {
    this.main = Optional.of(proponent);
  }

  public int size() {
    return this.proponents.size();
  }

  public boolean hasMain() {
    return main.isPresent();
  }

  public boolean areProponentsInLegalAge() {
    for(Proponent proponent : proponents.values()) {
      if(proponent.getAge() < 18) {
        return false;
      }
    }
    return true;
  }

  public Proponent getMain() {
    return main.get();
  }

}
