package nl.riebie.mcclans.api.parsers;

import nl.riebie.mcclans.api.ClanPlayer;
import nl.riebie.mcclans.api.ClanService;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.service.user.UserStorageService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.selector.Selector;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

/**
 * Command element parsing ClanPlayers for sponge commands.
 * <p>
 * Created by Kippers on 27/03/2017.
 */
public class ClanPlayerCommandElement extends CommandElement {

    private ClanService clanService;
    private UserStorageService userStorageService;

    /**
     * @param key                The key to look up this command element
     * @param clanService        The ClanService to get the ClanPlayers from
     * @param userStorageService Optional UserStorageService to improve looking up players by name. If not provided,
     *                           only online players can be parsed to a ClanPlayer.
     */
    protected ClanPlayerCommandElement(@Nullable Text key, @Nonnull ClanService clanService, @Nullable UserStorageService userStorageService) {
        super(key);
        this.clanService = clanService;
        this.userStorageService = userStorageService;
    }

    @Nullable
    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        String value = args.next();

        User user = null;
        if (value.startsWith("@")) {
            Set<Entity> entities = Selector.parse(value).resolve(source);
            if (entities.size() > 0 && entities.toArray()[0] instanceof Player) {
                UUID uuid = ((Player) entities.toArray()[0]).getUniqueId();
                user = getUser(uuid);
            }
        } else {
            user = getUser(value);
        }

        if (user == null) {
            return null;
        }

        ClanPlayer clanPlayer = clanService.getClanPlayer(user.getUniqueId());
        if (clanPlayer == null) {
            return clanService.createClanPlayer(user.getUniqueId(), user.getName());
        } else {
            return clanPlayer;
        }
    }

    @Nonnull
    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        return Collections.emptyList();
    }

    @Nonnull
    @Override
    public Text getUsage(CommandSource src) {
        return Text.of("<player name>");
    }

    @Nullable
    private User getUser(String playerName) {
        Optional<? extends User> user = userStorageService == null
                ? Sponge.getServer().getPlayer(playerName) : userStorageService.get(playerName);
        return user.orElse(null);
    }

    @Nullable
    private User getUser(UUID uuid) {
        Optional<? extends User> user = userStorageService == null
                ? Sponge.getServer().getPlayer(uuid) : userStorageService.get(uuid);
        return user.orElse(null);
    }
}
