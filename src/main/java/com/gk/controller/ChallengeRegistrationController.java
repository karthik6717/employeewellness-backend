package com.gk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gk.dto.ChallengeRegistrationDto;
import com.gk.service.ChallengeRegistrationServiceImpl;

@RestController
@RequestMapping("/api/employeewellness")
@CrossOrigin("*")
public class ChallengeRegistrationController {

    @Autowired
    private ChallengeRegistrationServiceImpl challengeRegService;

    // Register an employee for a challenge
    
    @PostMapping("/challengeregister/{employeeId}/{challengeId}")
    public ResponseEntity<String> registerForChallenge(
            @PathVariable Long employeeId,
            @PathVariable Long challengeId) {
        boolean success = challengeRegService.registerForChallenge(employeeId, challengeId);

        if (success) {
            return ResponseEntity.ok("Employee successfully registered for the challenge.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Registration failed. Employee may already be registered or an error occurred.");
        }
    }

    // Retrieve all registered challenges for an employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<ChallengeRegistrationDto>> getRegisteredChallenges(@PathVariable Long employeeId) {
        List<ChallengeRegistrationDto> registeredChallenges = challengeRegService.getRegisteredChallengesByEmployeeId(employeeId);
        return ResponseEntity.ok(registeredChallenges);
    }

    // Mark a challenge as complete for an employee
    @PostMapping("/set-status-complete/{employeeId}/{challengeId}/{challengeStatus}")
    public ResponseEntity<String> setStatusComplete(
            @PathVariable Long employeeId,
            @PathVariable Long challengeId,
            @PathVariable String challengeStatus) {
        challengeRegService.completeChallenges(employeeId, challengeId, challengeStatus);
        return ResponseEntity.ok("Challenge status updated successfully.");
    }

    // Complete challenges and add reward points
    @PostMapping("/complete/{employeeId}/{challengeId}/{challengeStatus}")
    public ResponseEntity<?> completeChallenges(
            @PathVariable Long employeeId,
            @PathVariable Long challengeId,
            @PathVariable String challengeStatus) {
        try {
            challengeRegService.completeChallenges(employeeId, challengeId, challengeStatus);
            List<ChallengeRegistrationDto> registeredChallenges = challengeRegService.getRegisteredChallengesStatus(employeeId);

            return ResponseEntity.ok()
                    .body(new ResponseWrapper(
                            "Reward points added for completed challenges successfully!",
                            registeredChallenges));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }

    // Utility Classes for Response Wrapping
    static class ResponseWrapper {
        private String message;
        private List<ChallengeRegistrationDto> challenges;

        public ResponseWrapper(String message, List<ChallengeRegistrationDto> challenges) {
            this.message = message;
            this.challenges = challenges;
        }

        public String getMessage() {
            return message;
        }

        public List<ChallengeRegistrationDto> getChallenges() {
            return challenges;
        }
    }

    static class ErrorResponse {
        private String error;

        public ErrorResponse(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }
}
