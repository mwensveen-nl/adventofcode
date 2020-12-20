package nl.mwensveen.adventofcode.year_2020.day_20;

import java.util.List;

public class ImageArranger {

    public Grid arrange(List<Image> imagesIn) {

        Grid grid = new Grid();

        Image image = imagesIn.get(0);
        grid.put(0, 0, image);
        imagesIn.remove(0);
        int imageSize = image.getRow(0).length();

        while (imagesIn.size() > 0) {
            for (int x = grid.getMinX(); x <= grid.getMaxX(); x++) {
                for (int y = grid.getMinY(); y <= grid.getMaxY(); y++) {
                    Image baseImage = grid.get(x, y);
                    if (baseImage != null) {
                        findAbove(x, y, grid, imagesIn, imageSize, baseImage);
                        findRight(x, y, grid, imagesIn, imageSize, baseImage);
                        findBelow(x, y, grid, imagesIn, imageSize, baseImage);
                        findLeft(x, y, grid, imagesIn, imageSize, baseImage);
                    }
                }

            }
        }
        return grid;
    }

    private void findRight(int r, int c, Grid grid, List<Image> imagesIn, int imageSize, Image baseImage) {
        if (grid.get(r, c + 1) != null) {
            return;
        }

        boolean found = false;
        int columnToFind = 0;
        String columnToMatch = baseImage.getColumn(imageSize - 1);
        for (int i = 0; i < imagesIn.size() && !found; i++) {
            Image image = imagesIn.get(i);

            // rotate 0
            found = fitImageOnColumn(r, c + 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            if (!found) {
                image.flip();
                found = fitImageOnColumn(r, c + 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }

            // rotate 1
            if (!found) {
                image.rotate();
                found = fitImageOnColumn(r, c + 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }
            if (!found) {
                image.flip();
                found = fitImageOnColumn(r, c + 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }

            // rotate 2
            if (!found) {
                image.rotate();
                found = fitImageOnColumn(r, c + 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }
            if (!found) {
                image.flip();
                found = fitImageOnColumn(r, c + 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }

            // rotate 3
            if (!found) {
                image.rotate();
                found = fitImageOnColumn(r, c + 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }
            if (!found) {
                image.flip();
                found = fitImageOnColumn(r, c + 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }
        }
    }

    private void findLeft(int r, int c, Grid grid, List<Image> imagesIn, int imageSize, Image baseImage) {
        boolean found = false;
        if (grid.get(r, c - 1) != null) {
            return;
        }

        int columnToFind = imageSize - 1;
        String columnToMatch = baseImage.getColumn(0);
        for (int i = 0; i < imagesIn.size() && !found; i++) {
            Image image = imagesIn.get(i);

            // rotate 0
            found = fitImageOnColumn(r, c - 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            if (!found) {
                image.flip();
                found = fitImageOnColumn(r, c - 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }

            // rotate 1
            if (!found) {
                image.rotate();
                found = fitImageOnColumn(r, c - 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }
            if (!found) {
                image.flip();
                found = fitImageOnColumn(r, c - 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }

            // rotate 2
            if (!found) {
                image.rotate();
                found = fitImageOnColumn(r, c - 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }
            if (!found) {
                image.flip();
                found = fitImageOnColumn(r, c - 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }

            // rotate 3
            if (!found) {
                image.flip();
                image.rotate();
                found = fitImageOnColumn(r, c - 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }
            if (!found) {
                image.flip();
                found = fitImageOnColumn(r, c - 1, grid, imagesIn, columnToMatch, i, image, columnToFind);
            }
        }

    }

    private boolean fitImageOnColumn(int x, int y, Grid grid, List<Image> imagesIn, String columnToFind, int i, Image image, int columnNr) {
        String column = image.getColumn(columnNr);
        if (columnToFind.equals(column)) {
            grid.put(x, y, image);
            imagesIn.remove(i);
            return true;
        }
        return false;
    }

    private void findAbove(int r, int c, Grid grid, List<Image> imagesIn, int imageSize, Image baseImage) {
        boolean found = false;
        if (grid.get(r - 1, c) != null) {
            return;
        }

        int rowToMatch = imageSize - 1;
        String rowToFind = baseImage.getRow(0);
        for (int i = 0; i < imagesIn.size() && !found; i++) {
            Image image = imagesIn.get(i);

            // rotate 0
            found = fitImageOnRow(r - 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            if (!found) {
                image.flip();
                found = fitImageOnRow(r - 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }

            // rotate 1
            if (!found) {
                image.rotate();
                found = fitImageOnRow(r - 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }
            if (!found) {
                image.flip();
                found = fitImageOnRow(r - 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }

            // rotate 2
            if (!found) {
                image.rotate();
                found = fitImageOnRow(r - 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }
            if (!found) {
                image.flip();
                found = fitImageOnRow(r - 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }

            // rotate 3
            if (!found) {
                image.rotate();
                found = fitImageOnRow(r - 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }
            if (!found) {
                image.flip();
                found = fitImageOnRow(r - 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }
        }

    }

    private void findBelow(int r, int c, Grid grid, List<Image> imagesIn, int imageSize, Image baseImage) {
        boolean found = false;
        if (grid.get(r + 1, c) != null) {
            return;
        }

        int rowToMatch = 0;
        String rowToFind = baseImage.getRow(imageSize - 1);
        for (int i = 0; i < imagesIn.size() && !found; i++) {
            Image image = imagesIn.get(i);

            // rotate 0
            found = fitImageOnRow(r + 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            if (!found) {
                image.flip();
                found = fitImageOnRow(r + 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }

            // rotate 1
            if (!found) {
                image.rotate();
                found = fitImageOnRow(r + 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }
            if (!found) {
                image.flip();
                found = fitImageOnRow(r + 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }

            // rotate 2
            if (!found) {
                image.rotate();
                found = fitImageOnRow(r + 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }
            if (!found) {
                image.flip();
                found = fitImageOnRow(r + 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }

            // rotate 3
            if (!found) {
                image.rotate();
                found = fitImageOnRow(r + 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }
            if (!found) {
                image.flip();
                found = fitImageOnRow(r + 1, c, grid, imagesIn, rowToFind, i, image, rowToMatch);
            }
        }

    }

    private boolean fitImageOnRow(int x, int y, Grid grid, List<Image> imagesIn, String rowToMatch, int i, Image image, int rowNr) {
        String row = image.getRow(rowNr);
        if (rowToMatch.equals(row)) {
            grid.put(x, y, image);
            imagesIn.remove(i);
            return true;
        }
        return false;
    }
}
