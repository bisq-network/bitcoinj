/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.core.listeners;

import org.bitcoinj.core.Peer;
import org.bitcoinj.core.VersionMessage;

/**
 * <p>Implementors can listen to events indicating a peer's VersionMessage receival during handshake.</p>
 */
public interface VersionMessageReceivedEventListener {

    /**
     * Called when a peer's VersionMessage is received during handshake.
     *
     * @param peer
     * @param peerCount the total number of connected peers
     */
    void onVersionMessageReceived(Peer peer, VersionMessage versionMessage);
}
