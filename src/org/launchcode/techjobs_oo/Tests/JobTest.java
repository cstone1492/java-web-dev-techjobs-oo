package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;

    @Before
    public void createJobObject() {
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertFalse(job1.equals(job2));
        assertEquals(job1.getId() + 1, job2.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Front-end Developer", new Employer("GE"), new Location("San Francisco"), new PositionType("Front-end Developer"), new CoreCompetency("JavaScript"));
        Job testJob2 = new Job("Front-end Developer", new Employer("GE"), new Location("San Francisco"), new PositionType("Front-end Developer"), new CoreCompetency("JavaScript"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testJobToStringBlankLine() {
        //when passed a job object, it should return a string
        // that contains a blank line before and after the job information

        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        System.out.println(testJob.toString());

        assertEquals(testJob.toString().indexOf("\n"), 0);
        assertEquals(testJob.toString().substring(testJob.toString().length() -1), "\n");

    }

    @Test
    public void testJobToStringLabelData() {

        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.toString().contains("ID"));
        assertTrue(testJob.toString().contains("Name"));
        assertTrue(testJob.toString().contains("Employer"));
        assertTrue(testJob.toString().contains("Location"));
        assertTrue(testJob.toString().contains("Position Type"));
        assertTrue(testJob.toString().contains("Quality control"));

    }

    @Test
    public void testJobToStringEmptyField() {
        //If a field is empty, the method should add, “Data not available” after the label.

        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.toString().contains("Employer: Data not available"));
    }

    /**BONUS**/
    /*@Test
    public void testJobToStringBonus() {
        //(Bonus) If a Job object ONLY contains data for the id field,
        // the method should return, “OOPS! This job does not seem to exist.”
        System.out.println(job1);
        //assertEquals(job1.toString(), "OOPS! This job does not seem to exist");

    }*/
}
