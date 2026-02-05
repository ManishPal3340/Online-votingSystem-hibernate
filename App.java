package com.votingmachine;

import com.votingmachine.model.*;
import com.votingmachine.service.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VoterService voterService = new VoterService();
        CandidateService candidateService = new CandidateService();
        VoteService voteService = new VoteService();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== VOTING MACHINE MENU =====");
            System.out.println("1. Register Voter");
            System.out.println("2. Add Candidate");
            System.out.println("3. Cast Vote");
            System.out.println("4. Update Voter");
            System.out.println("5. Delete Candidate");
            System.out.println("6. View Vote by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = getIntInput(sc);

            switch (choice) {
                case 1:
                    // Register Voter
                    System.out.print("Voter Name: ");
                    String voterName = sc.nextLine();
                    System.out.print("Voter Age: ");
                    int age = getIntInput(sc);

                    Voter voter = new Voter(voterName, age);
                    voterService.registerVoter(voter);
                    System.out.println("✅ Voter registered (ID: " + voter.getId() + ")");
                    break;

                case 2:
                    // Add Candidate
                    System.out.print("Candidate Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Party Name: ");
                    String party = sc.nextLine();

                    Candidate candidate = new Candidate(cname, party);
                    candidateService.addCandidate(candidate);
                    System.out.println("✅ Candidate added (ID: " + candidate.getId() + ")");
                    break;

                case 3:
                    // Cast Vote
                    System.out.print("Enter Voter ID: ");
                    long voterId = getLongInput(sc);
                    System.out.print("Enter Candidate ID: ");
                    long candidateId = getLongInput(sc);

                    voter = voterService.getVoterById(voterId);
                    candidate = candidateService.getCandidateById(candidateId);

                    if (voter == null || candidate == null) {
                        System.out.println("❌ Invalid voter or candidate");
                        break;
                    }

                    if (voter.isHasVoted()) {
                        System.out.println("❌ This voter has already casted vote");
                        break;
                    }

                    voteService.castVote(voter, candidate);
                    System.out.println("✅ Vote cast successfully");
                    System.out.println("Candidate " + candidate.getName() + " now has " + candidate.getVoteCount() + " votes.");
                    break;

                case 4:
                    // Update Voter
                    System.out.print("Enter Voter ID to update: ");
                    voterId = getLongInput(sc);
                    voter = voterService.getVoterById(voterId);

                    if (voter == null) {
                        System.out.println("❌ Voter not found");
                        break;
                    }

                    System.out.print("Enter new name (" + voter.getName() + "): ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new age (" + voter.getAge() + "): ");
                    int newAge = getIntInput(sc);

                    voter.setName(newName.isEmpty() ? voter.getName() : newName);
                    voter.setAge(newAge);
                    voterService.updateVoter(voter);
                    System.out.println("✅ Voter updated");
                    break;

                case 5:
                    // Delete Candidate
                    System.out.print("Enter Candidate ID to delete: ");
                    candidateId = getLongInput(sc);
                    candidate = candidateService.getCandidateById(candidateId);

                    if (candidate == null) {
                        System.out.println("❌ Candidate not found");
                        break;
                    }

                    candidateService.deleteCandidate(candidateId);
                    System.out.println("✅ Candidate deleted");
                    break;

                case 6:
                    // View Vote by ID
                    System.out.print("Enter Vote ID: ");
                    long voteId = getLongInput(sc);
                    Vote vote = voteService.getVoteById(voteId);

                    if (vote == null) {
                        System.out.println("❌ Vote not found");
                    } else {
                        System.out.println("Vote ID: " + vote.getId() +
                                ", Voter: " + vote.getVoter().getName() +
                                ", Candidate: " + vote.getCandidate().getName() +
                                ", Time: " + vote.getVoteTime());
                    }
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting Voting Machine. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }

        sc.close();
        // Optional: Close Hibernate sessionFactory
        // HibernateUtil.shutdown();
    }

    // Safe integer input
    private static int getIntInput(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static long getLongInput(Scanner sc) {
        while (true) {
            try {
                return Long.parseLong(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
