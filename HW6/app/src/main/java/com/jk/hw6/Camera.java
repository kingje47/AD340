package com.jk.hw6;

/* class designed from Head First Android Development Chapter 13 */

import java.util.ArrayList;

public class Camera {
    private String description;
    private String cameraUrl;
    private int cameraId;
    private ArrayList list;


    public void setList(ArrayList list){
        this.list = list;
    }

    public ArrayList getList(){
        return list;
    }

    public Camera(String description, String cameraUrl, int cameraId) {
        this.description = description;
        this.cameraUrl = cameraUrl;
        this.cameraId = cameraId;
    }


    public String getDescription() { return description; }

    public String getCameraUrl() { return cameraUrl; }

    public int getCameraId() { return cameraId; }
}
