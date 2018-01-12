package de.torqdev.ws.hateoasproxygenerator.logic;

import de.torqdev.ws.hateoasproxygenerator.dummies.DummyCodeGenerator;
import de.torqdev.ws.hateoasproxygenerator.dummies.DummyServiceAnalyser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class BusinessServiceTest {
    @Test(expected = IllegalStateException.class)
    public void whenLaunchingUnconfigured_throwsExceptions() throws Exception {
        new BusinessService().launch();
    }

    @Test
    public void whenLaunching_fetchesStructureFromAnalyserAndPushesToGenerator() throws Exception {
        initWithDummies();

        BusinessService bs = new BusinessService();
        bs.launch();
    }

    @Test
    public void whenLaunching_fetchesStructureFromAnalyser() throws Exception {
        initWithDummies();
        new BusinessService().launch();
        assertFetchWasCalled();
    }

    @Test
    public void whenLaunching_pushesStructureToGenerator() throws Exception {
        initWithDummies();
        new BusinessService().launch();
        assertGenerateWasCalled();
    }

    @Test
    public void whenLaunching_pushesStructureFromAnalyserToGenerator() throws Exception {
        initWithDummies();
        new BusinessService().launch();
        assertStructureWasPassed();
    }

    private void assertFetchWasCalled() {
        WiringMonostate wm = new WiringMonostate();
        DummyServiceAnalyser dsa = (DummyServiceAnalyser) wm.getServiceAnalyser();
        assertTrue(dsa.fetchWasCalled);
    }

    private void assertGenerateWasCalled() {
        WiringMonostate wm = new WiringMonostate();
        DummyCodeGenerator dcg = (DummyCodeGenerator) wm.getCodeGenerator();
        assertTrue(dcg.generateWasCalled);
    }

    private void assertStructureWasPassed() {
        WiringMonostate wm = new WiringMonostate();
        DummyServiceAnalyser dsa = (DummyServiceAnalyser) wm.getServiceAnalyser();
        DummyCodeGenerator dcg = (DummyCodeGenerator) wm.getCodeGenerator();
        assertEquals(dsa.returnedStructure, dcg.passedStructure);
    }

    private void initWithDummies() {
        WiringMonostate.initialize(new DummyServiceAnalyser(), new DummyCodeGenerator());
    }

    @Before
    @After
    public void setUp() throws Exception {
        WiringMonostateUtil.reset();
    }
}