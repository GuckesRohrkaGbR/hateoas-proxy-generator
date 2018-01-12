package de.torqdev.ws.hateoasproxygenerator.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class WiringMonostateTest {
    @Test(expected = IllegalStateException.class)
    public void creatingWithoutInitializing_throwsException() throws Exception {
        new WiringMonostate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInitializing_serviceAnalyserCantBeNull() throws Exception {
        WiringMonostate.initialize(null, new CodeGenerator() {
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInitializing_codeGeneratorCantBeNull() throws Exception {
        WiringMonostate.initialize(new ServiceAnalyser() {
        }, null);
    }

    @Test(expected = IllegalStateException.class)
    public void whenInitializingSecond_throwsException() throws Exception {
        initWM();
        initWM();
    }

    @Test(expected = IllegalStateException.class)
    public void whenCallingServiceAnalyserGetterWithoutInitializing_throwsIllegalArgumentException() {
        WiringMonostate wm = new WiringMonostate();
        wm.getServiceAnalyser();
    }

    @Test(expected = IllegalStateException.class)
    public void whenCallingCodeGeneratorGetterWithoutInitializing_throwsIllegalArgumentException() {
        WiringMonostate wm = new WiringMonostate();
        wm.getCodeGenerator();
    }

    @Test
    public void initializingCorrectly_works() {
        initWM();
    }

    @Test
    public void onceInialized_returnsServiceAnalyser() throws Exception {
        initWM();
        WiringMonostate wm = new WiringMonostate();
        assertNotNull(wm.getServiceAnalyser());
    }

    @Test
    public void onceInialized_returnsCodeGenerator() throws Exception {
        initWM();
        WiringMonostate wm = new WiringMonostate();
        assertNotNull(wm.getCodeGenerator());
    }

    private void initWM() {
        WiringMonostate.initialize(new ServiceAnalyser() {
        }, new CodeGenerator() {
        });
    }

    @Before
    @After
    public void unInitWM() {
        WiringMonostate.serviceAnalyser = null;
        WiringMonostate.codeGenerator = null;
    }
}