package event.processors.warranty;

import domain.event.Event;
import domain.proposal.Proposals;
import domain.proposal.Warranty;
import event.processors.EventProcessor;

public class AddWarranty implements EventProcessor {
  @Override
  public void process(Event event, Proposals proposals) {
    String[] eventData = event.getData();
    String proposalId = eventData[0];
    Warranty warranty = new Warranty(eventData);
    proposals.addWarrantyToProposal(proposalId, warranty);
  }

  @Override
  public String getId() {
    return "warranty.added";
  }
}
