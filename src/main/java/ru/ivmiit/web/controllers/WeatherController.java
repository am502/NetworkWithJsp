package ru.ivmiit.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.ivmiit.dto.WeatherDto;
import ru.ivmiit.service.WeatherService;
import ru.ivmiit.web.utils.exception.IncorrectDataException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public ModelAndView getWeather(@RequestParam(value = "city") String city,
                                   @RequestParam(value = "units") String units,
                                   HttpServletResponse response) {
        Cookie cookie = new Cookie("City-Units", city + "/" + units);
        response.addCookie(cookie);
        return new ModelAndView("redirect:/weather");
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public ModelAndView getWeather(@CookieValue(value = "City-Units", required = false) String cookie,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        List<WeatherDto> weatherDtoList = null;
        if (cookie != null) {
            String[] cityUnits = cookie.split("/");
            try {
                weatherDtoList = weatherService.getWeather(cityUnits[0], cityUnits[1]);
            } catch (IncorrectDataException e) {
                ModelAndView error = new ModelAndView();
                error.addObject("error", true);
                error.setViewName("weather");
                for (Cookie c : request.getCookies()) {
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
                return error;
            }
        }
        modelAndView.addObject("weatherDtoList", weatherDtoList);
        modelAndView.addObject("error", false);
        modelAndView.setViewName("weather");
        return modelAndView;
    }
}
