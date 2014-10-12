package be.baws.diplomacycast.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import be.baws.diplomacycast.domain.Player;
import be.baws.diplomacycast.service.PlayerService;
import be.baws.diplomacycast.service.UserSharedPreferences;

/**
 * Created by fbousson on 12/10/14.
 */
public class PlayerServiceImpl implements PlayerService {

    private UserSharedPreferences _userSharedPreferences;
    private ObjectMapper _objectMapper;


    public PlayerServiceImpl(UserSharedPreferences userSharedPreferences) {
        _objectMapper = new ObjectMapper();
        _objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        _objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        _userSharedPreferences = userSharedPreferences;
    }

    @Override
    public boolean storePlayer(Player player) {
        boolean success = false;
        try {
            _userSharedPreferences.setPlayer(_objectMapper.writeValueAsString(player));
            success = true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }finally {
            return success;
        }

    }

    @Override
    public Player retrieveLastKnownPlayer() {
       Player player = null;
        try
        {
            String playerString = _userSharedPreferences.getPlayer();
            if(playerString != null){
                player = _objectMapper.readValue(new StringReader(playerString), Player.class);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        return player;
    }

    @Override
    public void registerPlayer(Player player) {

    }

    @Override
    public List<Player> getListOfPlayers() {
        return null;
    }
}
