package net.mcreator.tillmanstollemod.client.renderer.item;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import net.mcreator.tillmanstollemod.init.TillmanstollemodModItems;

@EventBusSubscriber(Dist.CLIENT)
public class TillmansArmorArmor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			private final Identifier armorTexture = Identifier.parse("tillmanstollemod:textures/models/armor/tillmansarmor_layer_2.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		}, TillmanstollemodModItems.TILLMANS_ARMOR_LEGGINGS.get());
		event.registerItem(new IClientItemExtensions() {
			private final Identifier armorTexture = Identifier.parse("tillmanstollemod:textures/models/armor/tillmansarmor_layer_1.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		}, TillmanstollemodModItems.TILLMANS_ARMOR_BOOTS.get());
	}
}