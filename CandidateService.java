package com.votingmachine.service;

import com.votingmachine.dao.CandidateDao;
import com.votingmachine.model.Candidate;

public class CandidateService {

    private CandidateDao candidateDao = new CandidateDao();

    public void addCandidate(Candidate candidate) {
        candidateDao.saveCandidate(candidate);
    }

    public Candidate getCandidateById(Long id) {
        return candidateDao.getCandidateById(id);
    }

    public void deleteCandidate(Long id) {
        candidateDao.deleteCandidate(id);
    }
}
