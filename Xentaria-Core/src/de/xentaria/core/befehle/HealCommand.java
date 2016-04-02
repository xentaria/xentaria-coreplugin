package de.xentaria.core.befehle;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;

public class HealCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player p = (Player)cs;

			if (!(p.hasPermission("xentaria.heal"))) {
				p.sendMessage(Main.pre + "Dafür fehlen dir die Berechtigungen!");
				return true;
			} else {
				if (args.length == 0) {
					p.setHealth(20.0);
					p.sendMessage(Main.pre + "Du hast dich geheilt.");
					return true;
				} else if (args.length == 1 || p.hasPermission("xentaria.heal.others")) {
					Player spieler = Bukkit.getPlayer(args[0]);
					spieler.setHealth(20.0);
					spieler.sendMessage(Main.pre + "Du wurdest geheilt!");
					p.sendMessage(Main.pre + "Du hast " + spieler.getName() + " geheilt!");
					return true;
				} else {
					p.sendMessage(Main.pre + "Der Befehl ist falsch. Benutze /heal [Spieler].");
				}
				
			}
		
		return true;
	}

}
