package com.inf1nlty.swt;

import net.minecraft.*;
import com.google.common.eventbus.Subscribe;
import net.xiaoyu233.fml.reload.event.PlayerLoggedInEvent;

public class SWTEventListener {

    @Subscribe
    public static void onPlayerLoggedIn(PlayerLoggedInEvent event) {

        ServerPlayer player = event.getPlayer();
        if (player == null) return;

        IClaim claim = (IClaim) (Object) player;

        if (claim.swt_hasClaimedTorch()) {
            return;
        }

        World world = player.worldObj;
        ItemStack torchStack = new ItemStack(Block.torchWood, 1, 0);
        boolean added = player.inventory.addItemStackToInventory(torchStack);

        if (!added) {
            EntityItem ei = new EntityItem(world, player.posX, player.posY + 1.0D, player.posZ, torchStack);
            world.spawnEntityInWorld(ei);
        }

        claim.swt_setClaimedTorch(true);

        player.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("swt.claim.success").setColor(EnumChatFormatting.GREEN)
        );
    }

}