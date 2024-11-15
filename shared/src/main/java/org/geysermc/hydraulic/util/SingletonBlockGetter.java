package org.geysermc.hydraulic.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.EmptyBlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

public class SingletonBlockGetter implements BlockGetter {
    private final BlockState state;

    public SingletonBlockGetter(BlockState state) {
        this.state = state;
    }

    @Nullable
    @Override
    public BlockEntity getBlockEntity(@Nonnull BlockPos blockPos) {
        return EmptyBlockGetter.INSTANCE.getBlockEntity(blockPos);
    }

    @Override
    public BlockState getBlockState(@Nonnull BlockPos blockPos) {
        return this.state;
    }

    @Override
    public FluidState getFluidState(@Nonnull BlockPos blockPos) {
        return Fluids.EMPTY.defaultFluidState();
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getMinBuildHeight() {
        return 0;
    }
}
