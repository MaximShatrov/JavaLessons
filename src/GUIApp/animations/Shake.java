package GUIApp.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition translateTransition;

    public Shake(Node node, int duration, double seByX) {
        translateTransition = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setFromX(0f);
        translateTransition.setByX(seByX);
        translateTransition.setCycleCount(6);
        translateTransition.setAutoReverse(true);
    }

    public void playAnim(){
        translateTransition.playFromStart();
    }
}
