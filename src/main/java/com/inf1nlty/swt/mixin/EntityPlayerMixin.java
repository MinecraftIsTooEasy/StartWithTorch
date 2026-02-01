package com.inf1nlty.swt.mixin;

import com.inf1nlty.swt.IClaim;
import net.minecraft.EntityPlayer;
import net.minecraft.NBTTagCompound;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public abstract class EntityPlayerMixin implements IClaim {

    @Unique private boolean swt$claimedTorch = false;

    @Inject(method = "readEntityFromNBT", at = @At("RETURN"))
    private void onReadEntityFromNBT(NBTTagCompound nbt, CallbackInfo ci) {
        if (nbt != null && nbt.hasKey("swt_claimed_torch")) {
            this.swt$claimedTorch = nbt.getBoolean("swt_claimed_torch");
        }
        else {
            this.swt$claimedTorch = false;
        }
    }

    @Inject(method = "writeEntityToNBT", at = @At("RETURN"))
    private void onWriteEntityToNBT(NBTTagCompound nbt, CallbackInfo ci) {
        if (nbt != null) {
            nbt.setBoolean("swt_claimed_torch", this.swt$claimedTorch);
        }
    }

    @Override
    public boolean swt_hasClaimedTorch() {
        return this.swt$claimedTorch;
    }

    @Override
    public void swt_setClaimedTorch(boolean claimed) {
        this.swt$claimedTorch = claimed;
    }
}