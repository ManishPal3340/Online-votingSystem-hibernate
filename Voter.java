package com.votingmachine.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "voter")
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "voter_name", nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(name = "has_voted", nullable = false)
    private boolean hasVoted = false;

    @OneToMany(mappedBy = "voter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vote> votes = new ArrayList<>();

    // Constructors
    public Voter() {
        this.hasVoted = false;
    }

    public Voter(String name, int age) {
        this.name = name;
        this.age = age;
        this.hasVoted = false;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void addVote(Vote vote) {
        if (!votes.contains(vote)) {
            votes.add(vote);
            vote.setVoter(this);
        }
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hasVoted=" + hasVoted +
                '}';
    }
}
