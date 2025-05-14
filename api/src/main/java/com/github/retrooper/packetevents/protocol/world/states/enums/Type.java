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

public enum Type {
    BOTTOM(ac.grim.grimac.api.packet.world.enums.Type.BOTTOM),
    DOUBLE(ac.grim.grimac.api.packet.world.enums.Type.DOUBLE),
    LEFT(ac.grim.grimac.api.packet.world.enums.Type.LEFT),
    NORMAL(ac.grim.grimac.api.packet.world.enums.Type.NORMAL),
    RIGHT(ac.grim.grimac.api.packet.world.enums.Type.RIGHT),
    SINGLE(ac.grim.grimac.api.packet.world.enums.Type.SINGLE),
    STICKY(ac.grim.grimac.api.packet.world.enums.Type.STICKY),
    TOP(ac.grim.grimac.api.packet.world.enums.Type.TOP);

    public final ac.grim.grimac.api.packet.world.enums.Type type;

    Type(ac.grim.grimac.api.packet.world.enums.Type type) {
        this.type = type;
    }

    private static final Type[] API_MAP = values();

    public static Type of(ac.grim.grimac.api.packet.world.enums.Type api) {
        return API_MAP[api.ordinal()];
    }
}
