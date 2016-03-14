package MB;

import DAO.Usuario;
import controlador.UsuarioDaoHibernate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class MBUsuario {

    private String nombre;
    private String apellido;
    private String msn;
    private String msn1;
    private Integer id;
    private Date fecha;

    
    @PostConstruct
     public void init() {
       Usuario tmp = new Usuario();
       this.nombre = tmp.getNombres();
       this.apellido = tmp.getApellidos();
       this.fecha = tmp.getFechaRegistro();
       }
    
    public void guarda() {
        Usuario tmp = new Usuario();
        try {
            tmp.setNombres(getNombre());
            tmp.setApellidos(getApellido());
            tmp.setId(getId());
            tmp.setFechaRegistro(getFecha());
            UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
            usuarioDAO.save(tmp);

            msn = "El usuario se guardo correctamente";
        } catch (Exception e) {

            msn = "upss! Ocurrio un error " + e;
            System.out.println(" upss! Ocurrio un error.  " + e);
        }
    }

    public void actualizar() {
        Usuario tmp = new Usuario();
        try {
            tmp.setNombres(getNombre());
            tmp.setApellidos(getApellido());
            tmp.setId(getId());
            tmp.setFechaRegistro(getFecha());
            UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
            usuarioDAO.update(tmp);

            msn1 = "El usuario se guardo correctamente";
        } catch (Exception e) {

            msn1 = "upss! Ocurrio un error " + e;
            System.out.println(" upss! Ocurrio un error.  " + e);
        }
    }

    public List<Integer> completeUser(String query) {
        UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
        List<Usuario> lista = usuarioDAO.findAll();
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Usuario temp = lista.get(i);
            if ((temp.getId() + "").toLowerCase().startsWith(query)) {
                resultado.add(temp.getId());
            }
        }

        return resultado;
    }

    public void getUsuario() {
        UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
        List<Usuario> lista = usuarioDAO.findAll();
        List<Usuario> allThemes = lista;
    try{
        for (Usuario skin : allThemes) {
            if (this.id.equals((skin.getId()))) {
                this.nombre = skin.getNombres();
                this.apellido = skin.getApellidos();
                this.fecha = skin.getFechaRegistro();
                break;
            }

        }
    
    }catch(Exception ex){
        System.out.println(ex);
     }
    }

    public void eliminaUsuario() {
        UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
        List<Usuario> lista = usuarioDAO.findAll();
        for (Usuario temp:  lista) {
            if (this.id.equals((temp.getId()))) {
                usuarioDAO.delete(temp);
                msn = "El usuario se elimino correctamente";
                this.apellido = null;
                this.fecha = null;
                this.nombre = null;
                this.id = null;
                break;
            }

        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaConFormato = sdf.format(fecha);
        try {
            Date nuevaFecha = sdf.parse(fechaConFormato);
            this.fecha = nuevaFecha;
        } catch (ParseException ex) {
            this.fecha = new Date();
        }

    }

    /**
     * @return the msn
     */
    public String getMsn() {
        return msn;
    }

    /**
     * @param msn the msn to set
     */
    public void setMsn(String msn) {
        this.msn = msn;
    }

    /**
     * @return the msn
     */
    public String getMsn1() {
        return msn1;
    }

    /**
     * @param msn the msn to set
     */
    public void setMsn1(String msn) {
        this.msn1 = msn;
    }

}
