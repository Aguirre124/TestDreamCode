package us.zippopotam.api.utils.resources;

import us.zippopotam.api.utils.constants.EndPoints;

public enum WebServicesEndPoints {
    URI(EndPoints.URL_ZIP);

    private final String url;

    WebServicesEndPoints(String url) { this.url = url; }

    public String getUrl() { return this.url; }
}
