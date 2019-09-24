package horse.algorythm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Coordinate> getChildren(int w, int h) {
        List<Coordinate> children = new ArrayList<Coordinate>();
        children.add(new Coordinate(x + 2, y + 1));
        children.add(new Coordinate(x + 1, y + 2));
        children.add(new Coordinate(x - 2, y - 1));
        children.add(new Coordinate(x - 1, y - 2));
        children.add(new Coordinate(x + 2, y - 1));
        children.add(new Coordinate(x - 2, y + 1));
        children.add(new Coordinate(x + 1, y - 2));
        children.add(new Coordinate(x - 1, y + 2));
        List<Coordinate> goodChildren = new ArrayList<>();
        Iterator<Coordinate> it = children.iterator();
        while (it.hasNext()) {
            Coordinate cur = it.next();
            int curX = cur.getX();
            int curY = cur.getY();
            if(curX >= 0 && curX < w && curY >= 0 && curY < h) {
                goodChildren.add(cur);
            }
        }
        return goodChildren;
    }

    public static Coordinate parseStringToCoordinate(String excelFormat) {
        int endOfLetters = 0;
        while(excelFormat.charAt(endOfLetters) >= (int) 'A' && excelFormat.charAt(endOfLetters) <= (int) 'Z') {
            endOfLetters++;
        }
        int curX = 0;
        for (int i = 0; i < endOfLetters; i++) {
            curX = curX * 26 + ((int) excelFormat.charAt(i) - (int) 'A' + 1);
        }
        int curY = Integer.parseInt(excelFormat.substring(endOfLetters, excelFormat.length()));
        return new Coordinate(curX - 1, curY - 1);
    }
}
