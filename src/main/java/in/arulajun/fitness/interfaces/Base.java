package in.arulajun.fitness.interfaces;

public interface Base<T> {
	public abstract <T> T findAll();
	public abstract void create(T newT);
	public abstract void update(T newT);
	public abstract void delete(int id);
	public abstract <T> T findById(int id);
}