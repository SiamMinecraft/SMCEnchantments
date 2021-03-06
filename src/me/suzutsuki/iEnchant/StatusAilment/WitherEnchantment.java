package me.suzutsuki.iEnchant.StatusAilment;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantmentAPI;

public class WitherEnchantment extends CustomEnchantment{
	static final Material[] WITHER_ITEMS = {};
	public WitherEnchantment()
	{
		super("Wither", WITHER_ITEMS,1);
		EnchantmentAPI.registerCustomEnchantment(this);
	}
	
	@Override
	public void applyEffect(LivingEntity user,LivingEntity target, int lv,EntityDamageByEntityEvent event)
	{
		if(event.isCancelled() || target.getNoDamageTicks() > 0)return;
		if(user instanceof Player)
		{
			Player p = (Player)user;
			if(!p.hasPermission("ienchant.customenchant"))return;
		}
		PotionEffect WITHER = new PotionEffect(PotionEffectType.WITHER,10+(lv*10),lv-1);
		target.addPotionEffect(WITHER);
	}
}
