package domain.proposal;

import validations.ProposalValidator;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Proposals {

  private final Map<String, Proposal> proposals = new LinkedHashMap<>();
  private final Collection<ProposalValidator> validators;

  public Proposals(Collection<ProposalValidator> validators) {
    this.validators = validators;
  }

  public void addProposal(Proposal proposal) {
    proposals.put(proposal.getId(), proposal);
  }

  public void update(String id, Proposal proposal) {
    Proposal oldProposal = proposals.get(id);
    oldProposal.setLoanValue(proposal.getLoanValue());
    oldProposal.setNumberOfMonthlyInstallments(proposal.getNumberOfMonthlyInstallments());
  }

  public void remove(String id) {
    proposals.remove(id);
  }

  public void addWarrantyToProposal(String proposalId, Warranty warranty) {
    Proposal proposal = proposals.get(proposalId);
    proposal.addWarranty(warranty);
  }

  public void removeWarranty(String proposalId, String warrantyId) {
    Proposal proposal = proposals.get(proposalId);
    proposal.removeWarranty(warrantyId);
  }

  public void addProponent(String proposalId, Proponent proponent) {
    Proposal proposal = proposals.get(proposalId);
    proposal.addProponent(proponent);
  }

  public void setMainProponent(String proposalId, Proponent proponent) {
    Proposal proposal = proposals.get(proposalId);
    proposal.setMainProponent(proponent);
  }

  public String getValidProposals() {
    StringJoiner joiner = new StringJoiner(",");
    for(Proposal proposal : proposals.values()) {
      boolean isValid = true;
      for(ProposalValidator validator : validators) {
        if(!validator.validate(proposal)) {
          isValid = false;
          break;
        };
      }
      if(isValid) {
        joiner.add(proposal.getId());
      }
    }
    return joiner.toString();
  }
}
