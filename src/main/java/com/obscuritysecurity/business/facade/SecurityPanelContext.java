package main.java.com.obscuritysecurity.business.facade;

import main.java.com.obscuritysecurity.business.interfaces.SecurityPanelDisplay;
import main.java.com.obscuritysecurity.business.utils.State;
import main.java.com.obscuritysecurity.ui.Controller;

import java.util.Observable;
import java.util.Observer;

/**
 * The type Security panel context.
 */
public class SecurityPanelContext implements Observer {

    private String enteredPasscode = "";
    private final String PASSCODE = "000000";

    private State currentState = State.ZONES_NOT_READY;
    private State lastArmedButtonPressed;
    private int timeRemaining = 0;

    private static SecurityPanelContext securityPanelContext;
    private static SecurityPanelDisplay display;

    private SecurityPanelContext() {
    }

    /**
     * Singleton method for creating a security panel instance
     *
     * @param controller the controller
     * @return Security Panel Singleton
     */
    public static SecurityPanelContext securityPanel(Controller controller) {
        if (securityPanelContext == null) {
            securityPanelContext = new SecurityPanelContext();
        }
        display = controller;
        return securityPanelContext;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static SecurityPanelContext getInstance() {
        return securityPanelContext;
    }

    @Override
    public void update(Observable source, Object event) {
        this.currentState.get().handle(event);
    }

    /**
     * Handle event.
     *
     * @param args the args
     */
    public void handleEvent(Object args) {
        this.currentState.get().handle(args);
    }

    /**
     * Gets display.
     *
     * @return the display
     */
    public SecurityPanelDisplay getDisplay() {
        return display;
    }

    /**
     * Gets entered passcode.
     *
     * @return the entered passcode
     */
    public String getEnteredPasscode() {
        return this.enteredPasscode;
    }

    /**
     * Sets entered passcode.
     *
     * @param passcode the passcode
     */
    public void setEnteredPasscode(String passcode) {
        this.enteredPasscode = passcode;
    }

    /**
     * Gets passcode.
     *
     * @return the passcode
     */
    public String getPasscode() {
        return this.PASSCODE;
    }

    /**
     * Gets current state.
     *
     * @return the current state
     */
    public State getCurrentState() {
        return this.currentState;
    }

    /**
     * Gets last armed button pressed.
     *
     * @return the last armed button pressed
     */
    public State getLastArmedButtonPressed() {
        return this.lastArmedButtonPressed;
    }

    /**
     * Sets last armed button pressed.
     *
     * @param lastArmedButtonPressed the last armed button pressed
     */
    public void setLastArmedButtonPressed(State lastArmedButtonPressed) {
        this.lastArmedButtonPressed = lastArmedButtonPressed;
    }

    /**
     * Change current state.
     *
     * @param state the state
     * @param event the event
     */
    public void changeCurrentState(State state, Object event) {
        this.currentState = state;
        state.get().handle(event);
    }

    /**
     * Process entered passcode.
     *
     * @param passcodeNumber the passcode number
     */
    public void processEnteredPasscode(String passcodeNumber) {
        this.currentState.get().processEnteredPasscode(passcodeNumber);
    }
}
