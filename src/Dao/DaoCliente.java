package Dao;

import AccesoDatos.Conexion;
import Bean.BeanCliente;
import java.sql.ResultSet;

public class DaoCliente {

    DaoConexion dConexion=new DaoConexion();

    public void ingresarClienteForma1(
            String nomCliente, String ApellidoCliente, String celular,
            String direccion, String email, Integer dni, String tipo,
            String ruc, String razonSocial, String sexo, String telefono) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("INSERT INTO cliente("
                + "nomcli, apecli, celcli, dircli, emailcli, dnicli, tipocli,"
                + "ruc, razonsocial, sexo, telefono)"
                + "VALUES (" + nomCliente + ", " + ApellidoCliente + ","
                + celular + "," + direccion + "," + email + ","
                + dni + "," + tipo + "," + ruc + "," + razonSocial + ","
                + sexo + "," + telefono + ")");
    }

    public void ingresarCliente(BeanCliente bCliente) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("INSERT INTO cliente("
                + "nomcli, apecli, celcli, dircli, emailcli, dnicli, tipocli,"
                + "ruc, razonsocial, sexo, telefono)"
                + "VALUES ('" + bCliente.getNomCli() + "', '" + bCliente.getApeCli() + "','"
                + bCliente.getCelCli() + "','" + bCliente.getDirCli() + "','" + bCliente.getEmailCli() + "',"
                + bCliente.getDniCli() + ",'" + bCliente.getTipoCli() + "','" + bCliente.getRucCli() + "','" + bCliente.getRazonCocial() + "','"
                + bCliente.getSexo() + "'," + bCliente.getTelefono() + ")");
    }

    public String actualizarCliente(BeanCliente bCliente) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("UPDATE cliente"
                + "SET nomcli=" + bCliente.getNomCli() + ", apecli=" + bCliente.getApeCli() + ", celcli=" + bCliente.getCelCli() + ", dircli=" + bCliente.getDirCli() + ""
                + ", emailcli=" + bCliente.getEmailCli() + ""
                + " WHERE codcli=" + bCliente.getCodCliente());
        return "Actualizado Correctamente";
    }

    public Integer eliminarCliente(Integer codCliente) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("DELETE FROM cliente\n"
                + " WHERE codcli=" + codCliente);
        return 1; //Para Cliente Eliminado
    }

 public ResultSet listarCliente() throws Exception {//Devuleve todas las filas
        dConexion.conn.Conectar();
        ResultSet rs;
        rs = dConexion.conn.ejecutarListas("select codcli, nomcli, apecli, celcli, codsuc from cliente order by codcli asc");
        return rs;
    }
 
    public ResultSet buscarCliente(int cod) throws Exception {//Devuelve una fila
        dConexion.conn.Conectar();
        ResultSet rs;
        rs = dConexion.conn.ejecutarListas("select codcli, nomcli, apecli, tipocli,dnicli  from cliente where codcli=" + cod);
        return rs;
    }
 
    public ResultSet buscarCliente(String pApellido) throws Exception {
        dConexion.conn.Conectar();
        ResultSet rs;
        rs = dConexion.conn.ejecutarListas("Select codcli, nomcli, apecli from cliente where apecli like '" + pApellido + "%'");
        return rs;
    }

}
