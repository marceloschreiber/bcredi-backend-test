package validations;

import domain.proposal.Proposal;

public class HasAtLeastOneWarranty implements ProposalValidator {
  @Override
  public boolean validate(Proposal proposal) {
    return proposal.getValidWarranties().size() >= 1;
  }
}
