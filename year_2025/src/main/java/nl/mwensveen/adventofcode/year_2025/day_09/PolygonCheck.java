package nl.mwensveen.adventofcode.year_2025.day_09;

import java.util.List;

public class PolygonCheck {
    private List<Tile> polygon;
    private int size;

    public PolygonCheck(List<Tile> polygon) {
        this.polygon = polygon;
        size = polygon.size();
        if (size < 3) {
            throw new RuntimeException("invalid polygon");
        }
    }

    public boolean isRectangleInPolygon(Rectangle rect) {
        int xLeft = Math.min(rect.one().x(), rect.two().x());
        int yTop = Math.min(rect.one().y(), rect.two().y());
        int xRight = Math.max(rect.one().x(), rect.two().x());
        int yBottom = Math.max(rect.one().y(), rect.two().y());

        boolean ok = true;

        for (int x = xLeft; ok && x <= xRight; x++) {
            ok = isPointInPolygon(x, yTop) && isPointInPolygon(x, yBottom);
        }
        for (int y = yTop; ok && y <= yBottom; y++) {
            ok = isPointInPolygon(xRight, y) && isPointInPolygon(xLeft, y);
        }
        return ok;
    }

    /**
     * Hulpmethode om te controleren of een punt (p) binnen of op de rand
     * van een polygoon ligt, gedefinieerd door een lijst van punten.
     * De polygoonpunten moeten in volgorde (met de klok mee of tegen de klok in)
     * in de lijst staan.
     *
     * @param polygon De lijst met hoekpunten van de polygoon.
     * @param p Het testpunt.
     * @return true als het punt binnen of op de rand ligt, false anders.
     */
    public boolean isPointInPolygon(int x, int y) {

        int intersections = 0;

        // De Ray Casting methode
        // We lopen van i=0 tot size-1, waarbij de rand loopt van polygon[i] naar polygon[i+1]
        // De laatste rand loopt van polygon[size-1] naar polygon[0]
        for (int i = 0; i < size; i++) {
            Tile p1 = polygon.get(i);
            Tile p2 = polygon.get((i + 1) % size); // De modulo zorgt voor de laatste rand (size-1 naar 0)

            int p1x = p1.x();
            int p1y = p1.y();
            int p2x = p2.x();
            int p2y = p2.y();

            // 1. Speciale Afhandeling: Controleer of het punt op de rand ligt
            if (isPointOnSegment(x, y, p1x, p1y, p2x, p2y)) {
                return true; // Ligt op de rand
            }

            // 2. Ray Casting Logica
            // Controleer of de rand de horizontale ray snijdt, waarbij de snij-x kleiner moet zijn dan px.
            // Opmerking: we gebruiken het half-open interval [y_min, y_max) om dubbele tellingen op hoekpunten te voorkomen.
            if (p1y > y != p2y > y &&
                    x < (p2x - p1x) * (y - p1y) / (double) (p2y - p1y) + p1x) {

                intersections++;
            }
        }

        // Als het aantal snijpunten oneven is, ligt het punt binnen.
        return intersections % 2 != 0;
    }

    /**
     * Controleert of het punt (px, py) op het lijnsegment (x1, y1) - (x2, y2) ligt.
     */
    private static boolean isPointOnSegment(int px, int py, int x1, int y1, int x2, int y2) {
        // Collineariteit controleren: (py - y1) * (x2 - x1) == (y2 - y1) * (px - x1)
        long crossProduct = (long) (py - y1) * (x2 - x1) - (long) (y2 - y1) * (px - x1);

        if (crossProduct != 0) {
            return false; // Niet collineair
        }

        // Controleer of het punt binnen de bounding box van het segment ligt (op de lijn).
        return px >= Math.min(x1, x2) && px <= Math.max(x1, x2) &&
                py >= Math.min(y1, y2) && py <= Math.max(y1, y2);
    }
}