package de.torqdev.ws.hateoasproxygenerator.dummies;

import de.torqdev.ws.hateoasproxygenerator.logic.CodeGenerator;
import de.torqdev.ws.hateoasproxygenerator.model.ServiceStructure;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class DummyCodeGenerator implements CodeGenerator {
    public boolean generateWasCalled = false;
    public ServiceStructure passedStructure;

    @Override
    public void generate(ServiceStructure structure) {
        generateWasCalled = true;
        passedStructure = structure;
    }
}
