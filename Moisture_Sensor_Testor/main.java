package Moisture_Sensor_Testor;
import java.io.IOException;
import java.util.*;

import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

public class main {
    public static void main(String[] args)
            throws IOException, InterruptedException
    {
        String myPort  = "COM3";
        FirmataDevice myGrooveBoard = new FirmataDevice(myPort);
        myGrooveBoard.start(); // start the board
        myGrooveBoard.ensureInitializationIsDone(); // make it initialise
        Pin moistureSensor  = myGrooveBoard.getPin(15);
       // moistureSensor.setMode(Pin.Mode.INPUT);
          moistureSensor.setMode(Pin.Mode.ANALOG);
        //Defining OLED
        I2CDevice i2cObject = myGrooveBoard.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.init();//initialize the OLED object
        //moistureSensor.setValue(1);
       // Thread.sleep(2000);
        Timer myTimer = new Timer();
        TimerTask myTask = new moistureTask(moistureSensor,theOledObject);
        myTimer.schedule(myTask,new Date(),1000);
        System.out.println("Pin obtained");


    }

}
