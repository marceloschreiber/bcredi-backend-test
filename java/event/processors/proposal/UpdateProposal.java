package event.processors.proposal;

import domain.event.Event;
import domain.proposal.Proposal;
import domain.proposal.Proposals;
import event.processors.EventProcessor;

public class UpdateProposal implements EventProcessor {
  @Override
  public void process(Event event, Proposals proposals) {
    Proposal proposal = new Proposal(event.getData());
    proposals.update(proposal.getId(), proposal);
  }

  @Override
  public String getId() {
    return "proposal.update";
  }
}
