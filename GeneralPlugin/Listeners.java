package mc.harish.one;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import java.util.Random;


public class Listeners implements Listener{
	
	
	
	
	
	@EventHandler
	public void playerKill(PlayerDeathEvent e) {
		
		Player victim = ((Player) e).getPlayer();
		Player killer = ((Player)e).getKiller();
		
		killer.sendMessage("You sent " + victim.getDisplayName() + " to the Gulag! ");
		killer.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 30));
		
		String s = "You killed " + victim.getName();
		String n = "Nice Bakuretsu";
	    TitleAPI.sendTitle(killer, 20, 40, 20, s, n );
	    
	    victim.sendMessage("You were sent to horny jail by " + killer.getDisplayName());
	    
	    if(victim.getName().equals("DaddyThanosTHICC")) {
	    	killer.sendMessage("How dare you kill your indian friend :(");
	    }
	 
	}
	
	
	
	
	
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		
		Player victim = ((Player)e).getPlayer();
	//	victim.sendMessage("hello there ya degenerate");
		
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookMeta = (BookMeta) book.getItemMeta();
		
		bookMeta.setTitle("The constitution of the United States of Degeneracy ( UWU )");
		
		victim.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 10));
		victim.getInventory().addItem(book);	
	}
	
	
	
	
	
	
	
	@EventHandler
	public void onElytraGet(PlayerInteractEvent e) {
		Action action = e.getAction();
		
		if(action == Action.LEFT_CLICK_BLOCK){
			
		       Block block = e.getClickedBlock();
		       
		       if(block instanceof ItemFrame){
		    	   
		    	   ItemFrame itemFrame = (ItemFrame) block;
		    	   
		           if(itemFrame.getItem().getType().toString().equals("ELYTRA")) {
		        	   
		        	   e.getPlayer().sendMessage("Take to the Skies with your new weeb wings!");
		        	   
		           }
		        }
		     }
		
		
		
	}
	
	
	
	
	
	
	
	@EventHandler
	public static void shhhhhh(EntityDeathEvent e) {
		if (e.getEntity() instanceof Shulker) {
			
			Player killer = ((Player)e).getKiller();
			
			if (killer.getName().equals("DaddyThanosTHICC") || killer.getName().equals("KazooKidFTW")) {
				
			killer.getInventory().addItem(new ItemStack(Material.SHULKER_SHELL, 1));
			
			}
		}
	}
	
	
	
	
	
	
	@EventHandler
	public static void onEnderDragonDeath(EntityDeathEvent e) {
		
		if (e.getEntity() instanceof EnderDragon) {
			
			Player killer = ((Player)e).getKiller();
			
			killer.sendMessage("Congratulations! You dealt the final blow to the dragon");
			killer.setLevel(killer.getLevel() + 30);
			
		}
	}
	
	
	
	
	
	
	@EventHandler
	public static void onWitherDeath(EntityDeathEvent e) {
		Random rand = new Random(); 
		if (e.getEntity() instanceof Wither) {
			
			
			Player killer = ((Player)e).getKiller();
			killer.sendMessage("Congratulations! You dealt the final blow to the wither. Here are some spoils of war for you");
			killer.getInventory().addItem(new ItemStack(Material.WITHER_ROSE,1));
			
			
			int rand_int1 = rand.nextInt(4);
			
			
			if(rand_int1 == 2) {
			killer.sendMessage("Woah! Looks like you got lucky today... (hint, check your inventory)");
			killer.getInventory().addItem(new ItemStack(Material.WITHER_SKELETON_SKULL,1));
			}
			
			
			int rand_int2 = rand.nextInt(100);
			
			
			if(rand_int2 == 21) {
			killer.sendMessage("Today's your lucky day! Another day, another wither...(hint, check your inventory)");
			killer.getInventory().addItem(new ItemStack(Material.WITHER_SKELETON_SKULL,3));
			}
			
			
			int rand_int3 = rand.nextInt(250);
			
			
			if(rand_int3 == 83) {
			killer.sendMessage("Jackpot! Looks like you won't be in need of any diamonds...(hint, check your inventory)");
			killer.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK,7));	
			
			}
		}
	}
	
	
	
	
	
	
	@EventHandler
	public static void onElderGuardianDeath(EntityDeathEvent e) {
		
		if (e.getEntity() instanceof ElderGuardian) {
			
			Player killer = ((Player)e).getKiller();
			
			killer.sendMessage("RIP Elder Guardian");
			killer.getInventory().addItem(new ItemStack(Material.NETHERITE_SCRAP,1));
			
		}
		
	}
	
	
	
	
	
    @EventHandler
    public static void onWitchDeath(EntityDeathEvent e){
    	Random rand = new Random();
   
			
			Player killer = ((Player)e).getKiller();
			
			
			killer.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 10));
			
		
    }
    
    
	
	
	
	
	
	

}