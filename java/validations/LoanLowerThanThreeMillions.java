package validations;

import domain.proposal.Proposal;

import java.math.BigDecimal;

public class LoanLowerThanThreeMillions implements ProposalValidator {
  @Override
  public boolean validate(Proposal proposal) {
    return proposal.getLoanValue().compareTo(BigDecimal.valueOf(3000000)) < 0;
  }
}
