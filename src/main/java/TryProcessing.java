import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class TryProcessing extends PApplet {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public List<Integer> ballsPos = new ArrayList<>();
    public int ballCount = 4;
    public int diameter = 10;

    public static void main(String[] args) {
        PApplet.main("TryProcessing",args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        for(int ballIdx = 0 ; ballIdx < ballCount ; ballIdx++) {
            ballsPos.add(0);
        }
    }

    @Override
    public void draw() {

        for(int ballIdx = 0 ; ballIdx < ballCount ; ballIdx++) {
            int ball = ballsPos.get(ballIdx);
            ellipse(ball, getPosY(ballIdx), diameter, diameter);
            ballsPos.set(ballIdx, newBallPos(ballIdx, ball));
        }

    }

    private float getPosY(int ballIdx) {
        return HEIGHT * (ballIdx + 1) / 5f;
    }

    private int newBallPos(int ballIdx, int ball) {
        return ball + (ballIdx + 1);
    }
}
