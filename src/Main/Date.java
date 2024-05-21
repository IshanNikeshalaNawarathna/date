/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import raven.datetime.component.date.DateEvent;
import raven.datetime.component.date.DatePicker;
import raven.datetime.component.date.DateSelectionAble;
import raven.datetime.component.date.DateSelectionListener;

/**
 *
 * @author user
 */
public class Date extends JFrame {

    public Date() {//constructor

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 500));
        setLocationRelativeTo(null);

        DatePicker datepicker = new DatePicker(); // create a date picker object
        datepicker.setDateSelectionMode(DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED); // between to date selector
        datepicker.setSeparator("to date");//set a text
        datepicker.setUsePanelOption(true);// side panel set
        
        datepicker.setDateSelectionAble((LocalDate localDate) -> !localDate.isAfter(localDate.now()));
        
        datepicker.addDateSelectionListener(new DateSelectionListener() {
            @Override
            public void dateSelected(DateEvent dateEvent) {
              LocalDate[] date=datepicker.getSelectedDateRange();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                if(date !=null){
                    System.out.println(df.format(date[0])+"-"+df.format(date[1]));
                }
            }
        });
        
        
        JFormattedTextField dateEditor = new JFormattedTextField();// formatted filed set
        datepicker.setEditor(dateEditor);// set a edit option of date picker
        setLayout(new MigLayout());//improt a miglayout in project lib
        add(dateEditor, "width 250");// formatted filed a set size


    }

    public static void main(String[] args) {//main method
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Date().setVisible(true);
            }
        });
    }

}
