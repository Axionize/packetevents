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

public enum Thickness {
    BASE(ac.grim.grimac.api.packet.world.enums.Thickness.BASE),
    FRUSTUM(ac.grim.grimac.api.packet.world.enums.Thickness.FRUSTUM),
    MIDDLE(ac.grim.grimac.api.packet.world.enums.Thickness.MIDDLE),
    TIP(ac.grim.grimac.api.packet.world.enums.Thickness.TIP),
    TIP_MERGE(ac.grim.grimac.api.packet.world.enums.Thickness.TIP_MERGE);

    public final ac.grim.grimac.api.packet.world.enums.Thickness thickness;

    Thickness(ac.grim.grimac.api.packet.world.enums.Thickness thickness) {
        this.thickness = thickness;
    }

    private static final Thickness[] API_MAP = values();

    public static Thickness of(ac.grim.grimac.api.packet.world.enums.Thickness api) {
        return API_MAP[api.ordinal()];
    }
}
