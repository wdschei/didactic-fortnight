package com.thescheideggers.gradle.plugins.supercool;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.util.HashMap;
import java.util.Map;

import static org.gradle.api.Task.*;

/**
 * Defines the Super Cool Plugin.
 */
public class SuperCoolPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        SuperCoolPluginTask superCoolPluginTask = project.getTasks().create("supercool", SuperCoolPluginTask.class);
        superCoolPluginTask.setGroup("build");
        superCoolPluginTask.setDescription("This is SuperCool");

        // NOTE: This is the equivalent way with the alternative constructor.
        //Map<String, Object> options = new HashMap<>();
        //options.put(TASK_NAME, "supercool");                // The name of the task to create.
        //options.put(TASK_TYPE, SuperCoolPluginTask.class);  // The class of the task to create.
        ////options.put(TASK_ACTION, {});                       // The closure or Action to execute when the task executes.
        ////options.put(TASK_OVERWRITE, false);                 // Replace an existing task?
        ////options.put(TASK_DEPENDS_ON, "");                   // The dependencies of the task.
        //options.put(TASK_GROUP, "build");                   // The group of the task.
        //options.put(TASK_DESCRIPTION, "This is SuperCool"); // The description of the task.
        //SuperCoolPluginTask superCoolPluginTask = (SuperCoolPluginTask) project.getTasks().create(options);
    }
}
