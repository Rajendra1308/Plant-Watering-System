package Arduino;

import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Testing6 {
    public static void main(String[] args)
            throws InterruptedException, IOException {
        String myPort="COM3";
        IODevice myGrooveBoard = new FirmataDevice(myPort);
        myGrooveBoard.start();
        myGrooveBoard.ensureInitializationIsDone();
        Pin myPotentiometer = myGrooveBoard.getPin(15);
        I2CDevice i2cObject = myGrooveBoard.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.init();//initialize the OLED object
        Timer timer =new Timer();
        TimerTask myTask= new potTask(theOledObject,myPotentiometer);
        timer.schedule(myTask,new Date(),1000);


    }
}


