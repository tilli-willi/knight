package horse.algorythm;

import horse.algorythm.Coordinate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorseRiding {
    private final int width;
    private final int height;
    //Coordinates lies from 0 to width(or height) - 1
    private final Coordinate start;
    private final Coordinate end;

    public HorseRiding(int w, int h, String startPos, String endPos) {
        width = w;
        height = h;
        start = Coordinate.parseStringToCoordinate(startPos);
        end = Coordinate.parseStringToCoordinate(endPos);
    }

    public int countDistance() {
        int[][] st = new int[width][height];
        for (int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                st[i][j] = -1;
            }
        }
        Queue<Coordinate> q = new LinkedList<>();
        q.add(start);
        st[start.getX()][start.getY()] = 0;
        while (!q.isEmpty()) {
            Coordinate curVertex = q.remove();
            List<Coordinate> children = curVertex.getChildren(width, height);
            Iterator<Coordinate> it = children.iterator();
            while (it.hasNext()) {
                Coordinate curChild = it.next();
                int curX = curChild.getX();
                int curY = curChild.getY();
                if(st[curX][curY] < 0) {
                    st[curX][curY] = st[curVertex.getX()][curVertex.getY()] + 1;
                    if(curX == end.getX() && curY == end.getY()) {
                        return st[curX][curY];
                    }
                    q.add(curChild);
                }
            }
        }
        return st[end.getX()][end.getY()];
    }
}
