package com.inf1nlty.swt;

import net.minecraft.Block;
import net.minecraft.ChatMessageComponent;
import net.minecraft.EnumChatFormatting;
import net.minecraft.ItemStack;
import net.minecraft.ServerPlayer;
import moddedmite.rustedironcore.api.event.Handlers;
import moddedmite.rustedironcore.api.event.events.PlayerLoggedInEvent;
import moddedmite.rustedironcore.api.event.listener.IPlayerEventListener;

public class SWTEventListener extends Handlers {

    public static void register() {

        PlayerEvent.register(new IPlayerEventListener() {

            @Override
            public void onPlayerLoggedIn(PlayerLoggedInEvent event) {

                ServerPlayer player = event.player();

                if (player == null) return;

                if (!event.firstLogin()) return;

                Block lowTorch = SWTInit.getLowTorch();
                ItemStack torchStack = new ItemStack(lowTorch, 1, 0);

                player.inventory.addItemStackToInventory(torchStack);

                player.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("swt.claim.success").setColor(EnumChatFormatting.GREEN));
            }
        });
    }
}