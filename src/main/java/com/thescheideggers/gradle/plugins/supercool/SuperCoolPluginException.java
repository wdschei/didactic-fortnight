package com.thescheideggers.gradle.plugins.supercool;

public class SuperCoolPluginException extends RuntimeException {
    public SuperCoolPluginException(String message) {
        super(message);
    }

    public SuperCoolPluginException(String message, Throwable cause) {
        super(message, cause);
    }
}
