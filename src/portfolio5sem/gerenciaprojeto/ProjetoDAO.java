package portfolio5sem.gerenciaprojeto;

import java.util.List;

import org.hibernate.Session;

public class ProjetoDAO implements CRUDService<Long, Projeto> {

	@Override
	public void save(Projeto projeto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(projeto);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}
	
	public void update(Projeto projeto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(projeto);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}

	@Override
	public List<Projeto> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Projeto> projetos = session.createQuery("from Projeto").list();
		session.getTransaction().commit();
		session.flush();
		session.close();
		return projetos;
	}

	@Override
	public void delete(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Projeto projeto = (Projeto) session.load(Projeto.class, id);
	    if (projeto != null) {
	        session.delete(projeto);
	    }
	    session.flush();
		session.close();
	}

	@Override
	public Projeto get(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Projeto projeto = (Projeto) session.get(Projeto.class, id);
        session.close();
        return projeto;
	}

}
