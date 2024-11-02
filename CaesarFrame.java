import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarFrame extends JFrame {
    private JTextField inputField;
    private JTextField outputField;
    private JButton btn;
    private JComboBox comboBox;

    public CaesarFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SwingLab");
        setSize(400, 110);
        setResizable(false);
        setLayout(new BorderLayout());

        intializeInput();
        intializeOutput();
        initComboBox();
        initButton();

        createLayout();
    }

    private void createLayout(){
        JPanel topPanel = new JPanel();
        topPanel.add(comboBox);
        topPanel.add(inputField);
        topPanel.add(btn);

        topPanel.setLayout(new FlowLayout());

        JPanel bottomPanel = new JPanel();
        JLabel label = new JLabel("Output");
        label.setLabelFor(outputField); 
        bottomPanel.add(label);
        bottomPanel.add(outputField);

        bottomPanel.setLayout(new FlowLayout());

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initButton(){
        btn = new JButton();
        btn.setText("Code!");
        btn.addActionListener(new OkButtonActionListener());
    }

    private void initComboBox(){
        ArrayList<Object> alphabet = new ArrayList<>();
        for(int c = 'A'; c <= 'Z'; c++)
            alphabet.add((char)(c));
        
        comboBox = new JComboBox<>(alphabet.toArray());
    }

    private void intializeInput(){
        inputField = new JTextField();
        inputField.setColumns(20);
    }

    private void intializeOutput(){
        outputField = new JTextField();
        outputField.setColumns(20);
        outputField.setEditable(false);
    }
    private class OkButtonActionListener implements ActionListener{
        private Encoder encoder = new Encoder();

        @Override
        public void actionPerformed(ActionEvent e) {
            encoder.setShift((char)comboBox.getSelectedItem());
            outputField.setText(encoder.encode(inputField.getText()));
        }

    }
}
