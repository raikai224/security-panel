package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implement the Warning state.
 */
public class WarningState extends SecurityPanelState {

    private static WarningState instance;
    private final int WARNING_TIME_SECONDS = 15;
    private int timeRemaining = WARNING_TIME_SECONDS;

    private WarningState() {
    }

    /**
     * Instance warning state.
     *
     * @return WarningState
     */
    public static WarningState instance() {
        return Objects.requireNonNullElseGet(instance, WarningState::new);
    }

    public void handle(Object event) {
        if (event.equals(Event.TIMER_TICK)) {
            runTimer();
        } else if (event.equals(Event.WARN_ENDED)) {
            processWarningTimeComplete();
        }
    }

    /**
     * Run the timer.
     */
    private void runTimer() {
        this.timeRemaining--;
        display.updateStatusTimer(stateText, Integer.toString(this.timeRemaining));

        if (this.timeRemaining == 0) {
            this.timeRemaining = WARNING_TIME_SECONDS;
            context.handleEvent(Event.WARN_ENDED);
        }
    }

    private void processWarningTimeComplete() {
        context.changeCurrentState(State.ALARMED, Event.NONE);
    }

    /**
     * Processes the entered password and verifies if it corresponds to the actual password
     */
    public void processEnteredPasscode(String passcodeNumber) {
        context.setEnteredPasscode("" + context.getEnteredPasscode() + passcodeNumber);
        if (context.getEnteredPasscode().equals(context.getPasscode())) {
            processSuccessfulPasscode();
        }

        if (context.getEnteredPasscode().length() >= context.getPasscode().length()) {
            context.setEnteredPasscode("");
        }
    }

    /**
     * Process successful passcode.
     */
    public void processSuccessfulPasscode() {
        this.timeRemaining = WARNING_TIME_SECONDS;
        context.changeCurrentState(State.UNARMED, Event.NONE);
    }
}
