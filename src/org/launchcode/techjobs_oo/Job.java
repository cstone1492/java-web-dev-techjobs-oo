package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {
    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer; //DRY
    private Location location; //DRY


    private PositionType positionType; //DRY

    private CoreCompetency coreCompetency; //DRY

    // DONE: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // DONE: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        int aId = this.getId();
        String aName;
        String aEmployer;
        String aLocation;
        String aPositionType;
        String aCoreCompetency;
        String blankError = "Data not available";
        if ( this.getName() == null) {
            aName = blankError;
        } else {
            aName = this.getName();
        }
        if (this.getEmployer().getValue() == null || this.getEmployer().getValue() == "") {
            aEmployer = blankError;
        } else {
            aEmployer = this.getEmployer().getValue();
        }
        if (this.getLocation().getValue() == null) {
            aLocation = blankError;
        } else {
            aLocation = this.getLocation().getValue();
        }
        if (this.getPositionType().getValue() == null) {
            aPositionType = blankError;
        } else {
            aPositionType = this.getPositionType().getValue();
        }
        if (this.getCoreCompetency().getValue() == null) {
            aCoreCompetency = blankError;
        } else {
            aCoreCompetency = this.getCoreCompetency().getValue();
        }
        if (aName == blankError && aEmployer == blankError && aLocation == blankError && aPositionType == blankError && aCoreCompetency == blankError) {
            return "OOPS! This job does not seem to exist.";
        } else {
            return "\n" + "ID: " + aId + "\n" + "Name: " + aName + "\n" + "Employer: " + aEmployer + "\n" + "Location: " + aLocation + "\n" + "Position Type: " + aPositionType + "\n" + "Core Competency:" + aCoreCompetency + "\n";
        }
    }
    // DONE: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
