package se.krho.generalpersonallife.webbackend.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeWebController {

    Logger log = LoggerFactory.getLogger(HomeWebController.class);

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/")
    public RedirectView index(RedirectAttributes attributes) {
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.getModel().put("message", "FooBar!");
        return mv;
    }



}
