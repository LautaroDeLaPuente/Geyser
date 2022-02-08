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

package org.geysermc.geyser.api.custommodeldata;

/**
 * This is used to store data for a custom item.
 */
public class CustomItemData {
    private Integer customModelData;

    private String name;
    private String displayName;

    private boolean isTool;
    private boolean allowOffhand;
    private boolean isHat;

    private int textureSize;

    public CustomItemData(Integer customModelData, String name) {
        this.customModelData = customModelData;
        this.name = name;
        this.displayName = name;
        this.isTool = false;
        this.allowOffhand = false;
        this.isHat = false;
        this.textureSize = 16;
    }

    /**
     * Gets the item's custom model data.
     *
     * @return the item's custom model data
     */
    public Integer customModelData() {
        return this.customModelData;
    }

    /**
     * Gets the item's name.
     *
     * @return the item's name
     */
    public String name() {
        return this.name;
    }

    /**
     * Gets the item's display name.
     *
     * @return the item's display name
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Sets the item's display name.
     *
     * @param displayName the item's display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets if the item is a tool.
     *
     * @return true if the item is a tool, false otherwise
     */
    public boolean isTool() {
        return this.isTool;
    }

    /**
     * Sets if the item is a tool.
     *
     * @param isTool true if the item is a tool, false otherwise
     */
    public void setIsTool(boolean isTool) {
        this.isTool = isTool;
    }

    /**
     * Gets if the item is allowed to be used in the offhand.
     *
     * @return true if the item is allowed to be used in the offhand, false otherwise
     */
    public boolean allowOffhand() {
        return this.allowOffhand;
    }

    /**
     * Sets if the item is allowed to be used in the offhand.
     *
     * @param allowOffhand true if the item is allowed to be used in the offhand, false otherwise
     */
    public void setAllowOffhand(boolean allowOffhand) {
        this.allowOffhand = allowOffhand;
    }

    /**
     * Gets if the item is a hat.
     *
     * @return true if the item is a hat, false otherwise
     */
    public boolean isHat() {
        return this.isHat;
    }

    /**
     * Sets if the item is a hat.
     *
     * @param isHat true if the item is a hat, false otherwise
     */
    public void setIsHat(boolean isHat) {
        this.isHat = isHat;
    }

    /**
     * Gets the item's texture size.
     *
     * @return the item's texture size
     */
    public int textureSize() {
        return this.textureSize;
    }

    /**
     * Sets the item's texture size.
     *
     * @param textureSize the item's texture size
     */
    public void setTextureSize(int textureSize) {
        this.textureSize = textureSize;
    }
}