package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implement the Unarmed state.
 */
public class UnarmedState extends SecurityPanelState {

    private static UnarmedState instance;

    private UnarmedState() {
    }

    /**
     * Instance unarmed state.
     *
     * @return the unarmed state
     */
    public static UnarmedState instance() {
        return Objects.requireNonNullElseGet(instance, UnarmedState::new);
    }

    public void handle(Object event) {
        display.setNewStatus(stateText);

        if (event.equals(Event.AWAY)) {
            processArmedAway();
        } else if (event.equals(Event.STAY)) {
            processArmedStay();
        }
    }

    /**
     * Process armed away.
     */
    public void processArmedAway() {
        context.setLastArmedButtonPressed(State.ARMED_AWAY);
        context.changeCurrentState(State.WAITING, Event.NONE);
    }

    /**
     * Process armed stay.
     */
    public void processArmedStay() {
        context.setLastArmedButtonPressed(State.ARMED_STAY);
        context.changeCurrentState(State.WAITING, Event.NONE);
    }
}
