package com.designpatterns.structural.facade;

/**
 * This is the 'facade' class, a single entry point to manage the complex home theater sub-systems.
 * Client code interacts with this class to simplify the process of starting and stopping a movie experience.
 * 
 * The benefits of using the Facade pattern here include:
 * 1. Simplified Interface: Clients interact with a single class instead of multiple sub-systems.
 * 2. Reduced Complexity: Hides the complexities of the sub-systems from the client
 * 3. Improved Maintainability: Changes in sub-systems require minimal changes in client code.
 */
public class MovieExperienceFacade {

    private LightSystem lightSystem;
    private SoundSystem soundSystem;
    private ProjectionSystem projectionSystem;

    public MovieExperienceFacade() {
        this.lightSystem = new LightSystem();
        this.soundSystem = new SoundSystem();
        this.projectionSystem = new ProjectionSystem();
    }

    public void startMovie() {
        lightSystem.turnOn();
        soundSystem.turnOn();
        projectionSystem.turnOn();
    }

    public void stopMovie() {
        lightSystem.turnOff();
        soundSystem.turnOff();
        projectionSystem.turnOff();
    }
}