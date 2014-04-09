package me.suzutsuki.iEnchant;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantmentAPI;

public class LifestealEnchantment extends CustomEnchantment{

	 public LifestealEnchantment() {
		super("Life Steal",LIFESTEAL_ITEMS, 1);
		EnchantmentAPI.registerCustomEnchantment(this);
	}

	static final Material[] LIFESTEAL_ITEMS = new Material[]{};
	//static final Material[] LIFESTEAL_ITEMS = new Material[] {
    //    Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD, Material.DIAMOND_SWORD };

	@Override
	public void applyEffect(LivingEntity user, LivingEntity target, int enchantlevel, EntityDamageByEntityEvent event)
	{
		if(event.isCancelled() || target.getNoDamageTicks() > 0)return;
		if(user instanceof Player)
		{
			Player p = (Player)user;
			if(!p.hasPermission("ienchant.customenchant"))return;
		}
		double dmg = event.getDamage();
		double gainedhp = Math.ceil(dmg*(0.05*enchantlevel));
		double health = user.getHealth() + gainedhp;
		if(health > user.getMaxHealth())
		{
			health = 20;
		}
		user.setHealth(health);
	}
	
}
