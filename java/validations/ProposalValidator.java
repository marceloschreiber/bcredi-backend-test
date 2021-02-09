package validations;

import domain.proposal.Proposal;

public interface ProposalValidator {
  boolean validate(Proposal proposal);
}
