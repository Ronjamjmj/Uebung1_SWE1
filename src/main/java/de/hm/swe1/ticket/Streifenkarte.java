
package de.hm.swe1.ticket;

import java.time.*;
import java.util.*;

/**
 * Streifenkarte: besitzt eine Anzahl Streifen und Zonen.
 * Für die Demo: gültig, wenn mindestens 1 Streifen übrig ist.
 * Entwertung reduziert Streifenanzahl (z. B. je nach Fahrt).
 */
public class Streifenkarte extends Ticket {
    private int streifen;
    private final List<Zone> zones;

    public Streifenkarte(String name, int streifen, List<Zone> zones) {
        super(name);
        this.streifen = streifen;
        this.zones = List.copyOf(zones);
    }

    public void entwerte(int anzahl) {
        if (anzahl < 0) throw new IllegalArgumentException("Anzahl muss >= 0 sein");
        streifen = Math.max(0, streifen - anzahl);
    }

    public int getStreifen() { return streifen; }

    @Override
    public boolean isValidAt(ZonedDateTime when) {
        return streifen > 0;
    }

    @Override
    public String summary() {
        return "Streifenkarte " + getName() + " " + zones + " (" + streifen + " übrig)";
    }

    @Override
    public Set<Zone> zones() {
        return new HashSet<>(zones);
    }
}
