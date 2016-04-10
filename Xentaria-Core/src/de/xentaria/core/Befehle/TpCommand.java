package de.xentaria.core.Befehle;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;

public class TpCommand implements CommandExecutor {

	String x;
	String y;
	String z;
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player p = (Player)cs;
		
		if(!(p instanceof Player)) {
			p.sendMessage(Main.noplayer);
			return true;
		}
		
		if(!p.hasPermission("xentaria.tp")){
			p.sendMessage(Main.noperm);
			return true;
		} else if(args.length == 0){
			Player spieler = Bukkit.getPlayer(args[0]);
			double x = spieler.getLocation().getX();
			double y = spieler.getLocation().getY();
			double z = spieler.getLocation().getZ();
			double yaw = spieler.getLocation().getYaw();
			
			p.
			
			}
		}
		
		
		return true;
	}

}
