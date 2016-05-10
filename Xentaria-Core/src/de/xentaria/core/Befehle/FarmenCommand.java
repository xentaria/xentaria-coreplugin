package de.xentaria.core.Befehle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;

public class FarmenCommand implements CommandExecutor {

	private String welt = "freefarm";
	private String begruessung = Main.pre + "Viel Spaﬂ beim Farmen!";
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player p = (Player) cs;
		
		if(!(p.hasPermission("xentaria.farming"))){
			p.sendMessage(Main.noperm);
			return true;
		} else {
			Location loc0 = new Location(Bukkit.getWorld(welt), -211, 66, 25);
			Location loc1 = new Location(Bukkit.getWorld(welt), -562, 86, 49);
			
			int zufallsspawn;
			zufallsspawn = (int) Math.random() * 3 + 1;
			if(p.hasPermission("xentaria.farming.debug")) {
				p.sendMessage("Die Zufallszahl war " + zufallsspawn);
				
			}
			if (zufallsspawn == 1) {
				p.teleport(loc0);
				p.sendMessage(begruessung);
				return true;
			} else if ( zufallsspawn == 2) {
				p.teleport(loc1);
				p.sendMessage(begruessung);
				return true;
			} else {
				p.sendMessage(Main.pre + "Versuche es bitte noch einmal :)!");
				return true;
			}
		}
	}

}
