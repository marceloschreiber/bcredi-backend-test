package domain.proposal;

import java.math.BigDecimal;

public class Proponent {

  private String id;
  private String name;
  private Integer age;
  private BigDecimal monthlyIncome;

  public Proponent(String[] data) {
    this.id = data[1];
    this.name = data[2];
    this.age = Integer.parseInt(data[3]);
    this.monthlyIncome = new BigDecimal(data[4]);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public BigDecimal getMonthlyIncome() {
    return monthlyIncome;
  }

  public void setMonthlyIncome(BigDecimal monthlyIncome) {
    this.monthlyIncome = monthlyIncome;
  }
}
