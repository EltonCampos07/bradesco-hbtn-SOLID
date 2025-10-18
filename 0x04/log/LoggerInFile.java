import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerInFile {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggerInFile.class.getName());
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("logs.txt", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);

            logger.info("teste de Log");
            logger.info("Olá, eu sou o teste da classe principal");
        } catch (IOException e) {
            System.err.println("Erro ao criar FileHandler: " + e.getMessage());
        } finally {
            if (fileHandler != null) {
                fileHandler.close();
            }
        }
    }
}
