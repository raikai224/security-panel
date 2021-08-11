package main.java.com.obscuritysecurity.business.states;

import main.java.com.obscuritysecurity.business.facade.SecurityPanelContext;
import main.java.com.obscuritysecurity.business.interfaces.SecurityPanelDisplay;

/**
 * The class implements the Security panel state.
 */
public abstract class SecurityPanelState {

    protected static SecurityPanelContext context;
    protected static SecurityPanelDisplay display;
    protected String stateText;

    /**
     * Instantiates a new Security panel state.
     */
    protected SecurityPanelState() {
    }

    /**
     * Handle.
     *
     * @param event the event
     */
    public abstract void handle(Object event);

    /**
     * Sets state text.
     *
     * @param stateText the state text
     */
    public void setStateText(String stateText) {
        this.stateText = stateText;
    }

    /**
     * Process entered passcode.
     *
     * @param passcodeNumber the passcode number
     */
    public void processEnteredPasscode(String passcodeNumber) {
    }
}
