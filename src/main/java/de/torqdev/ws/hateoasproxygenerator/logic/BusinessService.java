package de.torqdev.ws.hateoasproxygenerator.logic;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class BusinessService {
    private WiringMonostate wiringMonostate = new WiringMonostate();

    public void launch() {
        ServiceAnalyser sa = wiringMonostate.getServiceAnalyser();
        CodeGenerator cg = wiringMonostate.getCodeGenerator();

        cg.generate(sa.analyse());
    }
}
