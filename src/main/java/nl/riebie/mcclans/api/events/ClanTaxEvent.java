/*
 * Copyright (c) 2016 riebie, Kippers <https://bitbucket.org/Kippers/mcclans-core-sponge>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package nl.riebie.mcclans.api.events;

import nl.riebie.mcclans.api.Clan;
import nl.riebie.mcclans.api.Tax;
import org.spongepowered.api.event.cause.Cause;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Taxation event for all clans.
 * <p>
 * Created by Kippers on 17-4-2017.
 */
public class ClanTaxEvent extends CancellableClanEvent {

    private final Map<Clan, List<Tax>> taxMap = new HashMap<>();

    public ClanTaxEvent(Cause cause, List<Clan> clans) {
        super("Tax event cancelled by an external plugin", cause);
        for (Clan clan : clans) {
            taxMap.put(clan, new ArrayList<>());
        }
    }

    /**
     * Add a tax for a clan.
     *
     * @param clan The clan to tax
     * @param tax  The tax for the clan
     */
    public void addTax(Clan clan, Tax tax) {
        List<Tax> taxes = taxMap.get(clan);
        if (taxes == null) {
            taxes = new ArrayList<>();
            taxMap.put(clan, taxes);
        }
        taxes.add(tax);
    }

    /**
     * Get all taxes for a clan.
     *
     * @param clan The clan to get the taxes for
     * @return All taxes present for the provided clan, or an empty list if there are no taxes
     */
    public List<Tax> getTax(Clan clan) {
        return taxMap.getOrDefault(clan, new ArrayList<>());
    }

    /**
     * Get all taxes for all clans.
     *
     * @return A map with all taxes
     */
    public Map<Clan, List<Tax>> getTaxes() {
        return taxMap;
    }
}
