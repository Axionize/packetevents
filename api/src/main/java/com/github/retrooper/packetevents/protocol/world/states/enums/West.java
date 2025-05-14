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

package com.github.retrooper.packetevents.protocol.world.states.enums;

public enum West {
    FALSE(ac.grim.grimac.api.packet.world.enums.West.FALSE),
    LOW(ac.grim.grimac.api.packet.world.enums.West.LOW),
    NONE(ac.grim.grimac.api.packet.world.enums.West.NONE),
    SIDE(ac.grim.grimac.api.packet.world.enums.West.SIDE),
    TALL(ac.grim.grimac.api.packet.world.enums.West.TALL),
    TRUE(ac.grim.grimac.api.packet.world.enums.West.TRUE),
    UP(ac.grim.grimac.api.packet.world.enums.West.UP);

    public final ac.grim.grimac.api.packet.world.enums.West west;

    West(ac.grim.grimac.api.packet.world.enums.West west) {
        this.west = west;
    }

    private static final West[] API_MAP = values();

    public static West of(ac.grim.grimac.api.packet.world.enums.West api) {
        return API_MAP[api.ordinal()];
    }
}
