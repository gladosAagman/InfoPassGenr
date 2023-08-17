package com.infopass.genr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infopass.genr.model.Participant;
import com.infopass.genr.repository.ParticipantRepository;

@Controller
public class RegistrationController {

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping("/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("participant", new Participant());
        return "index.html";
    }

    @PostMapping("/register")
    public String registerParticipant(@ModelAttribute Participant participant, RedirectAttributes redirectAttributes) {
        // Generate the password using provided information
        participant.generatePassword();

        // Save participant to the database
        participantRepository.save(participant);

        // Redirect to the welcome screen with participant ID as a parameter
        redirectAttributes.addAttribute("participantId", participant.getId());
        return "welcome";//redirect:/
    }

    @GetMapping("/welcome")
    public String showWelcomeScreen(@RequestParam Long participantId, Model model) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid participant ID"));

        model.addAttribute("participant", participant);
        return "welcome";
    }
}

