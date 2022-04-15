package com.example.challenge.controller;

import com.example.challenge.dto.UserChallengeDto;
import com.example.challenge.model.UserChallenge;
import com.example.challenge.service.BadgeClient;
import com.example.challenge.service.UserChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserChallengeController {

    private final UserChallengeService userChallengeService;
    private final BadgeClient badgeClient;

    @PostMapping("/mychallenge")
    public void add(@RequestBody UserChallengeDto challengeListDto){userChallengeService.addChallengeList(challengeListDto);}

    @PutMapping("/mychallenge/{id}")
    public void edit(@PathVariable Long id, @RequestBody UserChallengeDto challengeListDto){
        userChallengeService.editChallengeList(id, challengeListDto);
    }

    @GetMapping("/mychallenge")
    public List<UserChallenge> getAll(){return userChallengeService.getAllChallengeList();}

    @GetMapping("/mychallenge/{id}")
    public Optional<UserChallenge> getChallengeById(@PathVariable Long id){return userChallengeService.getChallengeListById(id);}

    @DeleteMapping("/mychallenge/{id}")
    public void del(@PathVariable("id")Long id) {
        userChallengeService.delChallengeList(id);
    }

    @GetMapping("/mychallenge/badge/{id}")
    public Badge findBadgeById(@PathVariable Long id) {
        return badgeClient.getBadgeById(id);
    }

    @GetMapping("/mychallenge/badge/find")
    public Badge findByBadgeName(@RequestParam(name = "badgeName", required = false) String badgeName) {
        return badgeClient.findByBadgeName(badgeName);
    }

    @GetMapping("/mychallenge/all/{challengeId}")
    public Long countByChallengeId(@PathVariable Long challengeId) {
        return userChallengeService.countByChallengeId(challengeId);
    }
}

