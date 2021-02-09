package domain.proposal;

import java.math.BigDecimal;

public class Warranty {
  private String id;
  private BigDecimal value;
  private Province province;

  public Warranty(String[] eventData) {
    this.id = eventData[1];
    this.value = new BigDecimal(eventData[2]);
    this.province = new Province(eventData[3]);
  }

  public String getId() {
    return id;
  }

  public BigDecimal getValue() {
    return value;
  }

  public Province getProvince() {
    return province;
  }
}
