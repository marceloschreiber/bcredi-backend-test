package event.processors.proponent;

import domain.event.Event;
import domain.proposal.Proponent;
import domain.proposal.Proposals;
import event.processors.EventProcessor;

public class AddProponent implements EventProcessor {
  @Override
  public void process(Event event, Proposals proposals) {
    String[] data = event.getData();
    String proposalId = data[0];
    Proponent proponent = new Proponent(data);

    proposals.addProponent(proposalId, proponent);

    if(Boolean.parseBoolean(data[5])) {
      proposals.setMainProponent(proposalId, proponent);
    }
  }

  @Override
  public String getId() {
    return "proponent.added";
  }
}
