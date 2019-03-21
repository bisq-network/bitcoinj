/*
 * Copyright 2011 Google Inc.
 * Copyright 2014 Andreas Schildbach
 *
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

package org.bitcoinj.core;

import org.bitcoinj.params.MainNetParams;
import org.junit.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import static org.bitcoinj.core.Utils.HEX;
import static org.junit.Assert.assertEquals;

public class PeerAddressTest
{
    @Test
    public void testPeerAddressRoundtrip() throws Exception {
        // copied verbatim from https://en.bitcoin.it/wiki/Protocol_specification#Network_address
        String fromSpec = "010000000000000000000000000000000000ffff0a000001208d";
        PeerAddress pa = new PeerAddress(MainNetParams.get(),
                HEX.decode(fromSpec), 0, 0);
        String reserialized = Utils.HEX.encode(pa.unsafeBitcoinSerialize());
        assertEquals(reserialized,fromSpec );
    }

    @Test
    public void testBitcoinSerialize() throws Exception {
        PeerAddress pa = new PeerAddress(InetAddress.getByName(null), 8333, 0);
        assertEquals("000000000000000000000000000000000000ffff7f000001208d",
                Utils.HEX.encode(pa.bitcoinSerialize()));
    }

    @Test
    public void testOnionHostname() throws Exception {
        PeerAddress pa = new PeerAddress(InetSocketAddress.createUnresolved("explorernuoc63nb.onion", 8333));
        assertEquals("explorernuoc63nb.onion", pa.toSocketAddress().getHostString());
        assertEquals("explorernuoc63nb.onion", pa.getHostname());
        assertEquals(null, pa.getAddr());
        assertEquals(8333, pa.toSocketAddress().getPort());
        assertEquals(8333, pa.getPort());
        PeerAddress pa2 = new PeerAddress(MainNetParams.get(), InetSocketAddress.createUnresolved("explorernuoc63nb.onion", 8333));
        assertPeerAddressEqualsRegardlessOfTime(pa, pa2);
        PeerAddress pa3 = new PeerAddress("explorernuoc63nb.onion", 8333);
        assertPeerAddressEqualsRegardlessOfTime(pa, pa3);
        PeerAddress pa4 = new PeerAddress(MainNetParams.get(), "explorernuoc63nb.onion", 8333);
        assertPeerAddressEqualsRegardlessOfTime(pa, pa4);
        byte[] serialized = pa.unsafeBitcoinSerialize();
        PeerAddress paFromSerialized = new PeerAddress(MainNetParams.get(), serialized, 0, NetworkParameters.ProtocolVersion.CURRENT.getBitcoinProtocolVersion());
        assertPeerAddressEqualsRegardlessOfTime(pa, paFromSerialized);
    }

    private void assertPeerAddressEqualsRegardlessOfTime(PeerAddress pa, PeerAddress pa2) {
        assertEquals(pa.getPort(), pa2.getPort());
        assertEquals(pa.getAddr(), pa2.getAddr());
        assertEquals(pa.getHostname(), pa2.getHostname());
        assertEquals(pa.getServices(), pa2.getServices());
    }


}
