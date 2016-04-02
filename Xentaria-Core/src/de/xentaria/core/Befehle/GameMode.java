package de.xentaria.core.Befehle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import de.xentaria.core.Main;

public class GameMode implements CommandExecutor {

		
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		if (cs instanceof ConsoleCommandSender) {
			return true;
		} else {
			Player p = (Player) cs;
			
			if(!(p.hasPermission("xentaria.gamemode"))) {
				p.sendMessage(Main.noperm);
				return true; 
			} else {
				if (args.length == 0) {
					p.sendMessage(Main.pre + "Zu wenig Argumente!");
					return true;
				} else if (args.length == 1) {
					 if (args[0].equalsIgnoreCase("1") || args[0].contains("crea") || args[0].contains("krea") || args[0].equalsIgnoreCase("c")){
						 p.setGameMode(org.bukkit.GameMode.CREATIVE);
						 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("2") || args[0].contains("advent") || args[0].equalsIgnoreCase("a")){
						 p.setGameMode(org.bukkit.GameMode.ADVENTURE);
						 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("surv") || args[0].equalsIgnoreCase("s")) {
						 p.setGameMode(org.bukkit.GameMode.SURVIVAL);
						 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("sp"))  {
						 p.setGameMode(org.bukkit.GameMode.SPECTATOR);
						 p.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 return true;
					 }
					
				} else if (args.length == 2 && p.hasPermission("xentaria.gamemode.others")){
					
					Player spieler = Bukkit.getPlayer(args[1]);
					 if (args[0].equalsIgnoreCase("1") || args[0].contains("crea") || args[0].contains("krea") || args[0].equalsIgnoreCase("c")){
						 spieler.setGameMode(org.bukkit.GameMode.CREATIVE);
						 spieler.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 p.sendMessage(Main.pre + "Du hast den Gamemode von " + spieler.getName() + " geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("2") || args[0].contains("advent") || args[0].equalsIgnoreCase("a")) {
						 spieler.setGameMode(org.bukkit.GameMode.ADVENTURE);
						 spieler.sendMessage(Main.pre + "Dein Gamemode wurde geändert!"); 
						 p.sendMessage(Main.pre + "Du hast den Gamemode von " + spieler.getName() + " geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("surv") || args[0].equalsIgnoreCase("s")) {
						 spieler.setGameMode(org.bukkit.GameMode.SURVIVAL);
						 spieler.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 p.sendMessage(Main.pre + "Du hast den Gamemode von " + spieler.getName() + " geändert!");
						 return true;
					 } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("sp")) {
						 spieler.setGameMode(org.bukkit.GameMode.SPECTATOR);
						 spieler.sendMessage(Main.pre + "Dein Gamemode wurde geändert!");
						 p.sendMessage(Main.pre + "Du hast den Gamemode von " + spieler.getName() + " geändert!");
						 return true;
					 }
					
				}
			}
			
		}
		

		
		return true;
	}

}
