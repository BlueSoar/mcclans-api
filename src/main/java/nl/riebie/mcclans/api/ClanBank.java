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

package nl.riebie.mcclans.api;

import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.account.Account;

import javax.annotation.Nullable;

/**
 * Represents the economy account of a clan bank.
 * <p>
 * Created by Kippers on 09/04/2017.
 */
public interface ClanBank {

    /**
     * Get the identifier for the economy account of the clan bank
     *
     * @return the identifier for the economy account of the clan bank
     */
    String getId();

    /**
     * Get the currency used by this clan bank
     *
     * @return the currency used by this clan bank, or null if economy is disabled
     */
    @Nullable
    Currency getCurrency();

    /**
     * Withdraw an amount of currency from the clan bank
     *
     * @param amount the amount to withdraw
     * @return true if successful
     */
    boolean withdraw(double amount);

    /**
     * Deposit an amount of currency to the clan bank
     *
     * @param amount the amount to deposit
     * @return true if successful
     */
    boolean deposit(double amount);

    /**
     * Transfer an amount of currency from the clan bank to the provided account
     *
     * @param account the account to transfer to
     * @param amount  the amount to transfer
     * @return true if successful
     */
    boolean transferFromBank(Account account, double amount);

    /**
     * Transfer an amount of currency to the clan bank from the provided account
     *
     * @param account the account to transfer from
     * @param amount  the amount to transfer
     * @return true if successful
     */
    boolean transferToBank(Account account, double amount);

    /**
     * Get the amount of currency in the clan bank
     *
     * @return the amount of currency in the clan bank
     */
    double getBalance();
}
