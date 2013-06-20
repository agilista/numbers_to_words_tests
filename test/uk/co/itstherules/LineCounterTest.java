package uk.co.itstherules;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LineCounterTest {

    @Test
    public void oneCount() {
        LineCounter unit = new LineCounter("test-resource/one_line.txt");
        assertThat(unit.count(), equalTo(1));
    }

    @Test
    public void twoCount() {
        LineCounter unit = new LineCounter("test-resource/two_lines.txt");
        assertThat(unit.count(), equalTo(2));
    }

    @Test
    public void twoCountOneLineReallyLong() {
        LineCounter unit = new LineCounter(
                "test-resource/two_lines_one_really_long.txt");
        assertThat(unit.count(), equalTo(11));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fileDoesntExist() {
        LineCounter unit = new LineCounter("test-resource/i_dont_exist.txt");
        unit.count();
    }

    @Test
    public void directoryCrawlAndCount() {
        LineCounter unit = new LineCounter("test-resource/three_dir");
        assertThat(unit.count(), equalTo(3));
    }

    @Test
    public void directoryCrawlACoupleOfLevels() {
        LineCounter unit = new LineCounter("test-resource/six_dir");
        assertThat(unit.count(), equalTo(6));
    }

}
