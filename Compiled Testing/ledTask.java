package Arduino;
//
//import org.firmata4j.Pin;
//
//import java.io.IOException;
//import java.util.TimerTask;
//

import org.firmata4j.Pin;

import java.io.IOException;
import java.util.TimerTask;
public class ledTask extends TimerTask {
    private final Pin myPin;
    // The Constructor for ButtonTask
    ledTask(Pin pin) {
        // Assign the externally-set "pin" to internal variable myPin
        this.myPin = pin;
    }
    @Override
    public void run() {
        // Print this each time TimerTask runs (e.g. once per 1000 ms.)
        try {
            System.out.println("Led on");
            myPin.setValue(1);
            Thread.sleep(1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Led off");
            myPin.setValue(0);
            Thread.sleep(1000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//public class ledtask extends TimerTask {
//   private final Pin myPin;
//  public  ledtask(int  myPin){
//     // this.myPin = myPin;
//
//   }
//    @Override
//    public void run() {
//        try {
//            myPin.setValue(1);
//            Thread.sleep(1000);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            myPin.setValue(0);
//            Thread.sleep(1000);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
