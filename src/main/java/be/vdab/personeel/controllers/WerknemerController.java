package be.vdab.personeel.controllers;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.forms.OpslagForm;
import be.vdab.personeel.forms.RijksregisternrForm;
import be.vdab.personeel.services.WerknemerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/werknemer")
public class WerknemerController
{
    private final WerknemerService werknemerService;
    private static final String REDIRECT= "redirect:/werknemer/{id}";
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

    @GetMapping("{optionalWerknemer}")
    public ModelAndView werknemer(@PathVariable Optional<Werknemer> optionalWerknemer)
    {
        ModelAndView modelAndView = new ModelAndView("werknemer");
        optionalWerknemer.ifPresent
                (werknemer ->  modelAndView.addObject("werknemer", werknemer));
        return modelAndView;
    }

    @GetMapping("{optionalWerknemer}/opslag")
    public ModelAndView opslagWerknemer(@PathVariable Optional<Werknemer> optionalWerknemer, @Valid OpslagForm form, Errors errors)
    {

        ModelAndView modelAndView = new ModelAndView("opslag");
        modelAndView.addObject("opslag").addObject(new OpslagForm(null));
        optionalWerknemer.ifPresent
                (werknemer ->  modelAndView.addObject("werknemer", werknemer));
        return modelAndView;
    }

    @PostMapping("{id}/opslag")
    public String postOpslagWerknemer(@PathVariable Long id, RedirectAttributes redirectAttributes, @Valid OpslagForm form, Errors errors)
    {
        redirectAttributes.addAttribute("id", id);
        if (! errors.hasErrors()) {
            werknemerService.opslag(id, form.getOpslag());
            return "redirect:/werknemer/{id}";
        }
        return "redirect:/werknemer/{id}/opslag";
    }

    @GetMapping("{optionalWerknemer}/rijksregisternr")
    public ModelAndView rijksregisternrWerknemer(@PathVariable Optional<Werknemer> optionalWerknemer,@Valid RijksregisternrForm form, Errors errors)
    {

        ModelAndView modelAndView = new ModelAndView("rijksregisternr");
        if (! errors.hasErrors())
        {
            optionalWerknemer.ifPresent(werknemer -> modelAndView.addObject("rijksregisternr").addObject(new RijksregisternrForm(null, werknemer.getGeboorte())));
        }
        optionalWerknemer.ifPresent
                (werknemer ->  modelAndView.addObject("werknemer", werknemer));
        return modelAndView;
    }

    @PostMapping("{id}/rijksregisternr")
    public String postRijksregisternrWerknemer(@PathVariable Long id, RedirectAttributes redirectAttributes, @Valid RijksregisternrForm form)
    {
        redirectAttributes.addAttribute("id", id);
        werknemerService.wijzigRijksregisternr(id,form.getRijksregisternr());
        return "redirect:/werknemer/{id}";
    }
}
