package com.jk.hw7;

/* class designed from Head First Android Development Chapter 13 */

public class Camera {
    private String description;
    private double latitude;
    private double longitude;
    private String cameraUrl;
    private int cameraId;

    public static final Camera[] cameras = {

    };

    public Camera(String description, double latitude, double longitude, String cameraUrl, int cameraId) {
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cameraUrl = cameraUrl;
        this.cameraId = cameraId;
    }


    public String getDescription() { return description; }

    public double getLatitude() { return latitude; }

    public double getLongitude() { return longitude; }

    public String getCameraUrl() { return cameraUrl; }

    public int getCameraId() { return cameraId; }
}
