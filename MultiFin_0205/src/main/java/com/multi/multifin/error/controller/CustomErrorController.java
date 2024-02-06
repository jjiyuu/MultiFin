package com.multi.multifin.error.controller;

import java.util.Optional;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

	@GetMapping
    public String handleError(HttpServletRequest request) {
        Optional<Object> maybeStatus =
                Optional.ofNullable(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        if(maybeStatus.isPresent()) {
            Integer statusCode = Integer.valueOf(maybeStatus.get().toString());
            System.out.println("statusCode : "+statusCode);
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/404";
            } else if(statusCode == 500) {
            	return "error/500";
            } else {
            	return "error/error";
			}
        }
        return "/error";
    }
    
//    @Override
//    public String getErrorPath() {
//        return "/errors";
//    }
}