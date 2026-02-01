package com.inf1nlty.swt;

import com.google.common.eventbus.Subscribe;
import net.xiaoyu233.fml.reload.event.CommandRegisterEvent;
import com.inf1nlty.swt.command.CommandClaimTorch;

public class SWTEventListener {

    @Subscribe
    public static void register(CommandRegisterEvent event) {
        event.register(new CommandClaimTorch());
    }
}