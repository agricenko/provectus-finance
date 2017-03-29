package com.provectus.taxmanagement.client.resource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageBundle extends ClientBundle {

    String PATH = "com/provectus/taxmanagement/client/resource/image/";

    @Source(PATH +  "homeBackground.jpg")
    ImageResource homeBackground();

    @Source(PATH +  "logo.png")
    ImageResource logo();
}