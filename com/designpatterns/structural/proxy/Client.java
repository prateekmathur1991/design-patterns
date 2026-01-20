package com.designpatterns.structural.proxy;

public class Client {
    
    public static void main(String[] args) {
        VideoDownloader basicDownloader = new BasicDownloadImplementation();
        VideoDownloader proxyDownloader = new ProxyDownloadImplementation();

        System.out.println("Using Basic Downloader:");
        String videoId = "12345";
        System.out.println(basicDownloader.getVideoInfo(videoId));
        basicDownloader.downloadVideo(videoId);

        System.out.println("\nUsing Proxy Downloader:");
        System.out.println(proxyDownloader.getVideoInfo(videoId));
        proxyDownloader.downloadVideo(videoId);
        // Subsequent calls to demonstrate caching
        System.out.println(proxyDownloader.getVideoInfo(videoId));
        proxyDownloader.downloadVideo(videoId);

        System.out.println("\nUsing Proxy Downloader for a new video ID:");
        String newVideoId = "67890";
        System.out.println(proxyDownloader.getVideoInfo(newVideoId));
        proxyDownloader.downloadVideo(newVideoId);

        System.out.println(proxyDownloader.getVideoInfo(newVideoId));
    }
}
