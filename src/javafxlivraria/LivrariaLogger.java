/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlivraria;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Classe de logging para mensagens de erro. Exemplo retirado de
 * http://blueskyworkshop.com/topics/Java-Pages/java-logger/
 *
 * @author CASN
 */
public class LivrariaLogger {

    private final static String loggerName = "LivrariaLogger";
    private final static Logger log = Logger.getLogger(loggerName);
    private static FileHandler fileHandler;

    /**
     *
     * @param xmlFormat
     * @return
     */
    public static Logger getInstance(boolean xmlFormat) {
        addFileHandler(log, xmlFormat);
        return log;
    }

    private static void addFileHandler(Logger log, boolean xmlFormat) {
        try {
            fileHandler = new FileHandler(loggerName + ".log");
        } catch (IOException ex) {
            log.severe(ex.getMessage());
        } catch (SecurityException ex) {
            log.severe(ex.getMessage());
        }
        if (!xmlFormat) {
            fileHandler.setFormatter(new SimpleFormatter());
        }
        log.addHandler(fileHandler);
    }
}
