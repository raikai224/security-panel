package main.java.com.obscuritysecurity.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.java.com.obscuritysecurity.business.facade.SecurityPanelContext;
import main.java.com.obscuritysecurity.business.interfaces.SecurityPanelDisplay;
import main.java.com.obscuritysecurity.business.utils.Event;

/**
 * Main UI
 * <p>
 * Pulls all buttons/text/etc and makes them variables to be used
 */
public class Controller implements EventHandler<ActionEvent>, SecurityPanelDisplay {

    private final SecurityPanelContext securityPanelContext = SecurityPanelContext.securityPanel(this);

    @FXML
    private TextField statusTextField;
    @FXML
    private Text statusText;

    @FXML
    private Button numPad0;
    @FXML
    private Button numPad1;
    @FXML
    private Button numPad2;
    @FXML
    private Button numPad3;
    @FXML
    private Button numPad4;
    @FXML
    private Button numPad5;
    @FXML
    private Button numPad6;
    @FXML
    private Button numPad7;
    @FXML
    private Button numPad8;
    @FXML
    private Button numPad9;
    @FXML
    private Button stayButton;
    @FXML
    private Button awayButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button motionButton;

    @FXML
    private CheckBox zone1;
    @FXML
    private CheckBox zone2;
    @FXML
    private CheckBox zone3;

    /**
     * Sets action on all elements in UI
     */
    public void initialize() {
        numPad0.setOnAction(this);
        numPad1.setOnAction(this);
        numPad2.setOnAction(this);
        numPad3.setOnAction(this);
        numPad4.setOnAction(this);
        numPad5.setOnAction(this);
        numPad6.setOnAction(this);
        numPad7.setOnAction(this);
        numPad8.setOnAction(this);
        numPad9.setOnAction(this);
        stayButton.setOnAction(this);
        awayButton.setOnAction(this);
        cancelButton.setOnAction(this);
        motionButton.setOnAction(this);

        zone1.setOnAction(this);
        zone2.setOnAction(this);
        zone3.setOnAction(this);
    }

    /**
     * Handles all events and passes new events to context
     *
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(numPad0)) {
            securityPanelContext.processEnteredPasscode("0");
        } else if (actionEvent.getSource().equals(numPad1)) {
            securityPanelContext.processEnteredPasscode("1");
        } else if (actionEvent.getSource().equals(numPad2)) {
            securityPanelContext.processEnteredPasscode("2");
        } else if (actionEvent.getSource().equals(numPad3)) {
            securityPanelContext.processEnteredPasscode("3");
        } else if (actionEvent.getSource().equals(numPad4)) {
            securityPanelContext.processEnteredPasscode("4");
        } else if (actionEvent.getSource().equals(numPad5)) {
            securityPanelContext.processEnteredPasscode("5");
        } else if (actionEvent.getSource().equals(numPad6)) {
            securityPanelContext.processEnteredPasscode("6");
        } else if (actionEvent.getSource().equals(numPad7)) {
            securityPanelContext.processEnteredPasscode("7");
        } else if (actionEvent.getSource().equals(numPad8)) {
            securityPanelContext.processEnteredPasscode("8");
        } else if (actionEvent.getSource().equals(numPad9)) {
            securityPanelContext.processEnteredPasscode("9");
        } else if (actionEvent.getSource().equals(stayButton)) {
            securityPanelContext.handleEvent(Event.STAY);
        } else if (actionEvent.getSource().equals(awayButton)) {
            securityPanelContext.handleEvent(Event.AWAY);
        } else if (actionEvent.getSource().equals(cancelButton)) {
            securityPanelContext.handleEvent(Event.CANCEL);
        } else if (actionEvent.getSource().equals(motionButton)) {
            securityPanelContext.handleEvent(Event.MOTION_DETECTED);
        } else if (actionEvent.getSource().getClass().equals(CheckBox.class)) {
            securityPanelContext.handleEvent(Event.ZONE_BREACHED);
        }
    }

    public void setNewStatus(String text) {
        statusTextField.setText(text);
        statusText.setText(text + " Status");
    }

    public void updateStatusTimer(String text, String timer) {
        setNewStatus(text);
        statusTextField.setText(statusTextField.getText() + " " + timer);
    }

    public boolean getZoneStatuses() {
        return zone1.isSelected() && zone2.isSelected() && zone3.isSelected();
    }
}
