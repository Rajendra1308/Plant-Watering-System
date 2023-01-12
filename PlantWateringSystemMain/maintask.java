package PlantWateringSystemMain;
import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.PinEventListener;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.TimerTask;

public class maintask extends TimerTask {
    private  Pin moisturesensor;
    private  SSD1306 display;
    private   Pin myPump;
    private  Pin button;

    //Constructor
    public maintask(Pin moisturesensor, SSD1306 display, Pin myPump, Pin button) {
        this.moisturesensor = moisturesensor;
        this.display = display;
        this.myPump = myPump;
        this.button = button;
    }
    @Override
    public void run() {
        long value= moisturesensor.getValue();
        String displayValue= String.valueOf(value);
        display.getCanvas().setTextsize(2);
        display.getCanvas().drawString(0,0,"Moisture Sensor: ");
        display.getCanvas().setCursor(71,15);
      //  display.getCanvas().write(displayValue);
        display.getCanvas().setTextsize(2);
       // display.getCanvas().drawString(0,40," Too Dry");


        //When the soil is too dry.
        if (value<570 ){
            try {
                System.out.println("The value of Moisture Sensor is :"+displayValue);
                System.out.println("Pump Stopped");
                myPump.setValue(0);
                //display.clear();
               // display.getCanvas().setCursor(0,0);
                display.getCanvas().setTextsize(2);
                display.getCanvas().write(displayValue);
                display.getCanvas().drawString(0,40,"Too Wet!");
                display.display();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //When the soil is too wet.
        else if(value>600) try {
            System.out.println("The value of Moisture Sensor is :"+displayValue);
            System.out.println("Pump Started");
            myPump.setValue(1);
          //  display.clear();
            //display.getCanvas().setCursor(0,0);
            display.getCanvas().setTextsize(2);
            display.getCanvas().write(displayValue);
            display.getCanvas().drawString(0, 40, "Watering");
            display.display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

