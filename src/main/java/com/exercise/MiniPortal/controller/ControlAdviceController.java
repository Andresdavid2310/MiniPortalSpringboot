package com.exercise.MiniPortal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ControlAdviceController {
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoHandlerFoundException(NoHandlerFoundException ex) {
        return "<html>" +
                "<body>" +
                "<h2>Custom 404 Error Page</h2>" +
                "<p>The page you are looking for does not exist.</p>" +
                "<a href='/portal'>Go to Home</a>" +
                "</body>" +
                "</html>";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneralException(Exception ex) {
        return "<html>" +
                "<body>" +
                "<h2>Custom 500 Error Page</h2>" +
                "<p>Something went wrong on the server.</p>" +
                "<p>Error Details: " + escapeHtmtl(ex.getMessage()) + "</p>" +
                "<a href='/hello'>Go to Home</a>" +
                "</body>" +
                "</html>";
    }

    private String escapeHtmtl(String message) {
        if (message == null) {
            return "";
        } else {
            return message.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;");
        }
    }

}
