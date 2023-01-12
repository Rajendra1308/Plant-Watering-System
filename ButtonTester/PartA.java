package ButtonTester;
import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

public class PartA {
    public static void main(String[] args)
    throws IOException,InterruptedException
    {
        String myPort= "COM3";
        FirmataDevice myGrooveBoard = new FirmataDevice(myPort);
        myGrooveBoard.start();
        myGrooveBoard.ensureInitializationIsDone();
        Pin Led= myGrooveBoard.getPin(7);
        Pin Button = myGrooveBoard.getPin(6);
        Led.setMode(Pin.Mode.OUTPUT);
        Button.setMode(Pin.Mode.INPUT);
        myGrooveBoard.addEventListener(new  ButtonListener(Led,Button));
    }
}
