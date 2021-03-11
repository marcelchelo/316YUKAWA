import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Obj
{
	
	
     public boolean visited = false; // indicates if this object has been visited by traverse() function
     static ArrayList<String> Objecttotal = new ArrayList<>();
     static int Visited = 0;
	Obj()


	{

                Objecttotal.add(" objects of "+this.getClass().getSuperclass().toString());
                Objecttotal.add(" objects of "+this.getClass().toString());
      
	}
        
        
        void traversal(){
            
         try {
             
             IO.displayln2("Object-graph traversal has started ...");
             IO.displayln2("");
             Class nuevo = this.getClass();
             IO.displayln2(nuevo.getName());
             Visited++;
             Object value = nuevo;
             
             
             if (value.getClass().getName().startsWith("Single")) {
                 nuevo = this.getClass().getSuperclass();
             } else {
                 nuevo = this.getClass();
             }
             
             
             
             Field superField = nuevo.getField("visited");

          
             superField.setBoolean(this,true);
             System.out.println("value for "+this.getClass()+" = "+superField.getBoolean(this));
             Field[] flds = nuevo.getDeclaredFields();
             
             for (Field f : flds) {
                 
                 try {
                     
                     f.setAccessible(true);
                     value = f.get(this);
                     //supF = value.getClass().getField("visited");
//                     System.out.println("value for "+value.getClass()+" = "+supF.getBoolean(value));
                     
                     
                         if (value.getClass().getName().startsWith("java.lang.")) {
                             IO.displayln2(value.toString());

                         } else {
                             IO.displayln2(value.getClass().getName());
                             Visited++;

                         }

                         if (!value.getClass().getName().startsWith("java.lang.")) {
                             recursion(value);
                         }
                     
                 } catch (IllegalArgumentException ex) {
                     Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                 } catch (IllegalAccessException ex) {
                     Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (SecurityException ex) {
                     Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
             
         //}
             IO.displayln2("Total of " + Visited + " Obj objects have been visited.");
             IO.displayln2("");
             Visited = 0;
         } catch (NoSuchFieldException ex) {
             Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SecurityException ex) {
             Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalArgumentException ex) {
             Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        }
        
    private void recursion(Object value) {
        Class c = value.getClass();
        
        Object valorr = c;
            if (value.getClass().getName().startsWith("Single") ) {
                c = value.getClass().getSuperclass();
            } else if(value.getClass().getName().startsWith("AddE")
                    ||value.getClass().getName().startsWith("SubE")){
                Class c1 = value.getClass();
                Field[] flds = c1.getDeclaredFields();
                
                for (Field f : flds) {
                    
                    try {
                        
                        valorr = f.get(value);
                        if(valorr.getClass().getName().startsWith("java.lang.")){
                            IO.displayln2(valorr.toString());
                            
                        }
                        else{
                            IO.displayln2(valorr.getClass().getName());
                            
                            Visited++; 
                        }
                        if(!valorr.getClass().getName().startsWith("java.lang.")) {
                            recursion(valorr);
                        }
                        
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
                c = value.getClass().getSuperclass();
            } else if(value.getClass().getName().startsWith("MulTerm") ||value.getClass().getName().startsWith("DivTerm")){
                Class c1 = value.getClass();
                Field[] flds = c1.getDeclaredFields();
                
                for (Field f : flds) {
                    
                    try {
                        
                        
                        valorr = f.get(value);
                        if(valorr.getClass().getName().startsWith("java.lang.")){
                            IO.displayln2(valorr.toString());
                            
                        }
                        else{
                            IO.displayln2(valorr.getClass().getName());
                            
                            Visited++;
                        }
                        if(!valorr.getClass().getName().startsWith("java.lang.")) {
                            recursion(valorr);
                        }
                        
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
                c = value.getClass().getSuperclass();
            }
            else    
            c = value.getClass();
            
        Field[] fields = c.getDeclaredFields();
                
                for (Field f : fields) {
                   
                    try {
                         
                        valorr = f.get(value);
                        
                        if(valorr.getClass().getName().startsWith("java.lang.")){
                            IO.displayln2(valorr.toString());     
                            
                        }     
                        else{ 
                            IO.displayln2(valorr.getClass().getName());
                            
                            Visited++;
                        }
                        
                        if(!valorr.getClass().getName().startsWith("java.lang.")) {
                            recursion(valorr);
                        }
                        
                        
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Obj.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
    }
    
 
    
    
    
}