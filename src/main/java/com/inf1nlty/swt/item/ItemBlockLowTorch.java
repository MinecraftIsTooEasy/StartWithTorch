package com.inf1nlty.swt.item;

import net.minecraft.Block;
import net.minecraft.ItemBlock;

public class ItemBlockLowTorch extends ItemBlock {

    public ItemBlockLowTorch(int blockId) {
        super(Block.getBlock(blockId));
        this.setUnlocalizedName("swt_low_torch_item");
    }
}