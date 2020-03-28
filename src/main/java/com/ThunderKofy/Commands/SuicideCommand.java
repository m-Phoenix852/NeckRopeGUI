package com.ThunderKofy.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;

public class SuicideCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!sender.hasPermission("NeckRopeGUI.suicide")) return true;

            Inventory suicideGui = Bukkit.createInventory(player, 9, ChatColor.RED + "Suicidal Menu");

            // Normal suicide.
            ItemStack normalSuicide = new ItemStack(Material.LEAD);
            ItemMeta normalSuicideMeta = normalSuicide.getItemMeta();
            normalSuicideMeta.setDisplayName(ChatColor.GREEN + "Normal");
            ArrayList<String> normalSuicideLore = new ArrayList<String>();
            normalSuicideLore.add(ChatColor.GOLD + "Click to commit a normal suicide.");
            normalSuicideMeta.setLore(normalSuicideLore);
            normalSuicide.setItemMeta(normalSuicideMeta);

            // Lightning suicide
            ItemStack lightningSuicide = new ItemStack(Material.TRIDENT);
            ItemMeta lightningSuicideMeta = lightningSuicide.getItemMeta();
            lightningSuicideMeta.setDisplayName(ChatColor.GREEN + "Lightning");
            ArrayList<String> lightningSuicideLore = new ArrayList<String>();
            lightningSuicideLore.add(ChatColor.GOLD + "Click to smite yourself.");
            lightningSuicideMeta.setLore(lightningSuicideLore);
            lightningSuicide.setItemMeta(lightningSuicideMeta);

            // Burn suicide
            ItemStack burnSuicide = new ItemStack(Material.FLINT_AND_STEEL);
            ItemMeta burnSuicideMeta = burnSuicide.getItemMeta();
            burnSuicideMeta.setDisplayName(ChatColor.GREEN + "Burn");
            ArrayList<String> burnSuicideLore = new ArrayList<String>();
            burnSuicideLore.add(ChatColor.GOLD + "Click to roast yourself like a chicken.");
            burnSuicideMeta.setLore(burnSuicideLore);
            burnSuicide.setItemMeta(burnSuicideMeta);


            // ------------------------------------------------------------------


            ItemStack[] gui = {normalSuicide, lightningSuicide, burnSuicide};
            suicideGui.setContents(gui);

            player.openInventory(suicideGui);
        } else {
            sender.sendMessage(ChatColor.RED + "[Error] Only players can run this command!");
            return true;
        }
        return true;
    }
}
