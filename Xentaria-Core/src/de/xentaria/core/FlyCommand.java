package de.xentaria.core;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player) cs;
		
		if(!(cs instanceof Player)) {
			p.sendMessage(Main.noplayer);
			return true;
		}
		if (!(p.hasPermission("xentaria.fly"))){
			p.sendMessage(Main.noperm);
			return true;
		}
		if (args.length == 0){
			if (p.getAllowFlight()) {
				p.setAllowFlight(false);
				p.setFlying(false);
				
				p.sendMessage(Main.pre + "Dein Flugmodus wurde ausgeschaltet!");
			} else {
				p.setAllowFlight(true);
				p.sendMessage(Main.pre + "Dein Flugmodus wurde eingeschaltet!");
			}
		}else if (args.length == 1) {
			Player spieler = Bukkit.getPlayer(args[0]);
			
			if(spieler.getAllowFlight()){
				spieler.setAllowFlight(false);
				spieler.setFlying(false);
				spieler.sendMessage(Main.pre + "Dein Flugmodus wurde von " + p.getName() + " ausgeschaltet!");
				p.sendMessage(Main.pre + "Du hast den Flugmodus von " + spieler.getName() + " ausgeschaltet!");
			} else {
				spieler.setAllowFlight(true);
				spieler.sendMessage(Main.pre + "Dein Flugmodus wurde von " + p.getName() + " eingeschaltet!");
				p.sendMessage(Main.pre + "Du hast den Flugmodus von " + spieler.getName() + " eingeschaltet!");
			}
			
		}
		
		return true;
	}

}
