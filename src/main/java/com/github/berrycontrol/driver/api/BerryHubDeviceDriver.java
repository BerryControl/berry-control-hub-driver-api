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

import java.util.List;
import java.util.Optional;

public interface BerryHubDeviceDriver<Command extends BerryHubDeviceCommand> {
    /**
     * @return list of supported commands
     */
    List<Command> getCommands();

    /**
     * Get command with the given ID.
     * @param id the command ID
     * @return the command with the given ID
     */
    default Optional<Command> getCommand(int id) {
        return getCommands().stream().filter(cmd -> cmd.getId() == id).findFirst();
    }

    /**
     * @return the height of the remote layout
     */
    int getRemoteLayoutHeight();

    /**
     * @return the width of the remote layout
     */
    int getRemoteLayoutWidth();

    /**
     * @return the remote layout; values are the commands IDs
     */
    int[][] getRemoteLayout();

    /**
     * Executes a command.
     *
     * @param command the command that shall be executed
     */
    void execute(Command command);

    /**
     * @return true if the device is ready, otherwise false
     */
    boolean isDeviceReady();
}
