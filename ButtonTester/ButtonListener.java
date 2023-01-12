package ButtonTester;
import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import java.io.IOException;

public class ButtonListener implements IODeviceEventListener {
    private Pin ledPin;
    private  Pin buttonPin;

    public ButtonListener(Pin ledPin, Pin buttonPin) {
        this.ledPin = ledPin;
        this.buttonPin = buttonPin;
    }

    @Override
    public void onPinChange(IOEvent event) {
        if(event.getPin().getIndex()!= buttonPin.getIndex()){
            return;
        }
       long i= ledPin.getValue();
        if(i==1){
            try {
                ledPin.setValue(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                ledPin.setValue(1);
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
