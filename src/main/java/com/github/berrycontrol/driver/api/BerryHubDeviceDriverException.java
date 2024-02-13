package com.github.berrycontrol.driver.api;

public class BerryHubDeviceDriverException extends Exception {
    public BerryHubDeviceDriverException() {
        super();
    }

    public BerryHubDeviceDriverException(String message) {
        super(message);
    }

    public BerryHubDeviceDriverException(String message, Throwable cause) {
        super(message, cause);
    }
}
