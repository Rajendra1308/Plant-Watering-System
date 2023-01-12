package PlantWateringSystemMain;
import org.firmata4j.I2CDevice;
import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args)
    throws IOException,InterruptedException
    {
        //Starting and initializing Groove Board
        String port = "COM3";
        FirmataDevice myGrooveBoard = new FirmataDevice(port);
        myGrooveBoard.start();
        myGrooveBoard.ensureInitializationIsDone();
        //Defining OLED
        I2CDevice i2cObject = myGrooveBoard.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.init();//initialize the OLED object
        //Defining Pump
        Pin pump = myGrooveBoard.getPin(7);
        pump.setMode(Pin.Mode.OUTPUT);
        //Defining Moisture Sensor
        Pin moistureSensor= myGrooveBoard.getPin(15);
        moistureSensor.setMode(Pin.Mode.ANALOG);
        //Defining Button
        Pin myButton =myGrooveBoard.getPin(6);
        myButton.setMode(Pin.Mode.INPUT);

        //Adding Event Listener to the groove board object and scheduling a task.
        myGrooveBoard.addEventListener(new Event(theOledObject,pump,myButton));
        Timer myTimer = new Timer();
        TimerTask myTask = new maintask(moistureSensor,theOledObject,pump,myButton);
        myTimer.schedule(myTask,new Date(),5000);


    }

}
