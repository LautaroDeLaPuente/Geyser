/*
 * Copyright (c) 2019-2022 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.geyser.registry.provider;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.geysermc.geyser.api.command.Command;
import org.geysermc.geyser.api.command.CommandSource;
import org.geysermc.geyser.api.custom.items.CustomItemData;
import org.geysermc.geyser.api.custom.items.CustomItemRegistrationTypes;
import org.geysermc.geyser.api.custom.items.FullyCustomItemData;
import org.geysermc.geyser.api.entity.EntityIdentifier;
import org.geysermc.geyser.api.provider.BuilderProvider;
import org.geysermc.geyser.command.GeyserCommandManager;
import org.geysermc.geyser.custom.items.builders.GeyserCustomItemData;
import org.geysermc.geyser.custom.items.builders.GeyserCustomItemRegistrationTypes;
import org.geysermc.geyser.custom.items.builders.GeyserFullyCustomItemData;
import org.geysermc.geyser.entity.GeyserEntityIdentifier;
import org.geysermc.geyser.registry.ProviderRegistries;
import org.geysermc.geyser.registry.SimpleMappedRegistry;

import java.util.Map;

public class GeyserBuilderProvider extends AbstractProvider implements BuilderProvider {
    public static GeyserBuilderProvider INSTANCE = new GeyserBuilderProvider();

    private GeyserBuilderProvider() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void registerProviders(Map<Class<?>, ProviderSupplier> providers) {
        providers.put(Command.Builder.class, args -> new GeyserCommandManager.CommandBuilder<>((Class<? extends CommandSource>) args[0]));
        providers.put(EntityIdentifier.Builder.class, args -> new GeyserEntityIdentifier.EntityIdentifierBuilder());

        providers.put(CustomItemData.Builder.class, args -> new GeyserCustomItemData.Builder((String) args[0], (CustomItemRegistrationTypes) args[1]));
        providers.put(CustomItemRegistrationTypes.Builder.class, args -> new GeyserCustomItemRegistrationTypes.Builder());
        providers.put(FullyCustomItemData.Builder.class, args -> new GeyserFullyCustomItemData.Builder((String) args[0], (String) args[1], (int) args[2]));
    }

    @Override
    public SimpleMappedRegistry<Class<?>, ProviderSupplier> providerRegistry() {
        return ProviderRegistries.BUILDERS;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <B extends T, T> @NonNull B provideBuilder(@NonNull Class<T> builderClass, @Nullable Object... args) {
        return (B) this.providerRegistry().get(builderClass).create(args);
    }
}