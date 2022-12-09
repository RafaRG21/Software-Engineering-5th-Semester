public abstract class Cerradura extends Object{
	
   protected Cerradura() {
       super();
   }   


   public final void wait(Condicion c) // poner a espera el objeto
      {
          c.waitC(this);

      }
   protected final void notify(Condicion c) // Salir de espera el objeto
      {
          c.notifyC(this);
      }


}
