package mvc.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
 
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDao<PK extends Serializable, T> {
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao()
    {
    	System.out.println("AbstractDao():start()" + (ParameterizedType)this.getClass().getGenericSuperclass());
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        System.out.println("AbstractDao():end()" + this.getClass());
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    public void persist(T entity) {
        getSession().persist(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
     
    protected Criteria createEntityCriteria(){
    	System.out.println("AbstractDao():createEntityCriteria()");
        return getSession().createCriteria(persistentClass);
       
    }
 
}