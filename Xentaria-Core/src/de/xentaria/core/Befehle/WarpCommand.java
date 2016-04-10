package de.xentaria.core.Befehle;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;
import de.xentaria.core.Manager.Warpmanager;

public class WarpCommand implements CommandExecutor {

	Warpmanager wmgr;
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player p = (Player) cs;
		
		
		if (args.length != 1) {
			return false;
		}
		
		Location warpLocation = wmgr.getWarp(args[0]);
		
		if(warpLocation != null) {
			p.teleport(warpLocation);
		p.sendMessage(Main.pre + "Du hast dich zum Warp-Punkt " + args[0] + "teleportiert!");	
		return true;
		} else {
			p.sendMessage(Main.pre + "Warp-Punkt nicht gefunden!");
		}
		return true;
		
	}

}
