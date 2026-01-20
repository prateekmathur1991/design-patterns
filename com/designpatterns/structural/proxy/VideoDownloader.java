package com.designpatterns.structural.proxy;

public interface VideoDownloader {

    String getVideoInfo(String videoId);

    void downloadVideo(String videoId);
}
