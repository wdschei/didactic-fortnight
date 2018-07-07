package com.thescheideggers.gradle.plugins.supercool;

import org.gradle.api.DefaultTask;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import org.gradle.api.tasks.TaskAction;

import static org.gradle.api.logging.LogLevel.WARN;

/**
 * Defines the Super Cool Plugin.
 */
public class SuperCoolPluginTask extends DefaultTask {

    static final Logger log = Logging.getLogger(SuperCoolPluginTask.class);

    /**
     * Executes this task.
     */
    @TaskAction
    void superCoolTask() {
        boolean rtn = SuperCool.doIt();
        log.log(WARN, "Finished the Super Cool Do It task with: {}", rtn);
    }
}
