package domain.event;

import java.util.Collection;

public class Events {

  private final Collection<Event> events;

  public Events(Collection<Event> events) {
    this.events = events;
  }

  public Collection<Event> getAll() {
    return events;
  }
}
