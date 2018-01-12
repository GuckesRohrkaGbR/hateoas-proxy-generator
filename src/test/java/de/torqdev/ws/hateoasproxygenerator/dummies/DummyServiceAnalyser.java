package de.torqdev.ws.hateoasproxygenerator.dummies;

import de.torqdev.ws.hateoasproxygenerator.logic.ServiceAnalyser;
import de.torqdev.ws.hateoasproxygenerator.model.ServiceStructure;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class DummyServiceAnalyser implements ServiceAnalyser {
    public boolean fetchWasCalled = false;
    public ServiceStructure returnedStructure = new ServiceStructure();

    @Override
    public ServiceStructure analyse() {
        fetchWasCalled = true;
        return returnedStructure;
    }
}
