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
 *  - The JavaFX project documentation, "javafx.scene.shape" package:
 *    https://openjfx.io
 *  - Oracle Java SE documentation: https://docs.oracle.com/en/java/
 */

package teddynotes.view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * The teddy bear logo, drawn entirely from distinct JavaFX shape classes.
 *
 * <p>The bear is built from four distinct shape types: {@code Circle} (head,
 * ears, eyes, nose, arms), {@code Ellipse} (muzzle, belly, body, legs),
 * {@code Rectangle} with rounded corners (the bear's seat/paws bar), and a
 * {@code CubicCurve} smile. All colors come from {@link Palette}, so the logo
 * follows the blue and pink color scheme automatically. Everything is laid
 * out on a fixed-size transparent pane, which the workspace centers above
 * its content.</p>
 *
 * <p>Classes used within the class: shape classes from
 * {@code javafx.scene.shape} (Circle, Ellipse, Rectangle, CubicCurve),
 * {@code javafx.scene.Group} to assemble the bear, and {@code Palette} for
 * every color used.</p>
 *
 * <p>Unique implementation notes: every part is made by a small private
 * factory method that positions one shape, so the {@code build()} method
 * reads like a parts list; the class extends {@code Group} so the finished
 * bear can be added to any layout like a single node.</p>
 *
 * @author Thaura, model GLM-5.3-Flash
 * @version 2026-11-08
 */
public class TeddyBearLogo extends Group {

    /** Overall drawing width of the bear, in pixels. */
    public static final double BEAR_WIDTH = 320.0;

    /** Overall drawing height of the bear, in pixels. */
    public static final double BEAR_HEIGHT = 360.0;

    /** Center x-coordinate all parts are positioned relative to. */
    private static final double CENTER_X = BEAR_WIDTH / 2.0;

    /** Fill used for the bear's main body parts. */
    private static final Color FUR = Palette.getTraditionalPastelPink();

    /** Fill used for inner ears, muzzle, belly and paw pads. */
    private static final Color ACCENT = Palette.getPastelRose();

    /** Fill used for eyes and the nose. */
    private static final Color FEATURE = Palette.getSpanishBlue();

    /** Fill used for lighter details such as the belly shine. */
    private static final Color LIGHT = Palette.getAndrea();

    /**
     * Constructs the bear and assembles all of its parts.
     */
    public TeddyBearLogo() {
        getChildren().addAll(
                buildLegs(),
                buildArms(),
                buildBody(),
                buildBelly(),
                buildPaws(),
                buildEars(),
                buildHead(),
                buildFace());
    }

    /**
     * Builds the two legs as ellipses at the bottom of the body.
     *
     * @return a {@code Node} group containing the left and right legs
     */
    private Node buildLegs() {
        Ellipse leftLeg = buildFurEllipse(CENTER_X - 70, 315, 42, 52);
        Ellipse rightLeg = buildFurEllipse(CENTER_X + 70, 315, 42, 52);
        return new Group(leftLeg, rightLeg);
    }

    /**
     * Builds the two arms as tilted circles at the body's upper sides.
     *
     * @return a {@code Node} group containing the left and right arms
     */
    private Node buildArms() {
        Circle leftArm = buildFurCircle(CENTER_X - 108, 220, 34);
        Circle rightArm = buildFurCircle(CENTER_X + 108, 220, 34);
        return new Group(leftArm, rightArm);
    }

    /**
     * Builds the round body as a large ellipse.
     *
     * @return a {@code Node} holding the body shape
     */
    private Node buildBody() {
        return buildFurEllipse(CENTER_X, 245, 95, 105);
    }

    /**
     * Builds the lighter belly patch on the body.
     *
     * @return a {@code Node} holding the belly ellipse
     */
    private Node buildBelly() {
        Ellipse belly = new Ellipse(CENTER_X, 258, 56, 64);
        belly.setFill(LIGHT);
        return belly;
    }

    /**
     * Builds the rounded paw bar across the bottom of the belly, using a
     * {@code Rectangle} with very rounded corners as the fourth shape type.
     *
     * @return a {@code Node} holding the rounded paw rectangle
     */
    private Node buildPaws() {
        Rectangle paws = new Rectangle(CENTER_X - 78, 296, 156, 26);
        paws.setArcWidth(26);
        paws.setArcHeight(26);
        paws.setFill(ACCENT);
        paws.setStroke(FUR);
        paws.setStrokeWidth(3);
        return paws;
    }

    /**
     * Builds the two ears as circles with accent-colored inner circles.
     *
     * @return a {@code Node} group containing both ears
     */
    private Node buildEars() {
        Circle leftOuter = buildFurCircle(CENTER_X - 62, 62, 32);
        Circle rightOuter = buildFurCircle(CENTER_X + 62, 62, 32);
        Circle leftInner = new Circle(CENTER_X - 62, 62, 15);
        leftInner.setFill(ACCENT);
        Circle rightInner = new Circle(CENTER_X + 62, 62, 15);
        rightInner.setFill(ACCENT);
        return new Group(leftOuter, rightOuter, leftInner, rightInner);
    }

    /**
     * Builds the head as a large circle.
     *
     * @return a {@code Node} holding the head shape
     */
    private Node buildHead() {
        return buildFurCircle(CENTER_X, 118, 78);
    }

    /**
     * Builds the face: muzzle, eyes, nose and smile.
     *
     * @return a {@code Node} group containing all facial features
     */
    private Node buildFace() {
        Ellipse muzzle = new Ellipse(CENTER_X, 142, 36, 26);
        muzzle.setFill(ACCENT);

        Circle leftEye = new Circle(CENTER_X - 28, 104, 8);
        Circle rightEye = new Circle(CENTER_X + 28, 104, 8);
        leftEye.setFill(FEATURE);
        rightEye.setFill(FEATURE);

        Circle nose = new Circle(CENTER_X, 132, 10);
        nose.setFill(FEATURE);

        CubicCurve smile = new CubicCurve(
                CENTER_X - 18, 148, CENTER_X - 8, 162,
                CENTER_X + 8, 162, CENTER_X + 18, 148);
        smile.setFill(Color.TRANSPARENT);
        smile.setStroke(FEATURE);
        smile.setStrokeWidth(3);

        return new Group(muzzle, leftEye, rightEye, nose, smile);
    }

    /**
     * Factory for a fur-colored circle at the given position.
     *
     * @param centerX the x-coordinate of the circle's center
     * @param centerY the y-coordinate of the circle's center
     * @param radius  the circle's radius in pixels
     * @return a filled, outlined {@code Circle}
     */
    private Circle buildFurCircle(double centerX, double centerY,
            double radius) {
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(FUR);
        circle.setStroke(ACCENT);
        circle.setStrokeWidth(3);
        return circle;
    }

    /**
     * Factory for a fur-colored ellipse at the given position.
     *
     * @param centerX    the x-coordinate of the ellipse's center
     * @param centerY    the y-coordinate of the ellipse's center
     * @param radiusX    the horizontal radius in pixels
     * @param radiusY    the vertical radius in pixels
     * @return a filled, outlined {@code Ellipse}
     */
    private Ellipse buildFurEllipse(double centerX, double centerY,
            double radiusX, double radiusY) {
        Ellipse ellipse = new Ellipse(centerX, centerY, radiusX, radiusY);
        ellipse.setFill(FUR);
        ellipse.setStroke(ACCENT);
        ellipse.setStrokeWidth(3);
        return ellipse;
    }
}
