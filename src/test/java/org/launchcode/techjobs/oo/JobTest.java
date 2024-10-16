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

        String expectedString = lineSeperator
                                +"ID: " + newJob.getId()
                                +lineSeperator
                                +"Name: " + newJob.getName()
                                +lineSeperator
                                +"Employer: " + newJob.getEmployer()
                                +lineSeperator
                                +"Location: " + newJob.getLocation()
                                +lineSeperator
                                +"Position Type: " + newJob.getPositionType()
                                +lineSeperator
                                +"Core Competency: " + newJob.getCoreCompetency()
                                +lineSeperator;

        String actualOutputString = newJob.toString();
        System.out.println(actualOutputString);

        assertEquals(expectedString, actualOutputString);

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job newJob = new Job("", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = """
                
                ID: 1
                Name: Data not available
                Employer: ACME
                Location: Desert
                Position Type: Quality control
                Core Competency: Persistence
                """;

        assertEquals(expected, newJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyJob() {

        Job newJob = new Job();

        String expectedOutput = "OOPS! This job does not seem to exist.";

        assertEquals(expectedOutput, newJob.toString());


    }
}
