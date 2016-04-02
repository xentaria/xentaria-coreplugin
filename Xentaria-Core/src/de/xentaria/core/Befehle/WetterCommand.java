package de.xentaria.core.Befehle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;

public class WetterCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player p = (Player) cs;
		
		if (!(p.hasPermission("xentaria.weather"))){
			p.sendMessage(Main.pre + "Daf�r hast du keine Berechtigungen!");
			return true;
		} else {
			if (label.equalsIgnoreCase("sun")) {
				p.getWorld().setStorm(false);
				p.getWorld().setThundering(false);
				p.sendMessage(Main.pre + "Du hast das Wetter auf sonnig gestellt!");
				return true;
			} else if (label.equalsIgnoreCase("rain")) {
				p.getWorld().setStorm(true);
				p.getWorld().setThundering(false);
				p.sendMessage(Main.pre + "Du hast das Wetter auf regnerisch ge�ndert!");
				return true;
			} else if (label.equalsIgnoreCase("storm")) {
				p.getWorld().setStorm(true);
				p.getWorld().setThundering(true);
				p.sendMessage(Main.pre + "Du hast ein Gewitter ausgel�st!");
				return true;
			} else {
				p.sendMessage(Main.pre + "Falsche Benutzung. M�gliche Befehle: Sun, Rain, Storm.");
				return true;
			}
		}
	}

}
