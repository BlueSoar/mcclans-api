package nl.riebie.mcclans.api.parsers;

import nl.riebie.mcclans.api.Clan;
import nl.riebie.mcclans.api.ClanService;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Command element parsing Clans for sponge commands.
 * <p>
 * Created by Kippers on 27/03/2017.
 */
public class ClanCommandElement extends CommandElement {

    private ClanService clanService;

    /**
     * @param key         The key to look up this command element
     * @param clanService The ClanService to get the Clans from
     */
    protected ClanCommandElement(@Nullable Text key, @Nonnull ClanService clanService) {
        super(key);
        this.clanService = clanService;
    }

    @Nullable
    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        String value = args.next();

        return clanService.getClan(value);
    }

    @Nonnull
    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        Optional<String> nextOpt = args.nextIfPresent();
        if (nextOpt.isPresent()) {
            String next = nextOpt.get();
            List<String> completions = new ArrayList<>();
            for (Clan clan : clanService.getClans()) {
                if (clan.getName().toLowerCase().startsWith(next.toLowerCase())) {
                    completions.add(clan.getName());
                }
            }
            return completions;
        } else {
            return Collections.emptyList();
        }
    }

    @Nonnull
    @Override
    public Text getUsage(CommandSource src) {
        return Text.of("<clan tag>");
    }
}
