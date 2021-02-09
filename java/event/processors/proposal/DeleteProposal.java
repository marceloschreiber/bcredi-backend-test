package event.processors.proposal;

import domain.event.Event;
import domain.proposal.Proposals;
import event.processors.EventProcessor;

public class DeleteProposal implements EventProcessor {
  @Override
  public void process(Event event, Proposals proposals) {
    proposals.remove(event.getData()[0]);
  }

  @Override
  public String getId() {
    return "proposal.delete";
  }
}
