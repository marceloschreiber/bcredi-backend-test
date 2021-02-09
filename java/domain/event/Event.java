package domain.event;

import java.time.Instant;
import java.util.Arrays;

public class Event {

  private final String id;
  private final String schema;
  private final String action;
  private final Instant instant;
  private String[] data;

  public Event(String[] columns) {
    this.id = columns[0];
    this.schema = columns[1];
    this.action = columns[2];
    this.instant = Instant.parse(columns[3]);
    this.data = Arrays.copyOfRange(columns, 4, columns.length);
  }

  public String getId() {
    return id;
  }

  public String getSchema() {
    return schema;
  }

  public String getAction() {
    return action;
  }

  public Instant getInstant() {
    return instant;
  }

  public String[] getData() {
    return data;
  }

  public String getFormattedEvent() {
    return schema + "." + action;
  }
}
