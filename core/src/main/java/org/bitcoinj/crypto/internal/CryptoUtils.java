/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package org.bitcoinj.crypto.internal;

import org.bitcoinj.core.Sha256Hash;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;

// Methods taken from BitcoinJ main branch
public class CryptoUtils {
    /**
     * Calculate RIPEMD160(SHA256(input)). This is used in Address calculations.
     * @param input bytes to hash
     * @return RIPEMD160(SHA256(input))
     */
    public static byte[] sha256hash160(byte[] input) {
        byte[] sha256 = Sha256Hash.hash(input);
        return digestRipeMd160(sha256);
    }

    /**
     * Calculate RIPEMD160(input).
     * @param input bytes to hash
     * @return RIPEMD160(input)
     */
    public static byte[] digestRipeMd160(byte[] input) {
        RIPEMD160Digest digest = new RIPEMD160Digest();
        digest.update(input, 0, input.length);
        byte[] ripemdHash = new byte[20];
        digest.doFinal(ripemdHash, 0);
        return ripemdHash;
    }
}
