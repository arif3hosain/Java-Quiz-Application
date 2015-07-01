package model;
// Generated Jun 28, 2015 10:38:36 PM by Hibernate Tools 3.6.0

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Examiner  implements java.io.Serializable {


     private Integer id;
     private String fullName;
     private String email;
     private String password;

    public Examiner() {
    }

    public Examiner(String fullName, String email, String password) {
       this.fullName = fullName;
       this.email = email;
       this.password = password;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean register(Examiner examiner){
      
        Session session=util.HibernateUtil.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(examiner);
        transaction.commit();
        session.close();
        
        return true;
    }

    public Examiner authenticate(Examiner examiner) {
        
        Session session=util.HibernateUtil.openSession();
        Transaction transaction=session.getTransaction();
        Query query=session.createQuery("from Examiner where Email='"+examiner.getEmail()+ "' and Password='"+examiner.getPassword()+"'");
        Examiner exami=(Examiner)query.uniqueResult();
        
        if(exami !=null){
            return exami;
        }else            
        return null;   
    }//finish authenticate method.
    
 

}


