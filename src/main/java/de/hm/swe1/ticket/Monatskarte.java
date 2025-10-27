
package de.hm.swe1.ticket;

import java.time.*;
import java.util.*;

/**
 * Monatskarte: gültig von Monatserstem 00:00 bis Monatsletzter 24:00 (vereinfacht).
 */
public class Monatskarte extends Ticket {
    private final List<Zone> zones;
    private final LocalDate monthStart; // z. B. 2025-10-01

    public Monatskarte(String name, List<Zone> zones, LocalDate monthStart) {
        super(name);
        this.zones = List.copyOf(zones);
        this.monthStart = monthStart;
    }

    @Override
    public boolean isValidAt(ZonedDateTime when) {
        LocalDate start = monthStart.withDayOfMonth(1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
        LocalDate d = when.toLocalDate();
        return !d.isBefore(start) && !d.isAfter(end);
    }

    @Override
    public String summary() {
        return "Monatskarte " + getName() + " " + zones;
    }

    @Override
    public Set<Zone> zones() {
        return new HashSet<>(zones);
    }
}
