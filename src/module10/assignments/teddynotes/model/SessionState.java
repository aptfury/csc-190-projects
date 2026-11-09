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
 *  - Oracle, "Using JavaFX Properties and Bindings" tutorial: https://docs.oracle.com/javafx/
 */

package teddynotes.model;

import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Single shared holder for everything the user does in one run of the program.
 *
 * <p>Stores the username, the window title submitted on the login form, and
 * the ordered list of note entries created during this run. The list is a
 * JavaFX {@code ObservableList}, so the view listens to it and repaints the
 * entry list automatically whenever an entry is added. Because this is a
 * prototype and demo, all of this state is intentionally temporary: a fresh
 * instance is created every launch and nothing is written to disk.</p>
 *
 * <p>Classes used within the class: {@code javafx.collections.FXCollections}
 * and {@code javafx.collections.ObservableList} for the observable entry
 * list, and {@code java.util.Objects} for validation.</p>
 *
 * <p>Unique implementation notes: exactly one instance exists per run, handed
 * to each view by the application class; it keeps no reference back to any
 * JavaFX control, so the model layer stays independent of the UI toolkit
 * controls.</p>
 *
 * @author Thaura, model GLM-5.3-Flash
 * @version 2026-11-08
 */
public class SessionState {

    /** Name the user submitted on the login form; shown in the welcome text. */
    private String username;

    /** Window title submitted on the login form; applied to the stage. */
    private String windowTitle;

    /** Notes entered this run; observed by the workspace view. */
    private final ObservableList<NoteEntry> entries;

    /**
     * Constructs a blank session: no username, no window title, no entries.
     */
    public SessionState() {
        this.username = "";
        this.windowTitle = "";
        this.entries = FXCollections.observableArrayList();
    }

    /**
     * Gets the name the user submitted on the login form.
     *
     * @return the trimmed {@code String} username, empty before login
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the name the user submitted on the login form.
     *
     * @param username the new username; may not be blank
     * @throws IllegalArgumentException when the username is blank; handled
     *         by the login view, which blocks submission instead
     */
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Username may not be blank in a logged-in session.");
        }
        this.username = username.trim();
    }

    /**
     * Gets the window title submitted on the login form.
     *
     * @return the trimmed {@code String} window title, empty before login
     */
    public String getWindowTitle() {
        return windowTitle;
    }

    /**
     * Sets the window title submitted on the login form.
     *
     * @param windowTitle the new window title; may not be null
     * @throws IllegalArgumentException when the title is null; handled by
     *         the login view, which substitutes a default title instead
     */
    public void setWindowTitle(String windowTitle) {
        if (windowTitle == null) {
            throw new IllegalArgumentException(
                    "Window title may not be null.");
        }
        this.windowTitle = windowTitle.trim();
    }

    /**
     * Gets the observable list of entries entered this run.
     *
     * @return the live {@code ObservableList} of {@code NoteEntry} objects;
     *         never null, and read-only use is expected of listeners
     */
    public ObservableList<NoteEntry> getEntries() {
        return entries;
    }

    /**
     * Appends a new entry to the session and notifies all listeners.
     *
     * @param title the short heading for the entry; may not be blank
     * @param note  the body text of the note; may not be null
     * @throws IllegalArgumentException when the title is blank or the note
     *         is null; handled by the workspace view, which shows a
     *         validation alert and leaves the list unchanged
     */
    public void addEntry(String title, String note) {
        entries.add(new NoteEntry(title, note));
    }

    /**
     * Reports whether the user has completed the login form.
     *
     * @return {@code true} when a non-blank username has been set;
     *         {@code false} before login
     */
    public boolean isLoggedIn() {
        return !Objects.toString(username, "").isBlank();
    }
}
