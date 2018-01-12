package de.torqdev.ws.hateoasproxygenerator.logic;

import de.torqdev.ws.hateoasproxygenerator.dummies.DummyCodeGenerator;
import de.torqdev.ws.hateoasproxygenerator.dummies.DummyServiceAnalyser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:christopher.guckes@torq-dev.de">Christopher Guckes</a>
 * @version 1.0
 */
public class SimpleServiceHelperTest {
    @Test(expected = IllegalStateException.class)
    public void givenNoAvailableServiceAnalysers_throwsException() throws Exception {
        createEmptyServiceHelper().findAllServiceAnalysers();
    }

    @Test(expected = IllegalStateException.class)
    public void givenNoAvailableCodeGenerators_throwsException() throws Exception {
        createEmptyServiceHelper().findAllCodeGenerators();
    }

    @Test
    public void givenManyAvailableServiceAnalysers_returnsThem() throws Exception {
        assertOneElement(createFilledServiceHelper().findAllServiceAnalysers());
    }

    @Test
    public void givenManyAvailableCodeGenerators_returnsThem() throws Exception {
        assertOneElement(createFilledServiceHelper().findAllCodeGenerators());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenFetchingCodeGenerators_returnsImmutableList() throws Exception {
        createFilledServiceHelper().findAllCodeGenerators().add(new DummyCodeGenerator());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenFetchingServiceAnalysers_returnsImmutableList() throws Exception {
        createFilledServiceHelper().findAllServiceAnalysers().add(new DummyServiceAnalyser());
    }

    private void assertOneElement(List<?> list) {
        assertEquals(1, list.size());
    }

    private SimpleServiceHelper createEmptyServiceHelper() {
        SimpleServiceHelper sh = new SimpleServiceHelper();
        sh.codeGenerators = new ArrayList<>();
        sh.serviceAnalysers = new ArrayList<>();
        return sh;
    }

    private SimpleServiceHelper createFilledServiceHelper() {
        SimpleServiceHelper sh = createEmptyServiceHelper();
        sh.codeGenerators.add(new DummyCodeGenerator());
        sh.serviceAnalysers.add(new DummyServiceAnalyser());
        return sh;
    }
}