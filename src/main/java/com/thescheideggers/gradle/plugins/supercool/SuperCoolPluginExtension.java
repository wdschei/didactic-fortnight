package com.thescheideggers.gradle.plugins.supercool;

import org.gradle.api.Project;
import org.gradle.internal.impldep.org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class SuperCoolPluginExtension {

    /**
     * The directory that will be used for UP-TO-DATE checks.
     * If the start file is not absolute, then it is assumed to be relative to here.
     */
    public File inputDir;

    /**
     * This is the file where results are logged.
     */
    public File logFile;

    /**
     * This class should not be instantiated without any arguments.
     */
    private SuperCoolPluginExtension() {
    }

    /**
     * Constructor that sets required defaults based on the project.
     */
    public SuperCoolPluginExtension(@NotNull Project project) {
        logFile = new File(project.getBuildDir(), "reports/supercool.txt");
    }
}
