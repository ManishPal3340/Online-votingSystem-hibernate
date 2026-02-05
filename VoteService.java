package com.votingmachine.service;

import com.votingmachine.dao.CandidateDao;
import com.votingmachine.dao.VoterDao;
import com.votingmachine.dao.VoteDao;
import com.votingmachine.model.Candidate;
import com.votingmachine.model.Voter;
import com.votingmachine.model.Vote;

import java.time.LocalDateTime;

public class VoteService {

    private VoteDao voteDao = new VoteDao();
    private CandidateDao candidateDao = new CandidateDao();
    private VoterDao voterDao = new VoterDao();

    /**
     * Cast a vote from a voter to a candidate
     *
     * @param voter     Voter object
     * @param candidate Candidate object
     */
    public void castVote(Voter voter, Candidate candidate) {
        if (voter.isHasVoted()) {
            System.out.println("❌ This voter has already voted!");
            return;
        }

        // 1️⃣ Create Vote object
        Vote vote = new Vote();
        vote.setVoter(voter);
        vote.setCandidate(candidate);
        vote.setVoteTime(LocalDateTime.now()); // Optional timestamp

        // 2️⃣ Save Vote in DB
        voteDao.saveVote(vote);

        // 3️⃣ Increment Candidate vote count and update in DB
        candidate.setVoteCount(candidate.getVoteCount() + 1);
        candidateDao.updateCandidate(candidate);

        // 4️⃣ Mark Voter as hasVoted and update in DB
        voter.setHasVoted(true);
        voterDao.updateVoter(voter);
    }

    /**
     * Get a vote by its ID
     *
     * @param id Vote ID
     * @return Vote object or null if not found
     */
    public Vote getVoteById(Long id) {
        return voteDao.getVoteById(id);
    }
}
