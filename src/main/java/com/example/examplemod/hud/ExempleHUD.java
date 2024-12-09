package com.example.examplemod.hud;

import com.mojang.blaze3d.vertex.PoseStack;
import me.axeno.abyssoria.hud.AbstractHUD;
import me.axeno.abyssoria.utils.Position;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

public class ExempleHUD extends AbstractHUD {

    private static ResourceLocation container = new ResourceLocation("examplemod", "textures/gui/container/example_hud.png");
    private static final ExempleHUD INSTANCE = new ExempleHUD();

    public ExempleHUD() {
        super(container);
    }

    @Override
    protected float getContainerWidthScale() {
        return 20;
    }

    @Override
    protected float getContainerHeightScale() {
        return 6;
    }

    @Override
    protected float getScaleFactor() {
        return 1.0F;
    }

    @Override
    protected Position setContainerPositionX() {
        return new Position(Position.X.RIGHT, 10);
    }

    @Override
    protected Position setContainerPositionY() {
        return new Position(Position.Y.BOTTOM, 10);
    }

    @Override
    protected void render(PoseStack poseStack) {
        MutableComponent text = new TextComponent("Hello, World!");

        beginScale(poseStack);

        mc.font.draw(
                poseStack,
                text,
                (int)(getCenteredTextX(containerX, containerWidth) * getScaleFactor(1.0F)),
                (int)(getTextY() * getScaleFactor(1.0F)),
                0xFFFFFF
        );

        endScale(poseStack);
    }

    public static ExempleHUD getINSTANCE() {
        return INSTANCE;
    }
}
