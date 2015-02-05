package com.compostela.curso.terremotos.model;

import android.graphics.Point;

/**
 * Created by mañá on 03/02/2015.
 */
public class Terremoto {
    private String id;
    private String title;
    private String url;
    private Point point;

    public Terremoto() {
    }

    public Terremoto(String id, String title, String url, Point point) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public class Point{
        private String latitude;
        private String longitude;

        Point(String latitude, String longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
