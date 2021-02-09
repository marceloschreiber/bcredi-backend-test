package domain.proposal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

public class Proposal {

  private final String id;
  private BigDecimal loanValue;
  private Integer numberOfMonthlyInstallments;

  private final Warranties warranties;
  private final Proponents proponents;

  private boolean isValid = true;

  public Proposal(String[] data) {
    this.id = data[0];
    this.loanValue = new BigDecimal(data[1]);
    this.numberOfMonthlyInstallments = Integer.parseInt(data[2]);
    this.warranties = new Warranties();
    this.proponents = new Proponents();
  }

  public String getId() {
    return id;
  }

  public BigDecimal getLoanValue() {
    return loanValue;
  }

  public Integer getNumberOfMonthlyInstallments() {
    return numberOfMonthlyInstallments;
  }

  public Warranties getWarranties() {
    return warranties;
  }

  public void setLoanValue(BigDecimal loanValue) {
    this.loanValue = loanValue;
  }

  public void setNumberOfMonthlyInstallments(Integer numberOfMonthlyInstallments) {
    this.numberOfMonthlyInstallments = numberOfMonthlyInstallments;
  }

  public int getProponentsSize() {
    return this.proponents.size();
  }

  public boolean isValid() {
    BigDecimal min = new BigDecimal("30000.00");
    BigDecimal max = new BigDecimal("3000000.00");

    if(loanValue.compareTo(min) < 0) {
      return false;
    }
    if(loanValue.compareTo(max) > 0) {
      return false;
    }

    if ((numberOfMonthlyInstallments < (12 * 2)) || numberOfMonthlyInstallments > (12 * 15)) {
      return false;
    }
    if (proponents.size() < 2) {
      return false;
    }
    if (!proponents.hasMain()) {
      return false;
    }
    if (!proponents.areProponentsInLegalAge()) {
      return false;
    }
    if (!warranties.hasAtLeastOneWarranty()) {
      return false;
    }

    if(warranties.sum().compareTo(loanValue.multiply(new BigDecimal(2))) < 0) {
      return false;
    }
    if(warranties.containsNotValidProvinces()) {
      return false;
    }
    Proponent main = proponents.getMain();
    if (main.getAge() >= 18 && main.getAge() < 24) {
      if(main.getMonthlyIncome().divide(getMonthlyValue(), RoundingMode.FLOOR).compareTo(new BigDecimal("4")) < 0) {
        return false;
      }
    } else if (main.getAge() >= 24 && main.getAge() < 50) {
      if(main.getMonthlyIncome().divide(getMonthlyValue(), RoundingMode.FLOOR).compareTo(new BigDecimal("3")) < 0) {
        return false;
      }
    } else if (main.getAge() >= 50) {
      if(main.getMonthlyIncome().divide(getMonthlyValue(), RoundingMode.FLOOR).compareTo(new BigDecimal("2")) < 0) {
        return false;
      }
    }
    return true;
  }

  public void addWarranty(Warranty warranty) {
    this.warranties.addWarranty(warranty);
  }

  public void removeWarranty(String warrantyId) {
    this.warranties.remove(warrantyId);
  }

  public void addProponent(Proponent proponent) {
    this.proponents.addProponent(proponent);
  }

  public void setMainProponent(Proponent proponent) {
    this.proponents.setMain(proponent);
  }

  public BigDecimal getMonthlyValue() {
    return loanValue.divide(BigDecimal.valueOf(numberOfMonthlyInstallments), RoundingMode.FLOOR);
  }

  public boolean hasMainProponent() {
    return proponents.hasMain();
  }

  public boolean areProponentsInLegalAge() {
    return proponents.areProponentsInLegalAge();
  }

  public Collection<Warranty> getValidWarranties() {
    return warranties.getValidWarranties();
  }
}
