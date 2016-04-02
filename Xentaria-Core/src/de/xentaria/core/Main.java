package de.xentaria.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.xentaria.core.befehle.ChatClear;
import de.xentaria.core.befehle.GameMode;
import de.xentaria.core.befehle.HealCommand;
import de.xentaria.core.befehle.Setspawn;
import de.xentaria.core.befehle.Spawn;
import de.xentaria.core.befehle.WetterCommand;
import de.xentaria.core.listener.HelpCmd;
import de.xentaria.core.listener.Joinlistener;
import de.xentaria.core.listener.ReloadNachricht;

public class Main extends JavaPlugin{

	public static String pre = "§7[§5Xentaria.de§7] §b";
	public static String farbe = "§b ";
	public static String noperm = pre + "§4Keine Rechte!";
	
	
	@Override
	public void onDisable() {
		
				
		System.out.println("[Xentaria.de] Das Plugin wurde deaktiviert!");
	}
	
	
	@Override
	public void onEnable(){
		
		new File("plugins/Xentaria").mkdirs();
		new File("plugins/Xentaria/Spieler").mkdirs();
		new File("plugins/Xentaria/Homes").mkdirs();
		new File("plugins/Xentaria/Spawns").mkdirs();
		new File("plugins/Xentaria/Permissions").mkdirs();
		new File("plugins/Xentaria/Money").mkdirs();
		new File("plugins/Xentaria", "Warps.yml");
			
		
		System.out.println("[Xentaria.de] Das Plugin wurde aktiviert");
	    
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ReloadNachricht(), this);
		pm.registerEvents(new HelpCmd(), this);
		pm.registerEvents(new Joinlistener(), this);
		
		getCommand("cc").setExecutor(new ChatClear());
		getCommand("setspawn").setExecutor(new Setspawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("gamemode").setExecutor(new GameMode());
		//getCommand("home").setExecutor(new HomeCommand());
		//getCommand("sethome").setExecutor(new SethomeCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("sun").setExecutor(new WetterCommand());
		getCommand("")
		
	}

	 public static File getPlayerFile(UUID arg0) {
	      File file = new File("plugins/Xentaria/Spieler", arg0.toString() + ".yml");
	      return file;
	   }
	   
	   public static YamlConfiguration getPlayerCfg(UUID arg0) {
	      YamlConfiguration playerscfg = YamlConfiguration.loadConfiguration(getPlayerFile(arg0));
	      return playerscfg;
	   }
	   
	   public static boolean existPlayerFile(UUID arg0) {
	      if(getPlayerFile(arg0).exists()) {
	         return true;
	      } else {
	         return false;
	      }
	   }
}
