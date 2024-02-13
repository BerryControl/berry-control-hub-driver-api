/*
 *    Copyright 2024 Thomas Bonk <thomas@meandmymac.de>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.github.berrycontrol.driver.api;

public abstract class BerryHubDeviceCommand {
    private final int id;
    private final String title;
    private byte[] icon;

    /**
     * Creates a command with an ID and a title.
     *
     * @param id    the command ID
     * @param title the command title
     */
    public BerryHubDeviceCommand(int id, String title) {
        this.id = id;
        this.title = title;
        this.icon = null;
    }

    /**
     * @return the command ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return the title of the command
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the icon of the command
     */
    public byte[] getIcon() {
        return icon;
    }
}
