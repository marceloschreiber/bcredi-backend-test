package event;

import domain.event.Event;
import domain.event.Events;
import domain.proposal.Proposals;
import event.processors.EventProcessor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EventProcessorManager {

  private final Map<String, EventProcessor> processors = new HashMap<>();
  private final Proposals proposals;

  public EventProcessorManager(Proposals proposals, Collection<EventProcessor> eventProcessors) {
    this.proposals = proposals;

    for(EventProcessor eventProcessor : eventProcessors) {
      processors.put(eventProcessor.getId(), eventProcessor);
    }
  }

  public void processEvents(Events events) {
    for(Event event : events.getAll()) {
      EventProcessor eventProcessor = processors.get(event.getFormattedEvent());

      Objects.requireNonNull(eventProcessor);

      eventProcessor.process(event, proposals);
    }
  }
}
