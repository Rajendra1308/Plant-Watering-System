package ButtonTester;
import org.firmata4j.I2CDevice;
import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;


public class OLEDListener implements  IODeviceEventListener{
    private SSD1306 display;
    private Pin potentiometer;
    private Pin button;

    public OLEDListener(SSD1306 display, Pin potentiometer, Pin button) {
        this.display = display;
        this.potentiometer = potentiometer;
        this.button = button;
    }

    @Override
    public void onPinChange(IOEvent event) {
        if(event.getPin().getIndex()!=button.getIndex()){
            return;
        }
        long k = potentiometer.getValue();
        String value = String.valueOf(k);
        display.getCanvas().drawString(0,0,value);
        display.display();
        display.clear();


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
