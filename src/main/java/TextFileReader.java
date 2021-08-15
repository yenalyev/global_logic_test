import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextFileReader {
    private static Logger logger = Logger.getLogger(TextFileReader.class.getName());

    public static double countFromFile(String filePath) {
        logger.info("-------------------------------------------------");
        logger.info("Opening file " + filePath);
        double res = 0d;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                res = res + convertStringIntoDouble(line);
            }
        } catch (IOException e) {
            logger.log(Level.WARNING,"Error was happened while opening file " + filePath);
            logger.log(Level.WARNING, e.getMessage());
        }
        return res;
    }

    public static double convertStringIntoDouble(String s){
        double res = 0d;
        if (s==null || s.equals("")){
            return res;
        } else {
            if (!s.startsWith("#")){
                try {
                    return Double.parseDouble(s);
                } catch (NumberFormatException e){
                    logger.log(Level.WARNING,"Line - " + s + " is not number. This line will be ignored");
                }
            } else {
                logger.log(Level.WARNING,"Line - " + s + " starts with #. This line will be ignored");
            }
        }
        return res;
    }
}