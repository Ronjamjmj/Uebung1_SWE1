
# Fahrkarten-App Starter (Java 17, Maven, VS Code + Copilot)

Dieser Starter ist **für Einsteiger:innen** gedacht. Er zeigt, wie man eine einfache
Fahrkarten-Domäne (Einzelfahrt, Streifenkarte, Monatskarte) modelliert und überprüft.

---

## 0) Was wir bauen
- **Domänenklassen**: `Ticket` (abstrakt), `Einzelfahrt`, `Streifenkarte`, `Monatskarte`
- **Service**: `TicketValidator` prüft die Gültigkeit
- **CLI-Demo**: `App` erzeugt Tickets, prüft Gültigkeit, druckt Ergebnisse

> Hinweis: Das ist ein didaktisches Beispiel – stark vereinfacht und nicht rechtsverbindlich.

---

## 1) Installationen

### macOS
1. **Homebrew** (falls noch nicht vorhanden)
   - Öffne „Terminal“.
   - Führe aus:  
     ```bash
     /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
     ```
2. **Java 17** installieren und prüfen
   ```bash
   brew install temurin
   java -version
   ```
3. **Maven** installieren und prüfen
   ```bash
   brew install maven
   mvn -version
   ```
4. **Git** installieren und prüfen
   ```bash
   brew install git
   git --version
   ```
5. **VS Code** installieren: https://code.visualstudio.com/
6. VS Code öffnen → Extensions (Icon links) → installiere:
   - **Java Extension Pack**
   - **GitHub Copilot**
   - **GitHub Copilot Chat**

### Windows
1. **Java 17** (Temurin) installieren: https://adoptium.net/  
   Danach in „Windows Terminal“ oder „PowerShell“ prüfen:
   ```powershell
   java -version
   ```
2. **Maven** installieren: https://maven.apache.org/download.cgi  
   `bin`-Ordner zur `PATH`-Umgebungsvariable hinzufügen. Prüfen:
   ```powershell
   mvn -version
   ```
3. **Git for Windows** installieren: https://git-scm.com/download/win  
   Prüfen:
   ```powershell
   git --version
   ```
4. **VS Code** installieren: https://code.visualstudio.com/  
   Extensions installieren:
   - **Java Extension Pack**
   - **GitHub Copilot**
   - **GitHub Copilot Chat**

---

## 2) Projekt öffnen & starten
1. Diese ZIP entpacken.
2. In **VS Code**: `Datei > Ordner öffnen…` und den Projektordner wählen.
3. VS Code fragt evtl. nach Vertrauen → **„Ja, ich vertraue…“**.
4. Java wird erkannt; der Java-Server startet.
5. Starten:
   - **Run > Run Without Debugging** (oder „Run App“ in der Run-Leiste), **oder**
   - Terminal:
     ```bash
     mvn -q exec:java
     ```

> Alternativ-Skripte: `scripts/run.sh` (macOS/Linux) oder `scripts\run.ps1` (Windows PowerShell).

---

## 3) Von Modell zu Code mit Copilot (Beispiele)

- **Neue Ticketart**:  
  *„Erzeuge eine Klasse `Tageskarte` als Subklasse von `Ticket` mit Startdatum und Gültigkeit bis 04:00 des Folgetags. JavaDoc bitte nach UML-Begriffen.“*

- **Assoziation / Aggregation**:  
  *„Füge `Kunde` hinzu und modellierte `List<Ticket>` im Kunden (1..*). Ergänze `purchase(Ticket)` und `getActiveTickets(at)`.“*

- **Sequenzdiagramm skizzieren**:  
  *„Erzeuge ein Mermaid-Sequenzdiagramm, das `App → TicketValidator → Ticket.isValidAt(...)` zeigt.“*

> Faustregeln UML → Code:  
> Klassen ⇒ Java-Klassen, Attribute ⇒ private Felder + Getter/Setter, Generalisierung ⇒ `abstract`/`interface`, Assoziationen 1..* ⇒ `List<T>` und sprechende Methoden.

---

## 4) Git (optional, empfohlen)
```bash
git init
git add .
git commit -m "Init Fahrkarten starter"
# Repository erstellen (GitHub) und verbinden:
git remote add origin <URL>
git branch -M main
git push -u origin main
```

---

## 5) Nächste Übungen
- Tests erst in einer späteren Übung: JUnit ist im `pom.xml` bereits vorbereitet (auskommentiert).
- Erweiterungen: Zonenmodell verfeinern, Preise kalkulieren, simple UI/REST hinzufügen.
