package me.suzutsuki.iEnchant.StatusAilment;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantmentAPI;

public class CurseEnchantment extends CustomEnchantment{

	static final Material[] CURSE_ITEMS = {};
	public CurseEnchantment()
	{
		super("Curse", CURSE_ITEMS,1);
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
		PotionEffect SLOW = new PotionEffect(PotionEffectType.SLOW,200,lv-1);
		PotionEffect SLOW_DIG = new PotionEffect(PotionEffectType.SLOW_DIGGING,200,lv-1);
		PotionEffect WEAKNESS = new PotionEffect(PotionEffectType.WEAKNESS,200,lv);
		target.addPotionEffect(SLOW);
		target.addPotionEffect(SLOW_DIG);
		target.addPotionEffect(WEAKNESS);
	}
}
