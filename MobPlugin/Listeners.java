// 
// Decompiled by Procyon v0.5.36
// 

package com.dreams;

import org.bukkit.event.EventHandler;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.Listener;

public class Listeners implements Listener
{
    @EventHandler
    public void creatureSpawn(final CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            final Creeper creeper = (Creeper)event.getEntity();
            creeper.setPowered(true);
        }
        if (event.getEntityType() == EntityType.ZOMBIE) {
            final Zombie zombie = (Zombie)event.getEntity();
            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        }
        if (event.getEntityType() == EntityType.SKELETON) {
            final Skeleton skeleton = (Skeleton)event.getEntity();
            skeleton.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            skeleton.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            final ItemStack punchBow = new ItemStack(Material.BOW);
            punchBow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
            skeleton.getEquipment().setItemInMainHand(punchBow);
            
        }
    }
    
    
    
    
    
    @EventHandler
    public void playerKill(PlayerDeathEvent e) {
    		
    		Player victim = ((Player)e).getPlayer();
    		Player killer = ((Player)e).getKiller();
    		
    		killer.sendMessage("You sent " + victim.getDisplayName() + " to the Gulag! ");
    		killer.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 30));
    	   
    	    
    	    victim.sendMessage("You were sent to horny jail by " + killer.getDisplayName());
    	    
    	    if(victim.getName().equals("DaddyThanosTHICC")) {
    	    	killer.sendMessage("How dare you kill your indian friend :(");
    	    }
    	 
    	}
        
        @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
    		
    		Player victim = ((Player)e).getPlayer();
    	//	victim.sendMessage("hello there ya degenerate");
    		victim.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 10));
    		
    	}
        
}
