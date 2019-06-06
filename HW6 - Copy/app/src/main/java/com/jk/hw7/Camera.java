package com.jk.hw7;

/* class designed from Head First Android Development Chapter 13 */

public class Camera {
    private String description;
    private String cameraUrl;
    private int cameraId;

//    public void setList(ArrayList list){
//        this.list = list;
//    }
//
//    public ArrayList getList(){
//        return list;
//    }

    public static final Camera[] cameras = {

    };

    public Camera(String description, String cameraUrl, int cameraId) {
        this.description = description;
        this.cameraUrl = cameraUrl;
        this.cameraId = cameraId;
    }


    public String getDescription() { return description; }

    public String getCameraUrl() { return cameraUrl; }

    public int getCameraId() { return cameraId; }
}
