package com.exercise.MiniPortal.util;

public class MenuUtil {
    public static String menu() {
        return """
            <nav style='display: flex; gap: 30px; background: #f0f0f0; padding: 10px; border-radius: 8px;'>
                <a href='/portal' style='text-decoration:none; color:#333; font-weight:bold;'>Inicio</a>
                <a href='/portal/form' style='text-decoration:none; color:#333; font-weight:bold;'>Registro</a>
                <a href='/portal/dashboard' style='text-decoration:none; color:#333; font-weight:bold;'>Panel</a>
                <a href='/portal/password-generator' style='text-decoration:none; color:#333; font-weight:bold;'>Generador Contraseñas</a>
                <a href='/portal/about' style='text-decoration:none; color:#333; font-weight:bold;'>Acerca de</a>
            </nav>
            <hr>
        """;
    }
}
