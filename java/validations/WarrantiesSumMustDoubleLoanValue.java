package validations;

import domain.proposal.Proposal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WarrantiesSumMustDoubleLoanValue implements ProposalValidator {
  @Override
  public boolean validate(Proposal proposal) {
    BigDecimal warrantiesSum = proposal.getWarranties().sum();
    return warrantiesSum.divide(proposal.getLoanValue(), RoundingMode.FLOOR).compareTo(BigDecimal.valueOf(2)) > 0;
  }
}
