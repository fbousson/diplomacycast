package be.baws.diplomacycast.service;

import java.util.List;

import be.baws.diplomacycast.domain.Player;

/**
 * Created by fbousson on 12/10/14.
 */
public interface PlayerService {


    /**
     * Stores the player on disc.
     * @param player
     */
    boolean storePlayer(Player player);

    /**
     * Retrieves the last known player from disc.
     * @return
     */
    Player retrieveLastKnownPlayer();


    /**
     *
     * Registers the player with the chromecast
     * @param player
     */
    void registerPlayer(Player player);


    /**
     * Get a list of players available on the chromecast
     * @return
     */
    List<Player> getListOfPlayers();




}
