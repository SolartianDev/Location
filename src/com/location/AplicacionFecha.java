package com.location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class AplicacionFecha {
    PrintWriter pw = new PrintWriter(System.out, true); 
// Paso 1: Crear un objeto PrintWriter para imprimir en la consola
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Paso 2: Crear un objeto BufferedReader para leer la entrada del usuario

    Locale ruLocale = new Locale("ru", "RU");
    // Paso 3: Crear un objeto de Locale para el idioma ruso
    Locale esLocale = new Locale("es", "ES");
    // Paso 4: Crear un objeto de Locale para el idioma español

    Locale currentLocale = Locale.US;
    // Paso 5: Establecer el idioma predeterminado en inglés (Locale de EE. UU.)
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", esLocale); // Paso 6: Cargar los mensajes en español desde el archivo "MessagesBundle.properties"

    LocalDateTime today = LocalDateTime.now();
    // Paso 7: Obtener la fecha y hora actual en formato LocalDateTime
    DateTimeFormatter df;

    public static void main(String[] args) {
        AplicacionFecha aplicacionFecha = new AplicacionFecha();
        aplicacionFecha.ejecutar();
    }

    public void ejecutar() {
        String linea = "";

        while (!(linea.equals("q"))) {
            this.mostrarMenu();
            // Paso 8: Mostrar el menú de opciones disponibles
            try {
                linea = this.br.readLine();
                // Paso 9: Leer la elección del usuario desde la entrada estándar
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

            switch (linea) {
                case "1":
                    this.setIngles(); 
// Paso 10: Cambiar el idioma a inglés
                    break;
                case "2":
                    this.setEspanol(); 
// Paso 11: Cambiar el idioma a español
                    break;
                case "3":
                    this.setFrances(); 
// Paso 12: Cambiar el idioma a francés
                    break;
                case "4":
                    this.setChino(); 
// Paso 13: Cambiar el idioma a chino
                    break;
                case "5":
                    this.setRuso(); 
// Paso 14: Cambiar el idioma a ruso
                    break;
            }
        }
    }

    public void mostrarMenu() {
        pw.println("=== Aplicación de Fecha ===");

        // Fecha Completa
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(currentLocale);
        pw.println(messages.getString("date1") + " " + today.format(df)); 
// Paso 15: Imprimir la fecha completa en el formato correspondiente al idioma actual

        // Fecha Larga
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(currentLocale);
        pw.println(messages.getString("date2") + " " + today.format(df)); 
// Paso 16: Imprimir la fecha larga en el formato correspondiente al idioma actual

        // Fecha Corta
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(currentLocale);
        pw.println(messages.getString("date3") + " " + today.format(df)); 
// Paso 17: Imprimir la fecha corta en el formato correspondiente al idioma actual

        // Fecha/Hora Media
        df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(currentLocale);
        pw.println(messages.getString("date4") + " " + today.format(df));
        // Paso 18: Imprimir la fecha/hora media en el formato correspondiente al idioma actual

        // Hora Media
        df = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(currentLocale);
        pw.println(messages.getString("date5") + " " + today.format(df));
        // Paso 19: Imprimir la hora media en el formato correspondiente al idioma actual

        pw.println("\n--- Elija una opción de idioma ---");
        pw.println("1. " + messages.getString("menu1"));
        pw.println("2. " + messages.getString("menu2"));
        pw.println("3. " + messages.getString("menu3"));
        pw.println("4. " + messages.getString("menu4"));
        pw.println("5. " + messages.getString("menu5"));
        pw.println("q. " + messages.getString("menuq"));
        System.out.print(messages.getString("menucommand") + " ");
    }

    public void setIngles() {
        currentLocale = Locale.US;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale); 
// Paso 20: Cambiar al idioma inglés y cargar los mensajes en inglés
    }

    public void setFrances() {
        currentLocale = Locale.FRANCE;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        // Paso 21: Cambiar al idioma francés y cargar los mensajes en francés
    }

    public void setChino() {
        currentLocale = Locale.SIMPLIFIED_CHINESE;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        // Paso 22: Cambiar al idioma chino y cargar los mensajes en chino simplificado
    }

    public void setRuso() {
        currentLocale = ruLocale;
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale); 
// Paso 23: Cambiar al idioma ruso y cargar los mensajes en ruso
    }

    public void setEspanol() {
        currentLocale = esLocale;
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        // Paso 24: Cambiar al idioma español y cargar los mensajes en español
    
    }
}

