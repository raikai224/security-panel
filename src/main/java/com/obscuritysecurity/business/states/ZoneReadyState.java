package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implement the Zone ready state.
 */
public class ZoneReadyState extends SecurityPanelState {

    private static ZoneReadyState instance;

    private ZoneReadyState() {
    }

    /**
     * Instance of zone ready state.
     *
     * @return ZoneReadyState
     */
    public static ZoneReadyState instance() {
        return Objects.requireNonNullElseGet(instance, ZoneReadyState::new);
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
        context.changeCurrentState(State.WAITING, Event.TIMER_TICK);
    }

    /**
     * Process armed stay.
     */
    public void processArmedStay() {
        context.setLastArmedButtonPressed(State.ARMED_STAY);
        context.changeCurrentState(State.WAITING, Event.TIMER_TICK);
    }
}
