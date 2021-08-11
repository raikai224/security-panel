package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implements the Alarmed State.
 */
public class AlarmedState extends SecurityPanelState {

    private static AlarmedState instance;

    private AlarmedState() {
    }

    /**
     * Instance alarmed state.
     *
     * @return the alarmed state
     */
    public static AlarmedState instance() {

        return Objects.requireNonNullElseGet(instance, AlarmedState::new);
    }

    public void handle(Object event) {
        display.setNewStatus(stateText);

        if (event.equals(Event.SUCCESSFUL_PASSCODE)) {
            processSuccessfulPasscode();
        }
    }

    // todo: figure this out
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
