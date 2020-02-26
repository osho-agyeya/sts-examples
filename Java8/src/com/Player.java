package com;

import java.time.LocalDate;
import java.util.Optional;

public class Player {
    private String name;
    private String role;
    private int totalRuns;
    private int totalWickets;
    private Optional<String> teamName;
    private LocalDate debutDate;

    public Player(final String name, final String role, final int totalRuns, final int totalWickets,
        final Optional<String> teamName, final LocalDate debutDate) {
        super();
        this.name = name;
        this.role = role;
        this.totalRuns = totalRuns;
        this.totalWickets = totalWickets;
        this.teamName = teamName;
        this.debutDate = debutDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public int getTotalRuns() {
        return this.totalRuns;
    }

    public void setTotalRuns(final int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalWickets() {
        return this.totalWickets;
    }

    public void setTotalWickets(final int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public Optional<String> getTeamName() {
        return this.teamName;
    }

    public void setTeamName(final Optional<String> teamName) {
        this.teamName = teamName;
    }

    public LocalDate getDebutDate() {
        return this.debutDate;
    }

    public void setDebutDate(final LocalDate debutDate) {
        this.debutDate = debutDate;
    }

    public void print() {
        System.out.println("Name: " + this.name);
        System.out.println("Role: " + this.role);
        System.out.println("Runs: " + this.totalRuns);
        System.out.println("Wickets: " + this.totalWickets);
        System.out.println("Team: " + this.teamName.orElse("No Team"));
        System.out.println("Debut: " + this.debutDate.toString());
    }

}
