package com.exercise.MiniPortal.controller;

import org.springframework.web.bind.annotation.*;

import com.exercise.MiniPortal.util.MenuUtil;

@RestController
@RequestMapping("/portal")
public class PortalController {

    @GetMapping
    @ResponseBody
    public String home() {
        return MenuUtil.menu().concat("<h1>Mini Portal</h1><p>Bienvenido. Usa el menú para navegar.</p>");
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return MenuUtil.menu().concat("""
            <h2>Acerca del Mini Portal</h2>
            <p>Aplicación web sencilla con registro, panel personalizado y generador de contraseñas.</p>
            <ul>
                <li>Spring Boot</li>
                <li>MVC</li>
                <li>Java</li>
            </ul>
        """);
    }
}