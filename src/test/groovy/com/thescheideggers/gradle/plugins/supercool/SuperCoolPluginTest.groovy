package com.thescheideggers.gradle.plugins.supercool

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class SuperCoolPluginTest {
    @Test
    public void demo_plugin_should_add_task_to_project() {
        Project project = ProjectBuilder.builder().build()
        project.getPlugins().apply 'com.thescheideggers.gradle.plugins.supercool'
        assertTrue(project.tasks.supercool instanceof SuperCoolPluginTask)
    }
}
