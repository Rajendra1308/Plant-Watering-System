package PlantWateringSystemMain;
import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;

import java.io.IOException;

public class Event implements IODeviceEventListener
{
    private final SSD1306 display;
    private final  Pin myPump;
    private final Pin button;
    //Constructor
    public Event( SSD1306 display, Pin myPump, Pin button) {
        this.display = display;
        this.myPump = myPump;
        this.button = button;
    }
    @Override
    public void onPinChange(IOEvent Event) {
        if (Event.getPin().getIndex()!=button.getIndex()){
            return;
        }
        long i = myPump.getValue();

        if (i==1){
            try {
                    myPump.setValue(0);
                System.out.println("Manual Control");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                myPump.setValue(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        }
    @Override
    public void onStart(IOEvent ioEvent) {

    }

    @Override
    public void onStop(IOEvent ioEvent) {

    }


    @Override
    public void onMessageReceive(IOEvent ioEvent, String s) {

    }
}
