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

package org.geysermc.geyser.level.block;

import org.geysermc.geyser.api.block.custom.component.BoxComponent;
import org.geysermc.geyser.api.block.custom.component.CustomBlockComponents;
import org.geysermc.geyser.api.block.custom.component.MaterialInstance;
import org.geysermc.geyser.api.block.custom.component.RotationComponent;

import java.util.Map;

public class GeyserCustomBlockComponents implements CustomBlockComponents {
    private final BoxComponent aimCollision;
    private final BoxComponent entityCollision;
    private final String geometry;
    private final Map<String, MaterialInstance> materialInstances;
    private final Float destroyTime;
    private final Float friction;
    private final Integer lightEmission;
    private final Integer lightDampening;
    private final RotationComponent rotation;

    private GeyserCustomBlockComponents(CustomBlockComponentsBuilder builder) {
        this.aimCollision = builder.aimCollision;
        this.entityCollision = builder.entityCollision;
        this.geometry = builder.geometry;
        this.materialInstances = builder.materialInstances;
        this.destroyTime = builder.destroyTime;
        this.friction = builder.friction;
        this.lightEmission = builder.lightEmission;
        this.lightDampening = builder.lightFilter;
        this.rotation = builder.rotation;
    }

    @Override
    public BoxComponent selectionBox() {
        return aimCollision;
    }

    @Override
    public BoxComponent collisionBox() {
        return entityCollision;
    }

    @Override
    public String geometry() {
        return geometry;
    }

    @Override
    public Map<String, MaterialInstance> materialInstances() {
        return materialInstances;
    }

    @Override
    public Float destroyTime() {
        return destroyTime;
    }

    @Override
    public Float friction() {
        return friction;
    }

    @Override
    public Integer lightEmission() {
        return lightEmission;
    }

    @Override
    public Integer lightDampening() {
        return lightDampening;
    }

    @Override
    public RotationComponent rotation() {
        return rotation;
    }

    public static class CustomBlockComponentsBuilder implements Builder {
        protected BoxComponent aimCollision;
        protected BoxComponent entityCollision;
        protected String geometry;
        protected Map<String, MaterialInstance> materialInstances;
        protected Float destroyTime;
        protected Float friction;
        protected Integer lightEmission;
        protected Integer lightFilter;
        protected RotationComponent rotation;

        @Override
        public Builder aimCollision(BoxComponent aimCollision) {
            this.aimCollision = aimCollision;
            return this;
        }

        @Override
        public Builder entityCollision(BoxComponent entityCollision) {
            this.entityCollision = entityCollision;
            return this;
        }

        @Override
        public Builder geometry(String geometry) {
            this.geometry = geometry;
            return this;
        }

        @Override
        public Builder materialInstances(Map<String, MaterialInstance> materialInstances) {
            this.materialInstances = materialInstances;
            return this;
        }

        @Override
        public Builder destroyTime(Float destroyTime) {
            this.destroyTime = destroyTime;
            return this;
        }

        @Override
        public Builder friction(Float friction) {
            this.friction = friction;
            return this;
        }

        @Override
        public Builder lightEmission(Integer lightEmission) {
            this.lightEmission = lightEmission;
            return this;
        }

        @Override
        public Builder lightFilter(Integer lightFilter) {
            this.lightFilter = lightFilter;
            return this;
        }

        @Override
        public Builder rotation(RotationComponent rotation) {
            this.rotation = rotation;
            return this;
        }

        @Override
        public CustomBlockComponents build() {
            return new GeyserCustomBlockComponents(this);
        }
    }
}
