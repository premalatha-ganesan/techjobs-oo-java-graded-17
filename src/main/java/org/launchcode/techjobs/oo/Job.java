package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
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


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        String noData = "Data not available";
        String outputName = this.name == null || this.name.isEmpty() ? noData : this.name;
        String outputEmployer = (this.employer == null || this.employer.getValue() == null || this.getEmployer().getValue().isBlank()) ?
                noData : this.employer.getValue();
        String outputLocation = (this.location == null || this.location.getValue() == null || this.getLocation().getValue().isBlank()) ?
                noData : this.location.getValue();
        String outputPositionType = (this.positionType == null || this.positionType.getValue() == null || this.getPositionType().getValue().isBlank()) ?
                noData : this.positionType.getValue();
        String outputCoreCompetency = (this.coreCompetency == null || this.coreCompetency.getValue() == null || this.getCoreCompetency().getValue().isBlank()) ?
                noData : this.coreCompetency.getValue();


        if(this.name == null && this.employer == null && this.location == null &&
                this.positionType == null && this.coreCompetency == null) {
            return "OOPS! This job does not seem to exist.";
        }

        else {
            return lineSeparator
                    + "ID: " + this.id
                    + lineSeparator
                    + "Name: " + outputName
                    + lineSeparator
                    + "Employer: " + outputEmployer
                    + lineSeparator
                    + "Location: " + outputLocation
                    + lineSeparator
                    + "Position Type: " + outputPositionType
                    + lineSeparator
                    + "Core Competency: " + outputCoreCompetency
                    + lineSeparator;

        }
    }
}
