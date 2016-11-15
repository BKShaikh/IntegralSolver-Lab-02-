/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
/**
 *
 * @author Shaikh
 */
public class simtable1 {
public IntegerProperty profit = new SimpleIntegerProperty();
    public DoubleProperty probability = new SimpleDoubleProperty();
    
    
    
    
    
    public simtable1(int pro, double probab )
    {
        super();
        profit.set(pro);
        probability.set(probab);
    }
    
    
    
    public final IntegerProperty profitProperty() {
		return this.profit;
	}
    
    public final int getProfit() {
        return this.profitProperty().get();
    }

    public void setProfit(final int profit) {
        this.profitProperty().set(profit);
        }

   
    public final DoubleProperty probabilityProperty() {
		return this.probability;
	}

	public final double getProbability() {
		return this.probabilityProperty().get();
	}

	public final void setSample(final int probability) {
		this.probabilityProperty().set(probability);
	}
    
}
