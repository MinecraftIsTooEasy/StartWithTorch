package com.inf1nlty.swt;

import com.inf1nlty.swt.block.BlockLowTorch;
import com.inf1nlty.swt.item.ItemBlockLowTorch;
import net.minecraft.Block;
import com.google.common.eventbus.Subscribe;
import net.minecraft.CreativeTabs;
import net.minecraft.Item;
import net.minecraft.ItemBlock;
import net.xiaoyu233.fml.api.block.IBlock;
import net.xiaoyu233.fml.reload.event.BlockRegistryEvent;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class SWTInit {

    private static Block lowTorch;

    @Subscribe
    public void onBlockRegister(BlockRegistryEvent event) {

        int lowTorchId = IdUtil.getNextBlockID();
        lowTorch = new BlockLowTorch(lowTorchId);
        Item.itemsList[lowTorchId] = new ItemBlock(lowTorch);
        event.registerBlock("swt", "low_torch", lowTorch);
        ((IBlock) lowTorch).setBlockTextureName("torch_on");
    }

    public static Block getLowTorch() {
        return lowTorch;
    }
}