package de.xentaria.core.listener;

import java.io.IOException;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.xentaria.core.Main;

public class Joinlistener implements Listener {
	

	
	public void onPlayerjoin(PlayerJoinEvent j) {
		Player p = j.getPlayer();
	      if(!Main.existPlayerFile(p.getUniqueId())) {
	         try {
	            Main.getPlayerFile(p.getUniqueId()).createNewFile(); //<---Zeile 39 im PlayerJoinEvent
	         } catch(IOException ioe) {
	            ioe.printStackTrace();
	         }
	         
	      }
	}
}
