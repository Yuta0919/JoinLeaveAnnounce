package yuta0919.joinleaveannounce;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import yuta0919.joinleaveannounce.Event.JoinEvent;
import yuta0919.joinleaveannounce.Event.LeaveEvent;

public final class JoinLeaveAnnounce extends JavaPlugin {
public static FileConfiguration config;
public static String JoinedPlayerUUID;
public static String FirstJoinMessage;
public static String JoinMessage;
public static String LeaveMessage;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        saveDefaultConfig();
        config = getConfig();
        getConfigInfo();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        config.set("JoinMessage", JoinMessage);
        config.set("FirstJoinMessage",FirstJoinMessage);
        config.set("JoinedPlayer",JoinedPlayerUUID);
        saveConfig();
    }
    //configの内容を取得
    public static void getConfigInfo(){
        try {
            JoinedPlayerUUID = config.getString("JoinedPlayer");
        }catch (NullPointerException e){
            JoinedPlayerUUID = "";
        }
        try {
            FirstJoinMessage = config.getString("FirstJoinMessage");
        }catch (NullPointerException e){
            FirstJoinMessage = "$PlayerNameは初参加です";
        }
        try {
            JoinMessage = config.getString("JoinMessage");
        }catch (NullPointerException e){
            JoinMessage = "$PlayerNameが参加しました";
        }
        try {
            LeaveMessage = config.getString("LeaveMessage");
        }catch (NullPointerException e){
            LeaveMessage = "$PlayerNameが退出しました";
        }
    }

}
