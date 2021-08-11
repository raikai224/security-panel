package main.java.com.obscuritysecurity.business.interfaces;

/**
 * The interface Security panel display.
 */
public interface SecurityPanelDisplay {

    /**
     * Sets new status.
     *
     * @param text the text
     */
    void setNewStatus(String text);

    /**
     * Update status timer.
     *
     * @param text  the text
     * @param timer the timer
     */
    void updateStatusTimer(String text, String timer);

    /**
     * Gets zone statuses.
     *
     * @return the zone statuses
     */
    boolean getZoneStatuses();
}
