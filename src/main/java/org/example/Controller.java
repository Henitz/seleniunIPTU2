package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping
public class Controller {

    @GetMapping
    public String getContribuinte(@PathParam("contribuinte") String contribuinte){
        return "<div id='contribuinte'>" + contribuinte + "</div>";

    }
}
