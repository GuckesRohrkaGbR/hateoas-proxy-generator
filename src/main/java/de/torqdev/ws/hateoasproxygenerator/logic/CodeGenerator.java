package de.torqdev.ws.hateoasproxygenerator.logic;

import de.torqdev.ws.hateoasproxygenerator.model.ServiceStructure;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public interface CodeGenerator {
    void generate(ServiceStructure structure);
}
