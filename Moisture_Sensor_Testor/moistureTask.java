package Moisture_Sensor_Testor;


import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.TimerTask;

public class moistureTask extends TimerTask {
    Pin mysensor;
    private final SSD1306 display;
    public moistureTask(Pin mysensor,SSD1306 display) {
        this.mysensor = mysensor;
        this.display=display;
    }

    @Override
    public void run() {
        long value= mysensor.getValue();
        String displayValue= String.valueOf(value);
        display.getCanvas().setTextsize(2);
        display.getCanvas().drawString(0,0,"Moisture Sensor: ");
        display.getCanvas().setCursor(71,15);
        display.getCanvas().write(displayValue);
        display.getCanvas().setTextsize(2);
        display.getCanvas().drawString(0,40," Too Dry");
        display.display();


//        var k =mysensor.getValue(); //this value is always long
//        String value1 = String.valueOf(k);
//        System.out.println("The moisture sensor reads " + value1);
//        try {
//            mysensor.setValue(1);
//            Thread.sleep(5000);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            mysensor.setValue(0);
//            Thread.sleep(2000);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
}
