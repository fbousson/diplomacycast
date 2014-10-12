package be.baws.diplomacycast.service.stub;

import java.util.ArrayList;
import java.util.List;

import be.baws.diplomacycast.domain.Player;
import be.baws.diplomacycast.service.PlayerService;

/**
 * Created by fbousson on 12/10/14.
 */
public class PlayerServiceStub implements PlayerService {

    private Player _player;

    @Override
    public boolean storePlayer(Player player) {
        _player = player;
        return true;
    }

    @Override
    public Player retrieveLastKnownPlayer() {
        return _player;
    }

    @Override
    public void registerPlayer(Player player) {



    }

    @Override
    public List<Player> getListOfPlayers() {
        List<Player> players = new ArrayList<Player>();

        return players;
    }
}
