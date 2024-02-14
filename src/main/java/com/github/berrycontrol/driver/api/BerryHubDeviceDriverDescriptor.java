package com.github.berrycontrol.driver.api;

import org.pf4j.Plugin;

import java.util.List;
import java.util.UUID;

public abstract class BerryHubDeviceDriverDescriptor<
        DeviceDriver extends BerryHubDeviceDriver<DeviceCommand>,
        DeviceInfo extends BerryHubDeviceInfo,
        DeviceCommand extends BerryHubDeviceCommand
    > extends Plugin {

    /**
     * Authentication method when pairing with the device.
     */
    public enum AuthenticationMethod {
        /** No authentication required */
        NONE,
        /** Authenticate using a PIN */
        PIN,
        /** Authenticate using a password */
        PASSWORD,
        /** Authenticate using a username and password */
        USER_AND_PASSWORD
    }

    private final UUID pluginId;
    private final String displayName;
    private final String description;

    /**
     * Constructor.
     *
     * @param pluginId      the plugin ID; this ID must be constant.
     * @param displayName   the display name
     * @param description   the description
     */
    public BerryHubDeviceDriverDescriptor(UUID pluginId, String displayName, String description) {
        this.pluginId = pluginId;
        this.displayName = displayName;
        this.description = description;
    }

    /**
     * @return the plugin ID
     */
    public UUID getPluginId() {
        return pluginId;
    }

    /**
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * All devices that are supported or are available.
     *
     * @return the devices
     */
    public abstract List<DeviceInfo> getDevices() throws BerryHubDeviceDriverException;

    /**
     * @return the authentication method
     */
    public abstract AuthenticationMethod authenticationMethod();

    /**
     * @return true if authentication is required, otherwise false
     */
    public boolean requiresAuthentication() {
        return !this.authenticationMethod().equals(AuthenticationMethod.NONE);
    }

    /**
     * @return true if pairing is required, otherwise false
     */
    public abstract boolean requiresPairing();

    /**
     * Start pairing with the given device.
     *
     * @param deviceInfo the device info of the device to pair with
     * @param remoteName the name of the remote
     * @return pairing request ID
     */
    public abstract String startPairing(DeviceInfo deviceInfo, String remoteName) throws BerryHubDeviceDriverException;

    /**
     * Finalize the pairing process.
     *
     * @param pairingRequest the pairing request id
     * @param pin            the pin for pairing with the device
     */
    public abstract boolean finalizePairing(String pairingRequest, String pin) throws BerryHubDeviceDriverException;

    /**
     * Create a device driver instance for the device with the given ID.
     *
     * @param deviceId the device id for the device instance to be created
     * @return the instance of the device
     */
    public abstract DeviceDriver createDriverInstance(String deviceId);
}
