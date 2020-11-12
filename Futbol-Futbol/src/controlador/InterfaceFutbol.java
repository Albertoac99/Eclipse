package controlador;

public interface InterfaceFutbol<F> {

	public int searchPosition(F oObjeto);

	public F searchObject(F oObjeto);

	public boolean add(F oObjeto);

	public F read(F oObjeto);

	public boolean update(F oObjeto);

	public boolean delete(F oObjeto);

	public String printAll();
}
