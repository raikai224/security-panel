package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implement the Waiting state.
 */
public class WaitingState extends SecurityPanelState {

    private static WaitingState instance;
    private final int WAIT_TIME_SECONDS = 10;
    private int timeRemaining = WAIT_TIME_SECONDS;

    private WaitingState() {
    }

    /**
     * Instance waiting state.
     *
     * @return the waiting state
     */
    public static WaitingState instance() {
        return Objects.requireNonNullElseGet(instance, WaitingState::new);
    }

    public void handle(Object event) {
        if (event.equals(Event.TIMER_TICK)) {
            runTimer();
        } else if (event.equals(Event.WAIT_ENDED)) {
            processWaitTimeComplete();
        }
    }

    /**
     * Run timer.
     */
    public void runTimer() {
        this.timeRemaining--;
        display.updateStatusTimer(stateText, Integer.toString(this.timeRemaining));

        if (timeRemaining == 0) {
            this.timeRemaining = WAIT_TIME_SECONDS;
            context.handleEvent(Event.WAIT_ENDED);
        }
    }

    private void processWaitTimeComplete() {
        checkZoneStatus();
        if (context.getCurrentState() == State.ZONES_READY) {
            context.changeCurrentState(context.getLastArmedButtonPressed(), Event.NONE);
        }
    }

    private void checkZoneStatus() {
        if (display.getZoneStatuses()) {
            context.changeCurrentState(State.ZONES_READY, Event.NONE);
        } else {
            context.changeCurrentState(State.ZONES_NOT_READY, Event.NONE);
        }
    }
}
