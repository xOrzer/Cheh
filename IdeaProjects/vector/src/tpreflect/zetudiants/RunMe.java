package tpreflect.zetudiants;

import tpreflect.paquetcadeau.PaquetCadeau;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Vector;

public class RunMe {

  public static void main(String[] args) {

    Vector v = new PaquetCadeau().getPaquetCadeau();

    Iterator i = v.iterator();
    while (i.hasNext()) {
      Object o = i.next();
      introspect(o);
    }
  }

  private static void introspect(Object o) {
        //System.out.println(o.toString());

        Method[] tabM = o.getClass().getMethods();
        for(int i=0; i<tabM.length ; i++ ){
          System.out.println(tabM[i]);
        }

        /*
        Constructor[] tabC = o.getClass().getConstructors();
        for(int i=0; i<tabC.length ; i++ ){
          System.out.println(tabC[i]);
        }*/

        /*
        Field[] tabF = o.getClass().getDeclaredFields();
        for(int i=0; i<tabF.length ; i++ ){
          System.out.println(tabF[i]);
        }*/
  }

}
