package com.inf1nlty.swt.block;

import net.minecraft.BlockTorch;
import net.minecraft.CreativeTabs;

public class BlockLowTorch extends BlockTorch {

    public BlockLowTorch(int id) {
        super(id);
        this.setLightValue(12.0F / 16.0F);
        this.setUnlocalizedName("swt_low_torch");
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
}