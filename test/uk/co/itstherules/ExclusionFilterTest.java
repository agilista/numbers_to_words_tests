package uk.co.itstherules;

import java.io.File;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExclusionFilterTest {

    @Test public void wontAcceptDS_Store() {
        ExclusionFilter unit = new ExclusionFilter();
        File file = new File("bogus/.DS_Store");
        assertThat(unit.accept(file), is(false));
    }

    @Test public void wontAcceptThumbs() {
        ExclusionFilter unit = new ExclusionFilter();
        File file = new File("bogus/Thumbs.db");
        assertThat(unit.accept(file), is(false));
    }

    @Test public void wontAcceptIntellijFiles() {
        ExclusionFilter unit = new ExclusionFilter();
        File file = new File("bogus/.idea");
        assertThat(unit.accept(file), is(false));
        file = new File("bogus/project.iml");
        assertThat(unit.accept(file), is(false));
    }

    @Test public void wontAcceptEclipseFiles() {
        ExclusionFilter unit = new ExclusionFilter();
        File file = new File("bogus/.project");
        assertThat(unit.accept(file), is(false));
        file = new File("bogus/.classpath");
        assertThat(unit.accept(file), is(false));
    }

    @Test public void willAcceptIntellijishFiles() {
        ExclusionFilter unit = new ExclusionFilter();
        File file = new File("bogus.idea/blah");
        assertThat(unit.accept(file), is(true));
        file = new File("bogus.iml/project");
        assertThat(unit.accept(file), is(true));
    }

    @Test public void wontAcceptGitFiles() {
        ExclusionFilter unit = new ExclusionFilter();
        File file = new File("bogus/.gitignore");
        assertThat(unit.accept(file), is(false));
    }

}