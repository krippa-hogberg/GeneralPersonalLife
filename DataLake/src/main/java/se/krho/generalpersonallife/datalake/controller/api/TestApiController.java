package se.krho.generalpersonallife.datalake.controller.api;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.krho.generalpersonallife.datalake.model.dto.ApiTestGreeting;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ForbiddenException;

@RestController
public class TestApiController {

    @RequestMapping("/api/greeting")
    public ApiTestGreeting greeting() {
        
        String name = "Krippa";
        
        // Do the actual stuff
        return new ApiTestGreeting(1L, "Hi "+name+"!");
    }
}