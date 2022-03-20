package itis;

import itis.Model.BlockChain;
import itis.Model.BlockModel;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private DefaultTableModel tableModel;

    public Frame(BlockChain blockChain) throws HeadlessException {
        setTitle("Block Chain");
        setLayout(new BorderLayout());

        JPanel editorPanel = new JPanel();
        // name test input
        JLabel nameLabel = new JLabel("Name");
        JTextField name = new JTextField();
        // data text input
        JLabel dataLabel = new JLabel("Data");
        JTextField data = new JTextField();
        name.setPreferredSize(new Dimension(200, 30));
        data.setPreferredSize(new Dimension(200, 30));

        // Button to create new blockchain
        JButton btnCreate = new JButton("Create");
        btnCreate.setForeground(Color.WHITE);
        btnCreate.setFocusPainted(false);
        name.setName("Name");

        editorPanel.setPreferredSize(new Dimension(100, 100));
        editorPanel.add(nameLabel);
        editorPanel.add(name);
        editorPanel.add(dataLabel);
        editorPanel.add(data);
        editorPanel.add(btnCreate);
        add(editorPanel, BorderLayout.NORTH);

        // move to another method

        JTable table = new JTable();

        tableModel = new DefaultTableModel();

        String[] tableNames = new String[]{"PrevHash", "Data", "Name", "Signature", "Time", "Public Key"};

        tableModel.setColumnIdentifiers(tableNames);
        for (int i = 0; i <blockChain.getBlockModelList().size() ; i++) {
            BlockModel bc = blockChain.getBlockModelList().get(i);
            addNewBlockToTable(bc);
        }

        JScrollPane pane = new JScrollPane(table);
        table.setModel(tableModel);

        add(pane);

        btnCreate.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!data.getText().isEmpty() && !name.getText().isEmpty()){

                    BlockModel bc =  blockChain.addNewBlockChain(data.getText(),name.getText());
                    addNewBlockToTable(bc);
                    tableModel.fireTableDataChanged();

                }else {
                    JOptionPane.showConfirmDialog(
                            Frame.this,
                            "There are empty fields!!!",
                            "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setVisible(true);
        setSize(1000, 600);
        setMinimumSize(new Dimension(900, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void addNewBlockToTable(BlockModel bc) {
        String[] rowData = new String[6];
        for (int j = 0; j <rowData.length ; j++) {
            rowData[0] = bc.getPrevhash();
            rowData[1] = bc.getData().getData();
            rowData[2] = bc.getData().getName();
            rowData[3] = bc.getSignature();
            rowData[4] = bc.getTs();
            rowData[5] = bc.getPublickey();
        }
        tableModel.addRow(rowData);
    }
}
