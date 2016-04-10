package de.xentaria.core.Befehle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;
import de.xentaria.core.Manager.Warpmanager;

public class DelwarpCommand implements CommandExecutor {

	Warpmanager wmgr;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player p = (Player) cs;
		
		if(args.length != 1) {
			return false;
		}
		
		wmgr.removeWarp(args[0]);
		p.sendMessage(Main.pre + "Warp-Punkt " + args[0] + " entfernt.");
		
		return false;
	}

}
