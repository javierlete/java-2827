package com.ipartek.formacion.springapp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
public class ForwardController {
    @RequestMapping(value = "/{path:[^.]*}/**")
    public String forward(@PathVariable String path) {
        log.info("Forwarding request for path: " + path);
        return "forward:/index.html";
    }
}
