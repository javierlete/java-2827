package com.ipartek.formacion.servidor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UiApplication {
    @RequestMapping("/resource")
    public Map<String, Object> home() {
        var model = new HashMap<String, Object>();
        
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        
        return model;
    }
}
