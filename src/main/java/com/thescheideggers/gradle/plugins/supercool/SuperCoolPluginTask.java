package com.thescheideggers.gradle.plugins.supercool;

import org.gradle.api.DefaultTask;
import org.gradle.api.logging.LogLevel;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static org.gradle.api.logging.LogLevel.*;

/**
 * Defines the Super Cool Plugin.
 */
public class SuperCoolPluginTask extends DefaultTask {

    static final Logger log = Logging.getLogger(SuperCoolPluginTask.class);
    private SuperCoolPluginExtension superCoolPluginExtension;

    static void logMsg(LogLevel level, PrintWriter printWriter, String msg) {
        log.log(level, msg);
        if (printWriter != null && log.isEnabled(level)) {
            printWriter.println(msg);
        }
    }

    static void logMsg(LogLevel level, PrintWriter printWriter, String format, Object arg) {
        log.log(level, format, arg);
        if (printWriter != null && log.isEnabled(level)) {
            printWriter.printf(format.replace("{}", "%s"), arg);
            printWriter.println();
        }
    }

    static void logMsg(LogLevel level, PrintWriter printWriter, String format, Object arg1, Object arg2) {
        log.log(level, format, arg1, arg2);
        if (printWriter != null && log.isEnabled(level)) {
            printWriter.printf(format.replace("{}", "%s"), arg1, arg2);
            printWriter.println();
        }
    }

    public void setExtension(SuperCoolPluginExtension extension) {
        superCoolPluginExtension = extension;
    }

    @InputDirectory
    public File getInputDirectory() {
        return superCoolPluginExtension.inputDir;
    }

    @OutputFile
    public File getLogFile() {
        return superCoolPluginExtension.logFile;
    }

    /**
     * Executes this task.
     */
    @TaskAction
    void supercoolTask() throws SuperCoolPluginException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(superCoolPluginExtension.logFile))) {
            logMsg(WARN, printWriter, "This task is going to be Super Cool.");
            logMsg(WARN, printWriter, "Run with --info or --debug for more information.");
            logMsg(INFO, printWriter, "Maybe not so super cool.");
            logMsg(DEBUG, printWriter, "I wouldn't use cool at all.");

            logMsg(WARN, printWriter, "");
            boolean rtn = SuperCool.doIt();
            logMsg(WARN, printWriter, "Finished the Super Cool Do It task with: {}", rtn);
            if (!rtn) {
                String msg = "Failing build for SuperCool failure.";
                logMsg(WARN, printWriter, msg);
                throw new SuperCoolPluginException(msg);
            }
        } catch (IOException e) {
            log.info("Failed to write output!", e);
            throw new SuperCoolPluginException(
                    String.format(
                            "Failing build for bad log file: %s",
                            superCoolPluginExtension.logFile.getAbsolutePath()
                    ), e);
        }
    }
}
