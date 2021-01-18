package assignment2.helper;

public class Test {
    public static void main(String[] args) {
        String url = "https://asdasd";
        SharedCharArrayToCheckURL sharedCharArrayToCheckURL = new SharedCharArrayToCheckURL(5);
        URLFindWaiter waiter = new URLFindWaiter(sharedCharArrayToCheckURL);
        new Thread(waiter, "waiter").start();
        URLFindNotifier notifier = new URLFindNotifier(url, sharedCharArrayToCheckURL);
        new Thread(notifier, "notifier").start();
    }
}
