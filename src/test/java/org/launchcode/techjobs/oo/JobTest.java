package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId () {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", newJob.getName());
        assertEquals("ACME",newJob.getEmployer().getValue());
        assertEquals("Desert", newJob.getLocation().getValue());
        assertEquals("Quality control", newJob.getPositionType().getValue());
        assertEquals("Persistence", newJob.getCoreCompetency().getValue());

        assertTrue(newJob.getName() instanceof String);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job newJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(newJob1.equals(newJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String lineSeparator = System.lineSeparator();
        boolean firstLine = newJob.toString().startsWith(lineSeparator);
        boolean lastLine = newJob.toString().endsWith(lineSeparator);

        assertTrue(firstLine);
        assertTrue(lastLine);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String lineSeperator = System.lineSeparator();

        String expectedOutput = String.format("""
                                
                                ID: %d
                                Name: Product tester
                                Employer: ACME
                                Location: Desert
                                Position Type: Quality control
                                Core Competency: Persistence
                                """, newJob.getId());


        String actualOutputString = newJob.toString();
        System.out.println(actualOutputString);

        assertEquals(expectedOutput, actualOutputString);

    }

    @Test
    public void testToStringHandlesEmptyField() {
//        Job newJob = new Job("", new Employer("ACME"), new Location("Desert"),
//                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job newJob = new Job("Web Developer",new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));

        String expected = String.format("""
                
                ID: %d
                Name: Web Developer
                Employer: Data not available
                Location: StL
                Position Type: Data not available
                Core Competency: Java
                """, newJob.getId());

        assertEquals(expected, newJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyJob() {

        Job newJob = new Job();

        String expectedOutput = "OOPS! This job does not seem to exist.";

        assertEquals(expectedOutput, newJob.toString());


    }
}
