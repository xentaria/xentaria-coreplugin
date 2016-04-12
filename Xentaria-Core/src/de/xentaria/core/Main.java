package de.xentaria.core;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import de.xentaria.core.Befehle.ChatClear;
import de.xentaria.core.Befehle.FlyCommand;
import de.xentaria.core.Befehle.GameMode;
import de.xentaria.core.Befehle.HealCommand;
import de.xentaria.core.Befehle.HelpCmd;
import de.xentaria.core.Befehle.SpeedCommand;
import de.xentaria.core.Befehle.TpCommand;
import de.xentaria.core.Befehle.WetterCommand;
import de.xentaria.core.Listener.GamemodeEvent;
import de.xentaria.core.Listener.Joinlistener;
import de.xentaria.core.Listener.PlugListener;
import de.xentaria.core.Listener.PluginListener;
import de.xentaria.core.Listener.ReloadNachricht;
import de.xentaria.core.Manager.Warpmanager;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin{

	public static String pre = "§7[§4Xentaria.de§7] §b";
	public static String farbe = "§b ";
	public static String noperm = pre + "§bDafür hast du keine Berechtigungen!";
	public static String noplayer = "Du bist eine Konsole. Die darf das nicht :/";
	public static Permission permission = null;
		
		
	
    private boolean vault;

	
	public static Warpmanager wmgr;
	
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
		
		//Warpmanager laden
		//wmgr = new Warpmanager("warps.db", this);
		
		if(!setupPermissions()){
			System.out.println("[Xentaria.de] Das Plugin benötigt Vault!");
			Bukkit.getPluginManager().disablePlugin(this);
		}
		
		
		
		this.vault = (Bukkit.getPluginManager().getPlugin("Vault") != null);
		System.out.println("[Xentaria.de] Das Plugin wurde aktiviert");
	    
		
		PluginManager pm = Bukkit.getPluginManager();
		//pm.registerEvents(new PluginListener(), this);
		pm.registerEvents(new ReloadNachricht(), this);
		pm.registerEvents(new HelpCmd(), this);
		pm.registerEvents(new Joinlistener(), this);
		pm.registerEvents(new GamemodeEvent(), this);
		pm.registerEvents(new PlugListener(), this);
		
		getCommand("cc").setExecutor(new ChatClear());
		//getCommand("setspawn").setExecutor(new Setspawn());
		//getCommand("spawn").setExecutor(new Spawn());
		getCommand("gamemode").setExecutor(new GameMode());
		//getCommand("home").setExecutor(new HomeCommand());
		//getCommand("sethome").setExecutor(new SethomeCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("sun").setExecutor(new WetterCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("speed").setExecutor(new SpeedCommand());
		getCommand("teleport").setExecutor(new TpCommand());
		//getCommand("warp").setExecutor(new WarpCommand());
		//getCommand("setwarp").setExecutor(new SetwarpCommand());
		//getCommand("delwarp").setExecutor(new DelwarpCommand());
		
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
	   
	   private boolean setupPermissions()
	    {
	        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	        if (permissionProvider != null) {
	            permission = permissionProvider.getProvider();
	        }
	        return (permission != null);
	    }
	   
}
