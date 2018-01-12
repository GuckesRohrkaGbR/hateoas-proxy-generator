package de.torqdev.ws.hateoasproxygenerator.logic;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class WiringMonostateUtil {
    static void reset() {
        WiringMonostate.serviceAnalyser = null;
        WiringMonostate.codeGenerator = null;
    }
}
