package com.exercise.MiniPortal.util;

public class MenuUtil {
    public static String menu() {
        return """
            <nav>
                <a href='/portal'>Inicio</a>
                <a href='/portal/form'>Registro</a>
                <a href='/portal/dashboard'>Panel</a>
                <a href='/portal/password-generator'>Generador Contraseñas</a>
                <a href='/portal/about'>Acerca de</a>
            </nav><hr>
        """;
    }
}
