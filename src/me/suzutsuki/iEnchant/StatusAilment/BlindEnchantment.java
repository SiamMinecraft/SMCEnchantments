package me.suzutsuki.iEnchant.StatusAilment;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantmentAPI;

public class BlindEnchantment extends CustomEnchantment{

	//static final Material[] BLIND_ITEMS = {Material.BOW};
	static final Material[] BLIND_ITEMS = {};
	public BlindEnchantment()
	{
		super("Retinal Poison", BLIND_ITEMS,1);
		EnchantmentAPI.registerCustomEnchantment(this);
	}
	
	@Override
	public void applyEffect(LivingEntity user,LivingEntity target,int level,EntityDamageByEntityEvent event)
	{
		if(event.isCancelled() || target.getNoDamageTicks() > 0)return;
		if(user instanceof Player)
		{
			Player p = (Player)user;
			if(!p.hasPermission("ienchant.customenchant"))return;
		}
		PotionEffect BLIND = new PotionEffect(PotionEffectType.BLINDNESS,200+(level*20),1);
		target.addPotionEffect(BLIND);
	}
}
