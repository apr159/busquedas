package busquedas;


public interface Cola
{
   public boolean estaVacia();
   public void addNodo(Nodo nodo);
   public Nodo removerNodoFrente();
   public int getTCola();
}
