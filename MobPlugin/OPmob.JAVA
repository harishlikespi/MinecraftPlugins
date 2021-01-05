// 
// Decompiled by Procyon v0.5.36
// 

package com.dreams;

import org.bukkit.plugin.Plugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import com.dreams.Listeners;



import org.bukkit.plugin.java.JavaPlugin;

public class OPmob extends JavaPlugin implements Listener
{
    private static OPmob instance;
    
    public static OPmob getInstance() {
        return OPmob.instance;
    }
    
    
    
    public void onEnable() {
        OPmob.instance = this;
        this.getServer().getPluginManager().registerEvents((Listener)new Listeners(), (Plugin)this);
    }
    
 
    public void onDisable() {
        OPmob.instance = null;
    }
}
