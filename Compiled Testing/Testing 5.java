package Arduino;

import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class Testing5 {
    public static void main(String[] args)
            throws InterruptedException, IOException {
        {
            String myPort = "COM3";
            IODevice myGrooveBoard = new FirmataDevice(myPort);
            myGrooveBoard.start();
            myGrooveBoard.ensureInitializationIsDone();
            I2CDevice i2cObject = myGrooveBoard.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
            SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
            theOledObject.init();//initialize the OLED object
            theOledObject.getCanvas().clear();
//
//            theOledObject.getCanvas().drawString(0,0,"Rajendra"); // write first name on canvas
//            theOledObject.display(); // tell OLED to display
//            Thread.sleep(1000); // show it for 1 sec
//            theOledObject.getCanvas().clear();
//
//            theOledObject.getCanvas().drawString(0,0,"Brahmbhatt"); // write first name on canvas
//            theOledObject.display(); // tell OLED to display
//            Thread.sleep(1000); // show it for 1 sec
//            theOledObject.getCanvas().clear();
//
//            theOledObject.getCanvas().drawString(0,0,"217925157"); // write first name on canvas
//            theOledObject.display(); // tell OLED to display
//            Thread.sleep(1000); // show it for 1 sec
//            theOledObject.getCanvas().clear();

//            myGrooveBoard.stop();
//
//
            Timer myTimer= new Timer();
            TimerTask task = new CountTask(theOledObject);
            myTimer.schedule(task,new Date(),1000);


        }
    }






















}

