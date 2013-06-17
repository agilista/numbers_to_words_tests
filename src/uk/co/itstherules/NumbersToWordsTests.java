package uk.co.itstherules;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileReader;
import java.util.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class NumbersToWordsTests {

    private static Properties expected;
    private static Properties actual;
    private final String numberToCheck;

    @BeforeClass
    public static void loadFile() throws Exception {
        actual = loadValues("actual_values.properties");
    }

    public NumbersToWordsTests(String numberToCheck) {
        this.numberToCheck = numberToCheck;
    }

    private static Properties loadValues(String path) {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(path));
            return properties;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkExpectedValue() {
        String expectedValue = expected.getProperty(numberToCheck);
        String actualValue = actual.getProperty(numberToCheck);
        assertNotNull(String.format("The value for \"%s\" has not been found in the file actual_values.properties",
                numberToCheck), actualValue);
        assertThat(actualValue.trim(), equalTo(expectedValue.trim()));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> values() {
        expected = loadValues("expected_values.properties");
        List<Object[]> reply = new ArrayList<Object[]>();
        Set<Object> set = expected.keySet();
        for (Object key : set) {
            reply.add(new Object[]{key});
        }
        return reply;
    }

}
