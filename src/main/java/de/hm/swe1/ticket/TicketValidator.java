
package de.hm.swe1.ticket;

import java.time.*;
import java.util.Set;

/**
 * Verantwortlichkeitsprinzip: zentrale Stelle für Prüfregeln.
 * Kann später Preise, Relationen, Tariflogik etc. aufnehmen.
 */
public class TicketValidator {

    /**
     * Prüft, ob ein Ticket zum Zeitpunkt gültig ist.
     * Zonenregeln könnten hier ergänzt werden (z. B. Fahrt in Zone M → Ticket muss Zone M enthalten).
     */
    public boolean isValidAt(Ticket ticket, ZonedDateTime when) {
        return ticket.isValidAt(when);
    }

    /** Beispielhafter Check: braucht das Ticket eine bestimmte Zone? */
    public boolean permitsZone(Ticket ticket, Zone requiredZone) {
        Set<Zone> zones = ticket.zones();
        return zones.isEmpty() || zones.contains(requiredZone);
    }
}
