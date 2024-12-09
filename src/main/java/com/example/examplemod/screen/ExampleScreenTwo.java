package com.example.examplemod.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import me.axeno.abyssoria.AbyssoriaUI;
import me.axeno.abyssoria.screen.AScreen;
import me.axeno.abyssoria.utils.GuiUtils;
import me.axeno.abyssoria.widget.button.AButton;
import me.axeno.abyssoria.widget.button.AIconButton;
import me.axeno.abyssoria.widget.button.Icons;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Optional;

public class ExampleScreenTwo extends AScreen {

    public ExampleScreenTwo() {
        super(Component.nullToEmpty("Example Screen"));
    }

    private int scaleWidth(float percentage) {
        return GuiUtils.scaleWidth(this.width, percentage);
    }

    private int scaleHeight(float percentage) {
        return GuiUtils.scaleHeight(this.height, percentage);
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        int buttonWidth = scaleWidth(26);
        int buttonHeight = scaleHeight(8);

        this.addRenderableWidget(new AButton(
            centerX - buttonWidth / 2,
            centerY - buttonHeight / 2,
            buttonWidth,
            buttonHeight,
            Component.nullToEmpty("Click me!"),
            Icons.WEB.texture,
            b -> {
                Player player = this.getMinecraft().player;
                if (player != null) {
                    player.sendMessage(Component.nullToEmpty("Hello, " + player.getName().getString() + "!"), player.getUUID());
                }
            }
        ));

        List<FormattedCharSequence> hoverText = List.of(
            new TextComponent("Joueur : 0/40").getVisualOrderText(),
            new TextComponent("Serveur : §aOnline").getVisualOrderText(),
            new TextComponent("Ping : 11").getVisualOrderText()
        );

        this.addRenderableWidget(new AButton(
            centerX - buttonWidth / 2,
            centerY - buttonHeight / 2 + scaleHeight(10),
            buttonWidth,
            buttonHeight,
            Component.nullToEmpty("Rejoindre Abyssoria"),
            hoverText,
            b -> {
                Player player = this.getMinecraft().player;
                if (player != null) {
                    player.sendMessage(Component.nullToEmpty("Hello, " + player.getName().getString() + "!"), player.getUUID());
                }
            }
        ));

        this.addRenderableWidget(new AIconButton(
            centerX - buttonWidth / 2,
            centerY - buttonHeight / 2 + scaleHeight(20),
            40,
            40,
            Icons.WEB,
            List.of(Component.nullToEmpty("Hello !").getVisualOrderText()),
            b -> {
                Player player = this.getMinecraft().player;
                if (player != null) {
                    player.sendMessage(Component.nullToEmpty("Hello, " + player.getName().getString() + "!"), player.getUUID());
                }
            }
        ));

        this.addRenderableWidget(new AIconButton(
            centerX - buttonWidth / 2 + 50,
            centerY - buttonHeight / 2 + scaleHeight(20),
            40,
            40,
            Icons.DISCORD,
            List.of(Component.nullToEmpty("Hello !").getVisualOrderText()),
            b -> {
                Player player = this.getMinecraft().player;
                if (player != null) {
                    player.sendMessage(Component.nullToEmpty("Hello, " + player.getName().getString() + "!"), player.getUUID());
                }
            }
        ));

        this.addRenderableWidget(new AIconButton(
            centerX - buttonWidth / 2 + 100,
            centerY - buttonHeight / 2 + scaleHeight(20),
            40,
            40,
            Icons.YOUTUBE,
            List.of(Component.nullToEmpty("Hello !").getVisualOrderText()),
            b -> {
                Player player = this.getMinecraft().player;
                if (player != null) {
                    player.sendMessage(Component.nullToEmpty("Hello, " + player.getName().getString() + "!"), player.getUUID());
                }
            }
        ));
    }

    @Override
    public void render(PoseStack poseStack, int x, int y, float partialTicks) {
        renderDarkBackground(poseStack);

        int logoWidth = scaleWidth(11);
        int logoHeight = scaleHeight(7);

        int logoX = this.width / 2 - logoWidth / 2;
        int logoY = 10;

        GuiUtils.drawImage(poseStack, logoX, logoY, logoWidth, logoHeight, AbyssoriaUI.LOGO_TEXT);

        super.render(poseStack, x, y, partialTicks);

        for (GuiEventListener widget : this.children()) {
            if (widget instanceof AButton button && button.isMouseOver(x, y)) {
                renderTooltip(poseStack, button.getHoverText(), x, y);
            }
            if (widget instanceof AIconButton button && button.isMouseOver(x, y)) {
                renderTooltip(poseStack, button.getHoverText(), x, y);
            }
        }
    }
}