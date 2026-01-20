package com.designpatterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

/** 
 * The proxy implementation that adds caching functionality over the basic downloader.
 * The proxy also implements the VideoDownloader interface, which is the same one the object being proxied implements as well.
 * This allows the proxy to be used in place of the original object seamlessly.
 */
public class ProxyDownloadImplementation implements VideoDownloader {

    private BasicDownloadImplementation basicDownloader;
    private Map<String, String> videoCache = new HashMap<>();

    public ProxyDownloadImplementation() {
        this.basicDownloader = new BasicDownloadImplementation();
    }

    @Override
    public String getVideoInfo(String videoId) {
        if (videoCache.containsKey(videoId)) {
            return videoCache.get(videoId);
        }
        String info = basicDownloader.getVideoInfo(videoId);
        videoCache.put(videoId, info);
        return info;
    }

    @Override
    public void downloadVideo(String videoId) {
        if (videoCache.containsKey(videoId)) {
            System.out.println("Fetching video from cache for ID: " + videoId);
        } else {
            basicDownloader.downloadVideo(videoId);
            videoCache.put(videoId, "Video Info for ID: " + videoId);
        }
    }

}
