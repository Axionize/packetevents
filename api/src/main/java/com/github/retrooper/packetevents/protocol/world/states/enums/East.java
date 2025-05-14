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

public enum East {
    FALSE(ac.grim.grimac.api.packet.world.enums.East.FALSE),
    LOW(ac.grim.grimac.api.packet.world.enums.East.LOW),
    NONE(ac.grim.grimac.api.packet.world.enums.East.NONE),
    SIDE(ac.grim.grimac.api.packet.world.enums.East.SIDE),
    TALL(ac.grim.grimac.api.packet.world.enums.East.TALL),
    TRUE(ac.grim.grimac.api.packet.world.enums.East.TRUE),
    UP(ac.grim.grimac.api.packet.world.enums.East.UP);

    public final ac.grim.grimac.api.packet.world.enums.East east;

    East(ac.grim.grimac.api.packet.world.enums.East east) {
        this.east = east;
    }

    private static final East[] API_MAP = values();

    public static East of(ac.grim.grimac.api.packet.world.enums.East api) {
        return API_MAP[api.ordinal()];
    }
}
