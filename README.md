# Online-votingSystem-hibernate
# Online Voting System

A **Java-based Online Voting System** using **Hibernate ORM** and **MySQL** that allows voters to register, candidates to be added, votes to be cast, and election data to be managed securely.  

This project demonstrates:

- Java programming with **OOP concepts**  
- **Database integration using Hibernate ORM**  
- CRUD operations for voters, candidates, and votes  
- Console-based interactive menu system  

---

## **Features**

- ✅ Register Voters  
- ✅ Add Candidates  
- ✅ Cast Votes  
- ✅ Update Voter Information  
- ✅ Delete Candidates  
- ✅ View Votes by Voter ID  
- ✅ Exit the System safely  

---

## **Technologies Used**

- **Programming Language:** Java  
- **ORM Framework:** Hibernate  
- **Database:** MySQL  
- **Build Tool:** Maven  
- **IDE:** Eclipse / IntelliJ IDEA / NetBeans  
- **Libraries/Dependencies:** Hibernate Core, MySQL Connector/J  

---

## **Database Setup**

1. Create a MySQL database:
```sql
CREATE DATABASE online_voting_db;

OnlineVotingSystem/
│
├── src/main/java/
│   └── com/voting/
│       ├── entity/             # Hibernate entity classes
│       │   ├── Voter.java       # Voter entity
│       │   ├── Candidate.java   # Candidate entity
│       │   └── Vote.java        # Vote entity
│       │
│       ├── dao/                # Data Access Objects for database operations
│       │   ├── VoterDAO.java
│       │   ├── CandidateDAO.java
│       │   └── VoteDAO.java
│       │
│       ├── service/            # Business logic
│       │   ├── VoterService.java
│       │   ├── CandidateService.java
│       │   └── VoteService.java
│       │
│       ├── util/               # Utility classes
│       │   └── HibernateUtil.java  # Hibernate session factory
│       │
│       └── VotingMachine.java  # Main application with menu system
│
├── src/main/resources/
│   └── hibernate.cfg.xml       # Hibernate configuration file
│
├── pom.xml                     # Maven dependencies and build file
├── README.md                   # Project documentation
└── LICENSE                     # License file (MIT recommended)
