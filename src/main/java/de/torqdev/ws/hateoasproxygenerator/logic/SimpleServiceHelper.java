package de.torqdev.ws.hateoasproxygenerator.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class SimpleServiceHelper {
    private static final String NO_CODE_GENERATORS_FOUND = "No code generators found!";
    private static final String NO_SERVICE_ANALYSERS_FOUND = "No service analysers found!";
    protected List<CodeGenerator> codeGenerators = new ArrayList<>();
    protected List<ServiceAnalyser> serviceAnalysers = new ArrayList<>();

    protected List<CodeGenerator> findAllCodeGenerators() {
        if (codeGenerators.isEmpty()) {
            throw new IllegalStateException(NO_CODE_GENERATORS_FOUND);
        }
        return Collections.unmodifiableList(codeGenerators);
    }

    protected List<ServiceAnalyser> findAllServiceAnalysers() {
        if (serviceAnalysers.isEmpty()) {
            throw new IllegalStateException(NO_SERVICE_ANALYSERS_FOUND);
        }
        return Collections.unmodifiableList(serviceAnalysers);
    }
}
