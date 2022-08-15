package ru.medcity.medicalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.medcity.medicalsystem.model.Proposal;
import ru.medcity.medicalsystem.service.ProposalService;

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    ProposalService proposalService;

    @GetMapping("appointment")
    public String appointment(Model model) {
        model.addAttribute("proposal", new Proposal());
        return "appointment";
    }

    @PostMapping("appointment")
    public String postAppointment(final Proposal appointmentData, final Model model) {
        proposalService.addProposal(appointmentData);
        return "appointment";
    }

    @GetMapping("appointment/proposals")
    public @ResponseBody List<Proposal> proposals(Model model) {
        return proposalService.getProposals();
    }
}