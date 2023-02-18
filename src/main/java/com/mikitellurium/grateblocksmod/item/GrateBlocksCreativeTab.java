package com.mikitellurium.grateblocksmod.item;

import com.mikitellurium.grateblocksmod.GrateBlocksMod;
import com.mikitellurium.grateblocksmod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GrateBlocksMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrateBlocksCreativeTab {

    public static CreativeModeTab TAB_GRATEBLOCKS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TAB_GRATEBLOCKS = event.registerCreativeModeTab(new ResourceLocation(GrateBlocksMod.MOD_ID, "grateblocks_creative_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.GRATE_MAGMA_BLOCK.get()))
                        .title(Component.translatable("creativemodetab.grateblocks_creative_tab")));
    }
}