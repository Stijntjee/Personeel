package be.vdab.personeel.controllers;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.services.WerknemerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/werknemer")
public class WerknemerController
{
    private final WerknemerService werknemerService;

    //CONSTRUCTORS
    public WerknemerController(WerknemerService werknemerService)
    {
        this.werknemerService = werknemerService;
    }

    //MAPPINGS
    @GetMapping
    public ModelAndView bigBoss()
    {
        ModelAndView modelAndView = new ModelAndView("werknemer");
        werknemerService.findBigBoss().ifPresent
                (werknemer ->  modelAndView.addObject("werknemer", werknemer));
        return modelAndView;
    }

    /*@GetMapping("{id}")
    public ModelAndView werknemer(@PathVariable long id)
    {
        ModelAndView modelAndView = new ModelAndView("werknemer");

        modelAndView.addObject("werknemer", id);
        return modelAndView;
    }*/
}
