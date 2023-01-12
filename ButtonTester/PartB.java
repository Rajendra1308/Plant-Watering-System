package ButtonTester;
import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

public class PartB {
    public static void main(String[] args)
            throws IOException,InterruptedException
    {
        String myPort= "COM3";
        FirmataDevice myGrooveBoard = new FirmataDevice(myPort);
        myGrooveBoard.start();
        myGrooveBoard.ensureInitializationIsDone();
        // Defining Button
        Pin Button = myGrooveBoard.getPin(6);
        Button.setMode(Pin.Mode.INPUT);
         //Defining OLED
        I2CDevice i2cObject = myGrooveBoard.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.init();//initialize the OLED object

         // Defining potentiometer object
        Pin potentiometer = myGrooveBoard.getPin(14);
        myGrooveBoard.addEventListener(new OLEDListener(theOledObject,potentiometer,Button));


    }
}
