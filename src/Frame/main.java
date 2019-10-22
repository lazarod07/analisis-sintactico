/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Lista.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;

/**
 *
 * @author lazarod
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    File file;
    Nodo ptr;
    String [][] primas;
    int indice = 0;

    public main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        file_path = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(555, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String tienerecursividad(String p) {
        String cab = p.substring(0, 1);
        String[] prods = p.split("\\|");
        int i = 0;
        String r = "";
        while (prods.length > i) {
            if (i == 0) {
                if (prods[i].substring(3, 4).equals(cab)) {
                    r = i + "_";
                }
                i++;
            } else {
                if (prods[i].substring(0, 1).equals(cab)) {
                    r = r + i + "_";
                }
                i++;
            }
        }
        if (!"".equals(r)) {
            return r;
        } else {
            return "-1";
        }
    }

    public void agregar_prod(String p) {
        String nt = p.substring(0, 1);
        if (ptr == null) {
            Nodo c = new Nodo(p);
            ptr = c;
        } else {
            Nodo k = ptr;
            while (k != null) {
                if (k.getProd().substring(0, 1).equals(nt)) {
                    k.setProd(k.getProd() + "|" + p.split(">")[1]);
                    break;
                } else {
                    if (k.link == null) {
                        Nodo n = new Nodo(p);
                        k.link = n;
                        break;
                    }
                    k = k.link;
                }
            }
        }
    }

    public void agregar_prod2(String p) {
        String nt = p.substring(0, 1);
        if (ptr == null) {
            Nodo c = new Nodo(p);
            ptr = c;
        } else {
            Nodo k = ptr;
            while (k.link != null) {
                k = k.link;
            }
            Nodo n = new Nodo(p);
            k.link = n;
        }
    }
    
    public void mostrar_prod() {
        Nodo p = ptr;
        String prueba;
        while (p != null) {
            if (!"-1".equals(tienerecursividad(p.getProd()))) {
                elim_rec2(p);
            }
            System.out.println(p.getProd());
            p = p.link;
        }
    }

    int tamaño() {
        int i = 0;
        Nodo p = ptr;
        while (p != null) {
            i++;
            p = p.link;
        }
        return i;
    }

    public void elim_rec(String p) {
        String[] prods = p.split("\\|");
        String alfa = "", prima, nueva;
        String beta = "";
        Nodo k = ptr;
        int i = 0, cont = 0, j = 0, posi, h = 0, t, cont2 = 0;
        String pos;
        while (k != null) {
            if (k.getProd().equals(p)) {
                pos = tienerecursividad(k.getProd());
                if (!"-1".equals(pos)) {
                    String[] r = pos.split("_");
                    while (j < r.length) {
                        posi = Integer.parseInt(r[j]);
                        if (j == 0) {
                            if (posi == 0) {
                                alfa = prods[posi].substring(4, prods[posi].length()) + p.substring(0, 1) + "'";
                            } else {
                                alfa = prods[posi].substring(1, prods[posi].length()) + p.substring(0, 1) + "'";
                            }
                        } else {
                            if (posi == 0) {
                                alfa = alfa + "|" + prods[posi].substring(4, prods[posi].length()) + p.substring(0, 1) + "'";
                            } else {
                                alfa = alfa + "|" + prods[posi].substring(1, prods[posi].length()) + p.substring(0, 1) + "'";
                            }
                        }
                        j++;
                    }
                    while (i < prods.length) {
                        cont2 = 0;
                        h = 0;
                        while (h < r.length) {
                            t = Integer.parseInt(r[h]);
                            if (i == t) {
                                cont2++;
                            }
                            h++;
                        }
                        if (cont2 == 0) {
                            if (i == 0) {
                                beta = prods[i].substring(3, prods[i].length()) + p.substring(0, 1) + "'";
                                cont++;
                            } else {
                                if (cont == 0) {
                                    beta = prods[i] + p.substring(0, 1) + "'";
                                    cont++;
                                } else {
                                    beta = beta + "|" + prods[i] + p.substring(0, 1) + "'";
                                }
                            }
                            cont++;
                        }
                        i++;
                    }
                }
                if (beta.equals("")) {
                    beta = p.substring(0, 1) + "'";
                }
                nueva = p.substring(0, 1) + "->" + beta;
                prima = p.substring(0, 1) + "'" + "->" + alfa + "|&";
                k.setProd(nueva);
                Nodo temp = k.link;
                Nodo n = new Nodo(prima);
                k.link = n;
                n.link = temp;
                break;
            } else {
                k = k.link;
            }
        }
    }

    public void elim_rec2(Nodo p) {
        String prod = p.getProd();
        String alfa = p.getProd().substring(4, p.getProd().length());
        String prima = dame_prima(p.getProd());
        agregar_prima(p.getProd(), prima);
        if(ya_e(prod)){
            agregar_prod2(prima+"->&");
        }
        primas[indice][0] = p.getProd().substring(0,1);
        p.setProd(prima+"->"+alfa+prima);
        primas[indice][1] = prima;
        indice++; 
    }
    
    boolean ya_e(String p){
        int i = 0;
        String prueba1;
        String prueba2;
        while(i < primas.length){
            prueba1 = p.substring(0,1);
            prueba2 = primas[i][0];
            if(p.substring(0,1).equals(primas[i][0])){
                return false;
            }else{
                i++;
            }
        }
        return true;
    }
    
    public void agregar_prima(String p, String prima){
        Nodo k = ptr;
        while(k != null){
            if(k.getProd().substring(0, 1).equals(p.substring(0, 1)) && k.tp == false && "-1".equals(tienerecursividad(k.getProd()))){
                k.setProd(k.getProd()+prima);
                k.tp = true;
            }
            k = k.link;
        }
    }
   
    String dame_prima(String p) {
        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Nodo k = ptr;
        int j = 0, t = primas.length;
        int i = 0;
        String prima, prueba1,  prueba2;
        while(j < primas.length){    
            if(p.substring(0, 1).equals(primas[j][0])){
                return primas[j][1];
            }else{
                j++;
            }
        }
        while (k != null) {
            if (k.getProd().substring(0, 1).equals(abecedario[i])) {
                i++;
            } else {
                k = k.link;
            }
        }
        return abecedario[i];
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int isselected = chooser.showSaveDialog(null);
        String line;
        file = chooser.getSelectedFile();
        if (isselected == JFileChooser.APPROVE_OPTION) {
            file_path.setText(file.getAbsolutePath());
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(file));
                line = reader.readLine();
                while (line != null) {
                    agregar_prod2(line);
                    line = reader.readLine();
                }
                primas = new String[tamaño()][2];
                mostrar_prod();
            } catch (Exception e) {
                System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField file_path;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
