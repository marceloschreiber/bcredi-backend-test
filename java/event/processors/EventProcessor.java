package event.processors;

import domain.event.Event;
import domain.proposal.Proposals;

public interface EventProcessor {

  void process(Event event, Proposals proposals);
  String getId();
}
