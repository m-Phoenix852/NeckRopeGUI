package com.ThunderKofy.Events;

import com.ThunderKofy.NeckRopeGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class SuicideSelectEvent implements Listener {
    private Plugin plugin;
    public SuicideSelectEvent(NeckRopeGUI plugin) {this.plugin = plugin;}
    @EventHandler
    public void onMenuSelect(InventoryClickEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Suicidal Menu")) {
            Player p = (Player) e.getWhoClicked();
            switch (e.getCurrentItem().getType()) {
                case LEAD:
                    if(!p.hasPermission("Suicide.normal")) {
                        p.closeInventory();
                        p.sendMessage(ChatColor.RED + "You are not permitted to use the \"normal\" suicide!");
                        break;
                    }
                    if(!plugin.getConfig().getBoolean("suicides.normal")){
                        p.closeInventory();
                        p.sendMessage(ChatColor.RED + "\"Normal\" suicide is not enabled!");
                        break;
                    }
                    p.setHealth(0.0);
                    Bukkit.broadcastMessage(plugin.getConfig().getString("suicide-message.normal").replaceAll("%PLAYER%", p.getName()));
                    break;
                case TRIDENT:
                    if(!p.hasPermission("Suicide.ligtning")) {
                        p.closeInventory();
                        p.sendMessage(ChatColor.RED + "You are not permitted to use the \"lightning\" suicide!");
                        break;
                    }
                    if(!plugin.getConfig().getBoolean("suicides.lightning")){
                        p.closeInventory();
                        p.sendMessage(ChatColor.RED + "\"Lightning\" suicide is not enabled!");
                        break;
                    }
                    p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                    p.setHealth(0.0);
                    Bukkit.broadcastMessage(plugin.getConfig().getString("suicide-message.lightning").replaceAll("%PLAYER%", p.getName()));
                    break;
                case FLINT_AND_STEEL:
                    if(!p.hasPermission("Suicide.burn")) {
                        p.closeInventory();
                        p.sendMessage(ChatColor.RED + "You are not permitted to use the \"burn\" suicide!");
                        break;
                    }
                    if(!plugin.getConfig().getBoolean("suicides.burn")){
                        p.closeInventory();
                        p.sendMessage(ChatColor.RED + "\"Burn\" suicide is not enabled!");
                        break;
                    }
                    p.setFireTicks(100);
                    p.setHealth(0.0);
                    Bukkit.broadcastMessage(plugin.getConfig().getString("suicide-message.burn").replaceAll("%PLAYER%", p.getName()));
                    break;
            }
            e.setCancelled(true);
            p.closeInventory();
        }
    }
}
