
package de.hm.swe1.ticket;

import java.time.*;
import java.util.*;

/**
 * Abstrakte Basis für Tickets.
 * Zeigt Generalisierung (UML): gemeinsame Attribute/Verhalten.
 */
public abstract class Ticket {
    private final String name;
    /** Demonstriert Klassenattribut (z. B. MwSt) – hier nur informativ. */
    protected static final double MWST = 0.07;

    protected Ticket(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    /** Kurze Zusammenfassung für die Demoausgabe. */
    public abstract String summary();

    /** Prüft Gültigkeit für Zeitpunkt/Zonen – Standard: Zeitpunkt. */
    public abstract boolean isValidAt(ZonedDateTime when);

    /** Optional: Zonen, falls das Ticket zonenbasiert ist. */
    public Set<Zone> zones() { return Set.of(); }
}
