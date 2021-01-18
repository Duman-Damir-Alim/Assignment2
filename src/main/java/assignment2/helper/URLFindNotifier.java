package assignment2.helper;

public class URLFindNotifier extends Thread {
    private final String message;
    private final SharedCharArrayToCheckURL sharedCharArrayToCheckURL;
    private int counter;

    public URLFindNotifier(String message, SharedCharArrayToCheckURL sharedCharArrayToCheckURL) {
        this.message = message;
        this.sharedCharArrayToCheckURL = sharedCharArrayToCheckURL;
        counter = 0;
    }

    @Override
    public void run() {
        for (char letter : message.toCharArray()) {
            synchronized (sharedCharArrayToCheckURL) {
                sharedCharArrayToCheckURL.updateText(letter, counter);
                counter++;
                if (counter == 5) {
                    sharedCharArrayToCheckURL.notify();
                    break;
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " Found URL");
    }
}
