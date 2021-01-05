package test;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


import net.md_5.bungee.api.ChatColor;

public class test extends JavaPlugin implements Listener  {
  @Override
  public void onEnable() {
	  
  }
  
  @Override
  public void onDisable() {
	  
  }
  
  
 
  
 
	  @EventHandler
	    public void onDeath(PlayerDeathEvent e){
		  
	        Player p = e.getEntity().getKiller();
	        Player player = e.getEntity();
	   
	      if(e.getEntity().getKiller() instanceof Player){
	          p.sendMessage(ChatColor.GOLD + "+1 kill");
	      }else if(player instanceof Player){
	          player.sendMessage("Test");
	      }
		  
	    }
  
  
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ) {
	  // /godboots
	  sender.sendMessage("If you're seeing this, then Zero Two is best girl");
	  if (label.equalsIgnoreCase("godboots")) {
		  if(!(sender instanceof Player)){
			  sender.sendMessage("Sorry no console commands allowed");
			  return true;
		  }
		  Player player = (Player) sender;
		  if (player.getInventory().firstEmpty() == -1) {
			  Location loc = player.getLocation();
			  World world = player.getWorld();
			  world.dropItemNaturally(loc, getItem());
			  player.sendMessage(ChatColor.GOLD + "The Gods have blessed you with something nearby");
		  }
		  player.getInventory().addItem(getItem());
		  player.sendMessage(ChatColor.GOLD + "The Gods have blessed you");
		  return true;
	  }
	return false;
	  
  }
  public void event(EntitySpawnEvent e) {
	  Creeper creeper = (Creeper) e.getEntity();
	  if (e.getEntityType() == EntityType.CREEPER) {
		  	creeper.explode();	  
	  }
  }
  public ItemStack getItem() {
	  ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
	  ItemMeta meta = boots.getItemMeta();
	  meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boots of Leaping");
	  List<String> lore = new ArrayList<String>();
	  lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Boots made for gods");
	  meta.setLore(lore);
	  meta.addEnchant(Enchantment.PROTECTION_FALL, 100, true);
	  meta.addEnchant(Enchantment.FROST_WALKER, 1, true);	
	  meta.addEnchant(Enchantment.THORNS, 15, true);
	  meta.setUnbreakable(true);
	  boots.setItemMeta(meta);
	  
	  return boots;
  }
   
}
