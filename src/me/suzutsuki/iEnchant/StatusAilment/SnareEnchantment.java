package me.suzutsuki.iEnchant.StatusAilment;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantmentAPI;

public class SnareEnchantment extends CustomEnchantment{

	static final Material[] SNARE_ITEMS = {};
	public SnareEnchantment()
	{
		super("Snare", SNARE_ITEMS,1);
		EnchantmentAPI.registerCustomEnchantment(this);
	}
	
	@Override
	public void applyEffect(LivingEntity user,LivingEntity target,int lv,EntityDamageByEntityEvent event)
	{
		if(event.isCancelled() || target.getNoDamageTicks() > 0)return;
		if(user instanceof Player)
		{
			Player p = (Player)user;
			if(!p.hasPermission("ienchant.customenchant"))return;
		}
		PotionEffect SLOW = new PotionEffect(PotionEffectType.SLOW,60,12);
		PotionEffect JUMP = new PotionEffect(PotionEffectType.JUMP,60,150);
		target.addPotionEffect(SLOW);
		target.addPotionEffect(JUMP);
	}
}
