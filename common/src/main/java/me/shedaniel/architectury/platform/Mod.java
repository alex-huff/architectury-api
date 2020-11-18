/*
 * This file is part of architectury.
 * Copyright (C) 2020 shedaniel
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package me.shedaniel.architectury.platform;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;

public interface Mod {
    @NotNull
    String getModId();
    
    @NotNull
    String getVersion();
    
    @NotNull
    String getName();
    
    @NotNull
    String getDescription();
    
    @NotNull
    Optional<String> getLogoFile(int preferredSize);
    
    @NotNull
    Path getFilePath();
    
    @NotNull
    Collection<String> getAuthors();
    
    @Nullable
    Collection<String> getLicense();
    
    @Nullable
    Optional<String> getHomepage();
    
    @Nullable
    Optional<String> getSources();
    
    @Nullable
    Optional<String> getIssueTracker();
    
    @Environment(EnvType.CLIENT)
    void registerConfigurationScreen(ConfigurationScreenProvider provider);
    
    @Environment(EnvType.CLIENT)
    @FunctionalInterface
    interface ConfigurationScreenProvider {
        Screen provide(Screen parent);
    }
}
