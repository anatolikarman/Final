public class Contorller extends HttpServlet{
    private static final long serialVersionUID =1L;
    public Contorller(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
    throws ServletException, IOException{
        processRequest();
        }
        protected void doPost (HttpServletRequest request, HttpServletResponse response){
    throws ServletException, IOException{
                processRequest();
            }
            private void processRequest(){
                System.out.println("I am here");}
        }
    }
}
