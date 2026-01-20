package com.designpatterns.structural.proxy;

public class BasicDownloadImplementation implements VideoDownloader {

    @Override
    public String getVideoInfo(String videoId) {
        return "Video Info for ID: " + videoId;
    }

    @Override
    public void downloadVideo(String videoId) {
        System.out.println("Downloading video with ID: " + videoId);
    }

}
