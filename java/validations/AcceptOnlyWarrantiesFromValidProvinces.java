package validations;

import domain.proposal.Proposal;
import domain.proposal.Warranties;

public class AcceptOnlyWarrantiesFromValidProvinces implements ProposalValidator {
  @Override
  public boolean validate(Proposal proposal) {
    Warranties warranties = proposal.getWarranties();
    return warranties.getValidWarranties().size() == warranties.size();
  }
}
