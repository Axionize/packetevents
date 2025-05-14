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

public enum Shape {
    ASCENDING_EAST(ac.grim.grimac.api.packet.world.enums.Shape.ASCENDING_EAST),
    ASCENDING_NORTH(ac.grim.grimac.api.packet.world.enums.Shape.ASCENDING_NORTH),
    ASCENDING_SOUTH(ac.grim.grimac.api.packet.world.enums.Shape.ASCENDING_SOUTH),
    ASCENDING_WEST(ac.grim.grimac.api.packet.world.enums.Shape.ASCENDING_WEST),
    EAST_WEST(ac.grim.grimac.api.packet.world.enums.Shape.EAST_WEST),
    INNER_LEFT(ac.grim.grimac.api.packet.world.enums.Shape.INNER_LEFT),
    INNER_RIGHT(ac.grim.grimac.api.packet.world.enums.Shape.INNER_RIGHT),
    NORTH_EAST(ac.grim.grimac.api.packet.world.enums.Shape.NORTH_EAST),
    NORTH_SOUTH(ac.grim.grimac.api.packet.world.enums.Shape.NORTH_SOUTH),
    NORTH_WEST(ac.grim.grimac.api.packet.world.enums.Shape.NORTH_WEST),
    OUTER_LEFT(ac.grim.grimac.api.packet.world.enums.Shape.OUTER_LEFT),
    OUTER_RIGHT(ac.grim.grimac.api.packet.world.enums.Shape.OUTER_RIGHT),
    SOUTH_EAST(ac.grim.grimac.api.packet.world.enums.Shape.SOUTH_EAST),
    SOUTH_WEST(ac.grim.grimac.api.packet.world.enums.Shape.SOUTH_WEST),
    STRAIGHT(ac.grim.grimac.api.packet.world.enums.Shape.STRAIGHT);

    public final ac.grim.grimac.api.packet.world.enums.Shape shape;

    Shape(ac.grim.grimac.api.packet.world.enums.Shape shape) {
        this.shape = shape;
    }

    private static final Shape[] API_MAP = values();

    public static Shape of(ac.grim.grimac.api.packet.world.enums.Shape api) {
        return API_MAP[api.ordinal()];
    }
}