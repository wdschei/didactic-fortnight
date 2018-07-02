package com.thescheideggers.gradle.plugins.supercool;

public class SuperCool {
    private SuperCool() {
        // This class should not be instantiated.
    }

    /**
     * Does that Super Cool thing.
     */
    public static boolean doIt() {
        return true;
    }

    /**
     * Public CLI entry point.
     */
    public static void main(String[] args) {
        boolean rtn = SuperCool.doIt();
        System.out.println(String.format("The SuperCool classes doIt() method returned: %b", rtn));
    }
}
