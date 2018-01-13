package de.torqdev.ws.hateoasproxygenerator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class HateoasBaseObject {
    @Getter
    @Setter
    private String title;

    @Getter
    private HashMap<String, HateoasObjectProperty> properties = new ConcurrentHashMap<String, HateoasObjectProperty>();
}
