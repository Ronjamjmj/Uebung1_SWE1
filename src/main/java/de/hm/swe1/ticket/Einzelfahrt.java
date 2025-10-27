
package de.hm.swe1.ticket;

import java.time.*;
import java.util.Set;

/**
 * Einzelfahrt: ab Startzeitpunkt für eine feste Dauer gültig (vereinfachtes Beispiel).
 */
public class Einzelfahrt extends Ticket {
    private final String relation;
    private final Zone zone;
    private final ZonedDateTime start;
    private final Duration duration;

    public Einzelfahrt(String name, Zone zone, ZonedDateTime start, Duration duration) {
        super(name);
        this.relation = "Einzelfahrt";
        this.zone = zone;
        this.start = start;
        this.duration = duration;
    }

    @Override
    public boolean isValidAt(ZonedDateTime when) {
        return !when.isBefore(start) && !when.isAfter(start.plus(duration));
    }

    @Override
    public String summary() {
        return relation + " " + getName() + " [" + zone + "] ab " + start.toLocalTime() + " für " + duration.toMinutes() + "m";
    }

    @Override
    public Set<Zone> zones() {
        return Set.of(zone);
    }
}
