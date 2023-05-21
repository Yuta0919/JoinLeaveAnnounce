package yuta0919.joinleaveannounce.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import yuta0919.joinleaveannounce.JoinLeaveAnnounce;

public class LeaveEvent implements Listener {
    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        String PlayerLeaveMessage;
        PlayerLeaveMessage = JoinLeaveAnnounce.LeaveMessage.replace("$PlayerName", p.getName());//$PlayerNameをプレイヤーの名前に変更
        PlayerLeaveMessage = PlayerLeaveMessage.replace("$","§");//チャットの色を変更
        e.setQuitMessage(PlayerLeaveMessage);
    }
}
