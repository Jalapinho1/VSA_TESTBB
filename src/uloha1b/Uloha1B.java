/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uloha1b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eduardo Martinez
 */
public class Uloha1B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        load("C:\\Users\\Eduardo Martinez\\Documents\\NetBeansProjects\\Uloha1\\data1.csv");
        load("C:\\Users\\Eduardo Martinez\\Documents\\NetBeansProjects\\Uloha1\\data2.csv");
    }
    
    public static void load (String csv){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uloha1BPU");
        EntityManager em = emf.createEntityManager();
        
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                String s[] = line.split(";");
                
                if (!s[0].isEmpty() && !s[1].isEmpty()){
                    Tovar t =(Tovar) em.find(Tovar.class, s[0].trim());
                    
                    if (t == null){
                        Tovar tovar = new Tovar(s[0].trim(),Integer.parseInt(s[1].trim()));
                        em.getTransaction().begin();
                        em.persist(tovar);
                        em.getTransaction().commit();
                    }else{
                        t.setMnozstvo(Integer.parseInt(s[1].trim()));
                    }
                    
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Uloha1B.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Uloha1B.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Uloha1B.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
