package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.utils.Event;
import main.java.com.obscuritysecurity.business.utils.State;

import java.util.Objects;

/**
 * This class implements the Away Armed State.
 */
public class AwayArmedState extends SecurityPanelState {

    private static AwayArmedState instance;

    private AwayArmedState() {
    }

    /**
     * Instance away armed state.
     *
     * @return the away armed state
     */
    public static AwayArmedState instance() {
        return Objects.requireNonNullElseGet(instance, AwayArmedState::new);
    }

    public void handle(Object event) {
        display.setNewStatus(stateText);

        if (event.equals(Event.CANCEL)) {
            processArmedCancel();
        } else if (event.equals(Event.MOTION_DETECTED)) {
            processMotionDetected();
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
     * Process motion detected.
     */
    public void processMotionDetected() {
        context.changeCurrentState(State.WARNING, Event.NONE);
    }

    /**
     * Process zone breached.
     */
    public void processZoneBreached() {
        context.changeCurrentState(State.WARNING, Event.NONE);
    }
}
