package main.java.com.obscuritysecurity.business.utils;

import main.java.com.obscuritysecurity.business.states.*;

public enum State {
    ZONES_NOT_READY("Not Ready", ZoneNotReadyState.instance()),
    ZONES_READY("Ready", ZoneReadyState.instance()),
    WAITING("Waiting", WaitingState.instance()),
    WARNING("Warning", WarningState.instance()),
    ALARMED("Alarmed", AlarmedState.instance()),
    ARMED_AWAY("Away", AwayArmedState.instance()),
    ARMED_STAY("Stay", StayArmedState.instance()),
    ARMED_CANCEL("Cancelled. Please Enter a password", CancelArmedState.instance()),
    UNARMED("Unarmed", UnarmedState.instance());

    private final String stateText;
    private final SecurityPanelState state;

    State(String stateText, SecurityPanelState state) {
        this.stateText = stateText;
        this.state = state;
        this.state.setStateText(this.stateText);
    }

    public String getText() {
        return this.stateText;
    }

    public SecurityPanelState get() {
        return this.state;
    }
}
