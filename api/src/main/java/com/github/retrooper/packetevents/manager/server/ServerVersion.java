/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2022 retrooper and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.retrooper.packetevents.manager.server;

import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Server Version.
 * This is a nice wrapper over minecraft's protocol versions.
 * You won't have to memorize the protocol version, just memorize the server version you see in the launcher.
 *
 * @author retrooper
 * @see <a href="https://wiki.vg/Protocol_version_numbers">https://wiki.vg/Protocol_version_numbers</a>
 * @since 1.6.9
 */
public enum ServerVersion {
    //TODO Rename to MinecraftVersion?
    V_1_7_10(5),
    V_1_8(47), V_1_8_3(47), V_1_8_8(47),
    V_1_9(107), V_1_9_1(108), V_1_9_2(109), V_1_9_4(110),
    //1.10 and 1.10.1 are redundant
    V_1_10(210), V_1_10_1(210), V_1_10_2(210),
    V_1_11(315), V_1_11_2(316),
    V_1_12(335), V_1_12_1(338), V_1_12_2(340),
    V_1_13(393), V_1_13_1(401), V_1_13_2(404),
    V_1_14(477), V_1_14_1(480), V_1_14_2(485), V_1_14_3(490), V_1_14_4(498),
    V_1_15(573), V_1_15_1(575), V_1_15_2(578),
    V_1_16(735), V_1_16_1(736), V_1_16_2(751), V_1_16_3(753), V_1_16_4(754), V_1_16_5(754),
    V_1_17(755), V_1_17_1(756),
    V_1_18(757), V_1_18_1(757), V_1_18_2(758),
    //1.19.1 and 1.19.2 have the same protocol version
    V_1_19(759), V_1_19_1(760), V_1_19_2(760), V_1_19_3(761), V_1_19_4(762),
    //1.20 and 1.20.1 have the same protocol version. 1.20.3 and 1.20.4 have the same protocol version. 1.20.5 and 1.20.6 have the same protocol version
    V_1_20(763), V_1_20_1(763), V_1_20_2(764), V_1_20_3(765), V_1_20_4(765), V_1_20_5(766), V_1_20_6(766),
    //1.21 and 1.21.1 have the same protocol version. 1.21.2 and 1.21.3 have the same protocol version
    V_1_21(767), V_1_21_1(767), V_1_21_2(768), V_1_21_3(768),

    // Snapshots for 1.21.4
    V_24W44A(1073742044, true),
    V_24W45A(1073742045, true),
    V_24W46A(1073742046, true),
    V_1_21_4_PRE1(1073742047, true),
    V_1_21_4_PRE2(1073742048, true),
    V_1_21_4_PRE3(1073742049, true),
    V_1_21_4_RC1(1073742050, true),
    V_1_21_4_RC2(1073742051, true),
    V_1_21_4_RC3(1073742052, true),

    V_1_21_4(769),

    // Snapshots for 1.21.5 (newer than 1.21.4 but older than 1.21.5)
    V_25W02A(1073742053, true),
    V_25W03A(1073742054, true),
    V_25W04A(1073742055, true),
    V_25W05A(1073742056, true),
    V_25W06A(1073742057, true),
    V_25W07A(1073742058, true),
    V_25W08A(1073742059, true),
    V_25W09A(1073742060, true),
    V_25W09B(1073742061, true),
    V_25W10A(1073742062, true),
    V_1_21_5_PRE1(1073742063, true),
    V_1_21_5_PRE2(1073742064, true),
    V_1_21_5_PRE3(1073742065, true),
    V_1_21_5_RC1(1073742066, true),
    V_1_21_5_RC2(1073742067, true),

    V_1_21_5(770),
    //TODO UPDATE Add server version constant
    ERROR(-1, true);

    private static final Map<Integer, ServerVersion> PROTOCOL_TO_SERVER_VERSION_MAP = new HashMap<>();
    private static final ServerVersion[] VALUES = values();
    private static final ServerVersion[] REVERSED_VALUES = new ServerVersion[VALUES.length];

    static {
        for (int i = 0, j = VALUES.length - 1; i <= j; i++, j--) {
            ServerVersion valueI = VALUES[i];
            ServerVersion valueJ = VALUES[j];

            // Populate map and reversed array in one pass
            PROTOCOL_TO_SERVER_VERSION_MAP.put(valueI.protocolVersion, valueI);
            PROTOCOL_TO_SERVER_VERSION_MAP.put(valueJ.protocolVersion, valueJ);

            REVERSED_VALUES[i] = valueJ;
            REVERSED_VALUES[j] = valueI;
        }
    }

