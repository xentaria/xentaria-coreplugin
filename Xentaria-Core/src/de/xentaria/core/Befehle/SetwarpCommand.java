package de.xentaria.core.Befehle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;
import de.xentaria.core.Manager.Warpmanager;

public class SetwarpCommand implements CommandExecutor {

	Warpmanager wmgr;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player p = (Player) cs;
		
		if(args.length != 1) {
			return false;
		}
		
		if(wmgr.addWarp(args[0], p.getLocation()) == 1){
			p.sendMessage(Main.pre + "Ein Warp-Punkt mit dem Namen " + args[0] + " existiert bereits.");
		} else {
			p.sendMessage(Main.pre + "Warp-Punkt wurde erstell: " + args[0] + ".");
		}
		
		
		
		return true;
	}

}
