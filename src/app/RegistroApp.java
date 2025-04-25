package app;

import model.Apartamento;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegistroApp extends JFrame {
    private JTextField txtApto, txtDueno, txtInquilino, txtAdultos, txtNinos;
    private JTextField txtAseo, txtDescuento;
    private JTextField txtPiscina, txtJuegos, txtZonas, txtSubtotal, txtTotal;
    private ArrayList<Apartamento> lista = new ArrayList<>();

    public RegistroApp() {
        setTitle("Registro de Apartamentos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(14, 2));

        txtApto = crearCampo("N° Apto:");
        txtDueno = crearCampo("Dueño:");
        txtInquilino = crearCampo("Inquilino:");
        txtAdultos = crearCampo("Adultos:");
        txtNinos = crearCampo("Niños:");
        txtAseo = crearCampo("Aseo:");
        txtDescuento = crearCampo("Descuento:");

        txtPiscina = crearCampoSoloLectura("Piscina:");
        txtJuegos = crearCampoSoloLectura("Juegos:");
        txtZonas = crearCampoSoloLectura("Zonas Sociales:");
        txtSubtotal = crearCampoSoloLectura("Subtotal:");
        txtTotal = crearCampoSoloLectura("Total a Pagar:");

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarApartamento());

        JButton btnMostrar = new JButton("Mostrar Lista");
        btnMostrar.addActionListener(e -> mostrarLista());

        add(btnGuardar);
        add(btnMostrar);

        pack();
        setVisible(true);
    }

    private JTextField crearCampo(String etiqueta) {
        JLabel label = new JLabel(etiqueta);
        JTextField campo = new JTextField();
        add(label);
        add(campo);
        return campo;
    }

    private JTextField crearCampoSoloLectura(String etiqueta) {
        JLabel label = new JLabel(etiqueta);
        JTextField campo = new JTextField();
        campo.setEditable(false);
        add(label);
        add(campo);
        return campo;
    }

    private void guardarApartamento() {
        try {
            int adultos = Integer.parseInt(txtAdultos.getText());
            int ninos = Integer.parseInt(txtNinos.getText());
            int totalPersonas = adultos + ninos;

            double piscina = totalPersonas * 2000;
            double juegos = (ninos > 0) ? 5000 : 0;
            double zonas = (adultos > 0) ? 10000 : 0;
            double aseo = Double.parseDouble(txtAseo.getText());
            double descuento = Double.parseDouble(txtDescuento.getText());

            double subtotal = piscina + juegos + zonas + aseo;
            double total = subtotal - descuento;

            // Mostrar resultados
            txtPiscina.setText(String.valueOf(piscina));
            txtJuegos.setText(String.valueOf(juegos));
            txtZonas.setText(String.valueOf(zonas));
            txtSubtotal.setText(String.valueOf(subtotal));
            txtTotal.setText(String.valueOf(total));

            Apartamento a = new Apartamento(
                    Integer.parseInt(txtApto.getText()),
                    txtDueno.getText(),
                    txtInquilino.getText(),
                    adultos,
                    ninos,
                    piscina,
                    juegos,
                    zonas,
                    aseo,
                    subtotal,
                    descuento,
                    total
            );

            lista.add(a);
            JOptionPane.showMessageDialog(this, "Apartamento guardado exitosamente.");
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void mostrarLista() {
        StringBuilder sb = new StringBuilder();
        for (Apartamento a : lista) {
            sb.append("Apto ").append(a.getNumero())
                    .append(" | Dueño: ").append(a.getDueno())
                    .append(" | Total a pagar: $").append(a.getTotalPagar()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No hay apartamentos registrados.");
    }

    private void limpiarCampos() {
        txtApto.setText("");
        txtDueno.setText("");
        txtInquilino.setText("");
        txtAdultos.setText("");
        txtNinos.setText("");
        txtAseo.setText("");
        txtDescuento.setText("");
        txtPiscina.setText("");
        txtJuegos.setText("");
        txtZonas.setText("");
        txtSubtotal.setText("");
        txtTotal.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistroApp());
    }
}