package ml.pkom.skwindow;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;

public class Mod extends JavaPlugin {

    public final String MOD_ID = "skwindow";
    public final String MOD_NAME = "SkWindow";
    public final String MOD_VER = "1.0.0";
    public final String MOD_AUT = "Pitan_MAD";

    private SkriptAddon addon;

    @Override
    public void onEnable()
    {
        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("ml.pkom.skwindow", "lang");
            getLogger().info(MOD_NAME + " is loaded!");;
        } catch (IOException e) {
            getLogger().info(MOD_NAME + " is not loaded!");
        }
        getLogger().info(MOD_NAME + " is enabled!");

    }

    @Override
    public void onDisable()
    {
        getLogger().info(MOD_NAME + " is disabled!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("skwindow")){
        	sender.sendMessage("§a" + MOD_NAME + " " + MOD_VER);
            return true;
        }
        return false;
    }

    public Mod getInstance(){
        return this;
    }

    public SkriptAddon getAddonInstance(){
        return addon;
    }

}