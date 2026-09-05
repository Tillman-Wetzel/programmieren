/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.newplayernames.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

import net.mcreator.newplayernames.NewplayernamesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NewplayernamesModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, NewplayernamesMod.MODID);
	public static final RegistryObject<Attribute> IS_NAMED = REGISTRY.register("is_named", () -> new RangedAttribute("attribute.newplayernames.is_named", 0d, 0d, 1d).setSyncable(true));
	public static final RegistryObject<Attribute> ORIGINAL_DIED = REGISTRY.register("original_died", () -> new RangedAttribute("attribute.newplayernames.original_died", 0d, 0d, 1d).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, IS_NAMED.get());
		event.add(EntityType.PLAYER, ORIGINAL_DIED.get());
	}

	@Mod.EventBusSubscriber
	public static class PlayerAttributesSync {
		@SubscribeEvent
		public static void playerClone(PlayerEvent.Clone event) {
			Player oldPlayer = event.getOriginal();
			Player newPlayer = event.getEntity();
			newPlayer.getAttribute(IS_NAMED.get()).setBaseValue(oldPlayer.getAttribute(IS_NAMED.get()).getBaseValue());
			newPlayer.getAttribute(ORIGINAL_DIED.get()).setBaseValue(oldPlayer.getAttribute(ORIGINAL_DIED.get()).getBaseValue());
		}
	}
}