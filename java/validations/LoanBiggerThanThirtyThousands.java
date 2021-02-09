package validations;

import domain.proposal.Proposal;

import java.math.BigDecimal;

public class LoanBiggerThanThirtyThousands implements ProposalValidator {

  @Override
  public boolean validate(Proposal proposal) {
    return proposal.getLoanValue().compareTo(BigDecimal.valueOf(30000)) > 0;
  }
}
