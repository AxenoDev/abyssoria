package com.example.examplemod;

import com.example.examplemod.hud.ExempleHUD;
import com.example.examplemod.screen.ExampleScreen;
import com.example.examplemod.screen.ExampleScreenTwo;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;

@Mod("examplemod")
public class ExampleMod
{
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod()
    {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(RegistryEvents.class);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(ExempleHUD.getINSTANCE());
    }

    @Mod.EventBusSubscriber(modid = "examplemod", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class RegistryEvents
    {
        @SubscribeEvent
        @OnlyIn(Dist.CLIENT)
        public static void onKeyInput(InputEvent.KeyInputEvent event) {
            if (event.getKey() == GLFW.GLFW_KEY_G && event.getAction() == GLFW.GLFW_PRESS) {
                Minecraft.getInstance().setScreen(new ExampleScreen());
            } else if(event.getKey() == GLFW.GLFW_KEY_H && event.getAction() == GLFW.GLFW_PRESS) {
                Minecraft.getInstance().setScreen(new ExampleScreenTwo());
            }
        }
    }
}
