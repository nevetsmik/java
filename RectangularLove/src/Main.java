public class Main {
    public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public String toString() {
            return "{ leftX: " + this.getLeftX() + ", bottomY: " + this.getBottomY() + ", width: " + this.getWidth() + ", height: " + this.getHeight() + " }";
        }
    }

    public static Rectangle xOverlap(Rectangle rect1, Rectangle rect2) {
        int highestStartingPoint = Math.max(rect1.getLeftX(), rect2.getLeftX());
        int lowestEndingPoint = Math.min(rect1.getLeftX() + rect1.getWidth(), rect2.getLeftX() + rect2.getWidth());

        if (highestStartingPoint >= lowestEndingPoint) {
            return new Rectangle(0, 0, 0, 0);
        }

        int width = lowestEndingPoint - highestStartingPoint;

        return new Rectangle(highestStartingPoint, 0, width, 0);
    }

    public static Rectangle yOverlap(Rectangle rect1, Rectangle rect2) {
        int highestStartingPoint = Math.max(rect1.getBottomY(), rect2.getBottomY());
        int lowestEndingPoint = Math.min(rect1.getBottomY() + rect1.getHeight(), rect2.getBottomY() + rect2.getHeight());

        if (highestStartingPoint >= lowestEndingPoint) {
            return new Rectangle(0, 0, 0, 0);
        }

        int height = lowestEndingPoint - highestStartingPoint;

        return new Rectangle(0, highestStartingPoint, 0, height);
    }

    public static Rectangle findOverlappingRectangle(Rectangle rect1, Rectangle rect2) {
        Rectangle overlappingX = xOverlap(rect1, rect2);
        Rectangle overlappingY = yOverlap(rect1, rect2);

        if (overlappingX.getWidth() == 0 || overlappingY.getHeight() == 0) {
            return new Rectangle(0,0,0,0);
        } else {
            return new Rectangle(overlappingX.getLeftX(), overlappingY.getBottomY(), overlappingX.getWidth(), overlappingY.getHeight());
        }
    }



    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(3, 2, 4, 3);
        Rectangle rect2 = new Rectangle(5, 3, 4, 3);

        Rectangle answer = findOverlappingRectangle(rect1, rect2);
        System.out.println(answer.toString());

    }
}
