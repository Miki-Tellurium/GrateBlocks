package com.mikitellurium.grateblocksmod;

import com.mikitellurium.grateblocksmod.block.ModBlocks;
import com.mikitellurium.grateblocksmod.item.GrateBlocksCreativeTab;
import com.mikitellurium.grateblocksmod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GrateBlocksMod.MOD_ID)
public class GrateBlocksMod {
    public static final String MOD_ID = "grateblocks";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GrateBlocksMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
        // Register ourselves for server and other game events we are interested in
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("LET ME COOK");
        LOGGER.info("GRATE BLOCKS -> {}", ModBlocks.GRATE_MAGMA_BLOCK.get());
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == GrateBlocksCreativeTab.TAB_GRATEBLOCKS) {
            event.accept(ModBlocks.GRATE_MAGMA_BLOCK);
            event.accept(ModBlocks.GRATE_SOUL_SAND);
        }
    }

    // Registering static method with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

}

