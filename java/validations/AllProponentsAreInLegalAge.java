package validations;

import domain.proposal.Proposal;

public class AllProponentsAreInLegalAge implements ProposalValidator {
  @Override
  public boolean validate(Proposal proposal) {
    return proposal.areProponentsInLegalAge();
  }
}
