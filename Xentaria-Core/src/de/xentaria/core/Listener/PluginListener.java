package de.xentaria.core.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.md_5.bungee.api.ChatColor;

public class PluginListener implements Listener {
	
	
	@EventHandler
	public void onPlugin(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		String cmd = e.getMessage();
		
		if(cmd.equalsIgnoreCase("/plugins") || cmd.equalsIgnoreCase("/pl")){
			if(!(p.hasPermission("xentaria.reload"))){
				e.setCancelled(true);
				p.sendMessage(ChatColor.WHITE + "Plugins (5): " + ChatColor.GREEN + "Xentaria-Core" + ChatColor.WHITE + ", " + ChatColor.GREEN + "Xentaria-Econ" + ChatColor.WHITE + ", " + ChatColor.GREEN + "Xentaria-Permission" + ChatColor.WHITE + ", " + ChatColor.GREEN + "Xentaria-NPC" + ChatColor.WHITE + ", " + ChatColor.GREEN + "Xentaria-Regions");
			} else {
			}
		}
	}

}
