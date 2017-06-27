package com.example.demo.Controller;

import com.example.demo.Entity.Scorers;
import com.example.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Aharon on 21/06/2017.
 */
@RestController
@RequestMapping(value = "/")
public class Controller {
    Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Scorers> getTopScorers(){
        return service.getTopScorers();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addScorer(@RequestBody Scorers scorer){
        return service.addScorer(scorer);
    }
}
