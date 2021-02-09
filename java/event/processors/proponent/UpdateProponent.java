package event.processors.proponent;

import domain.event.Event;
import domain.proposal.Proposals;
import event.processors.EventProcessor;

public class UpdateProponent implements EventProcessor {
  @Override
  public void process(Event event, Proposals proposals) {

  }

  @Override
  public String getId() {
    return "proponent.updated";
  }
}
