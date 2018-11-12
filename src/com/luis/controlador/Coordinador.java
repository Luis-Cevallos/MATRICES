package com.luis.controlador;

import com.luis.modelo.Punto;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *    @author Luis Cevallos
 *     
 *     
 *     
 */
public class Coordinador {
    
    ArrayList<Punto> listaPuntos=new ArrayList<>();
    
    public void almacenarPuntos(){
      int resp=0;
        do{
          if( resp==0 ){
              try {
                Punto p= new Punto();
                p.setX( Integer.parseInt( JOptionPane.showInputDialog( "ingresa X" )));
                p.setY( Integer.parseInt( JOptionPane.showInputDialog( "ingresa Y" )));

                listaPuntos.add( p );
              } catch (HeadlessException | NumberFormatException e) {
                  JOptionPane.showMessageDialog(null,"No debe dejar campos vacios");
              }
          }
      }while( resp==JOptionPane.showConfirmDialog(null, "Deseas ingresar mas puntos..?") );
    }

    public void imprimir(){
        String acu="";
        for ( Punto listaPunto : listaPuntos ) {
            try {
                acu +=listaPunto.toString()+"\n";
            } catch (Exception e) {
                System.out.println("!error" +e.getMessage());
            }
        }
        JOptionPane.showMessageDialog( null,acu );
    }
    
    public void calcularDistancia(){
       int abA1 = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el punto de la 1 absisa") );
       int abB1 = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el punto de la 1 ordenada") );
       int abA2 = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el punto de la 2 absisa") );
       int abB2 = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el punto de la 2 ordenada") );
       
       int puntoFinal=  (int) Math.sqrt(Math.abs( ( ( (abA2-abA1) * (abA2-abA1) ) + ( (abB2-abB1) * (abB2-abB1) )  ) ) );
       
       JOptionPane.showMessageDialog(null,"El resultado de los puntos ("+abA1+","+abB1+")("+abA2+","+abB2+") = "+puntoFinal);
    }
    public void menu(){
        int op=0;
        do {
            try{            
                 op= Integer.parseInt(JOptionPane.showInputDialog("Ingresa una opción: \n"
                 + "1.- Ingresar Punto\n"
                 + "2.- Modificar coordenadas\n"
                 + "3.- Calcular la distancia entre 2 puntos\n"
                 + "4.- Imprimir\n"
                 + "5.- Salir"));
                 switch(op){
                     case 1:     almacenarPuntos();       break;
                     case 2:
                         int i=Integer.parseInt(JOptionPane.showInputDialog(listaPuntos.toString()));
                         listaPuntos.get(i).setX(Integer.parseInt(JOptionPane.showInputDialog("ingrese nuevo parametro")));
                         listaPuntos.get(i).setY(Integer.parseInt(JOptionPane.showInputDialog("ingrese nuevo parametro")));
                         break;
                     case 3:     calcularDistancia();     break;
                     case 4:     imprimir();              break;
                 }
             }catch(HeadlessException | NumberFormatException e){
              System.out.println("error en el menu");           
             }  
        }while (op!=5); 
    }
    
}










