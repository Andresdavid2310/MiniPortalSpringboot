package com.exercise.MiniPortal.controller;

import com.exercise.MiniPortal.util.MenuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/portal")
public class FormController {

    @GetMapping("/form")
    @ResponseBody
    public String showForm() {
        return MenuUtil.menu().concat("""
            <h2>Registro</h2>
            <form method='post' action='/portal/welcome'>
                Nombre: <input name='nombre' required><br>
                Email: <input name='email' type='email' required><br>
                <button type='submit'>Registrarse</button>
            </form>
        """);
    }

    @PostMapping("/welcome")
    public String processForm(@RequestParam String nombre,
                              @RequestParam String email,
                              RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("nombre", nombre);
        redirectAttributes.addFlashAttribute("email", email);
        return "redirect:/portal/dashboard";
    }

    @GetMapping("/dashboard")
    @ResponseBody
    public String dashboard(@ModelAttribute("nombre") String nombre,
                            @ModelAttribute("email") String email) {
        LocalDateTime now = LocalDateTime.now();
        String currentTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int hour = now.getHour();
        String saludo = (hour >= 6 && hour < 12) ? "Buenos días" :
                        (hour >= 12 && hour < 20) ? "Buenas tardes" : "Buenas noches";
        return MenuUtil.menu().concat("""
            <h2>Panel</h2>
            <p>%s, %s!</p>
            <p>Email: %s</p>
            <p>Hora actual: %s</p>
        """.formatted(saludo, nombre != null && !nombre.isBlank() ? nombre : "Usuario", email != null && !email.isBlank() ? email : "No registrado", currentTime));
    }
}