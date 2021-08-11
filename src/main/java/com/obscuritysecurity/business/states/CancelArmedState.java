package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implements the Cancel Armed State.
 */
public class CancelArmedState extends SecurityPanelState {

    private static CancelArmedState instance;

    private CancelArmedState() {
    }

    /**
     * Instance cancel armed state.
     *
     * @return the cancel armed state
     */
    public static CancelArmedState instance() {
        return Objects.requireNonNullElseGet(instance, CancelArmedState::new);
    }

    public void handle(Object event) {
        display.setNewStatus(stateText);

        if (event.equals(Event.SUCCESSFUL_PASSCODE)) {
            processSuccessfulPasscode();
        }
    }

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
        context.changeCurrentState(State.UNARMED, Event.NONE);
    }
}
