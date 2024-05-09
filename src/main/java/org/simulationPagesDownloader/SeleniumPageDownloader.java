package org.simulationPagesDownloader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Selenium Page Downloader
 */

public class SeleniumPageDownloader {
    public static void main(String[] args) throws InterruptedException {
        // Imposta il percorso del ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe"); // Assicurati che il percorso sia corretto
        // Crea un'istanza del browser Chrome
        WebDriver driver = new ChromeDriver();

        // Start download delle pagine

        // REGISTRAZIONE
        try {
            // Vai alla pagina di registrazione
            driver.get("https://bandimprese.it/registrazione.php");

            // Ottieni il contenuto della pagina
            String pageSource = driver.getPageSource();

            // Salva il contenuto in un file HTML
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("registrazione.html"))) {
                writer.write(pageSource);
                System.out.println("Registrazione scaricata!");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            Thread.sleep(1000);
        }

        // LOGIN
        try {
            // Vai alla pagina di login
            driver.get("https://bandimprese.it/simulatore.php");

            // Ottieni il contenuto della pagina
            String pageSource = driver.getPageSource();

            // Salva il contenuto in un file HTML
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("login.html"))) {
                writer.write(pageSource);
                System.out.println("Login scaricata!");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            Thread.sleep(1000);
        }

        // HOMEPAGE
        try {
            // Vai alla pagina di login
            driver.get("https://bandimprese.it/simulatore.php");

            // Trova i campi di login e inserisci le credenziali
            WebElement usernameField = driver.findElement(By.name("nome")); // Modifica il nome dell'elemento
            WebElement passwordField = driver.findElement(By.name("password")); // Modifica il nome dell'elemento

            usernameField.sendKeys("fabio12"); // Inserisci il tuo nome utente
            passwordField.sendKeys("Test1234!"); // Inserisci la tua password

            // Esegui il login
            passwordField.sendKeys(Keys.RETURN);
            Thread.sleep(1000);

            // Vai alla pagina Homepage
            driver.get("https://bandimprese.it/simulatore.php");

            // Ottieni il contenuto della pagina
            String pageSource = driver.getPageSource();

            // Salva il contenuto in un file HTML
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("homepage.html"))) {
                writer.write(pageSource);
                System.out.println("Homepage scaricata!");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            Thread.sleep(1000);
        }

        // INIZIA SIMULAZIONE 21
        try {

            driver.findElement(new By.ByCssSelector("body > div:nth-child(2) > div > div:nth-child(1) > button")).click();
            Thread.sleep(1000);
            try {
                // Vai alla pagina desiderata
                driver.get("https://bandimprese.it/simulazione21.php"); // Modifica con l'URL giusto

                // Cicla 30 volte
                for (int i = 1; i <= 30; i++) {
                    // Ricarica la pagina
                    driver.navigate().refresh();

                    // Attendi un po' per assicurarti che la pagina sia completamente caricata
                    Thread.sleep(5000); // 5 secondi di attesa. Puoi regolare in base alla velocità del caricamento della pagina

                    // Ottieni il contenuto HTML della pagina
                    String pageSource = driver.getPageSource();

                    // Salva l'HTML in un file con nome incrementale
                    String filename = "simulazione21_" + i + ".html";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                        writer.write(pageSource);
                    }

                    System.out.println("Salvato: " + filename);
                }

            } catch (Exception e) {
                e.fillInStackTrace();
            } finally {
                Thread.sleep(1000);
            }

            try {
                // Vai alla pagina desiderata
                driver.get("https://bandimprese.it/simulazione22.php"); // Modifica con l'URL giusto

                // Cicla 30 volte
                for (int i = 1; i <= 30; i++) {
                    // Ricarica la pagina
                    driver.navigate().refresh();

                    // Attendi un po' per assicurarti che la pagina sia completamente caricata
                    Thread.sleep(5000); // 5 secondi di attesa. Puoi regolare in base alla velocità del caricamento della pagina

                    // Ottieni il contenuto HTML della pagina
                    String pageSource = driver.getPageSource();

                    // Salva l'HTML in un file con nome incrementale
                    String filename = "simulazione22_" + i + ".html";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                        writer.write(pageSource);
                    }
                    System.out.println("Salvato: " + filename);
                }

            } catch (Exception e) {
                e.fillInStackTrace();
            } finally {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            Thread.sleep(1000);
        }

        // TEMPI
        try {
            // Vai alla pagina Tempi
            driver.get("https://bandimprese.it/simulatoreTempi.php");

            // Ottieni il contenuto della pagina
            String pageSource = driver.getPageSource();

            // Salva il contenuto in un file HTML
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("tempi.html"))) {
                writer.write(pageSource);
                System.out.println("Tempi scaricata!");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            driver.quit();
        }
    }
}
