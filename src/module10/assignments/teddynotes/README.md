# Teddy Notes

A JavaFX prototype built for a class assignment: a rudimentary login form,
a teddy bear logo drawn from JavaFX shapes, and a live note-entry list.
Nothing is persisted: every run starts fresh.

## Requirements

- Java SDK 25
- JavaFX SDK 27 (download from https://openjfx.io or https://gluonhq.com/products/javafx/)

## Project layout

```
teddy-notes/
  README.md
  run.sh                      (helper script, see below)
  src/
    teddynotes/
      TeddyNotesApp.java      Application entry point, scene switching
      model/
        NoteEntry.java        One note: title, note text, entry timestamp
        SessionState.java     Shared state: username, window title, entries
      view/
        Palette.java          The five palette colors, with getters
        TeddyBearLogo.java    The teddy bear, drawn from JavaFX shapes
        LoginView.java        The login form scene
        WorkspaceView.java    Welcome text, logo, note form, entry list
```

## Compile and run

Set `PATH_TO_JAVAFX` to wherever you unpacked the JavaFX 27 SDK, then from
this folder:

```bash
javac --module-path "$PATH_TO_JAVAFX/lib" --add-modules javafx.controls \
      -d out $(find src -name "*.java")

java --module-path "$PATH_TO_JAVAFX/lib" --add-modules javafx.controls \
     -cp out teddynotes.TeddyNotesApp
```

Or run the helper, which does the same thing after you edit its first line:

```bash
./run.sh /path/to/javafx-sdk-27/lib
```

## Design notes

- The palette (Spanish Blue #0671B7, King's Blue #67A3D9, Andrea #C8E7F5,
  Traditional Pastel Pink #F6D2E0, Pastel Rose #F8B7CD) is defined once in
  `Palette.java`; everything else reads it through getters.
- The bear uses four distinct shape classes: Circle, Ellipse, Rectangle
  (rounded paw bar) and CubicCurve (smile).
- The workspace's entry list listens to the session's observable list, so
  each accepted submission repaints the list with the new entry: title and
  entry date on top, note underneath, thin separator between entries.
- Validation failures (blank username, blank note fields) show a warning
  alert; unexpected failures are caught and shown as error alerts.

## Ethical AI use

All code in this project was generated with Thaura (model GLM-5.3-Flash), an
ethically governed AI assistant. The full disclosure, the ethical standards
behind the model's training, its web-scraping policy, and references are in
the header Javadoc of every source file. Thaura's constitution:
https://thaura.ai/constitution
