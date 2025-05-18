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

package com.github.retrooper.packetevents.event;

import ac.grim.grimac.api.packet.types.event.PacketListenerInterface;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Abstract packet listener.
 *
 * @author retrooper
 * @since 1.8
 */
public abstract class PacketListenerCommon implements PacketListenerInterface {
    private final PacketListenerPriority priority;

    public PacketListenerCommon(PacketListenerPriority priority) {
        this.priority = priority;
    }

    public PacketListenerCommon() {
        this.priority = PacketListenerPriority.NORMAL;
    }

    public PacketListenerPriority getPriority() {
        return priority;
    }

    public void onUserConnect(UserConnectEvent event) {
    }

    public void onUserLogin(UserLoginEvent event) {
    }

    public void onUserDisconnect(UserDisconnectEvent event) {
    }

    public void onPacketReceive(PacketReceiveEvent event) {
    }

    public void onPacketSend(PacketSendEvent event) {
    }

    public void onPacketReceive(ac.grim.grimac.api.packet.types.event.PacketReceiveEvent event) {
        this.onPacketReceive((PacketReceiveEvent) event);
    }

    public void onPacketSend(ac.grim.grimac.api.packet.types.event.PacketSendEvent event) {
        this.onPacketSend((PacketSendEvent) event);
    }

    public void onPacketEventExternal(PacketEvent event) {
    }

    @Override
    public int getListenerPriority() {
        return priority.ordinal();
    }
}
