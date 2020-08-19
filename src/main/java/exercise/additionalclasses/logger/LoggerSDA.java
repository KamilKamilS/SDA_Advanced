package exercise.additionalclasses;

import java.io.File;
import java.io.IOException;

public class LoggerSDA {
    private File loggingFile;

    private LoggerSDA() {
        loggingFile = new File("log.txt");
        try {
            if (!loggingFile.exists()) {
                loggingFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class LoggerSDAHolder {
        private static LoggerSDA loggerSDA = new LoggerSDA();
    }

    public static LoggerSDA getInstance() {
        return LoggerSDAHolder.loggerSDA;
    }

    public void log(Level level, String msg) {
        LocalTime logTime = LocalTime.now();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(loggingFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(logTime + ", " + level + ", " + msg);
        printWriter.flush();
        printWriter.close();
    }


}

