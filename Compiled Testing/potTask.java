package Arduino;

import org.firmata4j.Pin;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;

import java.util.TimerTask;

public class potTask extends TimerTask {

    private int duration;
    private final SSD1306 myOled;
    private final Pin pinInput;
  //  private final Timer myTimer;

    public potTask( SSD1306 myOled, Pin pinInput) {

        this.myOled = myOled;
        this.pinInput = pinInput;
    }
//
//    //	class	constructor.
//    public potTask(SSD1306 display, Pin pin) {
//        this.myOled = display;
//        this.pinInput = pin;
//       // this.myTimer = timer;
//
//    }

    @Override
    public void run() {
        myOled.getCanvas().clear();
        long value = pinInput.getValue();
       String potValue= String.valueOf(value); // getting the value from pin and converting it into String.
        System.out.println("Pot value "+potValue); // printing to java console
        myOled.getCanvas().drawString(0,0,potValue);//writing it onto led
        myOled.display();
        myOled.getCanvas().drawHorizontalLine(0, 10, (int) Math.floor((( value)/1023.0)*50), MonochromeCanvas.Color.BRIGHT);
        myOled.display();
    //    myOled.getCanvas().drawHorizontalLine(10, 10, (int) value, MonochromeCanvas.Color.DARK);




    }
}