package com.lindeng.controller.security;

import com.lindeng.common.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "/login")
    public String loginGet(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model, HttpServletRequest request) {
//        if (RequestMethod.GET.name().equalsIgnoreCase(request.getMethod())) {
//            return "login";
//        }
//        return "redirect:/welcome";
////        logger.info("login method:{}", request.getMethod());
        if (!StringUtil.isBlank(error)) {
            logger.error("there is an error in login:{}", error);
            model.addAttribute("param.error", "login failed.");
        }
        if (!StringUtil.isBlank(logout)) {
            logger.info("logout");
            model.addAttribute("param.logout", "logout success.");
        }
        logger.info("return to login page.");
        return "login";
    }

    @PostMapping("/ablogin")
    public String loginPost(Model model, HttpServletRequest request){
        logger.info("login username is:{}, and password is:{}", request.getAttribute("username"), request.getAttribute("password"));
        return "redirect:welcome";

    }

    @GetMapping("/welcome")
    public String login(Model model) {
        model.addAttribute("loginUser", "tom");
        model.addAttribute("login", true);
        return "welcome";
    }
}
