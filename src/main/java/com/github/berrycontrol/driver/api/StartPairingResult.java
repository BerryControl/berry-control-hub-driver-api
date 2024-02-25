package com.github.berrycontrol.driver.api;

public class StartPairingResult {
    private final String pairingRequestId;
    private final boolean deviceProvidesPin;

    private StartPairingResult(String pairingRequestId, boolean deviceProvidesPin) {
        this.pairingRequestId = pairingRequestId;
        this.deviceProvidesPin = deviceProvidesPin;
    }

    public static StartPairingResult create(String pairingRequestId, boolean deviceProvidesPin) {
        return new StartPairingResult(pairingRequestId, deviceProvidesPin);
    }

    public String getPairingRequestId() {
        return pairingRequestId;
    }

    public boolean deviceProvidesPin() {
        return deviceProvidesPin;
    }
}
