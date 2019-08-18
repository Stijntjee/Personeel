package be.vdab.personeel.controllers;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.services.JobtitelService;
import be.vdab.personeel.services.WerknemerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/jobtitels")
public class JobtitelsController
{
    private final JobtitelService jobtitelService;
    private final WerknemerService werknemerService;

    //CONSTRUCTORS
    public JobtitelsController(JobtitelService jobtitelService, WerknemerService werknemerService) {
        this.jobtitelService = jobtitelService;
        this.werknemerService = werknemerService;
    }

    //MAPPINGS
    @GetMapping
    public ModelAndView jobtitel()
    {
        ModelAndView modelAndView = new ModelAndView("jobtitels");
        modelAndView.addObject("jobtitels", jobtitelService.findAll());
        return modelAndView;
    }

    @GetMapping("{jobtitel}")
    public ModelAndView specificJobtitel(@PathVariable Optional<Jobtitel> jobtitel)
    {
        ModelAndView modelAndView = new ModelAndView("jobtitels");
        modelAndView.addObject("jobtitels",jobtitelService.findAll());

        jobtitel.ifPresent(jobtite1 ->  modelAndView.addObject("jobtitel", jobtite1));
        jobtitel.ifPresent(jobtite1 ->  modelAndView.addObject("werknemers",  modelAndView.addObject("werknemers", werknemerService.findByJobtitel(jobtite1))));

        return modelAndView;
    }
}
