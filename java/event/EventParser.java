package event;

import domain.event.Event;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EventParser {

  public static Collection<Event> parseMessagesToEvents(List<String> messages) {
    return messages
      .stream()
      .map(EventParser::parseMessage)
      .collect(Collectors.toList());
  }

  private static Event parseMessage(String message) {
    String[] columns = message.split(",");

    return new Event(columns);
  }

}
