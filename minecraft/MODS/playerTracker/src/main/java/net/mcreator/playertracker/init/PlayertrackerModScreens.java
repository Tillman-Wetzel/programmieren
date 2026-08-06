/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playertracker.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.playertracker.client.gui.PlayerTrackerGuiScreen;

@EventBusSubscriber(Dist.CLIENT)
public class PlayertrackerModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(PlayertrackerModMenus.PLAYER_TRACKER_GUI.get(), PlayerTrackerGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}