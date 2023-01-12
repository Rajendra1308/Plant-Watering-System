package Arduino;

import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Testing3 {

    public static void main(String[] args)
            throws IOException, InterruptedException {
        var myUSBPort = "COM3"; // TO-DO : modify this!
        // Create a FirmataDevice, start it and ensure Init is done.
        FirmataDevice myGrooveBoard = new FirmataDevice(myUSBPort);
        myGrooveBoard.ensureInitializationIsDone();
        // Use getPin() to tell us which pin the button is connected to.
        var myButton = myGrooveBoard.getPin(6);
        var myLed = myGrooveBoard.getPin(4);
        // Set the mode of this pin to Input.
        myButton.setMode(Pin.Mode.INPUT);
        myLed.setMode(Pin.Mode.OUTPUT);
        // Button is Digital Input 6 on the Grove board (D6)
        // This is exactly like with the LED in Part 1, except that
        // 1. The Button is on digital input 6 (not 4)
        // 2. It’s not Pin.Mode.OUTPUT … it’s INPUT.

        // make a new task for the button
        //Using standard approach.
//        Timer myTime = new Timer();
//        TimerTask tt= new TimerTask() {
//            @Override
//            public void run() {
//             var i =  myButton.getValue();
//                System.out.println("value "+i); // for part 2
//
//                //For part 3
////             if(i==1){
////                 try {
////                     myLed.setValue(1);
////                 } catch (IOException e) {
////                     e.printStackTrace();
////                     System.out.println("value "+i);
////                 }
////
////             }
////             else {
////                 try {
////                     myLed.setValue(0);
////                 } catch (IOException e) {
////                     e.printStackTrace();
////                 }
////             }
//
//            }
//        };
//        myTime.schedule(tt,new Date(),1000);
        // Provide this task to the Timer.schedule() method
        // and set the time to “no delay” and 1000 ms. periods.
        // this is like in Lab C!
        //Using TimerTask Approach
        Timer myTime2 = new Timer();
        TimerTask myTask2 = new ButtonTask(myButton);
        myTime2.schedule(myTask2,new Date(),1000);
    }
}