package com.votingmachine.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "vote",
    uniqueConstraints = @UniqueConstraint(
        name = "uk_voter_candidate",
        columnNames = {"voter_id", "candidate_id"}
    )
)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voter_id", nullable = false)
    private Voter voter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @Column(name = "vote_time", nullable = false)
    private LocalDateTime voteTime;

    // Constructors
    public Vote() {
        this.voteTime = LocalDateTime.now();
    }

    public Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
        this.voteTime = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public LocalDateTime getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(LocalDateTime voteTime) {
        this.voteTime = voteTime;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", voterId=" + (voter != null ? voter.getId() : "null") +
                ", candidateId=" + (candidate != null ? candidate.getId() : "null") +
                ", voteTime=" + voteTime +
                '}';
    }
}
