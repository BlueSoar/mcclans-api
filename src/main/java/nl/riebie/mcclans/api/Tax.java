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

/**
 * Contains a single tax.
 * <p>
 * Created by Kippers on 17-4-2017.
 */
public class Tax {

    private String name;
    private double cost;

    /**
     * @param name User friendly name for the tax
     * @param cost The amount to charge
     */
    public Tax(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Set the user friendly name for this tax.
     *
     * @param name A user friendly name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the amount to charge.
     *
     * @param cost An amount
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Get the user friendly name for this tax.
     *
     * @return A user friendly name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the amount to charge.
     *
     * @return An amount
     */
    public double getCost() {
        return cost;
    }
}
