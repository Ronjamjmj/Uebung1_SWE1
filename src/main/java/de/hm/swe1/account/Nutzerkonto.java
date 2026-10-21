package de.hm.swe1.account;

import de.hm.swe1.ticket.Ticket;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Einfaches Nutzerkonto mit einer persönlichen Sammlung gekaufter Tickets.
 */
public class Nutzerkonto {
    private final String name;
    private final String email;
    private final String password;
    private final List<Ticket> tickets = new ArrayList<>();

    public Nutzerkonto(String name, String email) {
        this(name, email, null);
    }

    public Nutzerkonto(String name, String email, String password) {
        this.name = requireText(name, "Name");
        this.email = requireText(email, "E-Mail");
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String email, String password) {
        return this.email.equalsIgnoreCase(email) && Objects.equals(this.password, password);
    }

    public void kaufe(Ticket ticket) {
        tickets.add(Objects.requireNonNull(ticket, "Ticket darf nicht null sein"));
    }

    public List<Ticket> getTickets() {
        return List.copyOf(tickets);
    }

    public List<Ticket> getAktiveTickets(ZonedDateTime zeitpunkt) {
        Objects.requireNonNull(zeitpunkt, "Zeitpunkt darf nicht null sein");
        return tickets.stream()
                .filter(ticket -> ticket.isValidAt(zeitpunkt))
                .toList();
    }

    private static String requireText(String value, String feld) {
        Objects.requireNonNull(value, feld + " darf nicht null sein");
        if (value.isBlank()) {
            throw new IllegalArgumentException(feld + " darf nicht leer sein");
        }
        return value;
    }
}
