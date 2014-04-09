package me.suzutsuki.iEnchant;

import java.util.ArrayList;

import me.suzutsuki.iEnchant.PassiveEffect.SlownessEnchantment;
import me.suzutsuki.iEnchant.StatusAilment.BlindEnchantment;
import me.suzutsuki.iEnchant.StatusAilment.ComaEnchantment;
import me.suzutsuki.iEnchant.StatusAilment.CurseEnchantment;
import me.suzutsuki.iEnchant.StatusAilment.SnareEnchantment;
import me.suzutsuki.iEnchant.StatusAilment.WitherEnchantment;

import com.rit.sucy.CustomEnchantment;
import com.rit.sucy.EnchantPlugin;
import com.rit.sucy.EnchantmentAPI;

public class iEnchant extends EnchantPlugin{

	public ArrayList<CustomEnchantment> Enchantments = new ArrayList<CustomEnchantment>();
	@Override
    public void registerEnchantments() {
        Enchantments.add(new LifestealEnchantment());
        Enchantments.add(new BlindEnchantment());
        Enchantments.add(new ComaEnchantment());
        Enchantments.add(new CurseEnchantment());
        Enchantments.add(new SnareEnchantment());
        Enchantments.add(new SlownessEnchantment());
        Enchantments.add(new WitherEnchantment());
    }
	
	@Override
	public void onDisable()
	{
		for(CustomEnchantment ce : Enchantments)
		{
			EnchantmentAPI.unregisterCustomEnchantment(ce.name());
		}
	}
}
