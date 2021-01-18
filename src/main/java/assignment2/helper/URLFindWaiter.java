package assignment2.helper;


import java.util.Arrays;

public class URLFindWaiter implements Runnable {
    private final SharedCharArrayToCheckURL sharedCharArrayToCheckURL;

    public URLFindWaiter(SharedCharArrayToCheckURL sharedCharArrayToCheckURL) {
        this.sharedCharArrayToCheckURL = sharedCharArrayToCheckURL;
    }

    @Override
    public void run() {
        synchronized (sharedCharArrayToCheckURL) {
            try {
                System.out.println("Waiting for text...");
                sharedCharArrayToCheckURL.wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.println("Received text: " + Arrays.toString(sharedCharArrayToCheckURL.getText()));
            if (Arrays.equals(sharedCharArrayToCheckURL.getText(), "https".toCharArray())) {
                System.out.println("Protocol is secure, enjoy!");
            } else {
                System.out.println("Protocol is not secure, think twice!");
            }
        }
    }
}
