package test;

import DAO.Usuario;
import controlador.UsuarioDaoHibernate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author
 */
public class Main {

    public static void main(String[] args) {
        UsuarioDaoHibernate usuarioDAO = new UsuarioDaoHibernate();
//        Usuario usuario = new Usuario();
//        usuario.setId(13);
//        usuario.setNombres("Rolando Palermo1");
//        usuario.setApellidos("Rodríguez Cruz1");
//        usuario.setFechaRegistro(new Date());
//        usuarioDAO.save(usuario);
//        System.out.println("Todo salio bien en el insert");
//        usuario.setNombres("Caen");
//         usuarioDAO.update(usuario);
//         System.out.println("Todo salio bien en el update");

        List<Usuario> lista = usuarioDAO.findAll();
        for (Usuario user : lista) {
            System.out.println(user.toString());
        }

    }
}
