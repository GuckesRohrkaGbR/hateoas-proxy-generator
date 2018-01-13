package de.torqdev.ws.hateoasproxygenerator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class HateoasObjectProperty {
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private boolean readOnly;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String format;

    @Getter
    @Setter
    private List<String> enumeration;
}
