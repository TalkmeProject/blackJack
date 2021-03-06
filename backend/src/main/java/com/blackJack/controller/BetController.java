package com.blackJack.controller;

import com.blackJack.dbo.Bet;
import com.blackJack.dto.PlaceDto;
import com.blackJack.service.BetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bet")
public class BetController {

    private final BetService betService;

    @GetMapping("/{betId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Bet getBetByID(@PathVariable final String betID){
        return betService.getBetByID(betID);
    }

    @PostMapping("/place")
    public ResponseEntity<Void> placeBet(final Principal principal, @RequestBody final PlaceDto placeDto) {
        return betService.placeBet(principal, placeDto);
    }
}
