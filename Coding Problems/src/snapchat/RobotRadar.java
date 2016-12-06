package snapchat;
import java.util.Arrays;
import java.util.Comparator;

class Circle {
    int x;
    int y;
    int start;
    int end;
    int r;
    Circle (int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.start = y - r;
        this.end = y + r;
    }
    
    boolean isIntersect(Circle that) {
        int dist = (this.x - that.x) * (this.x * that.x) + (this.y - that.y) * (this.y - that.y);
        if (dist > (this.r * this.r + that.r * that.r)) {
            return false;
        }
        else {
            return true;
        }
    }
}

public class RobotRadar {
        public boolean canPass(Circle[] circles, int lowerBound, int higherBound) {
            Arrays.sort(circles, new Comparator<Circle>() {
                @Override
                public int compare(Circle o1, Circle o2) {
                    return o1.start - o2.start;
                }
            });
            
            int start = lowerBound;
            for (int i = 0; i < circles.length; i++) {
                if (start < circles[i].start) {
                    return true;
                }
                else {
                    if (i == 0) {
                        start = circles[i].end;
                    }
                    else {
                        boolean canPass = true;
                        for (int j = i; j > 0; j--) {
                            if (circles[j].isIntersect(circles[i - 1])) {
                                canPass = false;
                                break;
                            }
                        }
                        if (canPass) {
                            return true;
                        }
                        else {
                            start = Math.max(start, circles[i].end);
                        }
                    }
                }
            }
            
            return start < higherBound;
        }
    
    public static void main(String[] args) {
        RobotRadar test = new RobotRadar();
        Circle[] circles = new Circle[2];
        circles[0] = new Circle(1, -1, 4);
        circles[1] = new Circle(2, -4, 1);
        boolean ret = test.canPass(circles, -5, 5);
        System.out.println(ret);
    }
}