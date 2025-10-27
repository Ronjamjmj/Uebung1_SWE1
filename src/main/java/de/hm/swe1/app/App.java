
package de.hm.swe1.app;

import de.hm.swe1.ticket.*;
import java.time.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Fahrkarten-App Demo");
        TicketValidator validator = new TicketValidator();

        // Beispiel 1: Einzelfahrt ab jetzt gültig für 90 Minuten (vereinfacht)
        Ticket t1 = new Einzelfahrt("München", Zone.M, ZonedDateTime.now(), Duration.ofMinutes(90));

        // Beispiel 2: Monatskarte gültig vom 1. des Monats
        Ticket t2 = new Monatskarte("Monatskarte M+1", List.of(Zone.M, Zone.ZONE1),
                LocalDate.now().withDayOfMonth(1));

        // Beispiel 3: Streifenkarte mit 10 Streifen (vereinfacht)
        Streifenkarte t3 = new Streifenkarte("10er-Streifen", 10, List.of(Zone.M, Zone.ZONE1));

        ZonedDateTime now = ZonedDateTime.now();
        List<Ticket> tickets = List.of(t1, t2, t3);

        for (Ticket t : tickets) {
            boolean valid = validator.isValidAt(t, now);
            System.out.println(t.summary() + " → gültig jetzt? " + (valid ? "JA" : "NEIN"));
        }

        // Streifen entwerten und erneut prüfen
        t3.entwerte(2);
        boolean valid3 = validator.isValidAt(t3, now);
        System.out.println("Nach Entwertung: " + t3.summary() + " → gültig? " + (valid3 ? "JA" : "NEIN"));
    }
}
