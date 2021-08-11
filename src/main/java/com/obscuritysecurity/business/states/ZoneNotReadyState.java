package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.facade.SecurityPanelContext;
import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implement the Zone not ready state.
 */
public class ZoneNotReadyState extends SecurityPanelState {

    private static ZoneNotReadyState instance;

    private ZoneNotReadyState() {
    }

    /**
     * Instance of zone not ready state.
     *
     * @return ZoneNotReadyState
     */
    public static ZoneNotReadyState instance() {
        return Objects.requireNonNullElseGet(instance, ZoneNotReadyState::new);
    }

    public void handle(Object event) {
        context = SecurityPanelContext.getInstance();
        display = context.getDisplay();
        display.setNewStatus(stateText);

        if (event.equals(Event.AWAY)) {
            processArmedAway();
        } else if (event.equals(Event.STAY)) {
            processArmedStay();
        } else if (event.equals(Event.TIMER_TICK)) {
            runTimer();
        }
    }

    /**
     * Run the timer.
     */
    public void runTimer() {
        if (context == null) {
            context = SecurityPanelContext.getInstance();
            display = context.getDisplay();
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
