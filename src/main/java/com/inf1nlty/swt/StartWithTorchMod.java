package com.inf1nlty.swt;

import net.fabricmc.api.ModInitializer;
import net.xiaoyu233.fml.ModResourceManager;
import net.xiaoyu233.fml.reload.event.MITEEvents;

public class StartWithTorchMod implements ModInitializer {

    public static final String NAMESPACE = "swt";

    public void onInitialize() {

        ModResourceManager.addResourcePackDomain(NAMESPACE);

        MITEEvents.MITE_EVENT_BUS.register(new SWTInit());
        MITEEvents.MITE_EVENT_BUS.register(new SWTEventListener());
    }
}