package de.xentaria.core.Befehle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import net.milkbowl.vault.*;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.permissions.Permission;

import de.xentaria.core.Main;

public class HelpCmd implements Listener {

	
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if(e.getMessage().startsWith("/help")) {
			e.setCancelled(true);
			p.sendMessage("§6----------<>----------");
			p.sendMessage("§9Server-Hilfe / Server-Befehle");
			p.sendMessage("§6----------<>----------");
			p.sendMessage("§7/help §8> §9Siehe diese Nachricht");
			p.sendMessage("§7/msg §8> §9Schreibe eine Private Nachricht");
			p.sendMessage("§6----------<>----------");
		}
		
		if (permission.))
	}
}
