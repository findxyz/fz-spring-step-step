package com.springmvc.web;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by fz on 2015/7/19.
 */
@Controller
@RequestMapping("/html")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ThymeleafController {

    private static final Logger logger = Logger.getLogger(ThymeleafController.class);

    @RequestMapping(value="/{leafId}", method= RequestMethod.GET)
    public String first(@PathVariable String leafId, Model model){
        logger.info(leafId);
        model.addAttribute("leafId", leafId);
        return "thymeleaf/first";
    }

    @RequestMapping(value="/first", method= RequestMethod.GET)
    public String first(){
        return "thymeleaf/first";
    }

    @RequestMapping(value="/redirect")
    public String second(){
        return "redirect:/html/2333";
    }
}
