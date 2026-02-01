package com.inf1nlty.swt.command;

import com.inf1nlty.swt.IClaim;
import net.minecraft.*;

import org.jetbrains.annotations.NotNull;
import java.util.List;

@SuppressWarnings("rawtypes")
public class CommandClaimTorch implements ICommand, Comparable {

    @Override
    public String getCommandName() {
        return "ctorch";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/ctorch";
    }

    @Override
    public List getCommandAliases() {
        return List.of("t");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        if (!(sender instanceof EntityPlayer player)) {
            sender.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("swt.claim.onlyplayer").setColor(EnumChatFormatting.RED));
            return;
        }

        IClaim claim = (IClaim) player;

        if (claim.swt_hasClaimedTorch()) {
            sender.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("swt.claim.already").setColor(EnumChatFormatting.YELLOW));
            return;
        }

        ItemStack torchStack = new ItemStack(Block.torchWood, 1, 0);
        boolean added = player.inventory.addItemStackToInventory(torchStack);

        if (!added) {
            EntityItem ei = new EntityItem(player.worldObj, player.posX, player.posY + 1.0D, player.posZ, torchStack);
            player.worldObj.spawnEntityInWorld(ei);
        }

        claim.swt_setClaimedTorch(true);

        sender.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("swt.claim.success").setColor(EnumChatFormatting.GREEN));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int idx) {
        return false;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if (o instanceof ICommand) {
            return this.getCommandName().compareTo(((ICommand) o).getCommandName());
        }
        return 0;
    }
}