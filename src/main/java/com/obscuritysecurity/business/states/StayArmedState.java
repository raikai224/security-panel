package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implement the Stay Armed state.
 */
public class StayArmedState extends SecurityPanelState {

    private static StayArmedState instance;

    private StayArmedState() {
    }

    /**
     * Instance stay armed state.
     *
     * @return the stay armed state
     */
    public static StayArmedState instance() {
        return Objects.requireNonNullElseGet(instance, StayArmedState::new);
    }

    public void handle(Object event) {
        display.setNewStatus(stateText);

        if (event.equals(Event.CANCEL)) {
            processArmedCancel();
        } else if (event.equals(Event.ZONE_BREACHED)) {
            processZoneBreached();
        }
    }

    /**
     * Process armed cancel.
     */
    public void processArmedCancel() {
        context.changeCurrentState(State.ARMED_CANCEL, Event.NONE);
    }

    /**
     * Process zone breached.
     */
    public void processZoneBreached() {
        context.changeCurrentState(State.ALARMED, Event.NONE);
    }
}
