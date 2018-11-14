package Services;

import java.sql.*;

import Classes.*;
import static Services.Conexao.connection;
import java.util.ArrayList;
import java.util.List;

public class Conexao extends Thread {

    public static Usuarios usuario;
    public static Corrente corrente;
    public static Poupança poupança;
    public static Extratos extrato;
    public static List<Extratos> listExtrato = new ArrayList<>();
    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet r = null;

    public void run(int id) {

        while (true) {
            corrente = getCorrente(id);
            poupança = getPoup(id);
        }
    }

    public static Usuarios login(String agencia, String conta, String senha) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ops");
        }

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/u736501739_bank?zeroDateTimeBehavior=convertToNull", "bancario", "Pimenta10");
            statement = connection.createStatement();
            r = statement.executeQuery("SELECT * FROM usuarios WHERE conta = " + conta + " AND agencia = " + agencia + " AND senha = '" + senha + "';");

            while (r.next()) {
                System.out.println("---------- Abrindo aplicação ----------");
                System.out.println("ID: " + r.getInt("id"));
                System.out.println("Nome: " + r.getString("nome"));
                System.out.println("Sobrenome: " + r.getString("sobrenome"));
                System.out.println("CPF: " + r.getString("cpf"));
                System.out.println("RG: " + r.getString("rg"));
                System.out.println("Conta: " + r.getInt("conta"));
                System.out.println("Agencia: " + r.getInt("agencia"));
                System.out.println("Sexo: " + r.getString("sexo").charAt(0));
                System.out.println("Idade: " + r.getInt("idade"));
                System.out.println("Ultimo Acesso: " + r.getDate("ultimo_acesso"));

                usuario = new Usuarios(r.getInt("id"), r.getString("nome"), r.getString("sobrenome"),
                        r.getString("cpf"), r.getString("rg"), r.getInt("conta"), r.getInt("agencia"),
                        r.getString("senha"), r.getInt("tipo"), r.getString("sexo").charAt(0),
                        r.getInt("idade"), r.getDate("ultimo_acesso"));

            }
        } catch (SQLException sqlex) {
            return null;
        } finally {

            // Step 3: Closing database connection
            try {
                if (null != connection) {

                    // cleanup resources, once after processing
                    r.close();
                    statement.close();

                    // and then finally close connection
                    connection.close();
                }
            } catch (SQLException sqlex) {
            }
        }
        return usuario;

    }

    public static Corrente getCorrente(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ops");
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/u736501739_bank?zeroDateTimeBehavior=convertToNull", "bancario", "Pimenta10");
            statement = connection.createStatement();
            r = statement.executeQuery("SELECT * FROM corrente WHERE id_usuario = '" + id + "';");

            while (r.next()) {
                corrente = new Corrente(r.getInt("id"), r.getInt("id_usuario"), r.getDouble("saldo"), r.getTimestamp("ultima_alteracao"));
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
            return null;

        } finally {

            try {
                r.close();
                statement.close();
                connection.close();

            } catch (SQLException sqlex) {
                System.out.println(sqlex);
            }
        }
        return corrente;
    }
    
    public static Poupança getPoup(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ops");
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/u736501739_bank?zeroDateTimeBehavior=convertToNull", "bancario", "Pimenta10");
            statement = connection.createStatement();
            r = statement.executeQuery("SELECT * FROM poupanca WHERE id_usuario = '" + id + "';");

            while (r.next()) {
                poupança = new Poupança(r.getInt("id"), r.getInt("id_usuario"), r.getDouble("saldo"), r.getTimestamp("ultima_alteracao"));
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
            return null;

        } finally {

            try {
                r.close();
                statement.close();

                connection.close();

            } catch (SQLException sqlex) {
            }
        }
        return poupança;
    }

    public static List<Extratos> getExtratos(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ops");
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/u736501739_bank?zeroDateTimeBehavior=convertToNull", "bancario", "Pimenta10");
            statement = connection.createStatement();
            r = statement.executeQuery("SELECT * FROM extratos WHERE id_usuario = " + id);

            while (r.next()) {

                extrato = new Extratos(r.getInt("id"), r.getInt("id_usuario"), r.getInt("numero_conta"), r.getString("tipo"), r.getDouble("valor"), r.getDate("ultimo_acesso"));
                listExtrato.add(extrato);

            }
        } catch (SQLException sqlex) {
            return null;
        } finally {

            // Step 3: Closing database connection
            try {
                // cleanup resources, once after processing
                r.close();
                statement.close();

                // and then finally close connection
                connection.close();

            } catch (SQLException sqlex) {
            }
        }
        return listExtrato;
    }

}
