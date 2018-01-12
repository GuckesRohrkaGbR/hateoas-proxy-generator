package de.torqdev.ws.hateoasproxygenerator.logic;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class WiringMonostate {
    private static final String NOT_INITIALIZED = "The wiring monostate object needs to be initialized!";
    private static final String NO_NULL_INITIALIZATION = "The wiring monostate object can't be initialized with null values.";
    private static final String ALREADY_INITIALIZED = "The wiring monostate can only be initialized once!";

    protected static CodeGenerator codeGenerator;

    protected static ServiceAnalyser serviceAnalyser;

    @SuppressWarnings("squid:S1118")
    public WiringMonostate() {
        assertIsInitialized();
    }

    public CodeGenerator getCodeGenerator() {
        assertIsInitialized();
        return codeGenerator;
    }

    public ServiceAnalyser getServiceAnalyser() {
        assertIsInitialized();
        return serviceAnalyser;
    }

    private static void assertIsInitialized() {
        if (anyElementIsNull(serviceAnalyser, codeGenerator)) {
            throw new IllegalStateException(NOT_INITIALIZED);
        }
    }

    public static void initialize(ServiceAnalyser serviceAnalyser, CodeGenerator codeGenerator) {
        if (anyElementIsNull(serviceAnalyser, codeGenerator)) {
            throw new IllegalArgumentException(NO_NULL_INITIALIZATION);
        }
        if(!anyElementIsNull(WiringMonostate.serviceAnalyser, WiringMonostate.codeGenerator)) {
            throw new IllegalStateException(ALREADY_INITIALIZED);
        }
        WiringMonostate.serviceAnalyser = serviceAnalyser;
        WiringMonostate.codeGenerator = codeGenerator;
    }

    private static boolean anyElementIsNull(ServiceAnalyser serviceAnalyser, CodeGenerator codeGenerator) {
        return serviceAnalyser == null || codeGenerator == null;
    }
}