    private final int protocolVersion;
    private final String name;
    private ClientVersion toClientVersion;

    ServerVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
        this.name = name().substring(2).replace("_", ".");
    }

    ServerVersion(int protocolVersion, boolean isNotRelease) {
        this.protocolVersion = protocolVersion;
        if (isNotRelease) {
            if (name().startsWith("V_")) {
                this.name = name().substring(2)
                        .replaceFirst("_", ".")
                        .replaceFirst("_", ".")
                        .replaceFirst("_", "-")
                        .toLowerCase(Locale.ROOT);
            } else {
                this.name = name();
            }
        } else {
            this.name = name().substring(2).replace("_", ".");
        }
    }

    public static ServerVersion[] reversedValues() {
        return REVERSED_VALUES;
    }

    public static ServerVersion getLatest() {
        return REVERSED_VALUES[1];
    }

    public static ServerVersion getOldest() {
        return VALUES[0];
    }

    @Deprecated @Nullable
    public static ServerVersion getById(int protocolVersion) {
        return PROTOCOL_TO_SERVER_VERSION_MAP.get(protocolVersion);
    }

    public ClientVersion toClientVersion() {
        if (toClientVersion == null) {
            toClientVersion = ClientVersion.getById(protocolVersion);
        }
        return toClientVersion;
    }

    /**
     * Get the release name of this server version.
     * For example, for the V_1_18 enum constant, it would return "1.18".
     *
     * @return Release name
     */
    public String getReleaseName() {
        return name;
    }

    /**
     * Get this server version's protocol version.
     *
     * @return Protocol version.
     */
    public int getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * Is this server version newer than the compared server version?
     * This method simply checks if this server version's protocol version is greater than
     * the compared server version's protocol version.
     *
     * @param target Compared server version.
     * @return Is this server version newer than the compared server version.
     */
    public boolean isNewerThan(ServerVersion target) {
        return this.ordinal() > target.ordinal();
    }

    /**
     * Is this server version older than the compared server version?
     * This method simply checks if this server version's protocol version is less than
     * the compared server version's protocol version.
     *
     * @param target Compared server version.
     * @return Is this server version older than the compared server version.
     */
    public boolean isOlderThan(ServerVersion target) {
        return this.ordinal() < target.ordinal();
    }

    /**
     * Is this server version newer than or equal to the compared server version?
     * This method simply checks if this server version's protocol version is greater than or equal to
     * the compared server version's protocol version.
     *
     * @param target Compared server version.
     * @return Is this server version newer than or equal to the compared server version.
     */
    public boolean isNewerThanOrEquals(ServerVersion target) {
        return this.ordinal() >= target.ordinal();
    }

    /**
     * Is this server version older than or equal to the compared server version?
     * This method simply checks if this server version's protocol version is older than or equal to
     * the compared server version's protocol version.
     *
     * @param target Compared server version.
     * @return Is this server version older than or equal to the compared server version.
     */
    public boolean isOlderThanOrEquals(ServerVersion target) {
        return this.ordinal() <= target.ordinal();
    }

    /**
     * Is this server version newer than, older than or equal to the compared server version?
     * This method simply checks if this server version's protocol version is greater than, less than or equal to
     * the compared server version's protocol version.
     *
     * @param comparison    Comparison type.
     * @param targetVersion Compared server version.
     * @return true or false, based on the comparison type.
     * @see #isNewerThan(ServerVersion)
     * @see #isNewerThanOrEquals(ServerVersion)
     * @see #isOlderThan(ServerVersion)
     * @see #isOlderThanOrEquals(ServerVersion)
     */
    public boolean is(@NotNull VersionComparison comparison, @NotNull ServerVersion targetVersion) {
        switch (comparison) {
            case EQUALS:
                return protocolVersion == targetVersion.protocolVersion;
            case NEWER_THAN:
                return isNewerThan(targetVersion);
            case NEWER_THAN_OR_EQUALS:
                return isNewerThanOrEquals(targetVersion);
            case OLDER_THAN:
                return isOlderThan(targetVersion);
            case OLDER_THAN_OR_EQUALS:
                return isOlderThanOrEquals(targetVersion);
            default:
                return false;
        }
    }
}
