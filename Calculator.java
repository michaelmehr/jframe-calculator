import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements WindowListener{
    
    private TextField input1TF, input2TF, outputTF; // TextField variables
    private Button addButton, subButton, multButton, divButton; // Button variables
    private double input1DBL, input2DBL, outputDBL; // double variables
    
    public Calculator(){
        setLayout(new FlowLayout());
        
        add(new Label("Calculator"));
        
        CTextListener txtlist = new CTextListener();
        
        // First input TextField
        input1TF = new TextField(9);
        input1TF.setEditable(true);
        add(input1TF);
        input1TF.addTextListener(txtlist);
        
        
        // Second input TextField
        input2TF = new TextField(9);
        input2TF.setEditable(true);
        add(input2TF);
        input2TF.addTextListener(txtlist);
        
        // Output Textfield
        outputTF = new TextField("0.0", 9);
        outputTF.setEditable(false);
        add(outputTF);
        
        BtnListener btnlist = new BtnListener();
        
        // Addition Button
        addButton = new Button(" + ");
        add(addButton);
        addButton.addActionListener(btnlist);
        
        // Subtraction Button
        subButton = new Button(" - ");
        add(subButton);
        subButton.addActionListener(btnlist);
        
        // Multiplication Button
        multButton = new Button(" * ");
        add(multButton);
        multButton.addActionListener(btnlist);
        
        // Division Button
        divButton = new Button(" / ");
        add(divButton);
        divButton.addActionListener(btnlist);
        
        // WindowListener used so the window can be closed out of
        addWindowListener(this);
        
        setTitle("Calculator");
        setSize(400, 400);
        setVisible(true);
    }
    
    
    private class BtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            String str = evt.getActionCommand();
            
            // Takes String inputs into TextFields and converts them to doubles for calculation
            input1DBL = Double.parseDouble(input1TF.getText());
            input2DBL = Double.parseDouble(input2TF.getText());
            
            if(str.equals(" - ")){
                // Subtraction
                outputDBL = input1DBL - input2DBL;
                outputTF.setText(Double.toString(outputDBL));
            }
            if(str.equals(" + ")){
                // Addition
                outputDBL = input1DBL + input2DBL;
                outputTF.setText(Double.toString(outputDBL));
            }
            if(str.equals(" * ")){
                // Multiplication
                outputDBL = input1DBL * input2DBL;
                outputTF.setText(Double.toString(outputDBL));
            }
            if(str.equals(" / ")){
                // Division
                outputDBL = input1DBL / input2DBL;
                outputTF.setText(Double.toString(outputDBL));
            }
        }
    }
    
    // Allows user to close window
    @Override
    public void windowClosing(WindowEvent evt){
        System.exit(0);
    }
    
    // Tracks changes to TextFields
    private class CTextListener implements TextListener{
        public void textValueChanged(TextEvent e){}
    }   

    @Override public void windowOpened(WindowEvent evt){}
    @Override public void windowClosed(WindowEvent evt){}
    
    @Override public void windowIconified(WindowEvent evt) { System.out.println("Window Iconified"); }
    @Override public void windowDeiconified(WindowEvent evt) { System.out.println("Window Deiconified"); }
    @Override public void windowActivated(WindowEvent evt) { System.out.println("Window Activated"); }    
    @Override public void windowDeactivated(WindowEvent evt) { System.out.println("Window Deactivated"); }
    
    // Main Method
    public static void main(String[] args){
        new Calculator();
    }
}