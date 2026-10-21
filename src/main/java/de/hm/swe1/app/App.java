
package de.hm.swe1.app;

import de.hm.swe1.account.Nutzerkonto;
import de.hm.swe1.ticket.*;
import java.time.*;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Nutzerkonto DEMO_USER = new Nutzerkonto(
            "Max Mustermann",
            "max@example.com",
            "demo123"
    );

    public static void main(String[] args) {
        System.out.println("=== Fahrkarten-App ===");
        Scanner scanner = new Scanner(System.in);

        System.out.print("E-Mail: ");
        String email = scanner.nextLine();
        System.out.print("Passwort: ");
        String password = scanner.nextLine();

        if (!DEMO_USER.login(email, password)) {
            System.out.println("Login fehlgeschlagen. Bitte gültige Zugangsdaten verwenden.");
            return;
        }

        System.out.println("Login erfolgreich. Willkommen, " + DEMO_USER.getName() + "!");

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

        tickets.forEach(DEMO_USER::kaufe);
        System.out.println("Nutzerkonto: " + DEMO_USER.getName() + " (" + DEMO_USER.getEmail() + ")");

        for (Ticket t : tickets) {
            boolean valid = validator.isValidAt(t, now);
            System.out.println(t.summary() + " → gültig jetzt? " + (valid ? "JA" : "NEIN"));
        }

        System.out.println("Aktive Tickets im Nutzerkonto:");
        DEMO_USER.getAktiveTickets(now).forEach(t -> System.out.println(" - " + t.summary()));

        // Streifen entwerten und erneut prüfen
        t3.entwerte(2);
        boolean valid3 = validator.isValidAt(t3, now);
        System.out.println("Nach Entwertung: " + t3.summary() + " → gültig? " + (valid3 ? "JA" : "NEIN"));
    }
}
