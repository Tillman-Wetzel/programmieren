package net.mcreator.tillmanstollemod.item;

import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.tillmanstollemod.init.TillmanstollemodModAttributes;
import net.mcreator.tillmanstollemod.TillmanstollemodMod;

import java.util.Map;

public abstract class TillmansArmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(15, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 2, ArmorType.BODY, 6), 128,
			DeferredHolder.create(Registries.SOUND_EVENT, Identifier.parse("item.armor.equip_diamond")), 1.5f, 0f, TagKey.create(Registries.ITEM, Identifier.parse("tillmanstollemod:tillmans_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.parse("tillmanstollemod:tillmans_armor")));

	private TillmansArmorItem(Item.Properties properties) {
		super(properties);
	}

	public static class Boots extends TillmansArmorItem {
		public Boots(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS)
					.attributes(ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(Identifier.withDefaultNamespace("armor.boots"), 2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
							.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.withDefaultNamespace("armor.boots"), 1.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
							.add(TillmanstollemodModAttributes.CAN_FLY, new AttributeModifier(Identifier.fromNamespaceAndPath(TillmanstollemodMod.MODID, "tillmans_armor_0.boots"), 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
							.build()));
		}
	}
}