package me.suzutsuki.iEnchant.StatusAilment;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantmentAPI;

public class ComaEnchantment extends CustomEnchantment{

	static final Material[] COMA_ITEMS = {};
	public ComaEnchantment()
	{
		super("Coma", COMA_ITEMS,1);
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
		Random rand = new Random();
		int i = rand.nextInt(100);
		if((i <= lv || lv >= 100) && i > 0)
		{
			target.setHealth(1);
			if(target instanceof Player)
			{
				Player p = (Player)target;
				p.setFoodLevel(1);
			}			
		}
	}
}
