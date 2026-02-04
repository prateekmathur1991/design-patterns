package com.designpatterns.behavioral.mediator;

import java.util.List;
import java.util.ArrayList;

/**
 * The Mediator could be an interface, or even an abstract class, so that different mediators could be swapped in run-time
 * In this example, however, the Mediator is a stand-alone class used for co-ordinating communications with different objects.
 */
public class AirTrafficMediator {

    private List<String> registeredAircrafts = new ArrayList<>();

    private RUNWAY_STATUS runwayStatus = RUNWAY_STATUS.AVAILABLE;

    private enum RUNWAY_STATUS {
        OCCOUPIED,
        AVAILABLE
    }

    public enum LANDING_INSTRUCTION {
        PROCEED,
        HOLD
    }

    public void registerAircarft(String aircraftName) {
        this.registeredAircrafts.add(aircraftName);
    }

    public LANDING_INSTRUCTION requestLanding(String aircraftName) {
        if (!this.registeredAircrafts.contains(aircraftName)) {
            throw new IllegalArgumentException("Un-registerd air-craft requesting landing");
        }

        if (this.runwayStatus == RUNWAY_STATUS.AVAILABLE) {
            this.runwayStatus = RUNWAY_STATUS.OCCOUPIED;
            return LANDING_INSTRUCTION.PROCEED;
        }

        return LANDING_INSTRUCTION.HOLD;
    }

    public void finishLanding(String aircraftName) {
        if (!this.registeredAircrafts.contains(aircraftName)) {
            throw new IllegalArgumentException("Un-registerd air-craft requesting landing");
        }

        this.runwayStatus = RUNWAY_STATUS.AVAILABLE;
    }
}
