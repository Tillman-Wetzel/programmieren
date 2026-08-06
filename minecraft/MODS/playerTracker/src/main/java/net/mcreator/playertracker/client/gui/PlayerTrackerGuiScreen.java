package net.mcreator.playertracker.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.playertracker.world.inventory.PlayerTrackerGuiMenu;
import net.mcreator.playertracker.procedures.SetModeLabelProcedure;
import net.mcreator.playertracker.procedures.SetGuiTextPlayernameProcedure;
import net.mcreator.playertracker.procedures.IsPlayerNotChosenProcedure;
import net.mcreator.playertracker.procedures.IsPlayerChosenProcedure;
import net.mcreator.playertracker.procedures.GetUseYProcedure;
import net.mcreator.playertracker.network.PlayerTrackerGuiButtonMessage;
import net.mcreator.playertracker.init.PlayertrackerModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class PlayerTrackerGuiScreen extends AbstractContainerScreen<PlayerTrackerGuiMenu> implements PlayertrackerModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox UseYCheckbox;
	private Button button_add_yourself;
	private Button button_x;
	private Button button_toggle_mode;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("playertracker:textures/screens/player_tracker_gui.png");

	public PlayerTrackerGuiScreen(PlayerTrackerGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 170;
		this.imageHeight = 96;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("UseYCheckbox")) {
				if (UseYCheckbox.selected() != logicState)
					UseYCheckbox.onPress();
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.playertracker.player_tracker_gui.label_player_to_track"), 12, 53, -12829636, false);
		if (IsPlayerChosenProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, SetGuiTextPlayernameProcedure.execute(entity), 12, 70, -12829636, false);
		guiGraphics.drawString(this.font, SetModeLabelProcedure.execute(world, x, y, z), 39, 8, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_add_yourself = Button.builder(Component.translatable("gui.playertracker.player_tracker_gui.button_add_yourself"), e -> {
			int x = PlayerTrackerGuiScreen.this.x;
			int y = PlayerTrackerGuiScreen.this.y;
			if (IsPlayerNotChosenProcedure.execute(world, x, y, z)) {
				PacketDistributor.sendToServer(new PlayerTrackerGuiButtonMessage(0, x, y, z));
				PlayerTrackerGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 67, 85, 20).build();
		this.addRenderableWidget(button_add_yourself);
		button_x = Button.builder(Component.translatable("gui.playertracker.player_tracker_gui.button_x"), e -> {
			int x = PlayerTrackerGuiScreen.this.x;
			int y = PlayerTrackerGuiScreen.this.y;
			if (IsPlayerChosenProcedure.execute(world, x, y, z)) {
				PacketDistributor.sendToServer(new PlayerTrackerGuiButtonMessage(1, x, y, z));
				PlayerTrackerGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 147, this.topPos + 66, 10, 20).build();
		this.addRenderableWidget(button_x);
		button_toggle_mode = Button.builder(Component.translatable("gui.playertracker.player_tracker_gui.button_toggle_mode"), e -> {
			int x = PlayerTrackerGuiScreen.this.x;
			int y = PlayerTrackerGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PlayerTrackerGuiButtonMessage(2, x, y, z));
				PlayerTrackerGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 26, 75, 20).build();
		this.addRenderableWidget(button_toggle_mode);
		boolean UseYCheckboxSelected = GetUseYProcedure.execute(world, x, y, z);
		UseYCheckbox = Checkbox.builder(Component.translatable("gui.playertracker.player_tracker_gui.UseYCheckbox"), this.font).pos(this.leftPos + 111, this.topPos + 26).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "UseYCheckbox", value, false);
		}).selected(UseYCheckboxSelected).build();
		if (UseYCheckboxSelected)
			menu.sendMenuStateUpdate(entity, 1, "UseYCheckbox", true, false);
		this.addRenderableWidget(UseYCheckbox);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_add_yourself.visible = IsPlayerNotChosenProcedure.execute(world, x, y, z);
		this.button_x.visible = IsPlayerChosenProcedure.execute(world, x, y, z);
	}
}