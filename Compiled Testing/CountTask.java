package Arduino;

import org.firmata4j.ssd1306.SSD1306;

import java.util.TimerTask;

public class CountTask extends TimerTask {
    private int countValue = 0;
    private final SSD1306 theOledObject;
    // Constructor for CountTask
    public CountTask(SSD1306 aDisplayObject){
        theOledObject = aDisplayObject;
    }
    @Override
    public void run() {
        // Fill the OLED memory with something to draw.
        theOledObject.getCanvas().clear(); // clear contents first.
        // draw the String…
        theOledObject.getCanvas().drawString(0,0,String.valueOf(countValue));
        // Update the OLED display (move data from memory onto the screen itself)
        theOledObject.display();
        // Update your count variable.
        if(countValue<=9){
            countValue++;
        }
        else{
            countValue=0;
        }

    }
}
