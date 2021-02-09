package validations;

import domain.proposal.Proposal;

public class LoanTimeLessOrEqualToFifteenYears implements ProposalValidator {
  @Override
  public boolean validate(Proposal proposal) {
    return proposal.getNumberOfMonthlyInstallments() <= (12 * 15);
  }
}
