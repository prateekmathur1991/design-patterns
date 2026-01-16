package com.designpatterns.structural.facade;

public class Client {

    public static void main(String[] args) {
        MovieExperienceFacade movieFacade = new MovieExperienceFacade();

        System.out.println("Starting the movie experience:");
        movieFacade.startMovie();

        System.out.println("\nStopping the movie experience:");
        movieFacade.stopMovie();
    }
}
