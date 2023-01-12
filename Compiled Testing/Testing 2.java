package Arduino;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Testing2 {
    public static void main(String[] args)
            throws IOException
    {
        String myPort = "COM3";
        FirmataDevice myGroveBoard = new FirmataDevice(myPort); // using the name of a port
        try {
            myGroveBoard.start(); // start comms with board;
            System.out.println("Board started.");
            myGroveBoard.ensureInitializationIsDone();
        }
        catch (Exception ex) {
            System.out.println("couldn't connect to board.");
        }
//        finally {
            var myLED = myGroveBoard.getPin(4);
            myLED.setMode(Pin.Mode.OUTPUT);
            // LED D4 on.
            // Pause for two seconds.
            try {
                Thread.sleep(2000);
            }
            catch(Exception ex){
                System.out.println("sleep error.");
            }
            // LED D4 off.
//        }
        for(int i=0;i<=1;i++){
            System.out.println("i is "+i);
            if(i<=1){
                try {
                    myLED.setValue(1);// on the board
                    Thread.sleep(2000);//for 2 seconds

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("stop for 2 seconds");
                myLED.setValue(0); // off the board
                Thread.sleep(2000);//for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        myGroveBoard.stop(); // finish with the board.
        System.out.println("Board stopped.");

    }
}
