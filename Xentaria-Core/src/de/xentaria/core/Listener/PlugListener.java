package de.xentaria.core.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.xentaria.core.Main;

public class PlugListener implements Listener {
	
	
	@EventHandler
	public void onPlug(PlayerCommandPreprocessEvent e){
			Player p = (Player) e.getPlayer();
			String cmd = e.getMessage();
			
			
			if (cmd.equalsIgnoreCase("/plugins") || cmd.equalsIgnoreCase("/pl")) {
				if (!(p.hasPermission("xentaria.commands.plug"))){
					e.setCancelled(true);
					p.sendMessage("Test");
				} else {
					e.setCancelled(false);
				}
			}
		}
}
