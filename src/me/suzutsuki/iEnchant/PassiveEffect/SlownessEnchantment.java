package me.suzutsuki.iEnchant.PassiveEffect;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantmentAPI;

public class SlownessEnchantment extends CustomEnchantment{

	static final Material[] SLOWNESS_ITEMS = {};
	public SlownessEnchantment()
	{
		super("Heavy", SLOWNESS_ITEMS,1);
		EnchantmentAPI.registerCustomEnchantment(this);
	}
	
	@Override
	public void applyEquipEffect(Player p, int lv)
	{
		if(!p.hasPermission("ienchant.customenchant"))return;
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,10000000,lv-1));
	}
}
