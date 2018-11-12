package ru.ivmiit.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.dto.WeatherDto;
import ru.ivmiit.service.WeatherService;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public ModelAndView getWeather(@RequestParam(value = "city") String city,
                                   @RequestParam(value = "units") String units,
                                   @RequestParam(value = "day") int day,
                                   RedirectAttributes redirect) {
        WeatherDto weatherDto = weatherService.getWeather(city, units, day);
        redirect.addFlashAttribute("weatherDto", weatherDto);
        return new ModelAndView("redirect:/show");
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public ModelAndView getWeather() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public ModelAndView showWeather(Model model) {
        return new ModelAndView("weather");
    }
}
