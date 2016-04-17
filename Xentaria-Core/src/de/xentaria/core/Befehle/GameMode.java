package de.xentaria.core.Befehle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import de.xentaria.core.Main;

public class GameMode implements Listener,CommandExecutor {
			
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		if (cs instanceof ConsoleCommandSender) {
			return true;
		} else {
			Player p = (Player) cs;
			
			if(!(p.hasPermission("xentaria.gamemode"))) {
				p.sendMessage(Main.noperm);
				return true; 
			} else {
				if (args.length == 0) {
					Inventory inv = Bukkit.createInventory(null, 27, ChatColor.AQUA + "Gamemodeauswahl");
					
					ItemStack survival = new ItemStack(Material.GRASS);
					ItemMeta survivalMeta = survival.getItemMeta();
					ItemStack creative = new ItemStack(Material.DIAMOND);
					ItemMeta creativeMeta = creative.getItemMeta();
					ItemStack adventure = new ItemStack(Material.IRON_SWORD);
					ItemMeta adventureMeta = adventure.getItemMeta();
					ItemStack spectator = new ItemStack(Material.GLASS_BOTTLE);
					ItemMeta spectatorMeta = spectator.getItemMeta();
					
					survivalMeta.setDisplayName(ChatColor.AQUA + "Survivalmode");
					survival.setItemMeta(survivalMeta);
					
					creativeMeta.setDisplayName(ChatColor.AQUA + "Kreativmode");
					creative.setItemMeta(creativeMeta);
					
					adventureMeta.setDisplayName(ChatColor.AQUA + "Adventuremode");
					adventure.setItemMeta(adventureMeta);
					
					spectatorMeta.setDisplayName(ChatColor.AQUA + "Spectatormode");
					spectator.setItemMeta(spectatorMeta);
					
					// 012345678
					//
					inv.setItem(10, survival);
					inv.setItem(12, creative);
					inv.setItem(14, adventure);
					inv.setItem(16, spectator);
					
					p.openInventory(inv);
					
					//PluginManager pm = Bukkit.getPluginManager();
					//pm.registerEvents(new GamemodeEvent(), (Plugin) this);

					return true;
				} else if (args.length == 1) {
					 if (args[0].equalsIgnoreCase("1") || args[0].contains("crea") || args[0].contains("krea") || args[0].equalsIgnoreCase("c")){
						 p.setGameMode(org.bukkit.GameMode.CREATIVE);
						 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("2") || args[0].contains("advent") || args[0].equalsIgnoreCase("a")){
						 p.setGameMode(org.bukkit.GameMode.ADVENTURE);
						 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("surv") || args[0].equalsIgnoreCase("s")) {
						 p.setGameMode(org.bukkit.GameMode.SURVIVAL);
						 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("sp"))  {
						 p.setGameMode(org.bukkit.GameMode.SPECTATOR);
						 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 return true;
					 }
					
				} else if (args.length == 2 && p.hasPermission("xentaria.gamemode.others")){
					
					Player spieler = Bukkit.getPlayer(args[1]);
					 if (args[0].equalsIgnoreCase("1") || args[0].contains("crea") || args[0].contains("krea") || args[0].equalsIgnoreCase("c")){
						 spieler.setGameMode(org.bukkit.GameMode.CREATIVE);
						 spieler.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 p.sendMessage(Main.pre + "Du hast den Gamemode von " + spieler.getName() + " geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("2") || args[0].contains("advent") || args[0].equalsIgnoreCase("a")) {
						 spieler.setGameMode(org.bukkit.GameMode.ADVENTURE);
						 spieler.sendMessage(Main.pre + "Dein Gamemode wurde geändert!"); 
						 p.sendMessage(Main.pre + "Du hast den Gamemode von " + spieler.getName() + " geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("surv") || args[0].equalsIgnoreCase("s")) {
						 spieler.setGameMode(org.bukkit.GameMode.SURVIVAL);
						 spieler.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 p.sendMessage(Main.pre + "Du hast den Gamemode von " + spieler.getName() + " geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("sp")) {
						 spieler.setGameMode(org.bukkit.GameMode.SPECTATOR);
						 spieler.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 p.sendMessage(Main.pre + "Du hast den Gamemode von " + spieler.getName() + " geändert!");
						 return true;
					 }
					
				}
			}
			
		}
		
		
		
		return true;
	}
	
	public GameMode(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	} 
	
	@EventHandler
    public void onPlayerInventoryClick(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
        if (e.getInventory() == null) return;
        if (e.getInventory().getTitle().equalsIgnoreCase( ChatColor.AQUA + "Gamemodeauswahl")){
            ItemStack itemStack = e.getCurrentItem();
            if (itemStack.getItemMeta().getDisplayName() != null){
                if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Kreativmode")){
                    e.getWhoClicked().setGameMode(org.bukkit.GameMode.CREATIVE);
                    e.getWhoClicked().sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
                } else if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Survivalmode")){
                    e.getWhoClicked().setGameMode(org.bukkit.GameMode.SURVIVAL);
                    e.getWhoClicked().sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
                } else if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Adventuremode")){
                	e.getWhoClicked().setGameMode(org.bukkit.GameMode.ADVENTURE);
                	e.getWhoClicked().sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
                } else if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Spectatormode")){
                	e.getWhoClicked().setGameMode(org.bukkit.GameMode.SPECTATOR);
                	e.getWhoClicked().sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
                }
            }
        }
	}
	
}
