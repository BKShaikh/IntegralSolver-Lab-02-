/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Shaikh
 */
//class tableView {
////
//    SimpleIntegerProperty profit;
//    SimpleDoubleProperty probabilty;
//
//    public tableView(int profit, double prob) {
//        this.profit = new SimpleIntegerProperty(profit);
//        this.probabilty = new SimpleDoubleProperty(prob);
//    }
//}
class methodsForCal {

    //  double probCal(List<simtable1> table, int profit) {
//        int count = 1;
//        int index = 0;
//        // System.out.println("tableSize " + table.size());
//        for (int i = 0; i < table.size(); i++) {
//            if (table.get(i).profit.get() == profit) {
//                count = (int) ((table.get(i).probability.get() * 10) + 1);
//                index = i;
//                System.out.println(" " + count + " " + index + " " + profit + " " + table.get(i).probability);
//            }
//        }
//        if (count > 1) {
//            double val = count / 10.0;
//            System.out.println("1-Value" + val);
//            System.out.println(" " + count + " " + index + " " + profit + "" + table.get(index).probability);
//            table.get(index).probability.set(val);
//            return table.get(index).probability.get();
//        } else {
//            return 0.1;
//        }
//        profit = 0;
//        return 0;
    //  }
    double prob(int[] prof, int pro) {
        for (int i = 0; i < prof.length; i++) {
            if (prof[i] == pro) {
                return i;
            }
        }
        return 0.1;
    }

    int profitCacl(double sellingPrice, double costPrice, int quantity, double discount, int demand) {
        if (demand <= quantity) {
            return (int) ((sellingPrice * demand) - (costPrice * quantity) + (discount * sellingPrice) * (quantity - demand));
        } else {
            return (int) ((sellingPrice * quantity) - (costPrice * quantity));
        }
    }
}

public class FXMLDocumentController implements Initializable {

    //private Label label;
//    private TextField demand;
    @FXML
    private TextField quantity;
    @FXML
    private TextField bound;
    @FXML
    private TextField origin;
    @FXML
    private TextField stream;
    @FXML
    private TextField discount;
    @FXML
    private TextField sell;
    @FXML
    private TextField cost;
    @FXML
    private Button simulate;

    //declation for lists
//    ObservableList<tableView> profitArray;
    methodsForCal cal;
    @FXML
    private TableView<simtable1> tableForReading;
    @FXML
    private TableColumn<TableView, Integer> Profit;
    @FXML
    private TableColumn<TableView, Double> Probabilty;
    @FXML
    private BarChart<String, Integer> BarChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private ChoiceBox<String> demand;
    List<simtable1> simtable = new ArrayList<>();

    int profit;
    double prob;
    double costp, sellp, dis;
    int str, ori, bou, quan;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        //    profitArray.clear();
        ObservableList<simtable1> tableData = FXCollections.observableArrayList();
        Random r = new Random();

        //   System.out.println("You clicked me!");
        //  cost.setText("Hello World!");
        costp = Double.parseDouble(cost.getText());
        sellp = Double.parseDouble(sell.getText());
        dis = Double.parseDouble(discount.getText());
        str = Integer.parseInt(stream.getText());
        ori = Integer.parseInt(origin.getText());
        bou = Integer.parseInt(bound.getText());
        quan = Integer.parseInt(quantity.getText());
       // int[] arr = new int[str];
        int[] profi = new int[str];
        int[] fr = new int[str];
        int[] dema = new int[str];
        int tempInd = 0;
        double t=0 ;
        for (int i = 0; i < str; i++) {
            dema[i] = r.nextInt(bou - ori) + ori;
            int ans = dema[i];
            profit = cal.profitCacl(sellp, costp, quan, dis, ans);
            // prob = cal.probCal(simtable, profit);
            double temp = cal.prob(profi, profit);
//  System.out.println(profit);
            //  System.out.println(prob);
            if (temp != 0.1) {
                System.out.println("temp not equal 0.1");
                fr[(int) temp]++;

            } else {

                System.out.println("else");
                profi[tempInd] = profit;
                fr[tempInd] = 1;
                tempInd++;
            }
            
//            for (int j = 0; j <fr.length; j++) {
//                System.out.println(" "+fr.toString());
//            }
         //   t =(double) fr[i]/10;
            System.out.println(Arrays.toString(profi));
             System.out.println(Arrays.toString(fr)+" ");
//            simtable.add(new simtable1(profit, t));
//            if (prob == 0.1) {
//                profitArray.add(new tableView(profit, prob));
//            }

        }
        
//         for (int i = 0; i < str; i++) {
//        t=(double)fr[i]/10;
//            System.out.println(t);
//            simtable.add(new simtable1(profi[i], t));    
//        }
     
       
        
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        for (int i = 0; i < tempInd; i++) {
            series1.getData().add(new XYChart.Data<>("" + profi[i], fr[i]));
            t=(double)fr[i]/10;
            simtable1 values = new simtable1(profi[i], t);
            tableData.add(values);
        }

        BarChart.getData().add(series1);
//         ObservableList<String> profits = FXCollections.observableArrayList();
//        for (tableView profitArray1 : profitArray) {
//            System.out.println(profitArray1.profit.get() + "\t" + profitArray1.probabilty.get());
//            profits.add(""+profitArray1.profit.get());

        //       }
//        xAxis.setCategories(profit);
//         XYChart.Series<String, Integer> series = new XYChart.Series<>();
//       for (int i = 0 ; i < profitArray.size() ; i++) {
//          int temp = (int) (profitArray.get(i).prob.get() * 10);
//          series.getData().add(new XYChart.Data<>(profit.get(i),temp));
//       
//       }
//       BarChart.getData().add(series);
//       tableForReading.setItems(profitArray);
         
        Profit.setCellValueFactory(new PropertyValueFactory<>("profit"));
        Probabilty.setCellValueFactory(new PropertyValueFactory<>("probability"));
        tableForReading.setItems(tableData);
    }

//    private void demandActionPerformed (ActionEvent event) 
//            {
//                display.setText(diplay.getText+demand.getText());
//            }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        cal = new methodsForCal();
        demand.setItems(FXCollections.observableArrayList(
                "Normal",
                "Poison",
                "Uniform"
        ));

//        Profit.setCellValueFactory(new PropertyValueFactory("profit"));
//        Probabilty.setCellValueFactory(new PropertyValueFactory("probabilty"));
//
//        profitArray = FXCollections.observableArrayList();
    }

}
