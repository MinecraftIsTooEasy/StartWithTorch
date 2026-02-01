package com.inf1nlty.swt;

import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class StartWithTorchMod implements ModInitializer {
    public void onInitialize() {

        MITEEvents.MITE_EVENT_BUS.register(new SWTEventListener());
    }
}