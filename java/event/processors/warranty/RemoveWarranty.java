package event.processors.warranty;

import domain.event.Event;
import domain.proposal.Proposals;
import event.processors.EventProcessor;

public class RemoveWarranty implements EventProcessor {
  @Override
  public void process(Event event, Proposals proposals) {
    String[] data = event.getData();
    String proposalId = data[0];
    String warrantyId = data[1];

    proposals.removeWarranty(proposalId, warrantyId);
  }

  @Override
  public String getId() {
    return "warranty.removed";
  }
}
