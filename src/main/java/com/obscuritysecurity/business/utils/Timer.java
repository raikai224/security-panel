package main.java.com.obscuritysecurity.business.utils;

import main.java.com.obscuritysecurity.business.facade.SecurityPanelContext;

import java.util.Observable;

/**
 * Timer class implements Runnable to start a new thread then run that infinitely.
 * <p>
 * This then uses Observable to send an event to all observers that it ticked
 */
public class Timer extends Observable implements Runnable {
    private static Timer timer;
    private final Thread thread = new Thread(this);

    /**
     * Start the thread
     */
    private Timer() {
        thread.start();
    }

    /**
     * To get the instance
     *
     * @return returns the clock
     */
    public static Timer instance() {
        if (timer == null) {
            timer = new Timer();
        }
        return timer;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                addObserver(SecurityPanelContext.getInstance());
                setChanged();
                notifyObservers(Event.TIMER_TICK);
            }
        } catch (InterruptedException ex) {
            System.out.println("Sleep interrupted");
        }
    }
}
