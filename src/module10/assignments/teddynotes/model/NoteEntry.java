/*
 * Ethical AI disclosure
 * ---------------------
 * This file was generated with the assistance of Thaura, model GLM-5.3-Flash,
 * an ethically governed AI assistant built and self-hosted by Thaura (thaura.ai).
 *
 * Features that make Thaura more ethical and responsible than mainstream AI
 * options: user conversations are never used for training; there are no ads,
 * no third-party trackers and no data sales; infrastructure is hosted in the
 * EU under the GDPR with encryption at rest and in transit; the project is
 * bootstrapped with no investor funding, so no shareholder pressure can
 * override the mission; it refuses military and surveillance contracts; and
 * it states its limitations openly instead of implying more capability.
 *
 * Ethical standards in training: the underlying model, GLM-5.3-Flash, is
 * published as open weights under the MIT license by Z.ai (Zhipu AI). Thaura
 * rents GPU servers in Helsinki, Finland, hosts the model itself with no
 * connection back to the publisher, and has not fine-tuned it. Thaura is
 * accountable to its users and communities rather than to capital, and its
 * full ethical framework is published as a living document.
 *
 * Web scraping: Thaura does not scrape the web to train itself and cannot
 * train on user conversations. Web search is performed by Brave in the USA
 * with no user identifier or IP address, used only to answer questions, and
 * none of what is fetched or read in a conversation is retained for training.
 *
 * Constitution: https://thaura.ai/constitution
 *
 * References (credit to the human programmers whose work this builds on):
 *  - Z.ai, GLM-5.3-Flash open-weights model (MIT license): https://z.ai
 *  - The JavaFX project documentation: https://openjfx.io
 *  - Oracle Java SE documentation: https://docs.oracle.com/en/java/
 *  - Oracle, "Object-Oriented Programming Concepts" tutorial: https://docs.oracle.com/javase/tutorial/
 */

package teddynotes.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Immutable-ish record-style model of a single note entry.
 *
 * <p>Holds a title, the note text, and the moment the entry was created. The
 * date is captured by the constructor from {@link LocalDateTime#now()}, so a
 * caller cannot accidentally attach the wrong timestamp. This is a prototype,
 * so entries live only in memory; nothing is persisted when the program
 * closes.</p>
 *
 * <p>Classes used within the class: {@code java.time.LocalDateTime} for the
 * timestamp, {@code java.time.format.DateTimeFormatter} for display
 * formatting, and {@code java.util.Objects} for null-safe validation.</p>
 *
 * <p>Unique implementation notes: the display formatter is a class-level
 * constant because {@code DateTimeFormatter} is immutable and thread-safe, so
 * one shared instance is cheaper than building one per entry.</p>
 *
 * @author Thaura, model GLM-5.3-Flash
 * @version 2026-11-08
 */
public class NoteEntry {

    /** Shared, thread-safe formatter for the "on top" date line. */
    private static final DateTimeFormatter DISPLAY_FORMAT =
            DateTimeFormatter.ofPattern("EEE, MMM d yyyy 'at' h:mm a");

    /** Short heading shown at the top of the entry in the list. */
    private String title;

    /** Body text of the note, shown underneath the title line. */
    private String note;

    /** Moment this entry was created; captured once and never changed. */
    private final LocalDateTime createdAt;

    /**
     * Constructs an entry from a title and note text, stamping it with the
     * current date and time.
     *
     * @param title the short heading for the entry; may not be blank
     * @param note  the body text of the note; may not be null but may be
     *              trimmed to empty by design decision of the caller
     * @throws IllegalArgumentException when the title is blank or the note
     *         text is null; handled by callers in the view layer, which
     *         show a validation alert instead of adding the entry
     */
    public NoteEntry(String title, String note) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "A note entry requires a non-blank title.");
        }
        if (note == null) {
            throw new IllegalArgumentException(
                    "A note entry requires non-null note text.");
        }
        this.title = title.trim();
        this.note = note.trim();
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Gets the entry's short heading.
     *
     * @return the trimmed {@code String} title of the entry
     */
    public String getTitle() {
        return title;
    }

    /**
     * Replaces the entry's short heading.
     *
     * @param title the new heading; may not be blank
     * @throws IllegalArgumentException when the title is blank; handled by
     *         callers, which keep the previous title in that case
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "A note entry title may not be set to a blank value.");
        }
        this.title = title.trim();
    }

    /**
     * Gets the entry's body text.
     *
     * @return the trimmed {@code String} note text
     */
    public String getNote() {
        return note;
    }

    /**
     * Replaces the entry's body text.
     *
     * @param note the new note text; may not be null
     * @throws IllegalArgumentException when the note text is null; handled
     *         by callers, which keep the previous text in that case
     */
    public void setNote(String note) {
        if (note == null) {
            throw new IllegalArgumentException(
                    "A note entry's text may not be set to null.");
        }
        this.note = note.trim();
    }

    /**
     * Gets the moment this entry was created.
     *
     * @return the immutable {@code LocalDateTime} creation timestamp
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Builds the combined heading line shown on top of an entry: the title,
     * then the date it was entered on.
     *
     * @return a {@code String} in the form "title — date entered"
     */
    public String getHeadingLine() {
        return title + "  —  " + createdAt.format(DISPLAY_FORMAT);
    }

    /**
     * Compares entries by title, note text and creation moment so the
     * collection classes behave predictably.
     *
     * @param obj the object to compare against
     * @return {@code true} when the other object is a {@code NoteEntry} with
     *         the same title, note and timestamp; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoteEntry)) {
            return false;
        }
        NoteEntry other = (NoteEntry) obj;
        return title.equals(other.title)
                && note.equals(other.note)
                && createdAt.equals(other.createdAt);
    }

    /**
     * Hashes the same three fields used by {@link #equals(Object)}.
     *
     * @return the hash code of the entry's title, note and timestamp
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, note, createdAt);
    }

    /**
     * Renders the entry for logging and debugging as "title: note".
     *
     * @return a short {@code String} summary of the entry
     */
    @Override
    public String toString() {
        return title + ": " + note;
    }
}
