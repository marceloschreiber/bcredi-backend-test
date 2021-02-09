package domain.proposal;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Warranties {

  private Map<String, Warranty> warranties = new LinkedHashMap<>();

  public void addWarranty(Warranty warranty) {
    this.warranties.put(warranty.getId(), warranty);
  }

  public void remove(String warrantyId) {
    this.warranties.remove(warrantyId);
  }

  public boolean hasAtLeastOneWarranty() {
    for(Warranty warranty : warranties.values()) {
      if(warranty.getProvince().isValid()) {
        return true;
      }
    }
    return false;
  }

  public BigDecimal sum() {
    BigDecimal total = new BigDecimal(0);
    for(Warranty warranty : warranties.values()) {
      total = total.add(warranty.getValue());
    }
    return total;
  }

  public boolean containsNotValidProvinces() {
    for(Warranty warranty : warranties.values()) {
      if(!warranty.getProvince().isValid()) {
        return true;
      }
    }
    return false;
  }

  public Collection<Warranty> getValidWarranties() {
    return warranties
      .values()
      .stream()
      .filter(warranty -> warranty.getProvince().isValid())
      .collect(Collectors.toList());
  }

  public int size() {
    return warranties.size();
  }
}
