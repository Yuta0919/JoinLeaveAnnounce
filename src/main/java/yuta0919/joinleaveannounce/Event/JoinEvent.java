package yuta0919.joinleaveannounce.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import yuta0919.joinleaveannounce.JoinLeaveAnnounce;


public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String FirstPlayerJoinMessage;
        FirstPlayerJoinMessage = JoinLeaveAnnounce.FirstJoinMessage.replace("$PlayerName",p.getName());//$PlayerNameをプレイヤーの名前に変更
        FirstPlayerJoinMessage = FirstPlayerJoinMessage.replace("$","§");//チャットの色を変更
        String PlayerJoinMessage;
        PlayerJoinMessage = JoinLeaveAnnounce.JoinMessage.replace("$PlayerName", p.getName());//$PlayerNameをプレイヤーの名前に変更
        PlayerJoinMessage = PlayerJoinMessage.replace("$","§");//チャットの色を変更

        try {
            //初参加かを判別
            if (!JoinLeaveAnnounce.JoinedPlayerUUID.contains(p.getUniqueId().toString())) {
                e.setJoinMessage(FirstPlayerJoinMessage);
                JoinLeaveAnnounce.JoinedPlayerUUID = JoinLeaveAnnounce.JoinedPlayerUUID + p.getUniqueId();
            }else{
                e.setJoinMessage(PlayerJoinMessage);
            }
        }catch (NullPointerException error){
            //JoinedPlayerUUIDがnullの時
            e.setJoinMessage(FirstPlayerJoinMessage);
            JoinLeaveAnnounce.JoinedPlayerUUID = JoinLeaveAnnounce.JoinedPlayerUUID + p.getUniqueId();
        }
    }
}

