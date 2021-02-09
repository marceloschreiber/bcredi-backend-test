package validations;

import domain.proposal.Proposal;

public class AtLeastToProponents  implements ProposalValidator {
  @Override
  public boolean validate(Proposal proposal) {
    return proposal.getProponentsSize() >= 2;
  }
}
