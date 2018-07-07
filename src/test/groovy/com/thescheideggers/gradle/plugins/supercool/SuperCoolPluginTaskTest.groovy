package com.thescheideggers.gradle.plugins.supercool

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class SuperCoolPluginTaskTest {
    @Test
    public void should_be_able_to_add_task_to_project() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('supercool', type: SuperCoolPluginTask)
        assertTrue(task instanceof SuperCoolPluginTask)
    }
}
