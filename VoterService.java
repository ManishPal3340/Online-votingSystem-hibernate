package com.votingmachine.service;

import com.votingmachine.dao.VoterDao;
import com.votingmachine.model.Voter;

public class VoterService {

    private VoterDao voterDao = new VoterDao();

    public void registerVoter(Voter voter) {
        voterDao.saveVoter(voter);
    }

    public void updateVoter(Voter voter) {
        voterDao.updateVoter(voter);
    }

    public Voter getVoterById(Long id) {
        return voterDao.getVoterById(id);
    }

    public void deleteVoter(Long id) {
        voterDao.deleteVoter(id);
    }
}
