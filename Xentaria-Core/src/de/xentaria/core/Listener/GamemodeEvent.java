package de.xentaria.core.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.xentaria.core.Main;

public class GamemodeEvent implements Listener {
	
	
	@EventHandler
	public void onInvetoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("Gamemodeauswahl")){
			if(e.getCurrentItem().getType() == Material.GRASS){
				 p.setGameMode(org.bukkit.GameMode.SURVIVAL);
				 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
				 p.closeInventory();
			} else if (e.getCurrentItem().getType() == Material.DIAMOND){
				 p.setGameMode(org.bukkit.GameMode.CREATIVE);
				 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
				 p.closeInventory();
			} else if (e.getCurrentItem().getType() == Material.IRON_SWORD){
				 p.setGameMode(org.bukkit.GameMode.ADVENTURE);
				 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
				 p.closeInventory();
			} else if (e.getCurrentItem().getType() == Material.GLASS_BOTTLE){
				 p.setGameMode(org.bukkit.GameMode.SPECTATOR);
				 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
				 p.closeInventory();
			} else {
				p.closeInventory();
				}
		}
		
	}


}
