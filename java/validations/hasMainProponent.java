package validations;

import domain.proposal.Proposal;

public class hasMainProponent implements ProposalValidator{
  @Override
  public boolean validate(Proposal proposal) {
    return proposal.hasMainProponent();
  }
}
