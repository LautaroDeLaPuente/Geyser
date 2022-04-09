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

package org.geysermc.geyser.custom.items;

import com.nukkitx.nbt.NbtMap;
import com.nukkitx.nbt.NbtType;

import java.util.ArrayList;
import java.util.List;

public class ToolBreakSpeeds {
    public static int toolTierToSpeed(String toolTier) {
        return switch (toolTier) {
            case "wooden" -> 2;
            case "stone" -> 4;
            case "iron" -> 6;
            case "golden" -> 12;
            case "diamond" -> 8;
            case "netherite" -> 9;
            default -> 1;
        };
    }

    private static NbtMap createTagBreakSpeed(int speed, String... tags) {
        StringBuilder builder = new StringBuilder("query.any_tag('");
        builder.append(tags[0]);
        for (int i = 1; i < tags.length; i++) {
            builder.append("', '").append(tags[i]);
        }
        builder.append("')");

        return NbtMap.builder()
                .putCompound("block", NbtMap.builder()
                        .putString("tags", builder.toString())
                        .putInt("tags_version", 4)
                        .build())
                .putInt("speed", speed)
                .build();
    }

    private static NbtMap createBreakSpeed(int speed, String block) {
        return NbtMap.builder()
                .putCompound("block", NbtMap.builder()
                        .putString("name", block).build())
                .putCompound("on_dig", NbtMap.builder()
                        .putString("event", "tool_durability")
                        .putInt("target", 0)
                        .build())
                .putInt("speed", speed)
                .build();
    }

    private static NbtMap createDigger(List<NbtMap> speeds) {
        return NbtMap.builder()
                .putBoolean("use_efficiency", true)
                .putCompound("on_dig", NbtMap.builder()
                        .putString("event", "tool_durability")
                        .putInt("target", 0)
                        .build())
                .putList("destroy_speeds", NbtType.COMPOUND, speeds)
                .build();
    }

    public static NbtMap getAxeDigger(int speed) {
        List<NbtMap> speeds = new ArrayList<>();
        speeds.add(createTagBreakSpeed(speed, "wood", "pumpkin", "plant"));
        //All speeds need adding

        return createDigger(speeds);
    }

    public static NbtMap getPickaxeDigger(int speed, String toolTier) {
        List<NbtMap> speeds = new ArrayList<>();
        if (toolTier.equals("diamond") || toolTier.equals("netherite")) {
            speeds.add(createTagBreakSpeed(speed, "stone", "metal", "gravel", "iron_pick_diggable", "diamond_pick_diggable"));
        } else {
            speeds.add(createTagBreakSpeed(speed, "stone", "metal", "gravel", "iron_pick_diggable"));
        }
        //All speeds need adding

        return createDigger(speeds);
    }

    public static NbtMap getShovelDigger(int speed) {
        List<NbtMap> speeds = new ArrayList<>();
        speeds.add(createTagBreakSpeed(speed, "dirt", "sand", "gravel", "grass", "snow"));
        //All speeds need adding

        return createDigger(speeds);
    }

    public static NbtMap getSwordDigger(int speed) {
        List<NbtMap> speeds = new ArrayList<>();
        speeds.add(createBreakSpeed(speed, "minecraft:web"));
        speeds.add(createBreakSpeed(speed, "minecraft:bamboo"));
        //All speeds need adding

        return createDigger(speeds);
    }
}
