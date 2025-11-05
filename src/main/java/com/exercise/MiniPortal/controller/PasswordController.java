package com.exercise.MiniPortal.controller;

import com.exercise.MiniPortal.util.MenuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/portal")
public class PasswordController {

    @GetMapping("/password-generator")
    @ResponseBody
    public String passwordGenerator() {
        return MenuUtil.menu().concat("""
            <h2>Generador de Contraseñas</h2>
            <form method='post' action='/portal/generate-password'>
                Longitud: <input name='length' type='number' value='12' min='4' max='50'><br>
                <label><input type='checkbox' name='includeUppercase' checked> Mayúsculas</label><br>
                <label><input type='checkbox' name='includeLowercase' checked> Minúsculas</label><br>
                <label><input type='checkbox' name='includeNumbers' checked> Números</label><br>
                <label><input type='checkbox' name='includeSymbols' checked> Símbolos</label><br>
                <button type='submit'>Generar</button>
            </form>
        """);
    }

    @PostMapping("/generate-password")
    @ResponseBody
    public String generatePassword(@RequestParam(defaultValue = "12") int length,
                                  @RequestParam(defaultValue = "true") boolean includeUppercase,
                                  @RequestParam(defaultValue = "true") boolean includeLowercase,
                                  @RequestParam(defaultValue = "true") boolean includeNumbers,
                                  @RequestParam(defaultValue = "true") boolean includeSymbols) {
        StringBuilder charset = new StringBuilder();
        if (includeLowercase) charset.append("abcdefghijklmnopqrstuvwxyz");
        if (includeUppercase) charset.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (includeNumbers) charset.append("0123456789");
        if (includeSymbols) charset.append("!@#$%^&*()_+-=[]{}|;:,.<>?");
        if (charset.length() == 0) charset.append("abcdefghijklmnopqrstuvwxyz");
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charset.length());
            password.append(charset.charAt(index));
        }
        return MenuUtil.menu().concat("""
            <h3>Contraseña generada:</h3>
            <p>%s</p>
            <a href='/portal'><button>Volver al inicio</button></a>
        """.formatted(password));
    }
}