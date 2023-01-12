package Arduino;

import org.firmata4j.I2CDevice;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class basicArduinoMethods {
    public static void main(String[] args)
    throws InterruptedException, IOException
    {
        String myPORT = "COM3"; // port name
        FirmataDevice myGrooveBoard = new FirmataDevice(myPORT); // making groove board object
        myGrooveBoard.start(); // starting the groove board
        myGrooveBoard.ensureInitializationIsDone(); // initialize the board.
        //We do not use the Pin class for making an OLED object , instead we use the below code for making and initializing it.

        I2CDevice i2cObject = myGrooveBoard.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        // Initialize the OLED (SSD1306) object
        theOledObject.init();

//        //For setting text size method
//        theOledObject.getCanvas().setTextsize(3);
//        theOledObject.getCanvas().write("Hi");
//        theOledObject.display();
//        System.out.println("Board stopped");
//        myGrooveBoard.stop();

        // Word Wrap Method
//        theOledObject.getCanvas().write("Hello");
//        theOledObject.getCanvas().setWordWrap(true);
//        theOledObject.display();
//        myGrooveBoard.stop();

//        //setting cursor to print the contents at desired position on screen.
//        theOledObject.getCanvas().setCursor(15,15);
//        theOledObject.getCanvas().write("Hello");
//        theOledObject.display();
//        System.out.println("Stopped");
//        myGrooveBoard.stop();

        //get cursor method and get width and height methods, not that imp
//        theOledObject.getCanvas().setCursor(15,15);
//        //cursor position before the char has printed
//        System.out.println(theOledObject.getCanvas().getCursorX());
//        System.out.println(theOledObject.getCanvas().getCursorY());
//        System.out.println(theOledObject.getCanvas().getWidth());
//        System.out.println(theOledObject.getCanvas().getHeight());
//        theOledObject.getCanvas().write("H");
//        theOledObject.display();
//        //cursor position after the char has printed
//        System.out.println(theOledObject.getCanvas().getCursorX());
//        System.out.println(theOledObject.getCanvas().getCursorY());
//
//        //setPixel Method
//        theOledObject.clear();
//        theOledObject.getCanvas().setPixel(20,20, MonochromeCanvas.Color.BRIGHT); // displays a pixel at desired position
//
//        theOledObject.display();

//        //displaying a line
//        theOledObject.getCanvas().drawLine(0,0,10,10, MonochromeCanvas.Color.BRIGHT);
//        theOledObject.display();

        //drawing verticle line
//        theOledObject.getCanvas().drawVerticalLine(10,10,5, MonochromeCanvas.Color.BRIGHT); // x and y are the positions and h is the vertical length of the line
//        theOledObject.display();

//        //drawing Horizontal line
//        theOledObject.getCanvas().drawHorizontalLine(0,10,40, MonochromeCanvas.Color.BRIGHT);
//        //x and y are the positions and w is the horizontal  length of the line
//        theOledObject.display();

//        //draw rectangle
//        theOledObject.getCanvas().drawRect(0,0,10,10, MonochromeCanvas.Color.BRIGHT);
//        //width and height are w and h meaning the other 2 co-ordinates
//        theOledObject.display();

//        //Fill the screen
//        theOledObject.getCanvas().fillScreen(MonochromeCanvas.Color.BRIGHT);
//        theOledObject.display();
        //
        myGrooveBoard.stop();
        System.out.println("Stopped");


    }
}
